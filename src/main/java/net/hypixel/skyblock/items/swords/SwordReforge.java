package net.hypixel.skyblock.items.swords;

import java.util.Objects;

import javax.annotation.Nonnull;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.Reforge;
import net.hypixel.skyblock.items.accessories.AccessoryReforge;
import net.hypixel.skyblock.items.reforge_stone.ReforgeStone;

/**
 * Handle Sword Reforges.<br>
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Reforging">All Reforges</a>
 *
 * @version 29 July 2020
 * @since 11 June 2019
 */
public enum SwordReforge implements Reforge {
	Bulky(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Dirty(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Epic(new double[] { 15, 0, 0, 0, 0, 10, 0, 1 }, new double[] { 20, 0, 0, 0, 0, 15, 0, 2 },
			new double[] { 25, 0, 0, 0, 0, 20, 0, 4 }, new double[] { 32, 0, 0, 0, 0, 27, 0, 7 },
			new double[] { 40, 0, 0, 0, 0, 35, 0, 10 }),
	/**
	 * Unique
	 */
	Fabled(new double[] { 30, 0, 0, 0, 0, 15, 0, 0 }, new double[] { 35, 0, 0, 0, 0, 20, 0, 0 },
			new double[] { 40, 0, 0, 0, 0, 25, 0, 0 }, new double[] { 50, 0, 0, 0, 0, 32, 0, 0 },
			new double[] { 60, 0, 0, 0, 0, 40, 0, 0 }),
	Fair(new double[] { 2, 0, 0, 0, 2, 2, 2, 2 }, new double[] { 3, 0, 0, 0, 3, 3, 3, 3 },
			new double[] { 4, 0, 0, 0, 4, 4, 4, 4 }, new double[] { 7, 0, 0, 0, 7, 7, 7, 7 },
			new double[] { 10, 0, 0, 0, 10, 10, 10, 10 }),
	Fast(new double[] { 0, 0, 0, 0, 0, 0, 0, 10 }, new double[] { 0, 0, 0, 0, 0, 0, 0, 20 },
			new double[] { 0, 0, 0, 0, 0, 0, 0, 30 }, new double[] { 0, 0, 0, 0, 0, 0, 0, 40 },
			new double[] { 00, 0, 0, 0, 0, 0, 0, 50 }),
	Gentle(new double[] { 3, 0, 0, 0, 0, 0, 0, 8 }, new double[] { 5, 0, 0, 0, 0, 0, 0, 10 },
			new double[] { 7, 0, 0, 0, 0, 0, 0, 15 }, new double[] { 10, 0, 0, 0, 0, 0, 0, 20 },
			new double[] { 15, 0, 0, 0, 0, 0, 0, 25 }),
	/**
	 * This {@link SwordReforge} can only be applied to {@link MidasSword}<br>
	 * Unique
	 */
	Gilded(new double[] { 0, 0, 0, 0, 0, 0, 0, 0 }, new double[] { 0, 0, 0, 0, 0, 0, 0, 0 },
			new double[] { 0, 0, 0, 0, 0, 0, 0, 0 }, new double[] { 0, 0, 0, 0, 0, 0, 0, 0 },
			new double[] { 75, 0, 0, 0, 0, 0, 0, 0 }),
	Heroic(new double[] { 15, 0, 0, 0, 0, 0, 0, 0 }, new double[] { 20, 0, 0, 0, 0, 0, 0, 0 },
			new double[] { 25, 0, 0, 0, 0, 0, 0, 0 }, new double[] { 32, 0, 0, 0, 0, 0, 0, 0 },
			new double[] { 40, 0, 0, 0, 0, 0, 0, 0 }),
	Jerry(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Legendary(new double[] { 3, 0, 0, 0, 5, 5, 5, 10 }, new double[] { 7, 0, 0, 0, 7, 10, 8, 3 },
			new double[] { 12, 0, 0, 0, 9, 15, 12, 5 }, new double[] { 18, 0, 0, 0, 12, 22, 18, 7 },
			new double[] { 25, 0, 0, 0, 15, 28, 25, 10 }),
	Odd(new double[] { 0, 0, 0, 0, 12, 10, -5, 0 }, new double[] { 0, 0, 0, 0, 15, 15, -10, 0 },
			new double[] { 0, 0, 0, 0, 15, 15, -18, 0 }, new double[] { 0, 0, 0, 0, 20, 22, -32, 0 },
			new double[] { 0, 0, 0, 0, 25, 30, -50, 0 }),
	Sharp(new double[] { 0, 0, 0, 0, 10, 20, 0, 0 }, new double[] { 0, 0, 0, 0, 12, 30, 0, 0 },
			new double[] { 0, 0, 0, 0, 14, 40, 0, 0 }, new double[] { 0, 0, 0, 0, 17, 55, 0, 0 },
			new double[] { 0, 0, 0, 0, 20, 75, 0, 0 }),
	Spicy(new double[] { 2, 0, 0, 0, 1, 25, 0, 1 }, new double[] { 3, 0, 0, 0, 1, 35, 0, 2 },
			new double[] { 4, 0, 0, 0, 1, 45, 0, 4 }, new double[] { 7, 0, 0, 0, 1, 60, 0, 7 },
			new double[] { 10, 0, 0, 0, 1, 80, 0, 10 }),
	Spiritual(new double[0], new double[0], new double[0], new double[0], new double[0]),
	/**
	 * Unique
	 */
	Suspicious(new double[] { 0, 0, 0, 0, 1, 30, 0, 0 }, new double[] { 0, 0, 0, 0, 2, 40, 0, 0 },
			new double[] { 0, 0, 0, 0, 3, 50, 0, 0 }, new double[] { 0, 0, 0, 0, 5, 65, 0, 0 },
			new double[] { 0, 0, 0, 0, 7, 85, 0, 0 }),
	/**
	 * This {@link SwordReforge} can only be applied to {@link AspectOfTheEnd}<br>
	 * Unique
	 */
	Warped(new double[] { 0, 0, 0, 0, 0, 0, 0, 0 }, new double[] { 0, 0, 0, 0, 0, 0, 0, 0 },
			new double[] { 165, 0, 0, 0, 0, 0, 0, 0 }, new double[] { 165, 0, 0, 0, 0, 0, 0, 0 },
			new double[] { 0, 0, 0, 0, 0, 0, 0, 0 }),
	Withered(new double[0], new double[0], new double[0], new double[0], new double[0]);

	/**
	 * A primative type array of {@link AccessoryReforge} that holds all the
	 * nonunique of {@link AccessoryReforge}.<br>
	 * The {@link AccessoryReforge} in this are the ones returned from
	 * {@link #getRandomReforge()}
	 */
	@Nonnull
	public static final SwordReforge[] nonunique;

	/**
	 * A primative type array of {@link AccessoryReforge} that holds all the unique
	 * of {@link AccessoryReforge}.<br>
	 * These {@link AccessoryReforge} in this can only be applied through
	 * {@link ReforgeStone}
	 */
	@Nonnull
	public static final SwordReforge[] unique;

	static {
		nonunique = new SwordReforge[] { Epic, Fair, Fast, Gentle, Heroic, Legendary, Odd, Sharp, Spicy };
		unique = new SwordReforge[] { Fabled, Gilded, Suspicious, Warped };
	}

	/**
	 * @return a random {@link SwordReforge}
	 */
	public static SwordReforge getRandomReforge() {
		return nonunique[rand.nextInt(nonunique.length)];
	}

	/**
	 * The array for {@link ModItemRarity#Common}
	 */
	@Nonnull
	private final double[] common;

	/**
	 * The array for {@link ModItemRarity#Epic}
	 */
	@Nonnull
	private final double[] epic;

	/**
	 * The array for {@link ModItemRarity#Legendary}
	 */
	@Nonnull
	private final double[] legendary;

	/**
	 * The array for {@link ModItemRarity#Rare}
	 */
	@Nonnull
	private final double[] rare;

	/**
	 * The array for {@link ModItemRarity#Uncommon}
	 */
	@Nonnull
	private final double[] uncommon;

	private SwordReforge(double[] common, double[] uncommon, double[] rare, double[] epic, double[] legendary) {
		this.common = Objects.requireNonNull(common, "Common buff array must be non-null.");
		this.uncommon = Objects.requireNonNull(uncommon, "Uncommon buff array must be non-null.");
		this.rare = Objects.requireNonNull(rare, "Rare buff array must be non-null.");
		this.epic = Objects.requireNonNull(epic, "Epic buff array must be non-null.");
		this.legendary = Objects.requireNonNull(legendary, "Legendary buff array must be non-null.");
	}

	@Override
	public strictfp double[] common() {
		return this.common;
	}

	@Override
	public strictfp double[] epic() {
		return this.epic;
	}

	@Override
	public strictfp double[] legendary() {
		return this.legendary;
	}

	@Override
	public strictfp double[] rare() {
		return this.rare;
	}

	@Override
	public strictfp double[] uncommon() {
		return this.uncommon;
	}

	@Override
	public Reforge[] unique() {
		return empty;
	}

	@Override
	public Reforge[] nonunique() {
		return empty;
	}
}