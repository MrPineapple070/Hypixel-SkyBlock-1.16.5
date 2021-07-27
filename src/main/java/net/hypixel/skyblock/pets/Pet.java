package net.hypixel.skyblock.pets;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableList;

import net.hypixel.skyblock.items.Collection;
import net.hypixel.skyblock.items.ModItemRarity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

/**
 * Basis for all
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Pets">Pets</a>.
 *
 * @author MrPineapple070
 * @version 08 September 2020
 * @since 11 October 2019
 */
public abstract class Pet {
	/**
	 * {@link Logger}
	 */
	@Nonnull
	protected static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * {@link ImmutableList} of {@link Integer}
	 */
	@Nonnull
	protected static final ImmutableList<Integer> common = ImmutableList.copyOf(Arrays.asList(0, 100, 110, 120, 130,
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
	protected static final ImmutableList<Integer> uncommon = ImmutableList.copyOf(Arrays.asList(0, 175, 190, 210, 230,
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
	protected static final ImmutableList<Integer> rare = ImmutableList.copyOf(
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
	protected static final ImmutableList<Integer> epic = ImmutableList.copyOf(Arrays.asList(0, 440, 490, 540, 600, 660,
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
	protected static final ImmutableList<Integer> legendary = ImmutableList.copyOf(Arrays.asList(0, 660, 730, 800, 880,
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
	protected static final ImmutableList<Integer> getRequirement(@Nonnull ModItemRarity rarity) {
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
	protected static final int getRequirement(@Nonnull ModItemRarity rarity, @Nonnegative int lvl) {
		if (lvl < 0 || lvl > 99)
			return Integer.MAX_VALUE;
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
	protected static final int calcCost(Pet pet, int base) {
		return (int) ((1 - .003 * pet.level) * base);
	}

	/**
	 * {@link Random}
	 */
	@Nonnull
	protected static final Random rand = new Random();

	/**
	 * @return {@link ModItemRarity#Epic} or {@link ModItemRarity#Legendary}
	 *         randomly.
	 */
	protected static ModItemRarity getRandomRarityHigh() {
		return ModItemRarity.high.get(rand.nextInt(ModItemRarity.high.size()));
	}

	/**
	 * @return {@link ModItemRarity#Common}, {@link ModItemRarity#Uncommon}, or
	 *         {@link ModItemRarity#Rare} randomly.
	 */
	protected static ModItemRarity getRandomRarityLow() {
		return ModItemRarity.low.get(rand.nextInt(ModItemRarity.low.size()));
	}

	/**
	 * {@link Collection}
	 */
	@Nonnull
	public final Collection collection;

	/**
	 * Cumulative Experience collected.
	 */
	@Nonnegative
	protected float cumulative_xp;

	/**
	 * {@link Item} that this pet holds.
	 */
	@Nullable
	protected Item held_item;

	/**
	 * Level of this.
	 */
	@Nonnegative
	protected int level;

	/**
	 * {@link PetType}.
	 */
	@Nonnull
	public final PetType petType;

	/**
	 * {@link ModItemRarity}
	 */
	@Nonnull
	protected ModItemRarity rarity;

	protected Pet(ModItemRarity rarity, Collection collection, PetType petType) {
		this.rarity = Objects.requireNonNull(rarity, "Pet must have a rarity.");
		this.petType = Objects.requireNonNull(petType, "Pet must have a PetType");
		this.collection = Objects.requireNonNull(collection, "Pet must have a Collection");
		this.level = 100;
		this.cumulative_xp = 0;
	}

	/**
	 * Add experience points to the pet.
	 * 
	 * @param xp amount of experience points to add.
	 */
	public void addExperience(float xp) {
		this.cumulative_xp += xp;
	}

	/**
	 * Handle the effects that {@code this} will have.
	 *
	 * @param player the player.
	 */
	public abstract void effect(PlayerEntity player);

	/**
	 * Creates a primitive type array of buffs applied to {@link PlayerEntity}.<br>
	 * As each {@link Pet} gives different buffs, {@link Pet}s should not call this
	 * method to get a different {@link Pet}'s buffs.
	 * 
	 * @return primitive type array.
	 */
	public abstract double[] getBuffs();

	/**
	 * @return {@link #collection}
	 */
	public Collection getCollection() {
		return this.collection;
	}

	/**
	 * @return {@link #level}
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * @return {@link #petType}
	 */
	public PetType getPetType() {
		return this.petType;
	}

	public float getProgress() {
		return this.cumulative_xp / getRequirement(this.rarity, this.level);
	}

	/**
	 * @return {@link #rarity}
	 */
	public ModItemRarity getRarity() {
		return this.rarity;
	}

	/**
	 * Determine if this Pet is similar to another Pet.<br>
	 * Checks if {@link #petType} of the two pets are the same.
	 * 
	 * @param other {@link Pet} to compare with.
	 * @return true / false
	 */
	public boolean isIdentical(Pet other) {
		return this.petType == other.petType;
	}

	@Override
	public String toString() {
		return "Pet [collection=" + this.collection + ", current_xp=" + this.cumulative_xp + ", level=" + this.level
				+ ", petType=" + this.petType + ", rarity=" + this.rarity + "]";
	}

	/**
	 * Sets {@link #level} to the next level.
	 */
	public void upgradeLevel() {
		if (this.level < 100)
			++this.level;
	}

	/**
	 * Sets {@link #rarity} to the next tier.<br>
	 * This method should be the only one to modify {@link #rarity}.<br>
	 * Some pets can upgrade to {@link ModItemRarity#Mythic} and only through a
	 * certain item.
	 */
	public void upgradeTier() {
		switch (this.rarity) {
		case Mythic:
			return;
		default:
			this.rarity = this.rarity.getNext();
			int xp = 0, lvl = 0;
			while (xp < this.cumulative_xp) {
				xp += getRequirement(rarity, lvl);
				lvl++;
			}
			this.level = lvl - 1;
		}
	}
}