package net.hypixel.skyblock.inventory.container;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.hypixel.skyblock.inventory.container.init.ModContainerTypes;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.TimeSaverTileEntity;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;

/**
 * @author MrPineapple070
 * @version 07 October 2020
 * @since 07 October 2020
 */
public class TimeSaverContainer extends Container {
	protected static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * The {@link IWorldPosCallable} of this.
	 */
	@Nonnull
	protected final IWorldPosCallable canInteractWithCallable;

	/**
	 * The {@link AbstractMinionTileEntity} of this,
	 */
	@Nonnull
	protected final TimeSaverTileEntity time_saver;

	public TimeSaverContainer(int windowId, PlayerInventory pInvIn, TimeSaverTileEntity tileEntity) {
		super(ModContainerTypes.time_saver.get(), windowId);
		this.time_saver = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.create(this.time_saver.getLevel(),
				this.time_saver.getBlockPos());
		
		for (int i = 0; i < 9; ++i)
			this.addSlot(new TimeSelectorSlot(this.time_saver, i, 8 + 18 * i, 18, Items.DAYLIGHT_DETECTOR));
		for (int i = 0; i < 7; i++)
			this.addSlot(new TimeSelectorSlot(this.time_saver, i + 9, 26 + 18 * i, 36, Items.DAYLIGHT_DETECTOR));
		
		LOGGER.debug(this.getType().getRegistryName().toString());
	}
	
	public TimeSaverContainer(int windowId, PlayerInventory inventory, PacketBuffer data) {
		this(windowId, inventory, ModTileEntityTypes.day_saver.get().create());
	}

	@Override
	public boolean stillValid(PlayerEntity playerIn) {
		return true;
	}
}