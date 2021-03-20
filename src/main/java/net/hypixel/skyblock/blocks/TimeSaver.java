package net.hypixel.skyblock.blocks;

import java.util.Random;

import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.hypixel.skyblock.util.TimeConverter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.world.ClientWorld.ClientWorldInfo;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.IServerWorldInfo;
import net.minecraft.world.storage.IWorldInfo;
import net.minecraftforge.common.ToolType;

/**
 * When this block exists in the world, the world will remain at the indicated
 * time.<br>
 * Extended by {@link DaySaver} and {@link NightSaver}.<br>
 * If both of these blocks exist in the world, both blocks have no effect.
 *
 * @author MrPineapple070
 * @version 07 October 2020
 * @since 07 October 2020
 */
public abstract class TimeSaver extends ContainerBlock {
	/**
	 * While this block exists in the world, the world will remain at the indicated
	 * day time.
	 */
	public static class DaySaver extends TimeSaver {
		public DaySaver() {
			super();
		}

		@Override
		public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		}

		@Override
		public TileEntity createTileEntity(BlockState state, IBlockReader world) {
			return this.newBlockEntity(world);
		}

		@Override
		public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
			IWorldInfo info = worldIn.getLevelData();
			if (info instanceof IServerWorldInfo)
				((IServerWorldInfo) info).setGameTime(TimeConverter.hours.get(0));
			else if (info instanceof ClientWorldInfo)
				((ClientWorldInfo) info).setGameTime(TimeConverter.hours.get(0));
			return;
		}

		@Override
		public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
			return ModTileEntityTypes.day_saver.get().create();
		}
	}

	/**
	 * While this block exists in the world, the world will remain at the indicated
	 * night time.
	 */
	public static class NightSaver extends TimeSaver {
		public NightSaver() {
			super();
		}

		@Override
		public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		}

		@Override
		public TileEntity createTileEntity(BlockState state, IBlockReader world) {
			return this.newBlockEntity(world);
		}

		@Override
		public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
			IWorldInfo info = worldIn.getLevelData();
			if (info instanceof IServerWorldInfo)
				((IServerWorldInfo) info).setGameTime(TimeConverter.hours.get(0));
			else if (info instanceof ClientWorldInfo)
				((ClientWorldInfo) info).setGameTime(TimeConverter.hours.get(0));
			return;
		}

		@Override
		public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
			return ModTileEntityTypes.night_saver.get().create();
		}
	}

	/**
	 * A {@link VoxelShape}
	 */
	protected static final VoxelShape shape = Block.box(0d, 0d, 0d, 16d, 6d, 16d);

	protected TimeSaver() {
		super(Properties.of(Material.WOOD).strength(.2f, .2f).sound(SoundType.WOOD).harvestTool(ToolType.AXE));
	}

	@Override
	public abstract void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand);

	@Override
	public abstract TileEntity createTileEntity(BlockState state, IBlockReader world);

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return shape;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand,
			BlockRayTraceResult result) {
		if (worldIn.isClientSide)
			return ActionResultType.SUCCESS;
		else if (player.isSpectator())
			return ActionResultType.SUCCESS;
		else {
			final TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof AbstractMinionTileEntity) {
				player.openMenu((AbstractMinionTileEntity) tileentity);
				return ActionResultType.SUCCESS;
			}
			return ActionResultType.PASS;
		}
	}

	@Override
	public abstract void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer,
			ItemStack stack);
}