package net.hypixel.skyblock.items.crafting;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.hypixel.skyblock.enchantment.ModEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

/**
 * A {@link IEnchantmentRecipe} that handles craftable {@link ModEnchantment}
 * and {@link Enchantment}.
 *
 * @author MrPineapple070
 * @version 11 October 2020
 * @since 11 October 2020
 */
public class EnchantmentRecipe implements IEnchantmentRecipe {
	/**
	 * {@link ForgeRegistryEntry} of {@link IRecipeSerializer} implementing
	 * {@link IRecipeSerializer} of {@link EnchantmentRecipe} for
	 * {@link EnchantmentRecipe}
	 */
	public static final class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
			implements IRecipeSerializer<EnchantmentRecipe> {
		@Override
		public EnchantmentRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
			String group = JSONUtils.getAsString(json, "group", "");
			Map<String, ItemStack> map = EnchantmentRecipe.keyFromJson(JSONUtils.getAsJsonObject(json, "key"));
			String[] astring = EnchantmentRecipe
					.shrink(EnchantmentRecipe.patternFromJson(JSONUtils.getAsJsonArray(json, "pattern")));
			int width = astring[0].length();
			int height = astring.length;
			NonNullList<ItemStack> input = EnchantmentRecipe.dissolvePattern(astring, map, width, height);
			ItemStack output = EnchantmentRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "result"));
			return new EnchantmentRecipe(recipeId, group, width, height, input, output);
		}

		@Override
		public EnchantmentRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
			int width = buffer.readVarInt();
			int height = buffer.readVarInt();
			String group = buffer.readUtf(0x7fff);
			NonNullList<ItemStack> input = NonNullList.withSize(width * height, ItemStack.EMPTY);
			for (int k = 0; k < input.size(); ++k)
				input.set(k, buffer.readItem());
			ItemStack output = buffer.readItem();
			return new EnchantmentRecipe(recipeId, group, width, height, input, output);
		}

		@Override
		public void toNetwork(PacketBuffer buffer, EnchantmentRecipe recipe) {
			buffer.writeVarInt(recipe.width);
			buffer.writeVarInt(recipe.height);
			buffer.writeUtf(recipe.group);
			for (ItemStack stack : recipe.inputs)
				buffer.writeItem(stack);
			buffer.writeItem(recipe.output);
		}
	}

	protected static final Logger LOGGER = LogManager.getLogger();

	protected static int MAX_HEIGHT = 3;

	protected static int MAX_WIDTH = 3;

	/**
	 * Converts a {@link Map} from {@link String} to {@link ItemStack} to a
	 * {@link NonNullList} of {@link ItemStack}
	 * 
	 * @param pattern    privative type array of {@link String}
	 * @param patternMap {@link Map} from {@link String} to {@link ItemStack}
	 *                   consisting of pattern
	 * @param width      recipe width
	 * @param height     recipe height
	 * @return {@link NonNullList} of {@link ItemStack}
	 */
	private static final NonNullList<ItemStack> dissolvePattern(String[] pattern, Map<String, ItemStack> patternMap,
			int width, int height) {
		NonNullList<ItemStack> inputs = NonNullList.withSize(width * height, ItemStack.EMPTY);
		Set<String> set = Sets.newHashSet(patternMap.keySet());
		set.remove(" ");
		for (int i = 0; i < pattern.length; ++i)
			for (int j = 0; j < pattern[i].length(); ++j) {
				String key = pattern[i].substring(j, j + 1);
				ItemStack stack = patternMap.get(key);
				if (stack == null)
					throw new JsonSyntaxException(
							"Pattern references symbol '" + key + "' but it's not defined in the key");
				set.remove(key);
				inputs.set(j + width * i, stack);
			}
		if (!set.isEmpty())
			throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
		return inputs;
	}

	/**
	 * Find the first non-space in a {@link String}
	 * 
	 * @param line {@link String} to look through
	 * @return index of first non-space
	 */
	private static final int firstNonSpace(String line) {
		int i;
		for (i = 0; i < line.length() && line.charAt(i) == ' '; ++i) {
		}
		return i;
	}

	/**
	 * Retrieves an {@link ItemStack} from {@link JsonObject}
	 * 
	 * @param json {@link JsonObject} to look through
	 * @return {@link ItemStack}
	 */
	private static final ItemStack itemFromJson(JsonObject json) {
		ItemStack stack = new ItemStack(JSONUtils.getAsItem(json, "item"), JSONUtils.getAsInt(json, "count", 1));
		ResourceLocation ench_location = ResourceLocation.tryParse(JSONUtils.getAsString(json, "enchantment"));
		Enchantment ench = ForgeRegistries.ENCHANTMENTS.getValue(ench_location);
		stack.enchant(ench, ench.getMaxLevel() - 1);
		return stack;
	}

	/**
	 * Retrieves pattern {@link Map} from a {@link JsonObject}
	 * 
	 * @param json {@link JsonObject} to look through
	 * @return pattern {@link Map}
	 */
	private static final Map<String, ItemStack> keyFromJson(JsonObject json) {
		Map<String, ItemStack> map = Maps.newHashMap();
		for (Entry<String, JsonElement> entry : json.entrySet()) {
			String key = entry.getKey();
			if (key.length() != 1)
				throw new JsonSyntaxException("Invalid key entry: '" + (String) entry.getKey()
						+ "' is an invalid symbol (must be 1 character only).");
			if (" ".equals(key))
				throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
			map.put(key, CraftingHelper.getItemStack(entry.getValue().getAsJsonObject(), true));
		}
		map.put(" ", ItemStack.EMPTY);
		return map;
	}

	/**
	 * Finds the last non-space in a {@link String}
	 * 
	 * @param line {@link String} to look through
	 * @return index of last non-space
	 */
	private static final int lastNonSpace(String line) {
		int i;
		for (i = line.length() - 1; i >= 0 && line.charAt(i) == ' '; --i) {
		}
		return i;
	}

	/**
	 * Retrieves a privative type array of {@link String} from a {@link JsonArray}
	 * 
	 * @param json {@link JsonArray} to convert from
	 * @return privative type array of {@link String}
	 */
	private static final String[] patternFromJson(JsonArray json) {
		String[] astring = new String[json.size()];
		if (astring.length > MAX_HEIGHT)
			throw new JsonSyntaxException("Invalid pattern: too many rows, " + MAX_HEIGHT + " is maximum");
		if (astring.length == 0)
			throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
		for (int i = 0; i < astring.length; ++i) {
			String pattern = JSONUtils.convertToString(json.get(i), "pattern[" + i + "]");
			if (pattern.length() > MAX_WIDTH)
				throw new JsonSyntaxException("Invalid pattern: too many columns, " + MAX_WIDTH + " is maximum");
			if (i > 0 && astring[0].length() != pattern.length())
				throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
			astring[i] = pattern;
		}
		return astring;
	}

	/**
	 * Expand the max width and height allowed in the deserializer. This should be
	 * called by modders who add custom crafting tables that are larger than the
	 * vanilla 3x3.
	 * 
	 * @param width  your max recipe width
	 * @param height your max recipe height
	 */
	public static final void setCraftingSize(int width, int height) {
		if (MAX_WIDTH < width)
			MAX_WIDTH = width;
		if (MAX_HEIGHT < height)
			MAX_HEIGHT = height;
	}

	/**
	 * Shrinks an array of {@link String} to exclude space characters
	 * 
	 * @param inputs {@link String} to shrink down
	 * @return shrunk
	 */
	@VisibleForTesting
	public static final String[] shrink(String... inputs) {
		int firstNonSpace = Integer.MAX_VALUE, lastNonSpace = 0;
		int index = 0, length = 0;
		for (int i = 0; i < inputs.length; ++i) {
			String line = inputs[i];
			firstNonSpace = Math.min(firstNonSpace, firstNonSpace(line));
			int j = lastNonSpace(line);
			lastNonSpace = Math.max(lastNonSpace, j);
			if (j < 0) {
				if (index == i)
					++index;
				++length;
			} else
				length = 0;
		}
		if (inputs.length == length)
			return new String[0];
		String[] astring = new String[inputs.length - length - index];
		for (int k1 = 0; k1 < astring.length; ++k1)
			astring[k1] = inputs[k1 + index].substring(firstNonSpace, lastNonSpace + 1);
		return astring;
	}

	/**
	 * {@link String} that is the name for the group that this is in.
	 */
	@Nonnull
	private final String group;

	/**
	 * Height of this recipe
	 */
	private final int height;

	/**
	 * {@link ResourceLocation} for the id.
	 */
	@Nonnull
	private final ResourceLocation id;

	/**
	 * A {@link NonNullList} of {@link Ingredient} for this
	 * {@link IEnchantedItemRecipe}.
	 */
	@Nonnull
	private final NonNullList<ItemStack> inputs;

	/**
	 * Output {@link ItemStack} for this {@link IEnchantedItemRecipe}
	 */
	@Nonnull
	private final ItemStack output;

	/**
	 * Width of this recipe
	 */
	private final int width;

	public EnchantmentRecipe(ResourceLocation id, String group, int width, int height, NonNullList<ItemStack> input,
			ItemStack output) {
		this.id = Objects.requireNonNull(id, "id cannot be null");
		this.group = Objects.requireNonNull(group, "Group cannot be null");
		this.width = width;
		this.height = height;
		this.inputs = Objects.requireNonNull(input, "Inputs cannot be null");
		this.output = Objects.requireNonNull(output, "Output cannot be null");
		LOGGER.debug(this.inputs.toString());
		LOGGER.debug(this.output.toString());
	}

	@Override
	public ItemStack assemble(CraftingInventory p_77572_1_) {
		return this.output;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public NonNullList<ItemStack> getInputs() {
		return this.inputs;
	}

	@Override
	public ItemStack getResultItem() {
		return this.output;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return RecipeSerializerInit.enchantment_serializer.get();
	}

	@Override
	public boolean matches(CraftingInventory inv, World worldIn) {
		for (int i = 0; i < inv.getContainerSize(); ++i) {
			ItemStack stack = inv.getItem(i);
			if (stack.isEmpty())
				continue;
		}
		return false;
	}
}