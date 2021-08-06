package net.hypixel.skyblock.items;

import java.util.Random;

import javax.annotation.Nonnull;

import org.openjdk.nashorn.internal.ir.annotations.Immutable;

import net.hypixel.skyblock.items.accessories.Accessory;
import net.hypixel.skyblock.items.armor.ModArmorItem;
import net.hypixel.skyblock.items.bows.ModBowItem;
import net.hypixel.skyblock.items.swords.ModSwordItem;

/**
 * An interface to serve as the base for all Reforges.
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Reforging">All Reforges</a>
 *
 * @author MrPineapple070
 * @version 7 July 2020
 * @since 11 June 2019
 */
public interface Reforge {
	/**
	 * Index for attack speed buff.
	 */
	public static final int attack_speed = 0x7;

	/**
	 * Index for crit chance buff.
	 */
	public static final int crit_chance = 0x4;

	/**
	 * Index for crit damage buff.
	 */
	public static final int crit_damage = 0x5;

	/**
	 * Index for defense buff.
	 */
	public static final int defense = 0x1;
	
	/**
	 * Empty list of {@link Reforge}.<br>
	 * Used for {@link #unique()} and {@link #nonunique()}
	 */
	@Nonnull
	@Immutable
	public static final Reforge[] empty = new Reforge[0];

	/**
	 * Index for health buff.
	 */
	public static final int health = 0x3;

	/**
	 * Index for intelligence buff.
	 */
	public static final int intelligence = 0x6;

	/**
	 * When the current Item has no {@code Reforge}
	 */
	public static final Reforge None = null;

	/**
	 * {@link Random} to chose a random Reforge.
	 */
	@Nonnull
	public static final Random rand = new Random();

	/**
	 * Index for strength buff.
	 */
	public static final int strength = 0x0;
	
	/**
	 * Index for walkspeed buff.
	 */
	public static final int walkspeed = 0x2;

	/**
	 * Creates a buff array from inputs and index;
	 *
	 * @param inputs the amount to buff each stat
	 * @param index  the index of each stat.
	 * @return the created buff array.
	 */
	@Nonnull
	public static strictfp double[] create(double[] inputs, int[] index) {
		if (inputs.length != index.length)
			throw new IllegalArgumentException("input and index arrays must be the same length");
		final double[] temp = new double[8];
		for (int i = 0; i < inputs.length; ++i)
			temp[index[i]] = index[i] == health ? inputs[i] * .2 : inputs[i];
		return temp;
	}

	/**
	 * @return The array for {@link ModItemRarity#Common}
	 */
	@Nonnull
	public double[] common();

	/**
	 * @return The array for {@link ModItemRarity#Epic}
	 */
	@Nonnull
	public double[] epic();

	/**
	 *
	 * @param rarity the {@link ModItemRarity} of the {@link Accessory},
	 *               {@link ModArmorItem}, {@link ModBowItem}, or
	 *               {@link ModSwordItem}
	 * @return the appropriate buff array from the given {@link ModItemRarity}
	 */
	@Nonnull
	public default strictfp double[] getBuffArray(ModItemRarity rarity) {
		switch (rarity) {
		case Common:
			return this.common();
		case Uncommon:
			return this.uncommon();
		case Rare:
			return this.rare();
		case Epic:
			return this.epic();
		case Legendary:
			return this.legendary();
		default:
			throw new IllegalStateException("ModItemRarity " + rarity.name() + " does not have a buff array.");
		}
	}

	/**
	 * @return The array for {@link ModItemRarity#Legendary}
	 */
	@Nonnull
	public double[] legendary();

	@Deprecated
	default Reforge[] nonunique() {
		return empty;
	}

	/**
	 * @return The array for {@link ModItemRarity#Rare}
	 */
	@Nonnull
	public double[] rare();
	
	/**
	 * @return The array for {@link ModItemRarity#Uncommon}
	 */
	@Nonnull
	public double[] uncommon();
	
	@Deprecated
	default Reforge[] unique() {
		return empty;
	}
}