package net.hypixel.skyblock.enchantment;

import net.hypixel.skyblock.items.swords.AspectOfTheJerry;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class UltJerry extends UltimateEnchantment {
	public UltJerry() {
		super(EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND);
	}
	
	@Override
	public boolean canEnchant(ItemStack stack) {
		return stack.getItem() instanceof AspectOfTheJerry;
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
	}
}