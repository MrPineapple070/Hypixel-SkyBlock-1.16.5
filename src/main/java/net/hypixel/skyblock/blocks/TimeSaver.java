package net.hypixel.skyblock.blocks;

import java.util.Objects;

import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.TimeSaverTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

/**
 * When this block exists in the world, the world will remain at the indicated
 * time.<br>
 * If both of these blocks exist in the world, both blocks have no effect.
 *
 * @author MrPineapple070
 * @version 07 October 2020
 * @since 07 October 2020
 */
public class TimeSaver extends ContainerBlock {
	public static enum TimeSaverType {
		Day,
		Night;
	}

	/**
	 * A {@link VoxelShape}
	 */
	protected static final VoxelShape shape = Block.box(0d, 0d, 0d, 16d, 6d, 16d);
	
	public final TimeSaverType type;
	
	public TimeSaver(TimeSaverType type) {
		super(Properties.of(Material.WOOD).strength(.2f, .2f).sound(SoundType.WOOD).harvestTool(ToolType.AXE));
		this.type = Objects.requireNonNull(type, "TimeSaverType cannot be null");
	}

	@Override
	public final TileEntity createTileEntity(BlockState state, IBlockReader world) {
		switch (this.type) {
		case Day:
			return ModTileEntityTypes.day_saver.get().create(); 
		case Night:
			return ModTileEntityTypes.night_saver.get().create();
		default:
			throw new IllegalStateException("Illegal TimeSaverType:\t" + this.type.name());
		}
	}
	
	@Override
	public final VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return shape;
	}
	
	@Override
	public BlockRenderType getRenderShape(BlockState p_149645_1_) {
		return BlockRenderType.MODEL;
	}
	
	@Override
	public final boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	@Deprecated
	public final TileEntity newBlockEntity(IBlockReader world) {
		return createTileEntity(null, world);
	}

	@Override
	public final ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand,
			BlockRayTraceResult result) {
		if (worldIn.isClientSide)
			return ActionResultType.SUCCESS;
		final TileEntity te = worldIn.getBlockEntity(pos);
		if (te instanceof TimeSaverTileEntity)
			player.openMenu((TimeSaverTileEntity) te);
		return ActionResultType.CONSUME;
	}
	
	@Override
	public boolean useShapeForLightOcclusion(BlockState p_220074_1_) {
		return true;
	}
}