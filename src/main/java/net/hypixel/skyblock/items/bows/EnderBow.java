package net.hypixel.skyblock.items.bows;

import java.util.Arrays;
import java.util.List;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.util.ItemProperties;
import net.hypixel.skyblock.util.StatString;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

/**
 * @author MrPineapple070
 * @version 24 October 2020
 * @since 24 October 2020
 */
public class EnderBow extends ModBowItem {
	private static final List<ITextComponent> tooltip = Arrays.asList(
			item_ability.copy().append(new TranslationTextComponent("bow.ender")).withStyle(TextFormatting.GOLD),
			new TranslationTextComponent("bow.ender.0", Items.ENDER_PEARL.getName(ItemStack.EMPTY)),
			new TranslationTextComponent("bow.ender.1", StatString.health));

	public EnderBow() {
		super(ItemProperties.combat_1, ModItemRarity.Rare);
	}

	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.addAll(EnderBow.tooltip);
	}
}