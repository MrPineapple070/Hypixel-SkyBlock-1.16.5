package net.hypixel.skyblock.inventory.container;

import net.hypixel.skyblock.tileentity.TimeSaverTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TimeSelectorSlot extends GUISlot {
	public TimeSelectorSlot(IInventory inventory, int slot, int x, int y) {
		super(inventory, slot, x, y);
	}

	public TimeSelectorSlot(IInventory inv, int slot, int x, int y, Item item) {
		super(inv, slot, x, y, item);
	}

	public TimeSelectorSlot(IInventory inv, int slot, int x, int y, ItemStack stack) {
		super(inv, slot, x, y, stack);
	}

	@Override
	public boolean mayPickup(PlayerEntity player) {
		if (this.container instanceof TimeSaverTileEntity)
			((TimeSaverTileEntity) this.container).setSelected(this.index);
		return false;
	}
}