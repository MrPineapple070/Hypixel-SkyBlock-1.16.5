package net.hypixel.skyblock.tileentity.minion;

import java.util.Arrays;

import com.google.common.collect.ImmutableSet;

import net.hypixel.skyblock.inventory.container.minion.WheatMinionContainer;
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
 * The {@link AbstractMinionTileEntity} for the
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Wheat_Minion">Wheat
 * Minion</a>.
 *
 * @author MrPineapple070
 * @version 11 July 2019
 * @since 11 July 2019
 */
public class WheatMinionTileEntity extends AbstractFarmingPlacerMTE {
	public static class WheatMTE1 extends WheatMinionTileEntity {
		public WheatMTE1() {
			super(ModTileEntityTypes.wheat_minion_1.get(), MinionTier.I);
		}
	}

	public static class WheatMTE2 extends WheatMinionTileEntity {
		public WheatMTE2() {
			super(ModTileEntityTypes.wheat_minion_2.get(), MinionTier.II);
		}
	}

	public static class WheatMTE3 extends WheatMinionTileEntity {
		public WheatMTE3() {
			super(ModTileEntityTypes.wheat_minion_3.get(), MinionTier.III);
		}
	}

	public static class WheatMTE4 extends WheatMinionTileEntity {
		public WheatMTE4() {
			super(ModTileEntityTypes.wheat_minion_4.get(), MinionTier.IV);
		}
	}

	public static class WheatMTE5 extends WheatMinionTileEntity {
		public WheatMTE5() {
			super(ModTileEntityTypes.wheat_minion_5.get(), MinionTier.V);
		}
	}

	public static class WheatMTE6 extends WheatMinionTileEntity {
		public WheatMTE6() {
			super(ModTileEntityTypes.wheat_minion_6.get(), MinionTier.VI);
		}
	}

	public static class WheatMTE7 extends WheatMinionTileEntity {
		public WheatMTE7() {
			super(ModTileEntityTypes.wheat_minion_7.get(), MinionTier.VII);
		}
	}

	public static class WheatMTE8 extends WheatMinionTileEntity {
		public WheatMTE8() {
			super(ModTileEntityTypes.wheat_minion_8.get(), MinionTier.VIII);
		}
	}

	public static class WheatMTE9 extends WheatMinionTileEntity {
		public WheatMTE9() {
			super(ModTileEntityTypes.wheat_minion_9.get(), MinionTier.IX);
		}
	}

	public static class WheatMTEa extends WheatMinionTileEntity {
		public WheatMTEa() {
			super(ModTileEntityTypes.wheat_minion_a.get(), MinionTier.X);
		}
	}

	public static class WheatMTEb extends WheatMinionTileEntity {
		public WheatMTEb() {
			super(ModTileEntityTypes.wheat_minion_b.get(), MinionTier.XI);
		}
	}
	
	protected static final ImmutableSet<Block> valid = ImmutableSet.copyOf(Arrays.asList(Blocks.WHEAT));
	
	protected static final int[] speed = {15, 15, 13, 13, 11, 11, 10, 10, 9, 9, 8};

	public WheatMinionTileEntity(TileEntityType<? extends WheatMinionTileEntity> typeIn, MinionTier tier) {
		super(typeIn, tier);
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new WheatMinionContainer(id, player, this);
	}

	@Override
	protected Item[] getCompactor() {
		return new Item[] { Items.WHEAT, Items.DIAMOND };
	}

	@Override
	protected int getSpeed(MinionTier tier) {
		return speed[tier.asInt];
	}

	@Override
	protected BlockState getState() {
		return Blocks.WHEAT.defaultBlockState();
	}

	@Override
	protected Item[] getSuperCompactor() {
		return new Item[] { Items.WHEAT, Items.HAY_BLOCK, Items.WHEAT_SEEDS, Items.DIAMOND, Items.DIAMOND_BLOCK,
				ItemInit.enchanted_diamond.get() };
	}

	@Override
	protected ImmutableSet<Block> getValidBlocks() {
		return valid;
	}

	@Override
	protected StringTextComponent initDisplayName() {
		return new StringTextComponent("Wheat Minion Tier " + this.tier.name());
	}
}