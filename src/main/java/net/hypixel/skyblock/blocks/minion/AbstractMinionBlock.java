package net.hypixel.skyblock.blocks.minion;

import java.util.Objects;

import javax.annotation.Nonnull;

import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity.MinionTier;
import net.hypixel.skyblock.util.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

/**
 * This class serves as the base for all Minions.
 *
 * @author MrPineapple070
 * @version 28 May 2020
 */
public abstract class AbstractMinionBlock extends ContainerBlock {
	/**
	 * A {@link DirectionProperty} for this
	 */
	@Nonnull
	public static final DirectionProperty facing = BlockStateProperties.HORIZONTAL_FACING;

	/**
	 * The {@link MinionTier} for this
	 */
	@Nonnull
	protected final MinionTier tier;
	
	protected AbstractMinionBlock(Properties properties, MinionTier tier) {
		super(properties.strength(0f, 0x800f).noOcclusion().isValidSpawn(BlockProperties::never)
				.isRedstoneConductor(BlockProperties::never).isSuffocating(BlockProperties::never)
				.isViewBlocking(BlockProperties::never));
		this.tier = Objects.requireNonNull(tier, "Minion Block must have a Tier");
		this.registerDefaultState(this.stateDefinition.any().setValue(facing, Direction.NORTH));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(facing);
	}

	@Override
	public abstract TileEntity createTileEntity(BlockState state, IBlockReader world);

	@Override
	@Deprecated
	public final TileEntity newBlockEntity(IBlockReader world) {
		return this.createTileEntity(null, world);
	}

	@Override
	public void destroy(IWorld world, BlockPos pos, BlockState state) {
		if (world.isClientSide())
			return;
		final TileEntity te = world.getBlockEntity(pos);
		if (te instanceof AbstractMinionTileEntity)
			InventoryHelper.dropContents((World) world, pos, ((AbstractMinionTileEntity) te).getItems());
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.defaultBlockState().setValue(facing, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	@Deprecated
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(facing)));
	}

	@Override
	@Deprecated
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(facing, rot.rotate(state.getValue(facing)));
	}

	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand,
			BlockRayTraceResult result) {
		if (worldIn.isClientSide)
			return ActionResultType.PASS;
		else if (player.isSpectator())
			return ActionResultType.PASS;
		final TileEntity tileentity = worldIn.getBlockEntity(pos);
		if (tileentity instanceof AbstractMinionTileEntity) {
			player.openMenu((AbstractMinionTileEntity) tileentity);
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.PASS;
	}
}