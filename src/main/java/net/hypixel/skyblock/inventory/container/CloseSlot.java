package net.hypixel.skyblock.inventory.container;

import net.hypixel.skyblock.items.init.MenuItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;

public class CloseSlot extends GUISlot {

	public CloseSlot(IInventory inventory, int slot, int x, int y) {
		super(inventory, slot, x, y, MenuItemInit.close.get());
	}

	@Override
	public boolean mayPickup(PlayerEntity player) {
		LOGGER.debug("Closing");
		final Minecraft minecraft = Minecraft.getInstance();
		minecraft.player.closeContainer();
		return false;
	}
}