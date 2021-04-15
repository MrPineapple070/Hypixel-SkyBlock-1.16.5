package net.hypixel.skyblock.inventory.container;

import java.util.Objects;

import javax.annotation.Nonnull;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class GUISlot extends Slot {
	@Nonnull
	protected final ItemStack stack;

	public GUISlot(IInventory inventory, int slot, int x, int y) {
		this(inventory, slot, x, y, ItemStack.EMPTY);
	}

	public GUISlot(IInventory inv, int slot, int x, int y, Item item) {
		this(inv, slot, x, y, new ItemStack(item));
	}

	public GUISlot(IInventory inv, int slot, int x, int y, ItemStack stack) {
		super(inv, slot, x, y);
		this.stack = Objects.requireNonNull(stack, "ItemStack cannot be null");
	}

	@Override
	public boolean mayPickup(PlayerEntity p_82869_1_) {
		return false;
	}

	@Override
	public boolean mayPlace(ItemStack p_75214_1_) {
		return false;
	}
}