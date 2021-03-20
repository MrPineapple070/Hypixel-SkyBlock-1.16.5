package net.hypixel.skyblock.items.armor.snow;

import java.util.Arrays;
import java.util.List;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.armor.FullSetInformation;
import net.hypixel.skyblock.items.armor.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * Holds {@link EquipmentSlotType} specific information for the
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Snow_Suit">Snow Suit</a>.
 *
 * @author MrPineapple070
 * @version 24 January 2020
 * @since 18 December 2019
 */
public class SnowSet implements FullSetInformation {
	public static final SnowSet instance = new SnowSet();
	private static final List<ITextComponent> fsb = Arrays.asList(
			full_set_bonus.copy().append(new TranslationTextComponent("armor.snow.fsb")).withStyle(TextFormatting.GOLD),
			new TranslationTextComponent("armor.snow.fsb.discription"));

	public double boots_hp = 13;
	public double chestplate_hp = 20;
	public double helmet_hp = 14;
	public double leggings_hp = 15;

	@Override
	public double[] getBootsBuffs() throws IllegalAccessException {
		return new double[] { 0, 0, 0, this.boots_hp, 0, 0, 0 };
	}

	@Override
	public double[] getChestplateBuffs() throws IllegalAccessException {
		return new double[] { 0, 0, 0, this.chestplate_hp, 0, 0, 0 };
	}

	@Override
	public List<ITextComponent> getFullSetBonus() {
		return fsb;
	}

	@Override
	public double[] getHelmetBuffs() throws IllegalAccessException {
		return new double[] { 0, 0, 0, this.helmet_hp, 0, 0, 0 };
	}

	@Override
	public double[] getLeggingsBuffs() throws IllegalAccessException {
		return new double[] { 0, 0, 0, this.leggings_hp, 0, 0, 0 };
	}

	@Override
	public ModArmorMaterial getMaterial() {
		return ModArmorMaterial.Snow;
	}

	@Override
	public ModItemRarity getRarity() {
		return ModItemRarity.Epic;
	}
}