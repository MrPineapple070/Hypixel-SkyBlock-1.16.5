package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class Prosecute extends ModEnchantment {

	public Prosecute() {
		super(Rarity.COMMON, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return ench != EnchantmentInit.execute.get();
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}