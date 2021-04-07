package net.hypixel.skyblock.tileentity.minion;

import java.util.Arrays;

import com.google.common.collect.ImmutableSet;

import net.hypixel.skyblock.blocks.minion.CobblestoneMinion;
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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.StringTextComponent;

/**
 * {@link TileEntity} for the <a href=
 * "https://hypixel-skyblock.fandom.com/wiki/Cobblestone_Minion">Cobblestone
 * Minion</a>
 *
 * @author MrPineapple070
 * @version 11 June 2019
 * @since 11 June 2019
 */
public class CobblestoneMinionTileEntity extends AbstractMiningMTE {
	/**
	 * {@link ImmutableSet} of {@link Block} that this places.
	 */
	protected static final ImmutableSet<Block> valid = ImmutableSet.copyOf(Arrays.asList(Blocks.COBBLESTONE));

	public CobblestoneMinionTileEntity(MinionTier tier) {
		super(ModTileEntityTypes.cobblestone_minion.get(), tier);
	}

	public CobblestoneMinionTileEntity() {
		this(MinionTier.I);
	}

	@Override
	protected final Container createMenu(int id, PlayerInventory player) {
		return new CobblestoneMinionContainer(id, player, this);
	}

	@Override
	protected final Item[] getCompactor() {
		return COMP;
	}

	@Override
	protected final StringTextComponent initDisplayName() {
		return new StringTextComponent("Cobblestone Minion Tier " + this.tier.name());
	}

	@Override
	protected final BlockState getState() {
		return Blocks.COBBLESTONE.defaultBlockState();
	}

	@Override
	protected final Item[] getSuperCompactor() {
		return new Item[] { Items.COBBLESTONE, Items.DIAMOND, Items.DIAMOND_BLOCK, ItemInit.enchanted_diamond.get() };
	}

	protected final int getSpeed(MinionTier tier) {
		return CobblestoneMinion.speed.get(tier.asInt);
	}

	public final ImmutableSet<Block> getValidBlocks() {
		return valid;
	}
}