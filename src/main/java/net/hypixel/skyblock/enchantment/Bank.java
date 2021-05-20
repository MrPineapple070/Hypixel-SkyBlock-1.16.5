package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.EnchantmentType;

public class Bank extends UltimateEnchantment {
	public Bank() {
		super(EnchantmentType.ARMOR, armor);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}