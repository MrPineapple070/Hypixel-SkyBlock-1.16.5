package net.hypixel.skyblock.inventory.container.minion;

import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;

public class BirchMinionContainer extends AbstractMinionContainer {
	public static class BirchMC1 extends BirchMinionContainer {
		public BirchMC1(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.birch_minion_1.get(), windowId, player,
					ModTileEntityTypes.birch_minion_1.get().create());
		}

		public BirchMC1(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BirchMC2 extends BirchMinionContainer {
		public BirchMC2(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.birch_minion_2.get(), windowId, player,
					ModTileEntityTypes.birch_minion_2.get().create());
		}

		public BirchMC2(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BirchMC3 extends BirchMinionContainer {
		public BirchMC3(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.birch_minion_3.get(), windowId, player,
					ModTileEntityTypes.birch_minion_3.get().create());
		}

		public BirchMC3(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BirchMC4 extends BirchMinionContainer {
		public BirchMC4(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.birch_minion_4.get(), windowId, player,
					ModTileEntityTypes.birch_minion_4.get().create());
		}

		public BirchMC4(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BirchMC5 extends BirchMinionContainer {
		public BirchMC5(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.birch_minion_5.get(), windowId, player,
					ModTileEntityTypes.birch_minion_5.get().create());
		}

		public BirchMC5(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BirchMC6 extends BirchMinionContainer {
		public BirchMC6(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.birch_minion_6.get(), windowId, player,
					ModTileEntityTypes.birch_minion_6.get().create());
		}

		public BirchMC6(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BirchMC7 extends BirchMinionContainer {
		public BirchMC7(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.birch_minion_7.get(), windowId, player,
					ModTileEntityTypes.birch_minion_7.get().create());
		}

		public BirchMC7(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BirchMC8 extends BirchMinionContainer {
		public BirchMC8(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.birch_minion_8.get(), windowId, player,
					ModTileEntityTypes.birch_minion_8.get().create());
		}

		public BirchMC8(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BirchMC9 extends BirchMinionContainer {
		public BirchMC9(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.birch_minion_9.get(), windowId, player,
					ModTileEntityTypes.birch_minion_9.get().create());
		}

		public BirchMC9(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BirchMCa extends BirchMinionContainer {
		public BirchMCa(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.birch_minion_a.get(), windowId, player,
					ModTileEntityTypes.birch_minion_a.get().create());
		}

		public BirchMCa(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BirchMCb extends BirchMinionContainer {
		public BirchMCb(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.birch_minion_b.get(), windowId, player,
					ModTileEntityTypes.birch_minion_b.get().create());
		}

		public BirchMCb(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public BirchMinionContainer(ContainerType<? extends AbstractMinionContainer> type, int windowId,
			PlayerInventory player, AbstractMinionTileEntity tileEntity) {
		super(type, windowId, player, tileEntity);
	}
}