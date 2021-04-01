package net.hypixel.skyblock.tileentity.minion;

import java.util.Arrays;

import com.google.common.collect.ImmutableSet;

import net.hypixel.skyblock.inventory.container.minion.CobblestoneMinionContainer;
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
import net.minecraft.util.text.StringTextComponent;

/**
 * The base for Coal Minion TileEntity
 *
 * @author MrPineapple070
 * @version 23 July 2020
 */
public class CoalMinionTileEntity extends AbstractMiningMTE {
	public static class CoalMTE1 extends CoalMinionTileEntity {
		public CoalMTE1() {
			super(ModTileEntityTypes.coal_minion_1.get(), MinionTier.I);
		}
	}

	public static class CoalMTE2 extends CoalMinionTileEntity {
		public CoalMTE2() {
			super(ModTileEntityTypes.coal_minion_2.get(), MinionTier.II);
		}
	}

	public static class CoalMTE3 extends CoalMinionTileEntity {
		public CoalMTE3() {
			super(ModTileEntityTypes.coal_minion_3.get(), MinionTier.III);
		}
	}

	public static class CoalMTE4 extends CoalMinionTileEntity {
		public CoalMTE4() {
			super(ModTileEntityTypes.coal_minion_4.get(), MinionTier.IV);
		}
	}

	public static class CoalMTE5 extends CoalMinionTileEntity {
		public CoalMTE5() {
			super(ModTileEntityTypes.coal_minion_5.get(), MinionTier.V);
		}
	}

	public static class CoalMTE6 extends CoalMinionTileEntity {
		public CoalMTE6() {
			super(ModTileEntityTypes.coal_minion_6.get(), MinionTier.VI);
		}
	}

	public static class CoalMTE7 extends CoalMinionTileEntity {
		public CoalMTE7() {
			super(ModTileEntityTypes.coal_minion_7.get(), MinionTier.VII);
		}
	}

	public static class CoalMTE8 extends CoalMinionTileEntity {
		public CoalMTE8() {
			super(ModTileEntityTypes.coal_minion_8.get(), MinionTier.VIII);
		}
	}

	public static class CoalMTE9 extends CoalMinionTileEntity {
		public CoalMTE9() {
			super(ModTileEntityTypes.coal_minion_9.get(), MinionTier.IX);
		}
	}

	public static class CoalMTEa extends CoalMinionTileEntity {
		public CoalMTEa() {
			super(ModTileEntityTypes.coal_minion_a.get(), MinionTier.X);
		}
	}

	public static class CoalMTEb extends CoalMinionTileEntity {
		public CoalMTEb() {
			super(ModTileEntityTypes.coal_minion_b.get(), MinionTier.XI);
		}
	}

	private static final ImmutableSet<Block> validBlocks = ImmutableSet
			.copyOf(Arrays.asList(Blocks.AIR, Blocks.COAL_ORE));

	protected static final Item[] comp = new Item[] { Items.COAL, Items.DIAMOND };
	protected static final Item[] sup = new Item[] { Items.COAL, Items.COAL_BLOCK, Items.DIAMOND, Items.DIAMOND_BLOCK,
			ItemInit.enchanted_coal.get(), ItemInit.enchanted_diamond.get() };
	protected static final int[] speed = {};

	protected CoalMinionTileEntity(TileEntityType<? extends AbstractMinionTileEntity> typeIn, MinionTier tier) {
		super(typeIn, tier);
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new CobblestoneMinionContainer(id, player, this);
	}

	@Override
	protected Item[] getCompactor() {
		return comp;
	}

	@Override
	protected BlockState getState() {
		return Blocks.COAL_ORE.defaultBlockState();
	}

	@Override
	protected Item[] getSuperCompactor() {
		return sup;
	}

	@Override
	protected int getSpeed(MinionTier tier) {
		return speed[tier.asInt];
	}

	@Override
	protected ImmutableSet<Block> getValidBlocks() {
		return validBlocks;
	}

	@Override
	protected StringTextComponent initDisplayName() {
		return new StringTextComponent("Coal Minion Tier " + this.tier.name());
	}
}