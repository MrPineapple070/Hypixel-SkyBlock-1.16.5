package net.hypixel.skyblock.items.fishing_rod;

import java.util.Objects;

import net.hypixel.skyblock.items.Reforge;

public enum FishingRodReforge implements Reforge {
	Salty(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Treacherous(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Stiff(new double[0], new double[0], new double[0], new double[0], new double[0]),
	Lucky(new double[0], new double[0], new double[0], new double[0], new double[0]);

	public static final FishingRodReforge[] unique;

	static {
		unique = new FishingRodReforge[] { Salty, Treacherous, Stiff, Lucky };
	}
	
	private final double[] common;
	private final double[] uncommon;
	private final double[] rare;
	private final double[] epic;
	private final double[] legendary;

	private FishingRodReforge(double[] common, double[] uncommon, double[] rare, double[] epic, double[] legendary) {
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

	@Override
	public Reforge[] nonunique() {
		return empty;
	}
}