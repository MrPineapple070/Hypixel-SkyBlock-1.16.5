package net.hypixel.skyblock.items.bows;

import java.util.List;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.util.ItemProperties;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class SavannaBow extends ModBowItem {
	private static final ITextComponent info = new TranslationTextComponent("bow.savanna");
	public SavannaBow() {
		super(ItemProperties.c1, ModItemRarity.Uncommon);
	}

	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(info);
	}
}