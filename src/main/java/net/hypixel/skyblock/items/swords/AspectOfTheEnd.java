package net.hypixel.skyblock.items.swords;

import java.util.Arrays;
import java.util.List;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.util.ItemProperties;
import net.hypixel.skyblock.util.StatString;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
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
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.addAll(AspectOfTheEnd.tooltip);
		tooltip.add(StringTextComponent.EMPTY);
	}

	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack held = playerIn.getItemInHand(handIn);
		if (!worldIn.isClientSide)
			return ActionResult.pass(held);

		double x = playerIn.getX(), y = playerIn.getY(), z = playerIn.getZ();
		float phi = playerIn.yRot, theta = playerIn.xRot;
		phi *= Math.PI / 180f;
		theta *= Math.PI / 180f;

		x += Math.sin(theta);
		y += Math.sin(phi) * Math.cos(theta);
		z += Math.cos(phi) * Math.cos(theta);

		x *= 8;
		y *= 8;
		z *= 8;

		playerIn.setPos(x, y, z);
		return ActionResult.success(held);
	}
}