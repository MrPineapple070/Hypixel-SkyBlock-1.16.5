package net.hypixel.skyblock.inventory.container.minion;

import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;

/**
 * Serve as the basis for all 11 tiers of CobblestoneMinionContainer.
 *
 * @author MrPineapple070
 * @version 11 June 2019
 * @since 11 June 2019
 */
public class CobblestoneMinionContainer extends AbstractMinionContainer {
	public CobblestoneMinionContainer(int windowId, PlayerInventory player, AbstractMinionTileEntity minion) {
		super(null, windowId, player, minion);
	}
	
	public CobblestoneMinionContainer(int windowId, PlayerInventory player, PacketBuffer buffer) {
		this(windowId, player, ModTileEntityTypes.cobblestone_minion.get().create());
	}
}