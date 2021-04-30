package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;

public class Bank extends ModEnchantment {
	public Bank() {
		super(Rarity.VERY_RARE, EnchantmentType.ARMOR, armor);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return true;
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public boolean isAllowedOnBooks() {
		return true;
	}
}