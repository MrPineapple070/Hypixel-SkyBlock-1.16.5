package net.hypixel.skyblock.tileentity.minion;

import java.util.Arrays;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableSet;

import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.items.init.ItemInit;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class IronMinionTileEntity extends AbstractMiningMTE {
	public static class IronMTE1 extends IronMinionTileEntity {
		public IronMTE1() {
			super(ModTileEntityTypes.iron_minion_1.get(), MinionTier.I);
		}
	}
	
	public static class IronMTE2 extends IronMinionTileEntity {
		public IronMTE2() {
			super(ModTileEntityTypes.iron_minion_2.get(), MinionTier.I);
		}
	}
	
	public static class IronMTE3 extends IronMinionTileEntity {
		public IronMTE3() {
			super(ModTileEntityTypes.iron_minion_3.get(), MinionTier.I);
		}
	}
	
	public static class IronMTE4 extends IronMinionTileEntity {
		public IronMTE4() {
			super(ModTileEntityTypes.iron_minion_4.get(), MinionTier.I);
		}
	}
	
	public static class IronMTE5 extends IronMinionTileEntity {
		public IronMTE5() {
			super(ModTileEntityTypes.iron_minion_5.get(), MinionTier.I);
		}
	}
	
	public static class IronMTE6 extends IronMinionTileEntity {
		public IronMTE6() {
			super(ModTileEntityTypes.iron_minion_6.get(), MinionTier.I);
		}
	}
	
	public static class IronMTE7 extends IronMinionTileEntity {
		public IronMTE7() {
			super(ModTileEntityTypes.iron_minion_7.get(), MinionTier.I);
		}
	}
	
	public static class IronMTE8 extends IronMinionTileEntity {
		public IronMTE8() {
			super(ModTileEntityTypes.iron_minion_8.get(), MinionTier.I);
		}
	}
	
	public static class IronMTE9 extends IronMinionTileEntity {
		public IronMTE9() {
			super(ModTileEntityTypes.iron_minion_9.get(), MinionTier.I);
		}
	}
	
	public static class IronMTEa extends IronMinionTileEntity {
		public IronMTEa() {
			super(ModTileEntityTypes.iron_minion_a.get(), MinionTier.I);
		}
	}
	
	public static class IronMTEb extends IronMinionTileEntity {
		public IronMTEb() {
			super(ModTileEntityTypes.iron_minion_b.get(), MinionTier.I);
		}
	}
	
	/**
	 * Primitive type array holding how frequently to interact.
	 */
	@Nonnull
	private static final int[] speed = { 340, 340, 300, 300, 280, 280, 240, 240, 200, 200, 160 };
	
	/**
	 * Holds {@link Item} to {@link #compactor()}
	 */
	@Nonnull
	private static final Item[] comp = new Item[] { Items.DIAMOND, Items.IRON_INGOT };
	
	/**
	 * {@link ImmutableSet} of {@link Block} holding valid {@link Block} to interact.
	 */
	@Nonnull
	private static final ImmutableSet<Block> valid = ImmutableSet.copyOf(Arrays.asList(Blocks.IRON_ORE));
	
	/**
	 * Holds {@link Item} to {@link #superCompactor()}
	 */
	@Nonnull
	private static final Item[] sup = new Item[] { Items.DIAMOND, Items.DIAMOND_BLOCK, Items.IRON_INGOT, Items.IRON_BLOCK,
			ItemInit.enchanted_diamond.get(), ItemInit.enchanted_iron_ingot.get() };

	public IronMinionTileEntity(TileEntityType<? extends AbstractMinionTileEntity> type, MinionTier tier) {
		super(type, tier);
	}

	@Override
	protected BlockState getState() {
		return Blocks.IRON_ORE.defaultBlockState();
	}

	@Override
	protected ImmutableSet<Block> getValidBlocks() {
		return valid;
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		switch (this.tier) {
		case I:
			return MinionContainerTypes.iron_minion_1.get().create(id, player);
		case II:
			return MinionContainerTypes.iron_minion_2.get().create(id, player);
		case III:
			return MinionContainerTypes.iron_minion_3.get().create(id, player);
		case IV:
			return MinionContainerTypes.iron_minion_4.get().create(id, player);
		case V:
			return MinionContainerTypes.iron_minion_5.get().create(id, player);
		case VI:
			return MinionContainerTypes.iron_minion_6.get().create(id, player);
		case VII:
			return MinionContainerTypes.iron_minion_7.get().create(id, player);
		case VIII:
			return MinionContainerTypes.iron_minion_8.get().create(id, player);
		case IX:
			return MinionContainerTypes.iron_minion_9.get().create(id, player);
		case X:
			return MinionContainerTypes.iron_minion_a.get().create(id, player);
		case XI:
			return MinionContainerTypes.iron_minion_b.get().create(id, player);
		default:
			throw new IllegalStateException("Illegal MinionTier:\t" + this.tier.name());
		}
	}

	@Override
	protected Item[] getCompactor() {
		return comp;
	}

	@Override
	protected int getSpeed(MinionTier tier) {
		return speed[tier.asInt];
	}

	@Override
	protected Item[] getSuperCompactor() {
		return sup;
	}

	@Override
	protected ITextComponent initDisplayName() {
		return new StringTextComponent("Iron Minion Tier " + this.tier.name());
	}
}