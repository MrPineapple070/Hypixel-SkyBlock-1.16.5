package net.hypixel.skyblock.items.bows;

import java.util.Arrays;
import java.util.List;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.util.ItemProperties;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class Bonemerang extends ModBowItem {
	private static final List<ITextComponent> info = Arrays.asList(
			item_ability.copy().append(new TranslationTextComponent("bow.bonemerang")).withStyle(TextFormatting.GOLD),
			new TranslationTextComponent("bow.bonemerang.0"), new TranslationTextComponent("bow.bonemerang.1"),
			new TranslationTextComponent("bow.bonemerang.2"));

	public Bonemerang() {
		super(ItemProperties.c1, ModItemRarity.Legendary);
	}

	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.addAll(info);
		tooltip.add(StringTextComponent.EMPTY);
	}
}