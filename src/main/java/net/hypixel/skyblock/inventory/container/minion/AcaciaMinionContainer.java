package net.hypixel.skyblock.inventory.container.minion;

import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;

public class AcaciaMinionContainer extends AbstractMinionContainer {
	public AcaciaMinionContainer(int windowId, PlayerInventory player, AbstractMinionTileEntity tileEntity) {
		super(MinionContainerTypes.acacia_minion.get(), windowId, player, tileEntity);
	}
	
	public AcaciaMinionContainer(int windowId, PlayerInventory player, PacketBuffer data) {
		this(windowId, player, getTileEntity(player, data));
	}
}