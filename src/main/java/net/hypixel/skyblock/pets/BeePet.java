package net.hypixel.skyblock.pets;

import net.hypixel.skyblock.items.Collection;
import net.hypixel.skyblock.items.init.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

/**
 * The <a href="https://hypixel-skyblock.fandom.com/wiki/Bee_Pet"> Bee Pet</a>.
 * 
 * @author MrPineapple070
 * @version 21 February 2019
 * @since 21 February 2019
 */
public final class BeePet extends Pet {
	public static final int[] time = { 78000, 438000, 1734000, 5190000 };
	public static final int[] cost = { 5000, 40000, 150000, 450000 };
	public static final ItemStack[] items = new ItemStack[] { new ItemStack(Items.COAL_BLOCK, 128),
			new ItemStack(Items.GOLD_BLOCK, 128), new ItemStack(ItemInit.enchanted_coal_block.get(), 9),
			new ItemStack(ItemInit.enchanted_gold_block.get(), 9) };

	public BeePet() {
		super(Pet.getRandomRarityLow(), Collection.Farming, PetType.Bee);
	}

	@Override
	public void effect(PlayerEntity player) {
	}

	@Override
	public double[] getBuffs() {
		return new double[] {};
	}
}