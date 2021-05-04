package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class Chimera extends UltimateEnchantment {
	public Chimera() {
		super(EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}