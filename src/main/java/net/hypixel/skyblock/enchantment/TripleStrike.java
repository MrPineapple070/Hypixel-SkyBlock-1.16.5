package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class TripleStrike extends ModEnchantment {

	public TripleStrike() {
		super(Rarity.UNCOMMON, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return ench != EnchantmentInit.first_strike.get();
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}