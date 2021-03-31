package net.hypixel.skyblock.items.accessories;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.ReforgableItem;
import net.hypixel.skyblock.items.Reforge;
import net.hypixel.skyblock.items.UpgradableItem;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

/**
 * A Generic Accessory. <br>
 * These {@link Item} will give the player certain effects while in its
 * inventory.
 *
 * @author MrPineapple070
 * @version 18 May 2020
 * @since 21 June 2019
 */
public abstract class Accessory extends Item implements ReforgableItem, UpgradableItem {
	protected static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * The {@link ModItemRarity} of this.
	 */
	@Nonnull
	protected ModItemRarity rarity;

	/**
	 * The current {@link AccessoryReforge}
	 */
	@Nullable
	protected Reforge reforge = Reforge.None;

	/**
	 * Determine if this is upgraded.
	 */
	protected boolean upgraded;

	protected Accessory(Properties properties, ModItemRarity rarity) {
		super(properties);
		this.rarity = Objects.requireNonNull(rarity, "Accessory rarity must be non-null");
		this.upgraded = false;
	}

	@Override
	public abstract void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn);

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return false;
	}

	@Override
	public boolean canAttackBlock(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		return false;
	}

	@Override
	public boolean canBeDepleted() {
		return false;
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 0;
	}

	@Override
	public ITextComponent getName(ItemStack stack) {
		return new TranslationTextComponent(this.getOrCreateDescriptionId()).withStyle(this.rarity.color);
	}

	@Override
	public ModItemRarity getRarity() {
		return this.rarity;
	}

	@Override
	public Reforge getReforge() {
		return this.reforge;
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return false;
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return false;
	}

	@Override
	public void reforge() {
		this.reforge = AccessoryReforge.getRandomReforge();
	}

	@Override
	public void setRarity(ModItemRarity rarity) {
		this.rarity = Objects.requireNonNull(rarity, "New ModItemRarity cannot be null");
	}

	@Override
	public void setReforge(Reforge reforge) {
		this.reforge = reforge;
	}

	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return false;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [rarity=" + this.rarity + ", reforge=" + this.reforge + ", upgraded="
				+ this.upgraded + "]";
	}

	/**
	 * Upgrade {@link #rarity}. Each {@code Accessory} can only be upgraded once.
	 *
	 * @return {@code true} if upgrade successful.<br>
	 *         {@code false} if upgrade unsuccessful.
	 */
	@Override
	public boolean upgrade() {
		if (this.upgraded)
			return false;
		try {
			this.rarity = this.rarity.getNext();
			this.upgraded = true;
			return true;
		} catch (final IllegalStateException ise) {
			return false;
		}
	}
}