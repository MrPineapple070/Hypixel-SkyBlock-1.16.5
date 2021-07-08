package net.hypixel.skyblock.inventory.container.minion;

import java.awt.MenuItem;
import java.util.Objects;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.hypixel.skyblock.inventory.container.CloseSlot;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

/**
 * A base for all {@link Container} for all Minions.
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Minions">Click here for a
 * description of Minions.</a>
 *
 * @author MrPineapple070
 * @version 11 July 2019
 * @since 11 July 2019
 */
public class AbstractMinionContainer extends Container {
	/**
	 * {@link Logger} for this.
	 */
	@Nonnull
	protected static final Logger LOGGER = LogManager.getLogger();

	/**
	 * The {@link IWorldPosCallable} of this.
	 */
	@Nonnull
	protected final IWorldPosCallable access;

	/**
	 * The {@link IInventory} of this.
	 */
	@Nonnull
	protected final IInventory inventory;
	
	/**
	 * The {@link IInventory} that hold {@link MenuItem}
	 */
	@Nonnull
	protected final IInventory menu;

	/**
	 * The {@link AbstractMinionTileEntity} of this,
	 */
	@Nonnull
	protected final AbstractMinionTileEntity minion;

	/**
	 * Construct this
	 *
	 * @param type		the {@link ContainerType}.
	 * @param id		the unique window id.
	 * @param player	the {@link PlayerInventory}.
	 * @param minion	the {@link TileEntity} for {@code this}.
	 */
	public AbstractMinionContainer(ContainerType<? extends AbstractMinionContainer> type, int id,
			PlayerInventory player, AbstractMinionTileEntity minion) {
		super(type, id);
		this.minion = Objects.requireNonNull(minion, "AbstractMinionTileEntity cannot be null");
		this.inventory = new Inventory(
				this.minion.minionContents.toArray(new ItemStack[this.minion.getContainerSize()]));
		this.menu = new Inventory(2);
		this.access = IWorldPosCallable.create(this.minion.getLevel(), this.minion.getBlockPos());
		LOGGER.debug(this.getType().getRegistryName().toString());

		this.addSlot(new FuelSlot(this.minion));
		this.addSlot(new SellerSlot(this.minion));
		this.addSlot(new UpgradeSlot(this.minion, 2));
		this.addSlot(new UpgradeSlot(this.minion, 3));

		// Main Inventory
		int num = this.minion.getContainerSize();
		for (int row = 0; row < 3; ++row)
			for (int col = 0; col < 5; ++col)
				if (num == 4)
					break;
				else {
					this.addSlot(new MinionSlot(this.minion, row, col));
					num--;
				}
		
		// Menu Inventory
		this.addSlot(new CloseSlot(this.menu, 0, 80, 72));

		// Player Inventory
		for (int row = 0; row < 3; ++row)
			for (int column = 0; column < 9; ++column)
				this.addSlot(new Slot(player, 9 + row * 9 + column, 8 + column * 18, 102 + row * 18));

		// Player HotBar
		for (int column = 0; column < 9; ++column)
			this.addSlot(new Slot(player, column, 8 + column * 18, 160));
	}

	@Override
	public final boolean stillValid(PlayerEntity playerIn) {
		return true;
	}

	@Override
	public final void removed(PlayerEntity playerIn) {
		super.removed(playerIn);
		this.inventory.stillValid(playerIn);
	}

	@Override
	public final ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		final Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			final ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < this.minion.getContainerSize()) {
				if (!this.moveItemStackTo(itemstack1, this.minion.getContainerSize(), this.inventory.getContainerSize(),
						true))
					return ItemStack.EMPTY;
			} else if (!this.moveItemStackTo(itemstack1, 0, this.minion.getContainerSize(), false))
				return ItemStack.EMPTY;
			if (itemstack1.isEmpty())
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();
		}
		return itemstack;
	}
}