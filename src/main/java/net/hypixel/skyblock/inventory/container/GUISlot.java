package net.hypixel.skyblock.inventory.container;

import java.util.Objects;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class GUISlot extends Slot {
	protected static final Logger LOGGER = LogManager.getLogger();
	
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
		this.set(this.stack);
	}
	
	@Override
	public void set(ItemStack stack) {
		super.set(this.stack);
	}

	@Override
	public abstract boolean mayPickup(PlayerEntity player);

	@Override
	public boolean mayPlace(ItemStack stack) {
		return false;
	}
}