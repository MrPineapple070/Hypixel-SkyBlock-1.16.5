package net.hypixel.skyblock.inventory.container.minion;

import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.hypixel.skyblock.tileentity.minion.CoalMinionTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;

/**
 * Serve as a base for Coal Minion Containers
 *
 * @author MrPineapple070
 * @version 24 July 2020
 * @since 17 June 2019
 */
public class CoalMinionContainer extends AbstractMinionContainer {
	/**
	 * Construct a Coal Minion Container
	 *
	 * @param type       the {@link ContainerType} of this.
	 * @param windowId   the unique ID of this.
	 * @param pInvIn     the {@link PlayerInventory} of the player interacting with
	 *                   this.
	 * @param tileEntity the {@link CoalMinionTileEntity} for this.
	 */
	public CoalMinionContainer(ContainerType<? extends CoalMinionContainer> type, int windowId,
			PlayerInventory pInvIn, CoalMinionTileEntity tileEntity) {
		super(type, windowId, pInvIn, tileEntity);
	}
	
	public CoalMinionContainer(int windowId, PlayerInventory player, AbstractMinionTileEntity tileEntity) {
		super(MinionContainerTypes.coal_minion.get(), windowId, player, tileEntity);
	}

	public CoalMinionContainer(int windowId, PlayerInventory player, PacketBuffer buffer) {
		this(windowId, player, getTileEntity(player, buffer));
	}
}