package net.hypixel.skyblock.items.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

/**
 * @author MrPineapple070
 * @version 08 March 2021
 * @since 11 July 2019
 */
public enum ModToolTier implements IItemTier {
	BP0(0, 2f), BP1(1, 4f), BP2(2, 6f), BP3(3, 8f), BP4(4, 9f), BP5(5, 12f), BP6(6, 14f), BP7(7, 16f), BP8(8, 18f), BP9(9, 20f);

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