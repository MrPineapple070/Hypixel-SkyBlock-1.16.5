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

public class ExplosiveBow extends ModBowItem {
	private static final List<ITextComponent> info = Arrays.asList(
			item_ability.copy().append(new TranslationTextComponent("bow.explosive")).withStyle(TextFormatting.GOLD),
			new TranslationTextComponent("bow.explosive.0"), new TranslationTextComponent("bow.explosive.1"));

	public ExplosiveBow() {
		super(ItemProperties.c1, ModItemRarity.Epic);
	}

	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.addAll(info);
		tooltip.add(StringTextComponent.EMPTY);
	}
}