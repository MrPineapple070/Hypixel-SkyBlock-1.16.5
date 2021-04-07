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
 * @author MrPineapple070
 * @version 11 July 2019
 * @since 11 July 2019
 */
public class WheatMinion extends AbstractMinionBlock {
	public static final ImmutableList<Integer> speed = ImmutableList
			.copyOf(Arrays.asList(300, 300, 260, 260, 220, 220, 200, 200, 180, 180, 180));

	public WheatMinion(MinionTier tier) {
		super(Properties.of(Material.PLANT).sound(SoundType.CROP), tier);
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return this.newBlockEntity(world);
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader world) {
		return ModTileEntityTypes.wheat_minion.get().create();
	}
}