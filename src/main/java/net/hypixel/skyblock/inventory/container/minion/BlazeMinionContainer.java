package net.hypixel.skyblock.inventory.container.minion;

import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;

public class BlazeMinionContainer extends AbstractMinionContainer {
	public static class BlazeMC1 extends BlazeMinionContainer {
		public BlazeMC1(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.blaze_minion_1.get(), windowId, player,
					ModTileEntityTypes.blaze_minion_1.get().create());
		}

		public BlazeMC1(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BlazeMC2 extends BlazeMinionContainer {
		public BlazeMC2(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.blaze_minion_2.get(), windowId, player,
					ModTileEntityTypes.blaze_minion_2.get().create());
		}

		public BlazeMC2(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BlazeMC3 extends BlazeMinionContainer {
		public BlazeMC3(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.blaze_minion_3.get(), windowId, player,
					ModTileEntityTypes.blaze_minion_3.get().create());
		}

		public BlazeMC3(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BlazeMC4 extends BlazeMinionContainer {
		public BlazeMC4(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.blaze_minion_4.get(), windowId, player,
					ModTileEntityTypes.blaze_minion_4.get().create());
		}

		public BlazeMC4(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BlazeMC5 extends BlazeMinionContainer {
		public BlazeMC5(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.blaze_minion_5.get(), windowId, player,
					ModTileEntityTypes.blaze_minion_5.get().create());
		}

		public BlazeMC5(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BlazeMC6 extends BlazeMinionContainer {
		public BlazeMC6(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.blaze_minion_6.get(), windowId, player,
					ModTileEntityTypes.blaze_minion_6.get().create());
		}

		public BlazeMC6(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BlazeMC7 extends BlazeMinionContainer {
		public BlazeMC7(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.blaze_minion_7.get(), windowId, player,
					ModTileEntityTypes.blaze_minion_7.get().create());
		}

		public BlazeMC7(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BlazeMC8 extends BlazeMinionContainer {
		public BlazeMC8(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.blaze_minion_8.get(), windowId, player,
					ModTileEntityTypes.blaze_minion_8.get().create());
		}

		public BlazeMC8(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BlazeMC9 extends BlazeMinionContainer {
		public BlazeMC9(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.blaze_minion_9.get(), windowId, player,
					ModTileEntityTypes.blaze_minion_9.get().create());
		}

		public BlazeMC9(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BlazeMCa extends BlazeMinionContainer {
		public BlazeMCa(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.blaze_minion_a.get(), windowId, player,
					ModTileEntityTypes.blaze_minion_a.get().create());
		}

		public BlazeMCa(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	public static class BlazeMCb extends BlazeMinionContainer {
		public BlazeMCb(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.blaze_minion_b.get(), windowId, player,
					ModTileEntityTypes.blaze_minion_b.get().create());
		}

		public BlazeMCb(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	protected BlazeMinionContainer(ContainerType<? extends AbstractMinionContainer> container, int windowId,
			PlayerInventory player, AbstractMinionTileEntity minion) {
		super(container, windowId, player, minion);
	}
}