package net.hypixel.skyblock.blocks.minion;

import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity.MinionTier;
import net.hypixel.skyblock.tileentity.minion.IronMinionTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class IronMinion extends AbstractMinionBlock {

	public IronMinion(MinionTier tier) {
		super(Properties.of(Material.METAL).sound(SoundType.METAL), tier);
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new IronMinionTileEntity(this.tier);
	}
}