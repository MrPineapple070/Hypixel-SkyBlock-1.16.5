package net.hypixel.skyblock.enchantment;

import net.hypixel.skyblock.entity.ModCreatureAttribute;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

/**
 * @author MrPineapple070
 * @version 13 October 2020
 * @since 13 October 2020
 */
public class ModDamageEnchantment extends DamageEnchantment {
	private static final int[] LEVEL_COST = { 11, 8, 8, 8 };
	private static final int[] LEVEL_COST_SPAN = { 20, 20, 20, 20 };
	private static final int[] MIN_COST = { 1, 5, 5, 5 };

	public ModDamageEnchantment(Rarity rarityIn, int damageTypeIn, EquipmentSlotType... slots) {
		super(rarityIn, damageTypeIn, slots);
	}

	/**
	 * Calculates the additional damage that will be dealt by an item with this
	 * enchantment. This alternative to calcModifierDamage is sensitive to the
	 * targets EnumCreatureAttribute.
	 */
	@Override
	public float getDamageBonus(int level, CreatureAttribute creatureType) {
		switch (this.type) {
		case 3:
			if (creatureType == ModCreatureAttribute.cube)
				return 1.1f * level;
			break;
		case 4:
			if (creatureType == ModCreatureAttribute.dragon)
				return 1.08f * level;
			break;
		case 5:
			if (creatureType == ModCreatureAttribute.ender)
				return 1.12f * level;
			break;
		case 6:
			if (creatureType == ModCreatureAttribute.impaling)
				return 1.125f * level;
			break;
		}
		return super.getDamageBonus(level, creatureType);
	}

	@Override
	public boolean checkCompatibility(Enchantment ench) {
		return false;
	}

	@Override
	public int getMaxCost(int enchantmentLevel) {
		return this.getMinCost(enchantmentLevel) + LEVEL_COST_SPAN[this.type];
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public int getMinCost(int enchantmentLevel) {
		return MIN_COST[this.type] + (enchantmentLevel - 1) * LEVEL_COST[this.type];
	}

	@Override
	public void doPostAttack(LivingEntity user, Entity target, int level) {
		if (target instanceof LivingEntity) {
			final LivingEntity livingentity = (LivingEntity) target;
			if (this.type == 2 && livingentity.getMobType() == CreatureAttribute.ARTHROPOD) {
				final int i = 20 + user.getRandom().nextInt(10 * level);
				livingentity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, i, 3));
			}
		}
	}
}