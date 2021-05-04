package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.EnchantmentType;

public class NoPainNoGain extends UltimateEnchantment {
	public NoPainNoGain() {
		super(EnchantmentType.ARMOR, armor);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}