package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class Combo extends UltimateEnchantment {
	public Combo() {
		super(EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}