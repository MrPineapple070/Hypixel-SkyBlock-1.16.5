package net.hypixel.skyblock.items.biomestick;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class BirchForestBiomeStick extends AbstractBiomeStick {
	private static final ITextComponent info = new TranslationTextComponent(String.format(translate, "birch"));

	public BirchForestBiomeStick(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(info);
	}

	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getItemInHand(handIn));
	}
}