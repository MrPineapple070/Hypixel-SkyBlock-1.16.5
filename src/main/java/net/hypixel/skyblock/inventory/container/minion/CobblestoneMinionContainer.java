package net.hypixel.skyblock.inventory.container.minion;

import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;

/**
 * Serve as the basis for all 11 tiers of CobblestoneMinionContainer.
 *
 * @author MrPineapple070
 * @version 11 June 2019
 * @since 11 June 2019
 */
public class CobblestoneMinionContainer extends AbstractMinionContainer {
	public static class CobbleMC1 extends CobblestoneMinionContainer {
		public CobbleMC1(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.cobblestone_minion_1.get(), windowId, player,
					ModTileEntityTypes.cobblestone_minion_1.get().create());
		}

		public CobbleMC1(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CobbleMC2 extends CobblestoneMinionContainer {
		public CobbleMC2(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.cobblestone_minion_2.get(), windowId, player,
					ModTileEntityTypes.cobblestone_minion_2.get().create());
		}

		public CobbleMC2(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CobbleMC3 extends CobblestoneMinionContainer {
		public CobbleMC3(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.cobblestone_minion_3.get(), windowId, player,
					ModTileEntityTypes.cobblestone_minion_3.get().create());
		}

		public CobbleMC3(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CobbleMC4 extends CobblestoneMinionContainer {
		public CobbleMC4(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.cobblestone_minion_4.get(), windowId, player,
					ModTileEntityTypes.cobblestone_minion_4.get().create());
		}

		public CobbleMC4(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CobbleMC5 extends CobblestoneMinionContainer {
		public CobbleMC5(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.cobblestone_minion_5.get(), windowId, player,
					ModTileEntityTypes.cobblestone_minion_5.get().create());
		}

		public CobbleMC5(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CobbleMC6 extends CobblestoneMinionContainer {
		public CobbleMC6(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.cobblestone_minion_6.get(), windowId, player,
					ModTileEntityTypes.cobblestone_minion_6.get().create());
		}

		public CobbleMC6(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CobbleMC7 extends CobblestoneMinionContainer {
		public CobbleMC7(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.cobblestone_minion_7.get(), windowId, player,
					ModTileEntityTypes.cobblestone_minion_7.get().create());
		}

		public CobbleMC7(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CobbleMC8 extends CobblestoneMinionContainer {
		public CobbleMC8(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.cobblestone_minion_8.get(), windowId, player,
					ModTileEntityTypes.cobblestone_minion_8.get().create());
		}

		public CobbleMC8(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CobbleMC9 extends CobblestoneMinionContainer {
		public CobbleMC9(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.cobblestone_minion_9.get(), windowId, player,
					ModTileEntityTypes.cobblestone_minion_9.get().create());
		}

		public CobbleMC9(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CobbleMCa extends CobblestoneMinionContainer {
		public CobbleMCa(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.cobblestone_minion_a.get(), windowId, player,
					ModTileEntityTypes.cobblestone_minion_a.get().create());
		}

		public CobbleMCa(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CobbleMCb extends CobblestoneMinionContainer {
		public CobbleMCb(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.cobblestone_minion_b.get(), windowId, player,
					ModTileEntityTypes.cobblestone_minion_b.get().create());
		}

		public CobbleMCb(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	protected CobblestoneMinionContainer(ContainerType<? extends AbstractMinionContainer> container, int windowId,
			PlayerInventory player, AbstractMinionTileEntity minion) {
		super(container, windowId, player, minion);
	}
}