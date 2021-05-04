package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.EnchantmentType;

public class Legion extends UltimateEnchantment {
	public Legion() {
		super(EnchantmentType.ARMOR, armor);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}