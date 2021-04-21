package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class FirstStrike extends ModEnchantment {

	public FirstStrike() {
		super(Rarity.COMMON, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return ench != EnchantmentInit.triple_strike.get();
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}

	@Override
	public boolean isAllowedOnBooks() {
		return false;
	}
}