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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

/**
 * {@link TileEntity} for the <a href=
 * "https://hypixel-skyblock.fandom.com/wiki/Cobblestone_Minion">Cobblestone
 * Minion</a>
 *
 * @author MrPineapple070
 * @version 11 June 2019
 * @since 11 June 2019
 */
public class CobblestoneMinionTileEntity extends AbstractMiningMTE {
	public static class CobbleMTE1 extends CobblestoneMinionTileEntity {
		public CobbleMTE1() {
			super(ModTileEntityTypes.cobble_minion_1.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE2 extends CobblestoneMinionTileEntity {
		public CobbleMTE2() {
			super(ModTileEntityTypes.cobble_minion_2.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE3 extends CobblestoneMinionTileEntity {
		public CobbleMTE3() {
			super(ModTileEntityTypes.cobble_minion_3.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE4 extends CobblestoneMinionTileEntity {
		public CobbleMTE4() {
			super(ModTileEntityTypes.cobble_minion_4.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE5 extends CobblestoneMinionTileEntity {
		public CobbleMTE5() {
			super(ModTileEntityTypes.cobble_minion_5.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE6 extends CobblestoneMinionTileEntity {
		public CobbleMTE6() {
			super(ModTileEntityTypes.cobble_minion_6.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE7 extends CobblestoneMinionTileEntity {
		public CobbleMTE7() {
			super(ModTileEntityTypes.cobble_minion_7.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE8 extends CobblestoneMinionTileEntity {
		public CobbleMTE8() {
			super(ModTileEntityTypes.cobble_minion_8.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE9 extends CobblestoneMinionTileEntity {
		public CobbleMTE9() {
			super(ModTileEntityTypes.cobble_minion_9.get(), MinionTier.I);
		}
	}

	public static class CobbleMTEa extends CobblestoneMinionTileEntity {
		public CobbleMTEa() {
			super(ModTileEntityTypes.cobble_minion_a.get(), MinionTier.I);
		}
	}

	public static class CobbleMTEb extends CobblestoneMinionTileEntity {
		public CobbleMTEb() {
			super(ModTileEntityTypes.cobble_minion_b.get(), MinionTier.I);
		}
	}
	
	/**
	 * Holds {@link Item} to super compact when {@link #superCompactor()}
	 */
	@Nonnull
	private static final Item[] sup = new Item[] { Items.COBBLESTONE, Items.DIAMOND, Items.DIAMOND_BLOCK, ItemInit.enchanted_diamond.get() };
	
	/**
	 * Holds how frequently to interact.
	 */
	@Nonnull
	private static final int[] speed = { 280, 280, 240, 240, 200, 200, 180, 180, 160, 160, 140 };
	
	/**
	 * {@link ImmutableSet} of {@link Block} holding valid {@link Block} to interact.
	 */
	@Nonnull
	protected static final ImmutableSet<Block> valid = ImmutableSet.copyOf(Arrays.asList(Blocks.COBBLESTONE));

	public CobblestoneMinionTileEntity(TileEntityType<? extends AbstractMinionTileEntity> type, MinionTier tier) {
		super(type, tier);
	}

	@Override
	protected final Container createMenu(int id, PlayerInventory player) {
		switch (this.tier) {
		case I:
			return MinionContainerTypes.cobblestone_minion_1.get().create(id, player);
		case II:
			return MinionContainerTypes.cobblestone_minion_2.get().create(id, player);
		case III:
			return MinionContainerTypes.cobblestone_minion_3.get().create(id, player);
		case IV:
			return MinionContainerTypes.cobblestone_minion_4.get().create(id, player);
		case V:
			return MinionContainerTypes.cobblestone_minion_5.get().create(id, player);
		case VI:
			return MinionContainerTypes.cobblestone_minion_6.get().create(id, player);
		case VII:
			return MinionContainerTypes.cobblestone_minion_7.get().create(id, player);
		case VIII:
			return MinionContainerTypes.cobblestone_minion_8.get().create(id, player);
		case IX:
			return MinionContainerTypes.cobblestone_minion_9.get().create(id, player);
		case X:
			return MinionContainerTypes.cobblestone_minion_a.get().create(id, player);
		case XI:
			return MinionContainerTypes.cobblestone_minion_b.get().create(id, player);
		default:
			throw new IllegalStateException("Illegal MinionTier:\t" + this.tier.name());
		}
	}

	@Override
	protected final Item[] getCompactor() {
		return COMP;
	}

	@Override
	protected final ITextComponent initDisplayName() {
		return new StringTextComponent("Cobblestone Minion Tier " + this.tier.name());
	}

	@Override
	protected final BlockState getState() {
		return Blocks.COBBLESTONE.defaultBlockState();
	}

	@Override
	protected final Item[] getSuperCompactor() {
		return sup;
	}

	@Override
	protected final int getSpeed(MinionTier tier) {
		return speed[tier.asInt];
	}
	
	@Override
	public final ImmutableSet<Block> getValidBlocks() {
		return valid;
	}
}