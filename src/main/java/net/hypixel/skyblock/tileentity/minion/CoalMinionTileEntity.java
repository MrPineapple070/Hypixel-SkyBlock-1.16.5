package net.hypixel.skyblock.tileentity.minion;

import java.util.Arrays;

import com.google.common.collect.ImmutableSet;

import net.hypixel.skyblock.inventory.container.minion.CobblestoneMinionContainer;
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
 * The base for Coal Minion TileEntity
 *
 * @author MrPineapple070
 * @version 23 July 2020
 */
public class CoalMinionTileEntity extends AbstractMiningMTE {
	private static final ImmutableSet<Block> validBlocks = ImmutableSet
			.copyOf(Arrays.asList(Blocks.AIR, Blocks.COAL_ORE));
	protected static final Item[] comp = new Item[] { Items.COAL, Items.DIAMOND };
	protected static final Item[] sup = new Item[] { Items.COAL, Items.COAL_BLOCK, Items.DIAMOND, Items.DIAMOND_BLOCK,
			ItemInit.enchanted_coal.get(), ItemInit.enchanted_diamond.get() };
	protected static final int[] speed = {};
	
	public CoalMinionTileEntity(MinionTier tier) {
		super(ModTileEntityTypes.coal_minion.get(), tier);
	}
	
	public CoalMinionTileEntity() {
		this(MinionTier.I);
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new CobblestoneMinionContainer(id, player, this);
	}

	@Override
	protected Item[] getCompactor() {
		return comp;
	}

	@Override
	protected BlockState getState() {
		return Blocks.COAL_ORE.defaultBlockState();
	}

	@Override
	protected Item[] getSuperCompactor() {
		return sup;
	}

	@Override
	protected int getSpeed(MinionTier tier) {
		return speed[tier.asInt];
	}

	@Override
	protected ImmutableSet<Block> getValidBlocks() {
		return validBlocks;
	}

	@Override
	protected StringTextComponent initDisplayName() {
		return new StringTextComponent("Coal Minion Tier " + this.tier.name());
	}
}