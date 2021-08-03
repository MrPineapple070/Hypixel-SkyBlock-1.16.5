package net.hypixel.skyblock.items.accessories;

import java.util.Objects;

import javax.annotation.Nonnull;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.Reforge;
import net.hypixel.skyblock.items.reforge_stone.ReforgeStone;

/**
 * Handle Accessory Reforges.<br>
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Reforging">All Reforges</a>
 *
 * @version 26 July 2020
 */
public enum AccessoryReforge implements Reforge {
	Bizarre(new double[] { 1, 0, 0, .4, 0, -1, 6, 0 }, new double[] { 2, 0, 0, .4, 0, -2, 8, 0 },
			new double[] { 2, 0, 0, .4, 0, -2, 10, 0 }, new double[] { 3, 0, 0, .4, 0, -3, 14, 0 },
			new double[] { 5, 0, 0, .4, 0, -5, 20, 0 }),
	Blessed(new double[0], new double[0], new double[0], new double[0], new double[0]),
	/**
	 * Unique
	 */
	Bloody(new double[] { 1, 0, 1, 0, 0, 3, 0, 1 }, new double[] { 1, 0, 1, 0, 0, 4, 0, 1 },
			new double[] { 1, 0, 1, 0, 0, 5, 0, 1 }, new double[] { 2, 0, 1, 0, 0, 6, 0, 2 },
			new double[] { 3, 0, 1, 0, 0, 9, 0, 2 }),
	Demonic(new double[] { 1, 0, 0, 0, 0, 0, 5, 0 }, new double[] { 2, 0, 0, 0, 0, 0, 7, 0 },
			new double[] { 2, 0, 0, 0, 0, 0, 9, 0 }, new double[] { 3, 0, 0, 0, 0, 0, 12, 0 },
			new double[] { 5, 0, 0, 0, 0, 0, 15, 0 }),
	Forceful(new double[] { 4, 0, 0, 0, 0, 0, 0, 0 }, new double[] { 5, 0, 0, 0, 0, 0, 0, 0 },
			new double[] { 7, 0, 0, 0, 0, 0, 0, 0 }, new double[] { 10, 0, 0, 0, 0, 0, 0, 0 },
			new double[] { 15, 0, 0, 0, 0, 0, 0, 0 }),
	Godly(new double[] { 1, 0, 0, 0, 0, 2, 1, 0 }, new double[] { 2, 0, 0, 0, 0, 2, 1, 0 },
			new double[] { 3, 0, 0, 0, 0, 3, 1, 0 }, new double[] { 5, 0, 0, 0, 0, 4, 2, 0 },
			new double[] { 7, 0, 0, 0, 0, 6, 4, 0 }),
	Hurtful(new double[] { 0, 0, 0, 0, 0, 4, 0, 0 }, new double[] { 0, 0, 0, 0, 0, 5, 0, 0 },
			new double[] { 0, 0, 0, 0, 0, 7, 0, 0 }, new double[] { 0, 0, 0, 0, 0, 10, 0, 0 },
			new double[] { 0, 0, 0, 0, 0, 15, 0, 0 }),
	Itchy(new double[] { 1, 0, 0, 0, 0, 3, 0, 0 }, new double[] { 1, 0, 0, 0, 0, 4, 0, 0 },
			new double[] { 1, 0, 0, 0, 0, 5, 0, 1 }, new double[] { 2, 0, 0, 0, 0, 7, 0, 1 },
			new double[] { 3, 0, 0, 0, 0, 10, 0, 1 }),
	Keen(new double[] { 0, 1, 0, 0.2, 0, 0, 1, 0 }, new double[] { 0, 2, 0, 0.4, 0, 0, 1, 0 },
			new double[] { 0, 3, 0, 0.6, 0, 0, 2, 0 }, new double[] { 0, 4, 0, 0.8, 0, 0, 3, 0 },
			new double[] { 0, 5, 0, 1, 0, 0, 5, 0 }),
	Ominous(new double[] { 1, 1, 0, 0.4, 0, 1, 0, 0 }, new double[] { 1, 1, 0, 0.4, 0, 1, 1, 0 },
			new double[] { 1, 1, 0, 0.4, 0, 1, 2, 0 }, new double[] { 2, 2, 0, 0.6, 0, 1, 3, 0 },
			new double[] { 3, 3, 0, 0.8, 0, 1, 4, 0 }),
	Pleasant(new double[] { 0, 4, 0, 0, 0, 0, 0, 0 }, new double[] { 0, 5, 0, 0, 0, 0, 0, 0 },
			new double[] { 0, 7, 0, 0, 0, 0, 0, 0 }, new double[] { 0, 10, 0, 0, 0, 0, 0, 0 },
			new double[] { 0, 15, 0, 0, 0, 0, 0, 0 }),
	Pretty(new double[] { 0, 0, 0, 0.2, 0, 0, 3, 0 }, new double[] { 0, 0, 0, 0.2, 0, 0, 4, 0 },
			new double[] { 0, 0, 0, 0.4, 0, 0, 6, 1 }, new double[] { 0, 0, 1, 0.4, 0, 0, 9, 1 },
			new double[] { 0, 0, 1, 0.6, 0, 0, 13, 1 }),
	/**
	 * Unique
	 */
	Shaded(new double[] { 2, 0, 0, 0, 0, 3, 0, 0 }, new double[] { 3, 0, 0, 0, 0, 4, 0, 0 },
			new double[] { 4, 0, 0, 0, 0, 5, 0, 0 }, new double[] { 5, 0, 0, 0, 0, 6, 0, 0 },
			new double[] { 6, 0, 0, 0, 1, 9, 0, 0 }),
	Shiny(new double[] { 0, 0, 0, 0.8, 0, 0, 1, 0 }, new double[] { 0, 0, 0, 1, 0, 0, 2, 0 },
			new double[] { 0, 0, 0, 1.4, 0, 0, 2, 0 }, new double[] { 0, 0, 0, 2, 0, 0, 3, 0 },
			new double[] { 0, 0, 0, 3, 0, 0, 5, 0 }),
	/**
	 * Unique
	 */
	Silky(new double[] { 0, 0, 0, 0, 0, 5, 0, 0 }, new double[] { 0, 0, 0, 0, 0, 6, 0, 0 },
			new double[] { 0, 0, 0, 0, 0, 8, 0, 0 }, new double[] { 0, 0, 0, 0, 0, 10, 0, 0 },
			new double[] { 0, 0, 0, 0, 0, 15, 0, 0 }),
	Simple(new double[] { 1, 1, 1, 0.2, 0, 1, 1, 0 }, new double[] { 1, 1, 1, 0.2, 0, 1, 1, 0 },
			new double[] { 1, 1, 1, 0.2, 0, 1, 1, 0 }, new double[] { 1, 1, 1, 0.2, 0, 1, 1, 0 },
			new double[] { 1, 1, 1, 0.2, 0, 1, 1, 0 }),
	Strange(new double[] { 2, 0, 1, 0, 0, 1, 1, -1 }, new double[] { 1, 3, 0, 0, 0, 2, -1, 2 },
			new double[] { -1, 2, 1, 0, 0, 0, 2, 0 }, new double[] { 3, -1, 0, 0, 0, 1, 0, 4 },
			new double[] { 0, 1, 3, 0, 0, 7, 8, 0 }),
	Strong(new double[] { 1, 0, 0, 0, 0, 1, 0, 0 }, new double[] { 2, 0, 0, 0, 0, 2, 0, 0 },
			new double[] { 3, 1, 0, 0, 0, 3, 0, 0 }, new double[] { 5, 2, 0, 0, 0, 5, 0, 0 },
			new double[] { 8, 3, 0, 0, 0, 8, 0, 0 }),
	Superior(new double[] { 2, 0, 0, 0, 0, 2, 0, 0 }, new double[] { 3, 0, 0, 0, 0, 2, 0, 0 },
			new double[] { 4, 0, 0, 0, 0, 2, 0, 0 }, new double[] { 5, 0, 0, 0, 0, 3, 0, 0 },
			new double[] { 7, 0, 0, 0, 0, 3, 0, 0 }),
	Sweet(new double[0], new double[0], new double[0], new double[0], new double[0]),

	Unpleasant(new double[] { 0, 0, 0, 0, 1, 0, 0, 0 }, new double[] { 0, 0, 0, 0, 1, 0, 0, 0 },
			new double[] { 0, 0, 0, 0, 1, 0, 0, 0 }, new double[] { 0, 0, 0, 0, 2, 0, 0, 0 },
			new double[] { 0, 0, 0, 0, 2, 0, 0, 0 }),
	Vivid(new double[] { 0, 0, 1, 0.2, 0, 0, 0, 0 }, new double[] { 0, 0, 2, 0.4, 0, 0, 0, 0 },
			new double[] { 0, 0, 3, 0.6, 0, 0, 0, 0 }, new double[] { 0, 0, 4, 0.8, 0, 0, 0, 0 },
			new double[] { 0, 0, 5, 1, 0, 0, 0, 0 }),

	Zealous(new double[] { 1, 0, 0, 0, 0, 1, 1, 0 }, new double[] { 2, 0, 0, 0, 0, 2, 2, 0 },
			new double[] { 2, 0, 1, 0, 0, 2, 2, 0 }, new double[] { 3, 0, 1, 0, 0, 3, 3, 0 },
			new double[] { 5, 0, 1, 0, 0, 5, 5, 0 });

	/**
	 * A primative type array of {@link AccessoryReforge} that holds all the
	 * nonunique of {@link AccessoryReforge}.<br>
	 * The {@link AccessoryReforge} in this are the ones returned from
	 * {@link #getRandomReforge()}
	 */
	@Nonnull
	private static final AccessoryReforge[] nonunique;

	/**
	 * A primative type array of {@link AccessoryReforge} that holds all the unique
	 * of {@link AccessoryReforge}.<br>
	 * These {@link AccessoryReforge} in this can only be applied through
	 * {@link ReforgeStone}
	 */
	@Nonnull
	private static final AccessoryReforge[] unique;

	static {
		nonunique = new AccessoryReforge[] { Bizarre, Demonic, Forceful, Godly, Hurtful, Itchy, Keen, Ominous, Pleasant,
				Pretty, Shiny, Simple, Strange, Strong, Superior, Unpleasant, Vivid };
		unique = new AccessoryReforge[] { Bloody, Shaded, Silky };
	}

	/**
	 * @return a random {@link AccessoryReforge}
	 */
	@Nonnull
	public static AccessoryReforge getRandomReforge() {
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

	/**
	 * Construct a new Reforge. Each array must have a length of 8.
	 *
	 * @param common    the array for {@link ModItemRarity#Common}
	 * @param uncommon  the array for {@link ModItemRarity#Uncommon}
	 * @param rare      the array for {@link ModItemRarity#Rare}
	 * @param epic      the array for {@link ModItemRarity#Epic}
	 * @param legendary the array for {@link ModItemRarity#Legendary}
	 */
	private AccessoryReforge(double[] common, double[] uncommon, double[] rare, double[] epic, double[] legendary) {
		this.common = Objects.requireNonNull(common, "Common array must be non-null.");
		this.uncommon = Objects.requireNonNull(uncommon, "Uncommon array must be non-null.");
		this.rare = Objects.requireNonNull(rare, "Rare array must be non-null.");
		this.epic = Objects.requireNonNull(epic, "Epic array must be non-null.");
		this.legendary = Objects.requireNonNull(legendary, "Legendary array must be non-null.");
	}

	@Override
	public double[] common() {
		return this.common;
	}

	@Override
	public double[] epic() {
		return this.epic;
	}

	@Override
	public double[] legendary() {
		return this.legendary;
	}

	@Override
	public Reforge[] nonunique() {
		return nonunique;
	}

	@Override
	public double[] rare() {
		return this.rare;
	}

	@Override
	public double[] uncommon() {
		return this.uncommon;
	}

	@Override
	public Reforge[] unique() {
		return unique;
	}
}