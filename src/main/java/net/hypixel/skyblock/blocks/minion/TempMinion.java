package net.hypixel.skyblock.blocks.minion;

import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity.MinionTier;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class TempMinion extends AbstractMinionBlock {

	public TempMinion(MinionTier tier) {
		super(Properties.copy(Blocks.STONE), tier);
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
		return null;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return null;
	}
}