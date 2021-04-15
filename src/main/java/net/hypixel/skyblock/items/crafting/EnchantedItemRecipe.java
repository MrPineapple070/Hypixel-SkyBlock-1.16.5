package net.hypixel.skyblock.items.crafting;

import java.util.Objects;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.hypixel.skyblock.items.enchanted_items.EnchantedItem;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

/**
 * A {@link IEnchantedItemRecipe} that handles recipe {@link EnchantedItem}.
 *
 * @author MrPineapple070
 * @version 10 October 2020
 * @since 10 October 2020
 */
public class EnchantedItemRecipe implements IEnchantedItemRecipe {
	/**
	 * {@link ForgeRegistryEntry} of {@link IRecipeSerializer} implementing
	 * {@link IRecipeSerializer} of {@link EnchantmentRecipe} for
	 * {@link EnchantedItemRecipe}
	 */
	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
			implements IRecipeSerializer<EnchantedItemRecipe> {
		@Override
		public EnchantedItemRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
			String group = JSONUtils.getAsString(json, "group", "");
			ItemStack stack = CraftingHelper.getItemStack(JSONUtils.getAsJsonObject(json, "input"), true);
			if (stack.isEmpty())
				throw new JsonParseException("No ingredients for recipe");
			return new EnchantedItemRecipe(recipeId, group, stack,
					CraftingHelper.getItemStack(JSONUtils.getAsJsonObject(json, "output"), true));
		}

		@Override
		public EnchantedItemRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
			return new EnchantedItemRecipe(recipeId, buffer.readUtf(0x7FFF), buffer.readItem(), buffer.readItem());
		}

		@Override
		public void toNetwork(PacketBuffer buffer, EnchantedItemRecipe recipe) {
			buffer.writeUtf(recipe.group);
			buffer.writeItem(recipe.input);
			buffer.writeItem(recipe.output);
		}
	}

	@Nonnull
	protected static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Group name that this is in.
	 */
	@Nonnull
	private final String group;

	/**
	 * {@link ResourceLocation} for the id.
	 */
	@Nonnull
	private final ResourceLocation id;

	/**
	 * Input {@link ItemStack} for this {@link IEnchantedItemRecipe}.
	 */
	@Nonnull
	private final ItemStack input;

	/**
	 * Output {@link ItemStack} for this {@link IEnchantedItemRecipe}
	 */
	@Nonnull
	private final ItemStack output;

	public EnchantedItemRecipe(ResourceLocation id, String group, ItemStack input, ItemStack output) {
		this.id = Objects.requireNonNull(id, "ID ResourceLocation cannot be null");
		this.group = Objects.requireNonNull(group, "Group cannot be null");
		this.input = Objects.requireNonNull(input, "Inputs cannot be null");
		this.output = Objects.requireNonNull(output, "Output cannot be null");
		if (!this.group.isEmpty())
			LOGGER.debug("Group:\t" + this.group);
		LOGGER.debug("Input:\t" + this.input.toString());
		LOGGER.debug("Output:\t" + this.output.toString());
	}

	@Override
	public ItemStack assemble(CraftingInventory inv) {
		return this.output;
	}

	@Override
	public String getGroup() {
		return this.group;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public ItemStack getInput() {
		return this.input;
	}

	@Override
	public ItemStack getResultItem() {
		return this.output;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return RecipeSerializerInit.enchanted_item_serializer.get();
	}

	@Override
	public boolean matches(CraftingInventory inv, World world) {
		int size = 0;
		for (int j = 0; j < inv.getContainerSize(); ++j) {
			final ItemStack stack = inv.getItem(j);
			if (stack.isEmpty())
				continue;
			LOGGER.debug(stack.toString());
			if (this.input.sameItem(stack))
				size += this.input.getCount() >= stack.getCount() ? 1 : 0;
		}
		return size == 5;
	}
}