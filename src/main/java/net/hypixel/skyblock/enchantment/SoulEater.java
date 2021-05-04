package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class SoulEater extends UltimateEnchantment {
	public SoulEater() {
		super(EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}