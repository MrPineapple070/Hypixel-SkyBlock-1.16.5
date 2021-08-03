package net.hypixel.skyblock.items.tools;

import java.util.Objects;

import javax.annotation.Nonnull;

import org.openjdk.nashorn.internal.ir.annotations.Immutable;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.Reforge;
import net.hypixel.skyblock.items.reforge_stone.ReforgeStone;
import net.minecraft.item.ToolItem;

/**
 * Holds all {@link Reforge} for {@link ToolItem}
 * 
 * @author MrPineapple070
 * @version 14 July 2021
 * @since 01 July 2020
 */
public enum ToolReforge implements Reforge {
	Ambered(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Auspicious(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Bountiful(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Blessed(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Fleet(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Fruitful(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Heated(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Magnetic(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Mithric(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Moil(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Refined(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Stellar(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Toil(new double[0], new double[0], new double[0], new double[0], new double[0]);

	/**
	 * Empty list of {@link Reforge}.<br>
	 * Since these {@link Reforge} are only applied through {@link ReforgeStone},
	 * this is used in place of {@link #unique()} and {@link #nonunique()}
	 */
	@Nonnull
	@Immutable
	private static final Reforge[] empty = new Reforge[] { Magnetic };

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

	private ToolReforge(double[] common, double[] uncommon, double[] rare, double[] epic, double[] legendary) {
		this.common = Objects.requireNonNull(common, "Common buff array must be non-null.");
		this.uncommon = Objects.requireNonNull(uncommon, "Uncommon buff array must be non-null.");
		this.rare = Objects.requireNonNull(rare, "Rare buff array must be non-null.");
		this.epic = Objects.requireNonNull(epic, "Epic buff array must be non-null.");
		this.legendary = Objects.requireNonNull(legendary, "Legendary buff array must be non-null.");
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
		return empty;
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
		return empty;
	}
}