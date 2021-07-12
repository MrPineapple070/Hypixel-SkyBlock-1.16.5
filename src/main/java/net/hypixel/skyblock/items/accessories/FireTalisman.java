package net.hypixel.skyblock.items.accessories;

import java.util.List;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.util.ItemProperties;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

/**
 * An {@link Accessory} that provides immunity to fire.
 *
 * @author MrPineapple070
 * @version 26 July 2020
 */
public class FireTalisman extends Accessory {
	private static final EffectInstance fire = new EffectInstance(Effects.FIRE_RESISTANCE, 1);
	private static final ITextComponent info = new TranslationTextComponent("accessory.fire");

	public FireTalisman() {
		super(ItemProperties.combat_1, ModItemRarity.Common);
	}

	@Override
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
		tooltip.add(info);
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean isSelected) {
		if (world.isClientSide)
			return;
		if (!(entity instanceof PlayerEntity))
			return;
		final PlayerEntity player = (PlayerEntity) entity;
		player.forceAddEffect(fire);
	}
}