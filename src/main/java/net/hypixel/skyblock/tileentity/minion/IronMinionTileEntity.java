package net.hypixel.skyblock.tileentity.minion;

import java.util.Arrays;

import com.google.common.collect.ImmutableSet;

import net.hypixel.skyblock.items.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;

public class IronMinionTileEntity extends AbstractMiningMTE {
	protected static final int[] speed = { 17, 17, 15, 15, 14, 14, 12, 12, 10, 10, 8 };
	protected static final Item[] comp = new Item[] { Items.DIAMOND, Items.IRON_INGOT };
	protected static final ImmutableSet<Block> valid = ImmutableSet.copyOf(Arrays.asList(Blocks.IRON_ORE));

	public IronMinionTileEntity(MinionTier tier) {
		super(null, tier);
	}

	public IronMinionTileEntity() {
		this(MinionTier.I);
	}

	@Override
	protected BlockState getState() {
		return Blocks.IRON_ORE.defaultBlockState();
	}

	@Override
	protected ImmutableSet<Block> getValidBlocks() {
		return valid;
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return null;
	}

	@Override
	protected Item[] getCompactor() {
		return comp;
	}

	@Override
	protected int getSpeed(MinionTier tier) {
		return speed[tier.asInt];
	}

	@Override
	protected Item[] getSuperCompactor() {
		return new Item[] { Items.DIAMOND, Items.DIAMOND_BLOCK, Items.IRON_INGOT, Items.IRON_BLOCK,
				ItemInit.enchanted_diamond.get(), ItemInit.enchanted_iron_ingot.get() };
	}

	@Override
	protected StringTextComponent initDisplayName() {
		return new StringTextComponent("Iron Minion Tier " + this.tier.name());
	}
}