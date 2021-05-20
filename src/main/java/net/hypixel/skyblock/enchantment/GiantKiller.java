package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class GiantKiller extends ModEnchantment {

	public GiantKiller() {
		super(Rarity.UNCOMMON, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return ench != EnchantmentInit.titan_killer.get();
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}