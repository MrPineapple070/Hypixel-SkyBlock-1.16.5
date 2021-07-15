package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public abstract class UltimateEnchantment extends ModEnchantment {
	public UltimateEnchantment(EnchantmentType type, EquipmentSlotType... equipmentSlot) {
		super(Rarity.VERY_RARE, type, equipmentSlot);
	}

	@Override
	protected final boolean checkCompatibility(Enchantment ench) {
		return !(ench instanceof UltimateEnchantment);
	}
	
	@Override
	public ITextComponent getFullname(int level) {
		IFormattableTextComponent name = new TranslationTextComponent(this.getDescriptionId()).withStyle(TextFormatting.LIGHT_PURPLE);

		if (level != 1 || this.getMaxLevel() != 1)
			name.append(" ").append(new TranslationTextComponent("enchantment.level." + level));

		return name;
	}
}