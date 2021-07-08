package net.hypixel.skyblock.inventory.container.minion;

import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;

public class WheatMinionContainer extends AbstractMinionContainer {
	public static class WheatMC1 extends WheatMinionContainer {
		public WheatMC1(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.wheat_minion_1.get(), windowId, player,
					ModTileEntityTypes.wheat_minion_1.get().create());
		}

		public WheatMC1(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class WheatMC2 extends WheatMinionContainer {
		public WheatMC2(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.wheat_minion_2.get(), windowId, player,
					ModTileEntityTypes.wheat_minion_2.get().create());
		}

		public WheatMC2(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class WheatMC3 extends WheatMinionContainer {
		public WheatMC3(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.wheat_minion_3.get(), windowId, player,
					ModTileEntityTypes.wheat_minion_3.get().create());
		}

		public WheatMC3(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class WheatMC4 extends WheatMinionContainer {
		public WheatMC4(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.wheat_minion_4.get(), windowId, player,
					ModTileEntityTypes.wheat_minion_4.get().create());
		}

		public WheatMC4(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class WheatMC5 extends WheatMinionContainer {
		public WheatMC5(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.wheat_minion_5.get(), windowId, player,
					ModTileEntityTypes.wheat_minion_5.get().create());
		}

		public WheatMC5(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class WheatMC6 extends WheatMinionContainer {
		public WheatMC6(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.wheat_minion_6.get(), windowId, player,
					ModTileEntityTypes.wheat_minion_6.get().create());
		}

		public WheatMC6(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class WheatMC7 extends WheatMinionContainer {
		public WheatMC7(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.wheat_minion_7.get(), windowId, player,
					ModTileEntityTypes.wheat_minion_7.get().create());
		}

		public WheatMC7(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class WheatMC8 extends WheatMinionContainer {
		public WheatMC8(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.wheat_minion_8.get(), windowId, player,
					ModTileEntityTypes.wheat_minion_8.get().create());
		}

		public WheatMC8(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class WheatMC9 extends WheatMinionContainer {
		public WheatMC9(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.wheat_minion_9.get(), windowId, player,
					ModTileEntityTypes.wheat_minion_9.get().create());
		}

		public WheatMC9(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class WheatMCa extends WheatMinionContainer {
		public WheatMCa(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.wheat_minion_a.get(), windowId, player,
					ModTileEntityTypes.wheat_minion_a.get().create());
		}

		public WheatMCa(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class WheatMCb extends WheatMinionContainer {
		public WheatMCb(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.wheat_minion_b.get(), windowId, player,
					ModTileEntityTypes.wheat_minion_b.get().create());
		}

		public WheatMCb(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	protected WheatMinionContainer(ContainerType<WheatMinionContainer> container, int id, PlayerInventory player,
			AbstractMinionTileEntity minion) {
		super(container, id, player, minion);
	}
}