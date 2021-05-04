package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.EnchantmentType;

public class LastStand extends UltimateEnchantment {
	public LastStand() {
		super(EnchantmentType.ARMOR, armor);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}