package net.hypixel.skyblock.inventory.container;

import net.hypixel.skyblock.items.AbstractBackpack;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

/**
 * Extend the {@link PlayerContainer}
 *
 * @author MrPineapple070
 * @version 24 July 2020
 */
public class ExtendedPlayerContainer extends PlayerContainer {
	/**
	 * Construct this.
	 *
	 * @param playerInventory the {@link PlayerInventory} of this.
	 * @param localWorld      determine if this is server or client side
	 * @param playerIn        the {@link PlayerEntity} of this.
	 */
	public ExtendedPlayerContainer(PlayerInventory playerInventory, boolean localWorld, PlayerEntity playerIn) {
		super(playerInventory, localWorld, playerIn);
		/**
		 * this.addSlot(new Slot(playerInventory, 41, 77, 44) {
		 *
		 * @Nullable
		 * @Override
		 * @OnlyIn(Dist.CLIENT) public Pair<ResourceLocation, ResourceLocation>
		 *                      func_225517_c_() { return
		 *                      Pair.of(AtlasTexture.LOCATION_BLOCKS_TEXTURE, null); }
		 *
		 * @Override public boolean isItemValid(ItemStack stack) { return
		 *           stack.getItem() instanceof AbstractBackpack; } });
		 */
	}

	@Override
	public ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
		ItemStack copy = ItemStack.EMPTY;
		final Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			final ItemStack slotStack = slot.getItem();
			copy = slotStack.copy();
			final EquipmentSlotType equipmentslottype = MobEntity.getEquipmentSlotForItem(copy);
			if (index != 46 && copy.getItem() instanceof AbstractBackpack)
				if (!this.slots.get(46).hasItem())
					if (!this.moveItemStackTo(slotStack, 46, 47, false))
						return ItemStack.EMPTY;
					else if (index == 0) {
						if (!this.moveItemStackTo(slotStack, 9, 45, true))
							return ItemStack.EMPTY;
						slot.onQuickCraft(slotStack, copy);
					} else if (index < 5)
						if (!this.moveItemStackTo(slotStack, 9, 45, false))
							return ItemStack.EMPTY;
						else if (index < 9)
							if (!this.moveItemStackTo(slotStack, 9, 45, false))
								return ItemStack.EMPTY;
							else if (equipmentslottype.getType() == EquipmentSlotType.Group.ARMOR
									&& !this.slots.get(8 - equipmentslottype.getIndex()).hasItem()) {
								final int i = 8 - equipmentslottype.getIndex();
								if (!this.moveItemStackTo(slotStack, i, i + 1, false))
									return ItemStack.EMPTY;
							} else if (equipmentslottype == EquipmentSlotType.OFFHAND && !this.slots.get(45).hasItem())
								if (!this.moveItemStackTo(slotStack, 45, 46, false))
									return ItemStack.EMPTY;
								else if (index == 46)
									if (!this.moveItemStackTo(slotStack, 9, 45, false))
										return ItemStack.EMPTY;
									else if (index < 36)
										if (!this.moveItemStackTo(slotStack, 36, 45, false))
											return ItemStack.EMPTY;
										else if (index < 45)
											if (!this.moveItemStackTo(slotStack, 9, 36, false))
												return ItemStack.EMPTY;
											else if (!this.moveItemStackTo(slotStack, 9, 45, false))
												return ItemStack.EMPTY;

			if (slotStack.isEmpty())
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();

			if (slotStack.getCount() == copy.getCount())
				return ItemStack.EMPTY;

			final ItemStack itemstack2 = slot.onTake(playerIn, slotStack);
			if (index == 0)
				playerIn.drop(itemstack2, false);
		}
		return copy;
	}
}