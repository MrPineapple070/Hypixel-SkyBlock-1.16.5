package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.EnchantmentType;

public class Wisdom extends UltimateEnchantment {
	public Wisdom() {
		super(EnchantmentType.ARMOR, armor);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}