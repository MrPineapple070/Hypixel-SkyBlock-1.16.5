package net.hypixel.skyblock.tileentity.minion;

import java.util.Arrays;

import com.google.common.collect.ImmutableSet;

import net.hypixel.skyblock.blocks.minion.AcaciaMinion;
import net.hypixel.skyblock.inventory.container.minion.AcaciaMinionContainer;
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

/**
 * @author MrPineapple070
 * @version 31 December 2020
 * @since 11 July 2019
 */
public class AcaciaMinionTileEntity extends AbstractForagingMTE {
	public static AcaciaMinionTileEntity tier2() {
		return new AcaciaMinionTileEntity(MinionTier.II);
	}
	
	public static AcaciaMinionTileEntity tier3() {
		return new AcaciaMinionTileEntity(MinionTier.III);
	}
	
	public static AcaciaMinionTileEntity tier4() {
		return new AcaciaMinionTileEntity(MinionTier.IV);
	}
	
	public static AcaciaMinionTileEntity tier5() {
		return new AcaciaMinionTileEntity(MinionTier.V);
	}
	
	public static AcaciaMinionTileEntity tier6() {
		return new AcaciaMinionTileEntity(MinionTier.VI);
	}
	
	public static AcaciaMinionTileEntity tier7() {
		return new AcaciaMinionTileEntity(MinionTier.VII);
	}
	
	public static AcaciaMinionTileEntity tier8() {
		return new AcaciaMinionTileEntity(MinionTier.VIII);
	}
	
	public static AcaciaMinionTileEntity tier9() {
		return new AcaciaMinionTileEntity(MinionTier.IX);
	}
	
	public static AcaciaMinionTileEntity tiera() {
		return new AcaciaMinionTileEntity(MinionTier.X);
	}
	
	public static AcaciaMinionTileEntity tierb() {
		return new AcaciaMinionTileEntity(MinionTier.XI);
	}
	
	protected static final ImmutableSet<Block> valid = ImmutableSet.copyOf(Arrays.asList(Blocks.ACACIA_LOG));
	
	public AcaciaMinionTileEntity(MinionTier tier) {
		super(ModTileEntityTypes.acacia_minion_1.get(), tier);
	}
	
	public AcaciaMinionTileEntity() {
		this(MinionTier.I);
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new AcaciaMinionContainer(id, player, this);
	}

	@Override
	protected int getSpeed(MinionTier tier) {
		return AcaciaMinion.speed.get(tier.asInt);
	}

	@Override
	protected BlockState getState() {
		return Blocks.ACACIA_SAPLING.defaultBlockState();
	}

	@Override
	protected Item[] getSuperCompactor() {
		return new Item[] { Items.DIAMOND, Items.ACACIA_LOG, ItemInit.enchanted_diamond.get() };
	}

	@Override
	protected ImmutableSet<Block> getValidBlocks() {
		return valid;
	}

	@Override
	public StringTextComponent initDisplayName() {
		return new StringTextComponent("Acacia Minion Tier " + this.tier.name());
	}
}