package net.hypixel.skyblock.items.armor;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;
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
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

/**
 * Mod version of {@link ArmorItem}<br>
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Armor">All Armor</a>
 *
 * @author MrPineapple070
 * @version 7 July 2020
 * @since 11 June 2019
 */
public abstract class ModArmorItem extends ArmorItem implements ReforgableItem, PotatoBookableItem, UpgradableItem {
	protected static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * Determine if {@link #rarity} has been upgraded.
	 */
	protected boolean isUpgraded;

	/**
	 * The number of applied {@link HotPotatoBook}
	 */
	@Nonnegative
	protected int numPotatoBooks;

	/**
	 * The {@link ModItemRarity} of this.
	 */
	@Nonnull
	protected ModItemRarity rarity;

	/**
	 * The current {@link ArmorReforge}
	 */
	@Nullable
	protected Reforge reforge = Reforge.None;

	protected ITextComponent reforge_display = new StringTextComponent("");

	/**
	 * Construct this.
	 *
	 * @param materialIn {@link ModArmorMaterial} of this.
	 * @param slot       {@link EquipmentSlotType} of this.
	 * @param builder    {@link Properties} of this.
	 * @param rarity     {@link ModItemRarity} of this.
	 */
	protected ModArmorItem(ModArmorMaterial materialIn, EquipmentSlotType slot, Properties builder,
			ModItemRarity rarity) {
		super(materialIn, slot, builder);
		this.rarity = Objects.requireNonNull(rarity, "Armor must have a rarity.");
		this.isUpgraded = false;
		this.numPotatoBooks = 0;
	}

	@Override
	public abstract void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn);

	@Override
	public boolean apply() {
		if (this.numPotatoBooks == 10)
			return false;
		++this.numPotatoBooks;
		return true;
	}

	@Override
	public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
		return super.damageItem(stack, 0, entity, onBroken);
	}

	@Override
	public ITextComponent getName(ItemStack stack) {
		IFormattableTextComponent rd = this.reforge_display.copy();
		ITextComponent dp = super.getName(stack).copy();
		if (this.material == ModArmorMaterial.Wise_Dragon && this.reforge == ArmorReforge.Wise)
			rd = new StringTextComponent("Very");
		else if (this.material == ModArmorMaterial.Strong_Dragon && this.reforge == ArmorReforge.Strong)
			rd = new StringTextComponent("Very");
		else if (this.material == ModArmorMaterial.Superior_Dragon && this.reforge == ArmorReforge.Superior)
			rd = new StringTextComponent("Highly");
		else if (this.material == ModArmorMaterial.Heavy) {
			if (this.reforge == ArmorReforge.Heavy)
				rd = new StringTextComponent("Extremly");
			else if (this.reforge == ArmorReforge.Light)
				rd = new StringTextComponent("Not So");
		} else if (ModArmorMaterial.isPerfect(this.material) && this.reforge == ArmorReforge.Perfect)
			rd = new StringTextComponent("Absolutely");
		return (rd.append(dp)).withStyle(this.rarity.color);
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
	public boolean canBeDepleted() {
		return false;
	}

	@Override
	public void reforge() {
		this.reforge = ArmorReforge.getRandomReforge();
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
		LOGGER.warn("setRarity() method called.");
		this.rarity = Objects.requireNonNull(rarity, "New ModItemRarity cannot be null.");
	}

	@Override
	public void setReforge(Reforge reforge) {
		this.reforge = reforge;
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
	public boolean upgrade() {
		if (this.isUpgraded)
			return false;
		try {
			this.rarity = this.rarity.getNext();
			this.isUpgraded = true;
			return true;
		} catch (final IllegalStateException ise) {
			LOGGER.error(ise.getMessage());
			return false;
		}
	}
}