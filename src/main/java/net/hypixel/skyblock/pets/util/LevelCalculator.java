package net.hypixel.skyblock.pets.util;

import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableList;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.pets.Pet;

public class LevelCalculator {
	/**
	 * {@link ImmutableList} of {@link Integer}
	 */
	@Nonnull
	public static final ImmutableList<Integer> common = ImmutableList.copyOf(Arrays.asList(0, 100, 110, 120, 130,
			145, 160, 175, 190, 210, 230, 250, 275, 300, 330, 360, 400, 440, 490, 540, 600, 660, 730, 800, 880, 960,
			1050, 1150, 1260, 1380, 1510, 1650, 1800, 1960, 2130, 2310, 2500, 2700, 2920, 3160, 3420, 3700, 4000, 4350,
			4750, 5200, 5700, 6300, 7000, 7800, 8700, 9700, 10800, 12000, 13300, 14700, 16200, 17800, 19500, 21300,
			23200, 25200, 27400, 29800, 32400, 35200, 38200, 41400, 44800, 48400, 52200, 56200, 60400, 64800, 69400,
			74200, 79200, 84700, 90700, 97200, 104200, 111700, 119700, 128200, 137200, 146700, 156700, 167700, 179700,
			192700, 206700, 221700, 237700, 254700, 272700, 291700, 311700, 333700, 357700, 383700));
	
	/**
	 * {@link ImmutableList} of {@link Integer}
	 */
	@Nonnull
	public static final ImmutableList<Integer> uncommon = ImmutableList.copyOf(Arrays.asList(0, 175, 190, 210, 230,
			250, 275, 300, 330, 360, 400, 440, 490, 540, 600, 660, 730, 800, 880, 960, 1050, 1150, 1260, 1380, 1510,
			1650, 1800, 1960, 2130, 2310, 2500, 2700, 2920, 3160, 3420, 3700, 4000, 4350, 4750, 5200, 5700, 6300, 7000,
			7800, 8700, 9700, 10800, 12000, 13300, 14700, 16200, 17800, 19500, 21300, 23200, 25200, 27400, 29800, 32400,
			35200, 38200, 41400, 44800, 48400, 52200, 56200, 60400, 64800, 69400, 74200, 79200, 84700, 90700, 97200,
			104200, 111700, 119700, 128200, 137200, 146700, 156700, 167700, 179700, 192700, 206700, 221700, 237700,
			254700, 272700, 291700, 311700, 333700, 357700, 383700, 411700, 441700, 476700, 516700, 561700, 611700));
	
	/**
	 * {@link ImmutableList} of {@link Integer}
	 */
	@Nonnull
	public static final ImmutableList<Integer> rare = ImmutableList.copyOf(
			Arrays.asList(0, 275, 300, 330, 360, 400, 440, 490, 540, 600, 660, 730, 800, 880, 960, 1050, 1150, 1260,
					1380, 1510, 1650, 1800, 1960, 2130, 2310, 2500, 2700, 2920, 3160, 3420, 3700, 4000, 4350, 4750,
					5200, 5700, 6300, 7000, 7800, 8700, 9700, 10800, 12000, 13300, 14700, 16200, 17800, 19500, 21300,
					23200, 25200, 27400, 29800, 32400, 35200, 38200, 41400, 44800, 48400, 52200, 56200, 60400, 64800,
					69400, 74200, 79200, 84700, 90700, 97200, 104200, 111700, 119700, 128200, 137200, 146700, 156700,
					167700, 179700, 192700, 206700, 221700, 237700, 254700, 272700, 291700, 311700, 333700, 357700,
					383700, 411700, 441700, 476700, 516700, 561700, 611700, 666700, 726700, 791700, 861700, 936700));
	
	/**
	 * {@link ImmutableList} of {@link Integer}
	 */
	@Nonnull
	public static final ImmutableList<Integer> epic = ImmutableList.copyOf(Arrays.asList(0, 440, 490, 540, 600, 660,
			730, 800, 880, 960, 1050, 1150, 1260, 1380, 1510, 1650, 1800, 1960, 2130, 2310, 2500, 2700, 2920, 3160,
			3420, 3700, 4000, 4350, 4750, 5200, 5700, 6300, 7000, 7800, 8700, 9700, 10800, 12000, 13300, 14700, 16200,
			17800, 19500, 21300, 23200, 25200, 27400, 29800, 32400, 35200, 38200, 41400, 44800, 48400, 52200, 56200,
			60400, 64800, 69400, 74200, 79200, 84700, 90700, 97200, 104200, 111700, 119700, 128200, 137200, 146700,
			156700, 167700, 179700, 192700, 206700, 221700, 237700, 254700, 272700, 291700, 311700, 333700, 357700,
			383700, 411700, 441700, 476700, 516700, 561700, 611700, 666700, 726700, 791700, 861700, 936700, 1016700,
			1101700, 1191700, 1286700, 1386700));
	
	/**
	 * {@link ImmutableList} of {@link Integer}
	 */
	@Nonnull
	public static final ImmutableList<Integer> legendary = ImmutableList.copyOf(Arrays.asList(0, 660, 730, 800, 880,
			960, 1050, 1150, 1260, 1380, 1510, 1650, 1800, 1960, 2130, 2310, 2500, 2700, 2920, 3160, 3420, 3700, 4000,
			4350, 4750, 5200, 5700, 6300, 7000, 7800, 8700, 9700, 10800, 12000, 13300, 14700, 16200, 17800, 19500,
			21300, 23200, 25200, 27400, 29800, 32400, 35200, 38200, 41400, 44800, 48400, 52200, 56200, 60400, 64800,
			69400, 74200, 79200, 84700, 90700, 97200, 104200, 111700, 119700, 128200, 137200, 146700, 156700, 167700,
			179700, 192700, 206700, 221700, 237700, 254700, 272700, 291700, 311700, 333700, 357700, 383700, 411700,
			441700, 476700, 516700, 561700, 611700, 666700, 726700, 791700, 861700, 936700, 1016700, 1101700, 1191700,
			1286700, 1386700, 1496700, 1616700, 1746700, 1886700));

	/**
	 * Returns an {@link ImmutableList} of {@link Integer} holding all the
	 * experience point requirements to level up
	 * 
	 * @param rarity {@link ModItemRarity}
	 * @return {@link ImmutableList} of {@link Integer}
	 */
	@Nonnull
	public static final ImmutableList<Integer> getRequirement(@Nonnull ModItemRarity rarity) {
		switch (Objects.requireNonNull(rarity, "ModItemRarity cannot be null")) {
		case Common:
			return common;
		case Uncommon:
			return uncommon;
		case Rare:
			return rare;
		case Epic:
			return epic;
		case Legendary:
		case Mythic:
			return legendary;
		default:
			throw new IllegalStateException("Illegal ModItemRarity " + rarity.name());
		}
	}

	/**
	 * Gets a specific leveling requirement for a pet level
	 * 
	 * @param rarity {@link ModItemRarity} of {@link Pet}
	 * @param lvl    current Level of pet
	 * @return specific leveling requirement
	 */
	@Nonnegative
	public static final int getRequirement(@Nonnull ModItemRarity rarity, @Nonnegative int lvl) {
		if (lvl < 0)
			throw new IllegalStateException("Pet cannot be level " + lvl);
		// Thanks Golden Dragon
		if (lvl > 99)
			return 1886700;
		return getRequirement(rarity).get(lvl);
	}

	/**
	 * Calculates the cost of upgraded a {@link Pet}.
	 * 
	 * @param pet  {@link Pet} to upgrade
	 * @param base base price of the upgrade. Note: base prices are different for
	 *             each {@link ModItemRarity} and {@link Pet}
	 * @return cost
	 */
	public static final int calcCost(Pet pet, int base) {
		return (int) ((1 - .003 * pet.getLevel()) * base);
	}
}