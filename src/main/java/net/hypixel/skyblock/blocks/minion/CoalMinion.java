package net.hypixel.skyblock.blocks.minion;

import java.util.Arrays;

import com.google.common.collect.ImmutableList;

import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity.MinionTier;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

/**
 * The base for all Coal Minion
 *
 * @author MrPineapple070
 * @version 23 July 2020
 */
public class CoalMinion extends AbstractMinionBlock {
	/**
	 * An {@code Array} of {@code int} that determine the number of ticks between
	 * actions.
	 */
	public static final ImmutableList<Integer> speed = ImmutableList
			.copyOf(Arrays.asList(300, 300, 260, 260, 240, 240, 200, 200, 180, 180, 140));

	public CoalMinion(MinionTier tier) {
		super(Properties.of(Material.STONE).sound(SoundType.STONE), tier);
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return this.newBlockEntity(world);
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader world) {
		return ModTileEntityTypes.coal_minion.get().create();
	}
}