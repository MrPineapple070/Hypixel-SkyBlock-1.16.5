package net.hypixel.skyblock.items.armor.miner_outfit;

import java.util.Arrays;
import java.util.List;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.armor.FullSetInformation;
import net.hypixel.skyblock.items.armor.ModArmorItem;
import net.hypixel.skyblock.items.armor.ModArmorMaterial;
import net.hypixel.skyblock.util.ItemProperties;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

/**
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Miner%27s_Outfit">Miner
 * Set</a>
 *
 * @author MrPineapple070
 * @version 18 May 2020
 */
public class MinerOutfitSet extends ModArmorItem {
	private static final List<ITextComponent> fsb = Arrays.asList(
			FullSetInformation.full_set_bonus.copy().append(new TranslationTextComponent("armor.miner_outfit.fsb"))
					.withStyle(TextFormatting.GOLD),
			new TranslationTextComponent("armor.miner_outfit.fsb.discription",
					((IFormattableTextComponent) Effects.DIG_SPEED.getDisplayName())
							.withStyle(Style.EMPTY.withColor(Color.fromRgb(Effects.DIG_SPEED.getColor())))));
	
	private static final EffectInstance haste = new EffectInstance(Effects.DIG_SPEED, 1, 1);

	public MinerOutfitSet(EquipmentSlotType slot) {
		super(ModArmorMaterial.Miner_Outfit, slot, ItemProperties.mine_1, ModItemRarity.Rare);
	}

	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.addAll(fsb);
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClientSide)
			return;
		if (!(entity instanceof PlayerEntity))
			return;
		PlayerEntity player = (PlayerEntity) entity;
		int m = 0;
		for (ItemStack s : player.getArmorSlots()) {
			Item item = s.getItem();
			if (!(item instanceof ArmorItem))
				continue;
			ArmorItem armor = (ArmorItem) item;
			if (armor.getMaterial() == ModArmorMaterial.Miner_Outfit)
				m++;
		}
		if (m == 4)
			player.addEffect(haste);
			
	}
}
