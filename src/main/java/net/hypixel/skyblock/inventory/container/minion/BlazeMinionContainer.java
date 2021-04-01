package net.hypixel.skyblock.inventory.container.minion;

import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;

public class BlazeMinionContainer extends AbstractMinionContainer {

	public BlazeMinionContainer(int windowId, PlayerInventory pInvIn, AbstractMinionTileEntity tileEntity) {
		super(MinionContainerTypes.blaze_minion.get(), windowId, pInvIn, tileEntity);
	}

	public BlazeMinionContainer(int windowId, PlayerInventory pInvIn, PacketBuffer data) {
		super(MinionContainerTypes.blaze_minion.get(), windowId, pInvIn, data);
	}
}