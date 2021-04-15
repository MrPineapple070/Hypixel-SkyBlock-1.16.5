package net.hypixel.skyblock.items.crafting;

import javax.annotation.Nonnull;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.enchantment.ModEnchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.wrapper.RecipeWrapper;

/**
 * An {@link IRecipe} of {@link RecipeWrapper} that handles the custom recipe
 * for {@link ModEnchantment}
 *
 * @author MrPineapple070
 * @version 11 October 2020
 * @since 11 October 2020
 */
public interface IEnchantmentRecipe extends ICraftingRecipe {
	public static final ResourceLocation recipe_type_id = new ResourceLocation(HypixelSkyBlockMod.MOD_ID,
			"enchantment");

	@Override
	default boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Nonnull
	NonNullList<ItemStack> getInputs();
}