package net.hypixel.skyblock.pets;

import java.util.Objects;
import java.util.Random;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.hypixel.skyblock.items.Collection;
import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.pets.util.LevelCalculator;
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
	 * {@link Random}
	 */
	@Nonnull
	protected static final Random rand = new Random();

	/**
	 * @return {@link ModItemRarity#Epic} or {@link ModItemRarity#Legendary}
	 *         randomly.
	 */
	protected static ModItemRarity getRandomRarityHigh() {
		return ModItemRarity.high[rand.nextInt(ModItemRarity.high.length)];
	}

	/**
	 * @return {@link ModItemRarity#Common}, {@link ModItemRarity#Uncommon}, or
	 *         {@link ModItemRarity#Rare} randomly.
	 */
	protected static ModItemRarity getRandomRarityLow() {
		return ModItemRarity.low[rand.nextInt(ModItemRarity.low.length)];
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
	 * method to get a different {@link Pet}'s buffs.<br>
	 * If a pet does not have effects, return an empty array.
	 * 
	 * @return primitive type array.
	 */
	@Nonnull
	public abstract double[] getBuffs();

	/**
	 * @return {@link #level}
	 */
	public int getLevel() {
		return this.level;
	}

	public float getProgress() {
		return this.cumulative_xp / LevelCalculator.getRequirement(this.rarity, this.level);
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

	/**
	 * Sets {@link #level} to the next level.
	 */
	public void upgradeLevel() {
		switch (this.petType) {
		case GoldenDragon:
			if (this.level < 200)
				++this.level;
			return;
		default:
			if (this.level < 100)
				++this.level;
			return;
		}
	}

	/**
	 * Sets {@link #rarity} to the next tier.<br>
	 * This method should be the only one to modify {@link #rarity}.<br>
	 * Some pets can upgrade to {@link ModItemRarity#Mythic} and only through a
	 * certain item.
	 */
	public void upgradeTier() {
		LOGGER.debug("Upgrading rarity for " + this.petType.name());
		switch (this.rarity) {
		case Mythic:
			return;
		default:
			this.rarity = this.rarity.getNext();
			int xp = 0, lvl = 0;
			while (xp < this.cumulative_xp) {
				xp += LevelCalculator.getRequirement(rarity, lvl);
				lvl++;
			}
			this.level = lvl - 1;
		}
	}
}