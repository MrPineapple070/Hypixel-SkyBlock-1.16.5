package net.hypixel.skyblock.inventory.container.minion;

import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;

public class IronMinionContainer extends AbstractMinionContainer {
	public static class IronMC1 extends IronMinionContainer {
		public IronMC1(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.iron_minion_1.get(), windowId, player,
					ModTileEntityTypes.iron_minion_1.get().create());
		}

		public IronMC1(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}
	
	public static class IronMC2 extends IronMinionContainer {
		public IronMC2(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.iron_minion_2.get(), windowId, player,
					ModTileEntityTypes.iron_minion_2.get().create());
		}

		public IronMC2(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}
	
	public static class IronMC3 extends IronMinionContainer {
		public IronMC3(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.iron_minion_3.get(), windowId, player,
					ModTileEntityTypes.iron_minion_3.get().create());
		}

		public IronMC3(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}
	
	public static class IronMC4 extends IronMinionContainer {
		public IronMC4(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.iron_minion_4.get(), windowId, player,
					ModTileEntityTypes.iron_minion_4.get().create());
		}

		public IronMC4(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}
	
	public static class IronMC5 extends IronMinionContainer {
		public IronMC5(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.iron_minion_5.get(), windowId, player,
					ModTileEntityTypes.iron_minion_5.get().create());
		}

		public IronMC5(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}
	
	public static class IronMC6 extends IronMinionContainer {
		public IronMC6(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.iron_minion_6.get(), windowId, player,
					ModTileEntityTypes.iron_minion_6.get().create());
		}

		public IronMC6(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}
	
	public static class IronMC7 extends IronMinionContainer {
		public IronMC7(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.iron_minion_7.get(), windowId, player,
					ModTileEntityTypes.iron_minion_7.get().create());
		}

		public IronMC7(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}
	
	public static class IronMC8 extends IronMinionContainer {
		public IronMC8(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.iron_minion_8.get(), windowId, player,
					ModTileEntityTypes.iron_minion_8.get().create());
		}

		public IronMC8(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}
	
	public static class IronMC9 extends IronMinionContainer {
		public IronMC9(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.iron_minion_9.get(), windowId, player,
					ModTileEntityTypes.iron_minion_9.get().create());
		}

		public IronMC9(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}
	
	public static class IronMCa extends IronMinionContainer {
		public IronMCa(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.iron_minion_a.get(), windowId, player,
					ModTileEntityTypes.iron_minion_a.get().create());
		}

		public IronMCa(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}
	
	public static class IronMCb extends IronMinionContainer {
		public IronMCb(int windowId, PlayerInventory player) {
			super(MinionContainerTypes.iron_minion_b.get(), windowId, player,
					ModTileEntityTypes.iron_minion_b.get().create());
		}

		public IronMCb(int windowId, PlayerInventory player, PacketBuffer data) {
			this(windowId, player);
		}
	}

	protected IronMinionContainer(ContainerType<IronMinionContainer> type, int windowId, PlayerInventory player,
			AbstractMinionTileEntity tileEntity) {
		super(type, windowId, player, tileEntity);
	}
}