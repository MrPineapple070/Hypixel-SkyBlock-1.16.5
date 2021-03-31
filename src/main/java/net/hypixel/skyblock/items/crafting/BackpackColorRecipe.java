package net.hypixel.skyblock.items.crafting;

import net.hypixel.skyblock.items.AbstractBackpack;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags.Items;

public class BackpackColorRecipe extends SpecialRecipe {
	SpecialRecipeSerializer<BackpackColorRecipe> serializer = new SpecialRecipeSerializer<>(BackpackColorRecipe::new);

	public BackpackColorRecipe(ResourceLocation recipeId) {
		super(recipeId);
	}

	@Override
	public boolean matches(CraftingInventory inv, World world) {
		int i = 0;
		int j = 0;

		for (int k = 0; k < inv.getContainerSize(); ++k) {
			ItemStack itemstack = inv.getItem(k);
			if (itemstack.isEmpty())
				continue;
			
			if (itemstack.getItem() instanceof AbstractBackpack)
				++i;
			else {
				if (!itemstack.getItem().is(Items.DYES))
					return false;
				++j;
			}
			if (j > 1 || i > 1)
				return false;
		}
		return i == 1 && j == 1;
	}

	@Override
	public ItemStack assemble(CraftingInventory inv) {
		ItemStack original = ItemStack.EMPTY;
		DyeColor color = DyeColor.WHITE;
		for (int i = 0; i < inv.getContainerSize(); ++i) {
			ItemStack stack = inv.getItem(i);
			if (stack.isEmpty())
				continue;
			if (stack.getItem() instanceof AbstractBackpack)
				original = stack;
			else {
				DyeColor tmp = DyeColor.getColor(stack);
				if (tmp != null)
					color = tmp;
			}
		}
		ItemStack output = AbstractBackpack.getBackpackStack(((AbstractBackpack) original.getItem()).getType(),
				color);
		if (original.hasTag())
			output.setTag(original.getTag().copy());
		return output;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return width * height >= 2;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return serializer;
	}
}