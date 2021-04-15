package net.hypixel.skyblock.inventory.container.minion;

import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
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
	public static class CoalMC1 extends CoalMinionContainer {
		public CoalMC1(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.coal_minion_1.get(), windowId, player,
					ModTileEntityTypes.coal_minion_1.get().create());
		}

		public CoalMC1(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CoalMC2 extends CoalMinionContainer {
		public CoalMC2(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.coal_minion_2.get(), windowId, player,
					ModTileEntityTypes.coal_minion_2.get().create());
		}

		public CoalMC2(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CoalMC3 extends CoalMinionContainer {
		public CoalMC3(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.coal_minion_3.get(), windowId, player,
					ModTileEntityTypes.coal_minion_3.get().create());
		}

		public CoalMC3(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CoalMC4 extends CoalMinionContainer {
		public CoalMC4(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.coal_minion_4.get(), windowId, player,
					ModTileEntityTypes.coal_minion_4.get().create());
		}

		public CoalMC4(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CoalMC5 extends CoalMinionContainer {
		public CoalMC5(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.coal_minion_5.get(), windowId, player,
					ModTileEntityTypes.coal_minion_5.get().create());
		}

		public CoalMC5(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CoalMC6 extends CoalMinionContainer {
		public CoalMC6(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.coal_minion_6.get(), windowId, player,
					ModTileEntityTypes.coal_minion_6.get().create());
		}

		public CoalMC6(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CoalMC7 extends CoalMinionContainer {
		public CoalMC7(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.coal_minion_7.get(), windowId, player,
					ModTileEntityTypes.coal_minion_7.get().create());
		}

		public CoalMC7(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CoalMC8 extends CoalMinionContainer {
		public CoalMC8(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.coal_minion_8.get(), windowId, player,
					ModTileEntityTypes.coal_minion_8.get().create());
		}

		public CoalMC8(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CoalMC9 extends CoalMinionContainer {
		public CoalMC9(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.coal_minion_9.get(), windowId, player,
					ModTileEntityTypes.coal_minion_9.get().create());
		}

		public CoalMC9(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CoalMCa extends CoalMinionContainer {
		public CoalMCa(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.coal_minion_a.get(), windowId, player,
					ModTileEntityTypes.coal_minion_a.get().create());
		}

		public CoalMCa(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class CoalMCb extends CoalMinionContainer {
		public CoalMCb(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.coal_minion_b.get(), windowId, player,
					ModTileEntityTypes.coal_minion_b.get().create());
		}

		public CoalMCb(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	protected CoalMinionContainer(ContainerType<? extends AbstractMinionContainer> container, int windowId,
			PlayerInventory player, AbstractMinionTileEntity minion) {
		super(container, windowId, player, minion);
	}
}