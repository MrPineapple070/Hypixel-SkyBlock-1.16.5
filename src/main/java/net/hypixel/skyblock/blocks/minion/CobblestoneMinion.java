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
 * The base for all Cobblestone Minion
 *
 * @author MrPineapple070
 * @version 11 July 2019
 * @since 11 July 2019
 */
public class CobblestoneMinion extends AbstractMinionBlock {
	/**
	 * An {@code Array} of {@code int} that determine the number of ticks between
	 * actions.
	 */
	public static final ImmutableList<Integer> speed = ImmutableList
			.copyOf(Arrays.asList(280, 280, 240, 240, 200, 200, 180, 180, 160, 160, 140));

	public CobblestoneMinion(MinionTier tier) {
		super(Properties.of(Material.STONE).sound(SoundType.STONE), tier);
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return this.newBlockEntity(world);
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader world) {
		switch (this.tier) {
		case I:
			ModTileEntityTypes.cobblestone_minion_1.get().create();
		case II:
			ModTileEntityTypes.cobblestone_minion_2.get().create();
		case III:
			ModTileEntityTypes.cobblestone_minion_3.get().create();
		case IV:
			ModTileEntityTypes.cobblestone_minion_4.get().create();
		case V:
			ModTileEntityTypes.cobblestone_minion_5.get().create();
		case VI:
			ModTileEntityTypes.cobblestone_minion_6.get().create();
		case VII:
			ModTileEntityTypes.cobblestone_minion_7.get().create();
		case VIII:
			ModTileEntityTypes.cobblestone_minion_8.get().create();
		case IX:
			ModTileEntityTypes.cobblestone_minion_9.get().create();
		case X:
			ModTileEntityTypes.cobblestone_minion_a.get().create();
		case XI:
			ModTileEntityTypes.cobblestone_minion_b.get().create();
		default:
			throw new IllegalStateException("Illegal MinionTier:\t" + this.tier.name());
		}
	}
}