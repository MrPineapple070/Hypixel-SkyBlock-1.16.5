package net.hypixel.skyblock.util;

import javax.annotation.concurrent.Immutable;

@Immutable
public final class MithrilPowderCalculator {
	public static final int crystalized(int level) {
		return (int) Math.pow(level + 1, 3.4);
	}
	
	public static final int dailyPowder(int level) {
		return 182 + 18 * level;
	}
	
	public static final int efficientMiner(int level) {
		return (int) Math.pow(level + 1, 2.6);
	}
	
	public static final int lotc(int level) {
		return (int) Math.pow(level + 1, 3.07);
	}
	
	public static final int miningFortune(int level) {
		return (int) Math.pow(level + 1, 3.05);
	}
	
	public static final int miningSpeed(int level) {
		return (int) Math.pow(level + 1, 3);
	}
	
	public static final int orbiter(int level) {
		return 70 * level;
	}
	
	public static final int potm(int level) {
		return 25000 * level;
	}
	
	public static final int quickForge(int level) {
		return (int) Math.pow(level + 1, 4);
	}
	
	public static final int seasonedMineman(int level) {
		return (int) Math.pow(level + 1, 2.3);
	}
	
	public static final int titaniumInsanium(int level) {
		return (int) Math.pow(level + 1, 3.1);
	}
}