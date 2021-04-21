package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class Thunderlord extends ModEnchantment {

	public Thunderlord() {
		super(Rarity.RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return ench != EnchantmentInit.thunderbolt.get();
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}