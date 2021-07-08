package net.hypixel.skyblock.tileentity.minion;

import java.util.Arrays;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableSet;

import net.hypixel.skyblock.inventory.container.minion.BirchMinionContainer.BirchMC1;
import net.hypixel.skyblock.inventory.container.minion.BirchMinionContainer.BirchMC2;
import net.hypixel.skyblock.inventory.container.minion.BirchMinionContainer.BirchMC3;
import net.hypixel.skyblock.inventory.container.minion.BirchMinionContainer.BirchMC4;
import net.hypixel.skyblock.inventory.container.minion.BirchMinionContainer.BirchMC5;
import net.hypixel.skyblock.inventory.container.minion.BirchMinionContainer.BirchMC6;
import net.hypixel.skyblock.inventory.container.minion.BirchMinionContainer.BirchMC7;
import net.hypixel.skyblock.inventory.container.minion.BirchMinionContainer.BirchMC8;
import net.hypixel.skyblock.inventory.container.minion.BirchMinionContainer.BirchMC9;
import net.hypixel.skyblock.inventory.container.minion.BirchMinionContainer.BirchMCa;
import net.hypixel.skyblock.inventory.container.minion.BirchMinionContainer.BirchMCb;
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

public class BirchMinionTileEntity extends AbstractForagingMTE {
	public static class BirchMTE1 extends BirchMinionTileEntity {
		public BirchMTE1() {
			super(ModTileEntityTypes.birch_minion_1.get(), MinionTier.I);
		}
	}

	public static class BirchMTE2 extends BirchMinionTileEntity {
		public BirchMTE2() {
			super(ModTileEntityTypes.birch_minion_2.get(), MinionTier.II);
		}
	}

	public static class BirchMTE3 extends BirchMinionTileEntity {
		public BirchMTE3() {
			super(ModTileEntityTypes.birch_minion_1.get(), MinionTier.III);
		}
	}

	public static class BirchMTE4 extends BirchMinionTileEntity {
		public BirchMTE4() {
			super(ModTileEntityTypes.birch_minion_1.get(), MinionTier.IV);
		}
	}

	public static class BirchMTE5 extends BirchMinionTileEntity {
		public BirchMTE5() {
			super(ModTileEntityTypes.birch_minion_1.get(), MinionTier.V);
		}
	}

	public static class BirchMTE6 extends BirchMinionTileEntity {
		public BirchMTE6() {
			super(ModTileEntityTypes.birch_minion_1.get(), MinionTier.VI);
		}
	}

	public static class BirchMTE7 extends BirchMinionTileEntity {
		public BirchMTE7() {
			super(ModTileEntityTypes.birch_minion_1.get(), MinionTier.VII);
		}
	}

	public static class BirchMTE8 extends BirchMinionTileEntity {
		public BirchMTE8() {
			super(ModTileEntityTypes.birch_minion_1.get(), MinionTier.VIII);
		}
	}

	public static class BirchMTE9 extends BirchMinionTileEntity {
		public BirchMTE9() {
			super(ModTileEntityTypes.birch_minion_1.get(), MinionTier.IX);
		}
	}

	public static class BirchMTEa extends BirchMinionTileEntity {
		public BirchMTEa() {
			super(ModTileEntityTypes.birch_minion_1.get(), MinionTier.X);
		}
	}

	public static class BirchMTEb extends BirchMinionTileEntity {
		public BirchMTEb() {
			super(ModTileEntityTypes.birch_minion_1.get(), MinionTier.XI);
		}
	}
	
	/**
	 * Primitive type array of int holding how frequently to interact.
	 */
	@Nonnull
	protected static final int[] speed = { 960, 960, 900, 900, 840, 840, 760, 760, 660, 660, 540};
	
	/**
	 * {@link ImmutableSet} of {@link Block} holding valid {@link Block} to break.
	 */
	@Nonnull
	protected static final ImmutableSet<Block> valid = ImmutableSet.copyOf(Arrays.asList(Blocks.BIRCH_LOG));
	
	public BirchMinionTileEntity(TileEntityType<? extends AbstractMinionTileEntity> type, MinionTier tier) {
		super(type, tier);
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		switch (this.tier) {
		case I:
			return new BirchMC1(id, player);
		case II:
			return new BirchMC2(id, player);
		case III:
			return new BirchMC3(id, player);
		case IV:
			return new BirchMC4(id, player);
		case V:
			return new BirchMC5(id, player);
		case VI:
			return new BirchMC6(id, player);
		case VII:
			return new BirchMC7(id, player);
		case VIII:
			return new BirchMC8(id, player);
		case IX:
			return new BirchMC9(id, player);
		case X:
			return new BirchMCa(id, player);
		case XI:
			return new BirchMCb(id, player);
		default:
			throw new IllegalStateException("Illegal MinionTier:\t" + this.tier.name());
		}
	}

	@Override
	protected int getSpeed(MinionTier tier) {
		return speed[tier.asInt];
	}

	@Override
	protected BlockState getState() {
		return Blocks.BIRCH_LOG.defaultBlockState();
	}

	@Override
	protected Item[] getSuperCompactor() {
		return new Item[] { Items.DIAMOND, Items.BIRCH_LOG, ItemInit.enchanted_diamond.get() };
	}

	@Override
	protected ImmutableSet<Block> getValidBlocks() {
		return valid;
	}

	@Override
	protected ITextComponent initDisplayName() {
		return new StringTextComponent("Birch Minion Tier " + this.tier.name());
	}
}