package net.hypixel.skyblock.items.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

/**
 * @author MrPineapple070
 * @version 08 March 2021
 * @since 11 July 2019
 */
public enum ModToolTier implements IItemTier {
	Stonk(0, 35 * 510f),
	Pickonimbus(7, 35 * 1500),
	Divan(10, 35 * 1800)
	;

	private final int harvest_lvl;
	private final float speed;

	private ModToolTier(int lvl, float eff) {
		this.harvest_lvl = lvl;
		this.speed = eff;
	}

	@Override
	public int getUses() {
		return Integer.MAX_VALUE;
	}

	@Override
	public float getSpeed() {
		return this.speed;
	}

	@Override
	public float getAttackDamageBonus() {
		return 0f;
	}

	@Override
	public int getLevel() {
		return this.harvest_lvl;
	}

	@Override
	public int getEnchantmentValue() {
		return 32;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.EMPTY;
	}
}