package net.hypixel.skyblock.tileentity.minion;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public abstract class AbstractFarmingPlacerMTE extends AbstractPlacerMTE {
	protected static final Map<Block, BlockState> TILLABLES = ImmutableMap.of(Blocks.GRASS_BLOCK,
			Blocks.FARMLAND.defaultBlockState(), Blocks.GRASS_PATH, Blocks.FARMLAND.defaultBlockState(), Blocks.DIRT,
			Blocks.FARMLAND.defaultBlockState(), Blocks.COARSE_DIRT, Blocks.DIRT.defaultBlockState());

	public static enum PlacingMethods {
		/**
		 * This will till in a checker board pattern
		 */
		Checkerboard,

		/**
		 * This will till all
		 */
		Normal;
	}
	
	protected final PlacingMethods method;
	
	public AbstractFarmingPlacerMTE(TileEntityType<? extends AbstractMinionTileEntity> typeIn, MinionTier tier, PlacingMethods method) {
		super(typeIn, tier);
		this.method = Objects.requireNonNull(method, "PlacingMethod cannot be null");
	}

	@Override
	protected BlockPos[][][] initSurround() {
		return new BlockPos[1][9][9];
	}

	@Override
	protected void setSurround() {
		for (int x = 0; x < 9; ++x)
			for (int z = 0; z < 9; ++z)
				this.surround[0][x][z] = expanded_2_size[x] == 0 && expanded_2_size[z] == 0 ? null
						: new BlockPos(this.x + expanded_2_size[x], this.y, this.z + expanded_2_size[z]);
		for (BlockPos[] x : this.surround[0])
			LOGGER.debug(Arrays.deepToString(x));
	}

	@Override
	protected void setValidSurround() {
		this.validSurround.clear();
		int s, e;
		switch (this.countExpander()) {
		default:
			s = 2; e = 7;
		case 1:
			s = 1; e = 8;
		case 2:
			s = 0; e = 9;
		}
		for (int x = s; x < e; ++x)
			for (int z = s; z < e; ++z) {
				BlockPos pos = this.surround[0][x][z];
				if (pos == null)
					continue;
				Material material = this.level.getBlockState(pos).getMaterial();
				LOGGER.debug(material.toString());
				if (material == Material.PLANT)
					this.validSurround.add(pos);
			}
		LOGGER.debug(this.validSurround.toString());
	}
	
	@Override
	protected boolean interact(BlockPos pos) {
		if (pos == null)
			return false;
		LOGGER.debug("Interacting with:\t" + pos.toString());
		BlockState state = this.level.getBlockState(pos);
		if (state.getMaterial() == Material.AIR) {
			this.level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), this.getSoundEventPlacing(),
					SoundCategory.BLOCKS, 1f, 1f, true);
			this.level.setBlockAndUpdate(pos, this.getState());
		} else {
			this.addItemStacks(Block.getDrops(state, (ServerWorld) this.level, pos, this));
			this.level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), this.getSoundEventBreaking(),
					SoundCategory.BLOCKS, 1f, 1f, true);
			this.level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
		}
		return true;
	}
	
	@Override
	protected SoundEvent getSoundEventPlacing() {
		return SoundEvents.CROP_PLANTED;
	}

	@Override
	protected SoundEvent getSoundEventBreaking() {
		return SoundEvents.CROP_BREAK;
	}
}