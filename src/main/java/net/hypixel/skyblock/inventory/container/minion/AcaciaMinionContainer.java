package net.hypixel.skyblock.inventory.container.minion;

import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;

public class AcaciaMinionContainer extends AbstractMinionContainer {
	public static class AcaciaMC1 extends AcaciaMinionContainer {
		public AcaciaMC1(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.acacia_minion_1.get(), windowId, player,
					ModTileEntityTypes.acacia_minion_1.get().create());
		}

		public AcaciaMC1(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class AcaciaMC2 extends AcaciaMinionContainer {
		public AcaciaMC2(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.acacia_minion_2.get(), windowId, player,
					ModTileEntityTypes.acacia_minion_2.get().create());
		}

		public AcaciaMC2(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class AcaciaMC3 extends AcaciaMinionContainer {
		public AcaciaMC3(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.acacia_minion_3.get(), windowId, player,
					ModTileEntityTypes.acacia_minion_3.get().create());
		}

		public AcaciaMC3(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class AcaciaMC4 extends AcaciaMinionContainer {
		public AcaciaMC4(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.acacia_minion_4.get(), windowId, player,
					ModTileEntityTypes.acacia_minion_4.get().create());
		}

		public AcaciaMC4(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class AcaciaMC5 extends AcaciaMinionContainer {
		public AcaciaMC5(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.acacia_minion_5.get(), windowId, player,
					ModTileEntityTypes.acacia_minion_5.get().create());
		}

		public AcaciaMC5(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class AcaciaMC6 extends AcaciaMinionContainer {
		public AcaciaMC6(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.acacia_minion_6.get(), windowId, player,
					ModTileEntityTypes.acacia_minion_6.get().create());
		}

		public AcaciaMC6(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class AcaciaMC7 extends AcaciaMinionContainer {
		public AcaciaMC7(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.acacia_minion_7.get(), windowId, player,
					ModTileEntityTypes.acacia_minion_7.get().create());
		}

		public AcaciaMC7(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class AcaciaMC8 extends AcaciaMinionContainer {
		public AcaciaMC8(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.acacia_minion_8.get(), windowId, player,
					ModTileEntityTypes.acacia_minion_8.get().create());
		}

		public AcaciaMC8(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class AcaciaMC9 extends AcaciaMinionContainer {
		public AcaciaMC9(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.acacia_minion_9.get(), windowId, player,
					ModTileEntityTypes.acacia_minion_9.get().create());
		}

		public AcaciaMC9(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class AcaciaMCa extends AcaciaMinionContainer {
		public AcaciaMCa(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.acacia_minion_a.get(), windowId, player,
					ModTileEntityTypes.acacia_minion_a.get().create());
		}

		public AcaciaMCa(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class AcaciaMCb extends AcaciaMinionContainer {
		public AcaciaMCb(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.acacia_minion_b.get(), windowId, player,
					ModTileEntityTypes.acacia_minion_b.get().create());
		}

		public AcaciaMCb(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	protected AcaciaMinionContainer(ContainerType<AcaciaMinionContainer> containerType, int windowId,
			PlayerInventory player, AbstractMinionTileEntity minion) {
		super(containerType, windowId, player, minion);
	}
}