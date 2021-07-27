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
import net.minecraft.util.text.Color;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

/**
 * An {@link Accessory} that grants Night Vision I.<br>
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Night_Vision_Charm">Night
 * Vision Charm</a>
 *
 * @author MrPineapple070
 * @version 28 July 2020
 */
public class NightVisionCharm extends Accessory {
	private static final ITextComponent info = new TranslationTextComponent("accessory.night_vision",
			((IFormattableTextComponent) Effects.NIGHT_VISION.getDisplayName())
					.withStyle(Style.EMPTY.withColor(Color.fromRgb(Effects.NIGHT_VISION.getColor()))));
	
	private static final EffectInstance night_vision = new EffectInstance(Effects.NIGHT_VISION, 1, 1);

	public NightVisionCharm() {
		super(ItemProperties.farm_1, ModItemRarity.Common);
	}

	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(info);
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (worldIn.isClientSide)
			return;
		if (!(entityIn instanceof PlayerEntity))
			return;
		((PlayerEntity) entityIn).addEffect(night_vision);
	}
}