package net.hypixel.skyblock.items.crafting;

import java.util.Arrays;
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

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class ModShapedRecipe implements ICraftingRecipe {
	public static final ResourceLocation recipe_id = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "shaped");

	public static final class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
			implements IRecipeSerializer<ModShapedRecipe> {
		@Override
		public ModShapedRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
			String group = JSONUtils.getAsString(json, "group", "");
			Map<String, ItemStack> map = ModShapedRecipe.keyFromJson(JSONUtils.getAsJsonObject(json, "key"));
			String[] pattern = ModShapedRecipe
					.shrink(ModShapedRecipe.patternFromJson(JSONUtils.getAsJsonArray(json, "pattern")));
			int width = pattern[0].length();
			int height = pattern.length;
			NonNullList<ItemStack> input = ModShapedRecipe.dissolvePattern(pattern, map, width, height);
			return new ModShapedRecipe(recipeId, group, width, height, input,
					new ItemStack(JSONUtils.getAsItem(json, "item"), JSONUtils.getAsInt(json, "count", 1)));
		}

		@Override
		public ModShapedRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
			int width = buffer.readVarInt();
			int height = buffer.readVarInt();
			String group = buffer.readUtf(0x7fff);
			NonNullList<ItemStack> input = NonNullList.withSize(width * height, ItemStack.EMPTY);
			for (int k = 0; k < input.size(); ++k)
				input.set(k, buffer.readItem());
			ItemStack output = buffer.readItem();
			return new ModShapedRecipe(recipeId, group, width, height, input, output);
		}

		@Override
		public void toNetwork(PacketBuffer buffer, ModShapedRecipe recipe) {
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
		LOGGER.debug("Dissolving");
		NonNullList<ItemStack> inputs = NonNullList.withSize(width * height, ItemStack.EMPTY);
		Set<String> set = Sets.newHashSet(patternMap.keySet());
		set.remove(" ");
		for (int i = 0; i < pattern.length; ++i)
			for (int j = 0; j < pattern[i].length(); ++j) {
				String key = pattern[i].substring(j, j + 1);
				LOGGER.debug("Key:\t" + key);
				ItemStack stack = patternMap.get(key);
				if (stack == null)
					throw new JsonSyntaxException(
							"Pattern references symbol '" + key + "' but it's not defined in the key");
				LOGGER.debug("ItemStack:\t" + stack.toString());
				set.remove(key);
				inputs.set(j + width * i, stack);
			}
		if (!set.isEmpty())
			throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
		LOGGER.debug("List:\t" + inputs.toString());
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
		LOGGER.debug("Map:\t" + map.toString());
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
		LOGGER.debug("Patterns:\t" + Arrays.deepToString(astring));
		return astring;
	}

	/**
	 * Shrinks an array of {@link String} to exclude space characters
	 * 
	 * @param inputs
	 * @return
	 */
	@VisibleForTesting
	public static final String[] shrink(String... inputs) {
		LOGGER.debug("Shrinking:\t" + Arrays.deepToString(inputs));
		int firstNonSpace = Integer.MAX_VALUE, lastNonSpace = 0;
		int index = 0, length = 0;
		for (int i = 0; i < inputs.length; ++i) {
			String line = inputs[i];
			LOGGER.debug("Line:\t" + line);
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
		LOGGER.debug("Shrunk:\t" + Arrays.asList(astring));
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

	public ModShapedRecipe(ResourceLocation id, String group, int width, int height, NonNullList<ItemStack> input,
			ItemStack output) {
		this.id = Objects.requireNonNull(id, "id cannot be null");
		this.group = Objects.requireNonNull(group, "Group cannot be null");
		this.width = width;
		this.height = height;
		this.inputs = Objects.requireNonNull(input, "Inputs cannot be null");
		this.output = Objects.requireNonNull(output, "Output cannot be null");
	}

	@Override
	public boolean matches(CraftingInventory p_77569_1_, World p_77569_2_) {
		return false;
	}

	@Override
	public ItemStack assemble(CraftingInventory p_77572_1_) {
		return this.output;
	}

	@Override
	public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
		return false;
	}

	@Override
	public ItemStack getResultItem() {
		return this.output;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return null;
	}
}