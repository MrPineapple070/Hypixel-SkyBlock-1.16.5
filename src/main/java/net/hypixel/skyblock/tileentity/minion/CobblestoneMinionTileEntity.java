package net.hypixel.skyblock.tileentity.minion;

import java.util.Arrays;

import com.google.common.collect.ImmutableSet;

import net.hypixel.skyblock.blocks.minion.CobblestoneMinion;
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
			super(ModTileEntityTypes.cobblestone_minion_1.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE2 extends CobblestoneMinionTileEntity {
		public CobbleMTE2() {
			super(ModTileEntityTypes.cobblestone_minion_2.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE3 extends CobblestoneMinionTileEntity {
		public CobbleMTE3() {
			super(ModTileEntityTypes.cobblestone_minion_3.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE4 extends CobblestoneMinionTileEntity {
		public CobbleMTE4() {
			super(ModTileEntityTypes.cobblestone_minion_4.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE5 extends CobblestoneMinionTileEntity {
		public CobbleMTE5() {
			super(ModTileEntityTypes.cobblestone_minion_5.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE6 extends CobblestoneMinionTileEntity {
		public CobbleMTE6() {
			super(ModTileEntityTypes.cobblestone_minion_6.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE7 extends CobblestoneMinionTileEntity {
		public CobbleMTE7() {
			super(ModTileEntityTypes.cobblestone_minion_7.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE8 extends CobblestoneMinionTileEntity {
		public CobbleMTE8() {
			super(ModTileEntityTypes.cobblestone_minion_8.get(), MinionTier.I);
		}
	}

	public static class CobbleMTE9 extends CobblestoneMinionTileEntity {
		public CobbleMTE9() {
			super(ModTileEntityTypes.cobblestone_minion_9.get(), MinionTier.I);
		}
	}

	public static class CobbleMTEa extends CobblestoneMinionTileEntity {
		public CobbleMTEa() {
			super(ModTileEntityTypes.cobblestone_minion_a.get(), MinionTier.I);
		}
	}

	public static class CobbleMTEb extends CobblestoneMinionTileEntity {
		public CobbleMTEb() {
			super(ModTileEntityTypes.cobblestone_minion_b.get(), MinionTier.I);
		}
	}

	/**
	 * {@link ImmutableSet} of {@link Block} that this places.
	 */
	protected static final ImmutableSet<Block> valid = ImmutableSet.copyOf(Arrays.asList(Blocks.COBBLESTONE));

	public CobblestoneMinionTileEntity(TileEntityType<? extends AbstractMinionTileEntity> type, MinionTier tier) {
		super(type, tier);
	}

	@Override
	protected final Container createMenu(int id, PlayerInventory player) {
		switch (this.tier) {
		default:
			throw new IllegalStateException("Illegal MinionTier:\t" + this.tier.name());
		}
	}

	@Override
	protected final Item[] getCompactor() {
		return COMP;
	}

	@Override
	protected final StringTextComponent initDisplayName() {
		return new StringTextComponent("Cobblestone Minion Tier " + this.tier.name());
	}

	@Override
	protected final BlockState getState() {
		return Blocks.COBBLESTONE.defaultBlockState();
	}

	@Override
	protected final Item[] getSuperCompactor() {
		return new Item[] { Items.COBBLESTONE, Items.DIAMOND, Items.DIAMOND_BLOCK, ItemInit.enchanted_diamond.get() };
	}

	protected final int getSpeed(MinionTier tier) {
		return CobblestoneMinion.speed.get(tier.asInt);
	}

	public final ImmutableSet<Block> getValidBlocks() {
		return valid;
	}
}