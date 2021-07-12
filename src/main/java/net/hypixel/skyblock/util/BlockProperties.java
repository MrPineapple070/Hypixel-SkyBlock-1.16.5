package net.hypixel.skyblock.util;

import java.util.function.ToIntFunction;

import javax.annotation.concurrent.Immutable;

import net.minecraft.block.AbstractBlock.AbstractBlockState;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.DyeColor;
import net.minecraft.state.properties.BedPart;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

@Immutable
public final class BlockProperties {
	/**
	 * Always return true
	 * 
	 * @param state {@link BlockState}
	 * @param world {@link IBlockReader}
	 * @param pos   {@link BlockPos}
	 * @return true
	 */
	public static boolean always(BlockState state, IBlockReader world, BlockPos pos) {
		return true;
	}

	/**
	 * Always return true
	 * 
	 * @param state {@link BlockState}
	 * @param world {@link IBlockReader}
	 * @param pos   {@link BlockPos}
	 * @param type  {@link EntityType}
	 * @return true
	 */
	public static boolean always(BlockState state, IBlockReader world, BlockPos pos, EntityType<?> type) {
		return true;
	}

	/**
	 * Gets a {@link BedBlock} from {@link DyeColor}
	 * 
	 * @param color {@link DyeColor} of bed
	 * @return {@link BedBlock}
	 */
	public static BedBlock bed(DyeColor color) {
		return new BedBlock(color, Properties.of(Material.WOOL, (part) -> {
			return part.getValue(BedBlock.PART) == BedPart.FOOT ? color.getMaterialColor() : MaterialColor.WOOL;
		}).sound(SoundType.WOOD).strength(.2f).noOcclusion());
	}

	/**
	 * Makes {@link LeavesBlock}
	 * 
	 * @return {@link LeavesBlock}
	 */
	public static LeavesBlock leaves() {
		return new LeavesBlock(Properties.of(Material.LEAVES).strength(.2f).randomTicks().sound(SoundType.GRASS)
				.noOcclusion().isSuffocating(BlockProperties::never)
				.isViewBlocking(BlockProperties::never));
	}
	
	/**
	 * Returns the amount of light to emit.
	 * 
	 * @param light amount of light to emit
	 * @return {@link ToIntFunction} of {@link BlockState} light emission
	 */
	public static ToIntFunction<BlockState> litBlockEmission(int light) {
		return (state) -> {
			return state.getValue(BlockStateProperties.LIT) ? light : 0;
		};
	}
	
	/**
	 * Creates a Log
	 * 
	 * @param color0 {@link MaterialColor}
	 * @param color1 {@link MaterialColor}
	 * @return {@link RotatedPillarBlock}
	 */
	public static RotatedPillarBlock log(MaterialColor color0, MaterialColor color1) {
		return new RotatedPillarBlock(Properties.of(Material.WOOD, (state) -> {
			return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? color0 : color1;
		}).strength(2f).sound(SoundType.WOOD));
	}
	
	/**
	 * Always return false
	 * 
	 * @param state {@link BlockState}
	 * @param world {@link IBlockReader}
	 * @param pos	{@link BlockPos}
	 * @return false
	 */
	public static boolean never(BlockState state, IBlockReader world, BlockPos pos) {
		return false;
	}
	
	/**
	 * Always return false
	 * 
	 * @param state {@link BlockState}
	 * @param world {@link IBlockReader}
	 * @param pos	{@link BlockPos}
	 * @param type	{@link EntityType}
	 * @return	false
	 */
	public static boolean never(BlockState state, IBlockReader world, BlockPos pos, EntityType<?> type) {
		return false;
	}
	
	/**
	 * Rebuild Cache
	 */
	@SuppressWarnings("deprecation")
	public static void rebuildCache() {
		Block.BLOCK_STATE_REGISTRY.forEach(AbstractBlockState::initCache);
	}
}