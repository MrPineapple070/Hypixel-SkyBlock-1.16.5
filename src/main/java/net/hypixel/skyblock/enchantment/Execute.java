package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class Execute extends ModEnchantment {

	public Execute() {
		super(Rarity.COMMON, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return ench != EnchantmentInit.prosecute.get();
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