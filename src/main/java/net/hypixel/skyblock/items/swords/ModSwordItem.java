package net.hypixel.skyblock.items.swords;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.hypixel.skyblock.items.HotPotatoBook;
import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.PotatoBookableItem;
import net.hypixel.skyblock.items.ReforgableItem;
import net.hypixel.skyblock.items.Reforge;
import net.hypixel.skyblock.items.UpgradableItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

/**
 * Serve as a base for {@link SwordItem}.
 *
 * @author MrPineapple070
 * @version 07 July 2020
 * @since 11 June 2019
 */
public abstract class ModSwordItem extends SwordItem implements ReforgableItem, UpgradableItem, PotatoBookableItem {
	protected static final Logger LOGGER = LogManager.getLogger();
	public static final ITextComponent item_ability = new TranslationTextComponent("sword.ability");

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

	protected ITextComponent reforge_display = new StringTextComponent("");

	/**
	 * Construct this
	 *
	 * @param tier    {@link ModSwordTier} of this.
	 * @param builder {@link Properties} of this.
	 * @param rarity  {@link ModItemRarity} of this.
	 */
	protected ModSwordItem(ModSwordTier tier, Properties builder, ModItemRarity rarity) {
		super(tier, -1, Float.POSITIVE_INFINITY, builder);
		this.rarity = rarity;
		this.isUpgraded = false;
	}

	@Override
	public abstract void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn);

	@Override
	public boolean apply() {
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
	public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
		return super.damageItem(stack, 0, entity, onBroken);
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
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}

	@Override
	public void reforge() {
		this.reforge = SwordReforge.getRandomReforge();
		try {
			this.reforge_display = new StringTextComponent(
					this.reforge.getClass().getMethod("name", (Class<?>[]) null).invoke(this.reforge) + "");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			LOGGER.error(e.getLocalizedMessage());
			for (StackTraceElement element : e.getStackTrace())
				LOGGER.error(element.toString());
		}
	}

	@Override
	public void setRarity(ModItemRarity rarity) {
		this.rarity = rarity;
	}

	@Override
	public void setReforge(Reforge reforge) {
		this.reforge = reforge;
	}

	@Override
	public boolean upgrade() {
		if (this.isUpgraded)
			return false;
		this.setRarity(this.rarity.getNext());
		this.isUpgraded = true;
		return true;
	}

	@Override
	public abstract ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn);
}