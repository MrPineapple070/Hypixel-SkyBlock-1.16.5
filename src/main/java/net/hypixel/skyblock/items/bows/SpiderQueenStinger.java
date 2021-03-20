package net.hypixel.skyblock.items.bows;

import java.util.List;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.util.ItemProperties;
import net.hypixel.skyblock.util.StatString;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class SpiderQueenStinger extends ModBowItem {
	private static final ITextComponent info = new TranslationTextComponent("bow.spider.0");

	public SpiderQueenStinger() {
		super(ItemProperties.c1, ModItemRarity.Epic);
	}

	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(info);
		tooltip.add(new TranslationTextComponent("bow.spider.1", 0, StatString.ability_damage));
	}
}