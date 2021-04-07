package net.hypixel.skyblock.blocks.minion;

import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity.MinionTier;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

/**
 * The <a href="https://hypixel-skyblock.fandom.com/wiki/Birch_Minion">Birch
 * Minion</a>.
 * 
 * @author MrPineapple070
 * @version 04 January 2021
 * @since 11 July 2019
 */
public class BirchMinion extends AbstractMinionBlock {
	public BirchMinion(MinionTier tier) {
		super(Properties.of(Material.WOOD).sound(SoundType.WOOD), tier);
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return this.newBlockEntity(world);
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader world) {
		return ModTileEntityTypes.birch_minion.get().create();
	}
}