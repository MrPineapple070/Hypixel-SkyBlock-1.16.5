package net.hypixel.skyblock.items.swords;

import java.util.Arrays;
import java.util.List;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.util.ItemProperties;
import net.hypixel.skyblock.util.StatString;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

/**
 * The
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Aspect_of_the_End">Aspect
 * of the End</a>.
 *
 * @author MrPineapple070
 * @version 02 November 2020
 * @since 02 August 2019
 */
public class AspectOfTheEnd extends ModSwordItem {
	private static final List<ITextComponent> tooltip = Arrays.asList(
			item_ability.copy().append(new TranslationTextComponent("sword.aote")).withStyle(TextFormatting.GOLD),
			new TranslationTextComponent("sword.aote.0", StatString.speed));

	public AspectOfTheEnd() {
		super(ModSwordTier.AOTE, ItemProperties.combat_1, ModItemRarity.Rare);
	}

	@Override
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
		tooltip.addAll(AspectOfTheEnd.tooltip);
		tooltip.add(StringTextComponent.EMPTY);
	}

	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack held = player.getItemInHand(hand);
		if (!world.isClientSide)
			return ActionResult.pass(held);
		
		double x = player.getX(), y = player.getY(), z = player.getZ();
		double yaw = (double) player.yHeadRot, pitch = (double) player.xRot;
		yaw *= Math.PI / 180d;
		pitch *= Math.PI / 180d;
		
		for (int i = 0; i < 8; ++i) {
			if (world.getBlockState(new BlockPos(x, y, z)).getMaterial() != Material.AIR)
				break;
			x -= Math.sin(yaw) * Math.cos(pitch);
			y -= Math.sin(pitch);
			z += Math.cos(yaw) * Math.cos(pitch);
		}
		
		y = pitch > 0 ? Math.ceil(y) : Math.floor(y) - 1;
		
		player.setPos(x, y, z);
		return ActionResult.success(held);
	}
}