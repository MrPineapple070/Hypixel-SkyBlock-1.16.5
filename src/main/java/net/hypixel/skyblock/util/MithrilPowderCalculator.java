package net.hypixel.skyblock.util;

import javax.annotation.concurrent.Immutable;

/**
 * Calculates how much Mithril Powder an upgrade for HOTM costs.<br>
 * More information can be found <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain">here</a>.<br>
 * Most methods should have a level being upgraded to as input.<br>
 * All methods should return an integer cost of Mithril Powder.
 * 
 * @author MrPineapple070
 * @version 27 July 2021
 * @since 15 January 2021
 */
@Immutable
public final class MithrilPowderCalculator {
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Crystalized">Crystalized</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int crystalized(int level) {
		return (int) Math.pow(level + 1, 3.4);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Daily_Powder">Daily Powder</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int dailyPowder(int level) {
		return 182 + 18 * level;
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Efficient_Miner">Efficient Miner</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int efficientMiner(int level) {
		return (int) Math.pow(level + 1, 2.6);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Luck_of_the_Cave">Luck of the Cave</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int lotc(int level) {
		return (int) Math.pow(level + 1, 3.07);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Mining_Fortune">Mining Fortune</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int miningFortune(int level) {
		return (int) Math.pow(level + 1, 3.05);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Mining_Speed">Mining Speed</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int miningSpeed(int level) {
		return (int) Math.pow(level + 1, 3);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Orbiter">Orbiter</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int orbiter(int level) {
		return 70 * level;
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Peak_of_the_Mountain">Peak of the Mountain</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int potm(int level) {
		return 25000 * level;
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Quick Forge">Quick Forge</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int quickForge(int level) {
		return (int) Math.pow(level + 1, 4);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Seasoned_Mineman">Seasoned Mineman</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int seasonedMineman(int level) {
		return (int) Math.pow(level + 1, 2.3);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Titanium_Insanium">Titanium Insanium</a>.
	 * 
	 * @param level the level being upgraded.
	 * @return Mithril Cost
	 */
	public static final int titaniumInsanium(int level) {
		return (int) Math.pow(level + 1, 3.1);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Lonesome_Miner">Lonesome Miner</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int lonesomeMiner(int level) {
		return (int) Math.pow(level + 1, 3.07);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Professional">Professional</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int professional(int level) {
		return (int) Math.pow(level + 1, 2.3);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Mole">Mole</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int mole(int level) {
		return (int) Math.pow(level + 1, 2.2);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Fortunate">Fortunate</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int fortunate(int level) {
		return (int) Math.pow(level + 1, 3.05);
	}
	
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Great_Explorer">Great Explorer</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int greatExplorer(int level) {
		return (int) Math.pow(level + 1, 4);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Mining_Speed_II">Mining Speed II</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int miningSpeed2(int level) {
		return (int) Math.pow(level + 1, 3.2);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Powder_Buff">Powder Buff</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int powderBuff(int level) {
		return (int) Math.pow(level + 1, 3.2);
	}
	
	/**
	 * <a href="https://hypixel-skyblock.fandom.com/wiki/Heart_of_the_Mountain#Mining_Fortune_II">Mining Fortune II</a>.
	 * 
	 * @param level the level being upgraded to.
	 * @return Mithril Cost
	 */
	public static final int miningFortune2(int level) {
		return (int) Math.pow(level + 1, 3.2);
	}
}