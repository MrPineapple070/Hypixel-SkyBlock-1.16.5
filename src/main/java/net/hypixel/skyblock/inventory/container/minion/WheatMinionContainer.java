package net.hypixel.skyblock.inventory.container.minion;

import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;

public class WheatMinionContainer extends AbstractMinionContainer {
	public WheatMinionContainer(int windowId, PlayerInventory player, AbstractMinionTileEntity minion) {
		super(MinionContainerTypes.wheat_minion.get(), windowId, player, minion);
	}
	
	public WheatMinionContainer(int windowId, PlayerInventory player, PacketBuffer buffer) {
		this(windowId, player, ModTileEntityTypes.wheat_minion.get().create());
	}
}