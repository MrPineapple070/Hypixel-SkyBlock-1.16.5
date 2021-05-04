package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class Rend extends UltimateEnchantment {
	public Rend() {
		super(EnchantmentType.BOW, EquipmentSlotType.MAINHAND);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}