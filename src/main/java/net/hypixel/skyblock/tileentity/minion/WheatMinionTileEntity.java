package net.hypixel.skyblock.tileentity.minion;

import java.util.Arrays;

import com.google.common.collect.ImmutableSet;

import net.hypixel.skyblock.inventory.container.minion.WheatMinionContainer;
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
 * The {@link AbstractMinionTileEntity} for the
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Wheat_Minion">Wheat
 * Minion</a>.
 *
 * @author MrPineapple070
 * @version 11 July 2019
 * @since 11 July 2019
 */
public class WheatMinionTileEntity extends AbstractFarmingPlacerMTE {
	protected static final ImmutableSet<Block> valid = ImmutableSet.copyOf(Arrays.asList(Blocks.WHEAT));
	
	protected static final int[] speed = {15, 15, 13, 13, 11, 11, 10, 10, 9, 9, 8};

	public WheatMinionTileEntity(MinionTier tier) {
		super(ModTileEntityTypes.wheat_minion.get(), tier, PlacingMethods.Normal);
	}
	
	public WheatMinionTileEntity() {
		this(MinionTier.I);
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new WheatMinionContainer(id, player, this);
	}

	@Override
	protected Item[] getCompactor() {
		return new Item[] { Items.WHEAT, Items.DIAMOND };
	}

	@Override
	protected int getSpeed(MinionTier tier) {
		return speed[tier.asInt];
	}

	@Override
	protected BlockState getState() {
		return Blocks.WHEAT.defaultBlockState();
	}

	@Override
	protected Item[] getSuperCompactor() {
		return new Item[] { Items.WHEAT, Items.HAY_BLOCK, Items.WHEAT_SEEDS, Items.DIAMOND, Items.DIAMOND_BLOCK,
				ItemInit.enchanted_diamond.get() };
	}

	@Override
	protected ImmutableSet<Block> getValidBlocks() {
		return valid;
	}

	@Override
	protected StringTextComponent initDisplayName() {
		return new StringTextComponent("Wheat Minion Tier " + this.tier.name());
	}
}