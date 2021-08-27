package net.hypixel.skyblock.items.crafting;

import javax.annotation.Nonnull;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;

public interface IForgeRecipe extends ICraftingRecipe {
	/**
	 * {@link ResourceLocation} that is the ID for this {@link IRecipe}.
	 */
	@Nonnull
	ResourceLocation recipe_type_id = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "forge");

	@Override
	default boolean canCraftInDimensions(int width, int height) {
		return true;
	}
}