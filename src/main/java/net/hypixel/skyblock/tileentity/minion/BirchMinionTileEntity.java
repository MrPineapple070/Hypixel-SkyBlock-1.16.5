package net.hypixel.skyblock.tileentity.minion;

import java.util.Arrays;

import com.google.common.collect.ImmutableSet;

import net.hypixel.skyblock.items.init.ItemInit;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;

public class BirchMinionTileEntity extends AbstractForagingMTE {
	protected static final ImmutableSet<Block> valid = ImmutableSet.copyOf(Arrays.asList(Blocks.BIRCH_LOG));
	
	public static final BirchMinionTileEntity tier2() {
		return new BirchMinionTileEntity(MinionTier.II);
	}
	
	public static final BirchMinionTileEntity tier3() {
		return new BirchMinionTileEntity(MinionTier.III);
	}
	
	public static final BirchMinionTileEntity tier4() {
		return new BirchMinionTileEntity(MinionTier.IV);
	}
	
	public static final BirchMinionTileEntity tier5() {
		return new BirchMinionTileEntity(MinionTier.V);
	}
	
	public static final BirchMinionTileEntity tier6() {
		return new BirchMinionTileEntity(MinionTier.VI);
	}
	
	public static final BirchMinionTileEntity tier7() {
		return new BirchMinionTileEntity(MinionTier.VII);
	}
	
	public static final BirchMinionTileEntity tier8() {
		return new BirchMinionTileEntity(MinionTier.VIII);
	}
	
	public static final BirchMinionTileEntity tier9() {
		return new BirchMinionTileEntity(MinionTier.IX);
	}
	
	public static final BirchMinionTileEntity tiera() {
		return new BirchMinionTileEntity(MinionTier.X);
	}
	
	public static final BirchMinionTileEntity tierb() {
		return new BirchMinionTileEntity(MinionTier.XII);
	}
	
	public BirchMinionTileEntity(MinionTier tier) {
		super(ModTileEntityTypes.birch_minion.get(), tier);
	}
	
	public BirchMinionTileEntity() {
		this(MinionTier.I);
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return null;
	}

	@Override
	protected int getSpeed(MinionTier tier) {
		return 0;
	}

	@Override
	protected BlockState getState() {
		return Blocks.BIRCH_LOG.defaultBlockState();
	}

	@Override
	protected Item[] getSuperCompactor() {
		return new Item[] { Items.DIAMOND, Items.BIRCH_LOG, ItemInit.enchanted_diamond.get() };
	}

	@Override
	protected ImmutableSet<Block> getValidBlocks() {
		return valid;
	}

	@Override
	protected StringTextComponent initDisplayName() {
		return new StringTextComponent("Birch Minion Tier " + this.tier.name());
	}
}