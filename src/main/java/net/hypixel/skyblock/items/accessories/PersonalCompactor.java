package net.hypixel.skyblock.items.accessories;

import java.util.List;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.util.ItemMap;
import net.hypixel.skyblock.util.ItemProperties;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

/**
 * These {@link Accessory} automatically turns certain materials in the player's
 * inventory into their enchanted form.<br>
 * The base for Personal Compactors.<br>
 *
 * <a href=
 * "https://hypixel-skyblock.fandom.com/wiki/Personal_Compactor_4000">Personal
 * Compactor 4000</a><br>
 * <a href=
 * "https://hypixel-skyblock.fandom.com/wiki/Personal_Compactor_5000">Personal
 * Compactor 5000</a><br>
 * <a href=
 * "https://hypixel-skyblock.fandom.com/wiki/Personal_Compactor_6000">Personal
 * Compactor 6000</a><br>
 *
 * @author MrPineapple070
 * @version 25 July 2020
 */
public class PersonalCompactor extends PersonalAccessory {
	public static class PersonalComp4000 extends PersonalCompactor {
		public PersonalComp4000() {
			super(ItemProperties.mine_1, ModItemRarity.Uncommon, Type.Type4);
		}
	}

	public static class PersonalComp5000 extends PersonalCompactor {
		public PersonalComp5000() {
			super(ItemProperties.mine_1, ModItemRarity.Rare, Type.Type5);
		}
	}

	public static class PersonalComp6000 extends PersonalCompactor {
		public PersonalComp6000() {
			super(ItemProperties.mine_1, ModItemRarity.Epic, Type.Type6);
		}
	}

	public static class PersonalComp7000 extends PersonalCompactor {
		public PersonalComp7000() {
			super(ItemProperties.mine_1, ModItemRarity.Legendary, Type.Type7);
		}
	}

	private static final ITextComponent disc = new TranslationTextComponent("accessory.comp");

	protected PersonalCompactor(Properties properties, ModItemRarity rarity, Type type) {
		super(properties, rarity, type);
	}

	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(disc);
	}

	protected int[] getSuperCompIndex(Item item) {
		HypixelSkyBlockMod.LOGGER.info("Finding super compactor indexes for: " + item.getRegistryName().toString());
		int[] indexs = new int[3];
		int index = 0;
		boolean half = false;
		for (int i = this.items.size() - 1; i > -1; i--) {
			final ItemStack stack = this.items.get(i);
			if (stack.getItem().equals(item))
				switch (stack.getCount()) {
				case 32:
					if (!half) {
						indexs[index] = i;
						index++;
						half = true;
					}
					break;
				case 64:
					indexs[index] = i;
					index++;
					break;
				default:
					continue;
				}
			else
				continue;
		}
		return indexs;
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (worldIn.isClientSide)
			return;
		if (!(entityIn instanceof PlayerEntity))
			return;
		final PlayerEntity player = (PlayerEntity) entityIn;
		for (ItemStack st : this.items) {
			Item item = st.getItem();
			Integer count = ItemMap.enchReqMap.get(item);
			if (count == null)
				continue;
			if (player.inventory.countItem(item) >= count.intValue())
				for (final int index : this.getSuperCompIndex(item)) {
					final ItemStack s = this.items.get(index);
					if (s.getCount() < s.getMaxStackSize())
						this.decrStackSize(index, stack.getCount());
					else
						this.removeStackFromSlot(index);
				}
		}
	}
}