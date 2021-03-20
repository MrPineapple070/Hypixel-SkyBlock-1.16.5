package net.hypixel.skyblock.inventory.container.minion;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

/**
 * @author LaiHuy411846
 * @version 09 November 2020
 * @since 09 November 2020
 */
public class MinionChestSlot extends Slot {
	public MinionChestSlot(IInventory inventoryIn, int row, int col, int rowMax) {
		super(inventoryIn, row * rowMax + col, 84 + 18 * col, 63 + 18 * row);
	}

	@Override
	public boolean mayPlace(ItemStack p_75214_1_) {
		return false;
	}
}