package net.hypixel.skyblock.items.biomestick;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class NetherBiomeStick extends AbstractBiomeStick {
	private static final ITextComponent info = new TranslationTextComponent(String.format(translate, "desert"));

	public NetherBiomeStick(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
		tooltip.add(info);
	}

	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		return ActionResult.pass(playerIn.getItemInHand(handIn));
	}
}