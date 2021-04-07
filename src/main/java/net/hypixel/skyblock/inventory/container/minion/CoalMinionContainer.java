package net.hypixel.skyblock.inventory.container.minion;

import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;

/**
 * Serve as a base for Coal Minion Containers
 *
 * @author MrPineapple070
 * @version 24 July 2020
 * @since 17 June 2019
 */
public class CoalMinionContainer extends AbstractMinionContainer {
	public CoalMinionContainer(int windowId, PlayerInventory player, AbstractMinionTileEntity tileEntity) {
		super(MinionContainerTypes.coal_minion.get(), windowId, player, tileEntity);
	}

	public CoalMinionContainer(int windowId, PlayerInventory player, PacketBuffer buffer) {
		this(windowId, player, ModTileEntityTypes.coal_minion.get().create());
	}
}