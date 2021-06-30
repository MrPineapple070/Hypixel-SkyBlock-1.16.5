package net.hypixel.skyblock.tileentity.minion;

import java.util.Arrays;

import net.hypixel.skyblock.items.init.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;

/**
 * Serve as a base for all Foraging Minions.
 * 
 * @author MrPineapple070
 * @version 20 January 2021
 * @since 11 July 2019
 */
public abstract class AbstractForagingMTE extends AbstractPlacerMTE {
	/**
	 * Array of {@link Item} that {@link #getCompactor()} will return.
	 */
	protected static final Item[] comp = new Item[] { Items.DIAMOND };

	/**
	 * Array of differentials when {@link #countItem(Item)} of
	 * {@link ItemInit#minion_expander} == 0
	 */
	protected static final int[] default_size = { -2, 0, 2 };

	/**
	 * Array of differentials when {@link #countItem(Item)} of
	 * {@link ItemInit#minion_expander} == 2
	 */
	protected static final int[] expanded_1_size = { -4, -2, 0, 2, 4 };

	/**
	 * Array of differentials when {@link #countItem(Item)} of
	 * {@link ItemInit#minion_expander} == 1
	 */
	protected static final int[] expanded_size = { -3, -1, 1, 3 };
	
	protected final BlockPos[] large = new BlockPos[16], medium = new BlockPos[12], small = new BlockPos[8];

	public AbstractForagingMTE(TileEntityType<? extends AbstractMinionTileEntity> typeIn, MinionTier tier) {
		super(typeIn, tier);
	}

	@Override
	protected final Item[] getCompactor() {
		return comp;
	}

	@Override
	protected final SoundEvent getSoundEventBreaking() {
		return SoundEvents.WOOD_BREAK;
	}

	@Override
	protected final SoundEvent getSoundEventPlacing() {
		return SoundEvents.WOOD_PLACE;
	}

	@Override
	protected final BlockPos[][][] initSurround() {
		return new BlockPos[1][5][9];
	}

	@Override
	protected final void setSurround() {
		LOGGER.debug("Gathering Surrounding BlockPos.");
		int index_x = 0;
		for (int x : expanded_1_size) {
			int index_z = 0;
			for (int z : expanded_1_size) {
				this.surround[0][index_x][index_z] = x == 0 && z == 0 ? null : this.worldPosition.offset(x, 0, z);
				index_z += 2;
			}
			index_x += 1;
		}
		index_x = 0;
		for (int x : expanded_size) {
			int index_z = 1;
			for (int z : expanded_size) {
				this.surround[0][index_x][index_z] = Math.abs(x) <= 1 && Math.abs(z) <= 1 ? null
						: this.worldPosition.offset(x, 0, z);
				index_z += 2;
			}
			index_x += 1;
		}

		int index = 0;
		for (int i = 0; i < this.surround[0].length; i++)
			for (int j = 0; j < this.surround[0][i].length; j += 2)
				switch (i) {
				case 1: case 2: case 3:
					if (!(j == 0 || j == 8))
						continue;
				default:
					large[index++] = this.surround[0][i][j];
					continue;
				}
		
		index = 0;
		for (int i = 0; i < this.surround[0].length; i++)
			for (int j = 1; j < this.surround[0][i].length; j += 2)
				if (this.surround[0][i][j] == null)
					continue;
				else
					this.medium[index++] = this.surround[0][i][j];
		
		index = 0;
		for (int i = 1; i < 4; i++)
			for (int j : new int[] {2, 4, 6})
				if (this.surround[0][i][j] != null)
					this.small[index++] = this.surround[0][i][j];
		
		LOGGER.debug(Arrays.deepToString(this.surround));
		LOGGER.debug(Arrays.deepToString(this.large));
		LOGGER.debug(Arrays.deepToString(this.medium));
		LOGGER.debug(Arrays.deepToString(this.small));
	}

	@Override
	protected void setValidSurround() {
		LOGGER.debug("Gathering valid BlockPos");
		this.validSurround.clear();
		for (BlockPos[][] y : this.surround)
			for (BlockPos[] x : y)
				for (BlockPos pos : x) {
					if (pos == null)
						continue;
					BlockState state = this.level.getBlockState(pos);
					if (state.getMaterial() == Material.AIR) {
						if (this.level.getBlockState(pos.below()).getMaterial() == Material.DIRT)
							this.validSurround.add(pos);
					} else if (this.isBlockValid(state.getBlock()))
						this.validSurround.add(pos);
					else
						continue;
				}
		LOGGER.debug(this.validSurround.toString());
	}
}