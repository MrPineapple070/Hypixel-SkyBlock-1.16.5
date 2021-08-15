package net.hypixel.skyblock.items.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

/**
 * @author MrPineapple070
 * @version 08 March 2021
 * @since 11 July 2019
 */
public enum ModToolTier implements IItemTier {
	Stonk(0, 510/35f),
	Pickonimbus(7, 1500/35f),
	Mithril1(5, 450/35f),
	Mithril2(6, 600/35f),
	Titanium1(7, 700/35f),
	Titanium2(8, 900/35f),
	Titanium3(9, 1200/35f),
	Titanium4(9, 1600/35f),
	Divan(10, 1800/35f),
	Ruby(7, 150/35f),
	Gemstone(8, 300/35f),
	Topaz(9, 450/35f),
	Jasper(9, 600/35f)
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