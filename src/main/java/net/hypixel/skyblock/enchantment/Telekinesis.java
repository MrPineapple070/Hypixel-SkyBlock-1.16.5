package net.hypixel.skyblock.enchantment;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

/**
 * The Telekinesis {@link Enchantment}. <br>
 * This {@code Enchantment} will automatically place any {@link ItemStack}
 * dropped from {@link Entity} or {@link Block} directly into the player's
 * inventory.<br>
 * <a href=
 * "https://hypixel-skyblock.fandom.com/wiki/Enchantments#Telekinesis">Click
 * here for more information.</a>
 *
 * @author MrPineapple070
 * @version 16 May 2020
 */
public class Telekinesis extends ModEnchantment {
	public Telekinesis() {
		super(Rarity.COMMON, ModEnchantmentType.NONARMOR, EquipmentSlotType.MAINHAND);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return true;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return true;
	}

	@Override
	public int getMaxCost(int enchantmentLevel) {
		return 0x7fffffff;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public int getMinCost(int enchantmentLevel) {
		return 0;
	}
}