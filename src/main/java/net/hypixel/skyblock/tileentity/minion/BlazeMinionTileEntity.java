package net.hypixel.skyblock.tileentity.minion;

import net.hypixel.skyblock.inventory.container.minion.BlazeMinionContainer;
import net.hypixel.skyblock.items.init.ItemInit;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;

public class BlazeMinionTileEntity extends AbstractSummonerMTE {
	protected static int[] speed = {33, 33, 31, 31, 28, 28, 25, 25, 21, 21, 16};
	
	public BlazeMinionTileEntity(MinionTier tier) {
		super(ModTileEntityTypes.blaze_minion_1.get(), tier, EntityType.BLAZE);
	}
	
	public BlazeMinionTileEntity() {
		this(MinionTier.I);
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new BlazeMinionContainer(id, player, this);
	}

	@Override
	protected Item[] getSuperCompactor() {
		return new Item[] {Items.DIAMOND, Items.DIAMOND_BLOCK, ItemInit.enchanted_diamond.get(), Items.BLAZE_ROD};
	}

	@Override
	protected StringTextComponent initDisplayName() {
		return new StringTextComponent("Blaze Minion Tier " + this.tier.name());
	}

	@Override
	protected int getSpeed(MinionTier tier) {
		return speed[tier.asInt];
	}
}