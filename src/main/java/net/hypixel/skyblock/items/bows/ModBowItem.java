package net.hypixel.skyblock.items.bows;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.items.HotPotatoBook;
import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.PotatoBookableItem;
import net.hypixel.skyblock.items.ReforgableItem;
import net.hypixel.skyblock.items.Reforge;
import net.hypixel.skyblock.items.UpgradableItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

/**
 * Serve as a base for {@link BowItem}.
 *
 * @author MrPineapple070
 * @version 13 August 2020
 * @since 13 August 2020
 */
public abstract class ModBowItem extends BowItem implements ReforgableItem, UpgradableItem, PotatoBookableItem {
	protected static final ITextComponent item_ability = new TranslationTextComponent("bow.ability");

	/**
	 * Determine if {@link #rarity} has been changed.
	 */
	protected boolean isUpgraded;

	/**
	 * The number of {@link HotPotatoBook} applied.
	 */
	@Nonnegative
	protected int numPotatoBook;

	/**
	 * {@link ModItemRarity} of this.
	 */
	@Nonnull
	protected ModItemRarity rarity;

	/**
	 * {@link Reforge} of this.
	 */
	@Nullable
	protected Reforge reforge = Reforge.None;

	@Nonnull
	protected ITextComponent reforge_display = StringTextComponent.EMPTY;

	protected ModBowItem(Properties builder, ModItemRarity rarity) {
		super(builder);
		this.rarity = Objects.requireNonNull(rarity, "ModItemRarity cannot be null");
		this.isUpgraded = false;
		this.numPotatoBook = 0;
	}

	@Override
	public abstract void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn);

	@Override
	public final boolean apply() {
		if (this.numPotatoBook == 10)
			return false;
		++this.numPotatoBook;
		return true;
	}

	@Override
	public boolean canBeDepleted() {
		return false;
	}

	@Override
	public final ITextComponent getName(ItemStack stack) {
		return new TranslationTextComponent(this.getOrCreateDescriptionId()).withStyle(this.rarity.color);
	}

	@Override
	public final ModItemRarity getRarity() {
		return this.rarity;
	}

	@Override
	public final Reforge getReforge() {
		return this.reforge;
	}

	@Override
	public final void reforge() {
		this.reforge = BowReforge.getRandomReforge();
		try {
			this.reforge_display = new StringTextComponent(
					this.reforge.getClass().getMethod("name", (Class<?>[]) null).invoke(this.reforge) + "");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			HypixelSkyBlockMod.LOGGER.error(e.getLocalizedMessage());
			for (StackTraceElement element : e.getStackTrace())
				HypixelSkyBlockMod.LOGGER.error(element.toString());
		}
	}

	@Override
	public final void setRarity(ModItemRarity rarity) {
		HypixelSkyBlockMod.LOGGER.warn("Setting rarity:\t" + rarity.getNext());
		this.rarity = rarity;
	}

	@Override
	public final void setReforge(Reforge reforge) {
		this.reforge = reforge;
	}

	@Override
	public final boolean upgrade() {
		if (this.isUpgraded)
			return false;
		this.rarity = this.rarity.getNext();
		return true;
	}
}