package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public abstract class UltimateEnchantment extends ModEnchantment {
	public UltimateEnchantment(EnchantmentType type, EquipmentSlotType... equipmentSlot) {
		super(Rarity.VERY_RARE, type, equipmentSlot);
	}
	
	@Override
	protected final boolean checkCompatibility(Enchantment ench) {
		return !(ench instanceof UltimateEnchantment);
	}
}