package net.hypixel.skyblock.blocks.minion;

import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity.MinionTier;
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
		switch (this.tier) {
		case I:
			return ModTileEntityTypes.iron_minion_1.get().create();
		case II:
			return ModTileEntityTypes.iron_minion_2.get().create();
		case III:
			return ModTileEntityTypes.iron_minion_3.get().create();
		case IV:
			return ModTileEntityTypes.iron_minion_4.get().create();
		case V:
			return ModTileEntityTypes.iron_minion_5.get().create();
		case VI:
			return ModTileEntityTypes.iron_minion_6.get().create();
		case VII:
			return ModTileEntityTypes.iron_minion_7.get().create();
		case VIII:
			return ModTileEntityTypes.iron_minion_8.get().create();
		case IX:
			return ModTileEntityTypes.iron_minion_9.get().create();
		case X:
			return ModTileEntityTypes.iron_minion_a.get().create();
		case XI:
			return ModTileEntityTypes.iron_minion_b.get().create();
		default:
			throw new IllegalStateException("Illegal MinionTier:\t" + this.tier.name());
		}
	}
}