package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;

/**
 * @author MrPineapple070
 * @version 13 October 2020
 * @since 13 October 2020
 */
public class Critical extends ModEnchantment {
	protected Critical() {
		super(Rarity.UNCOMMON, EnchantmentType.WEAPON, new EquipmentSlotType[] { EquipmentSlotType.MAINHAND });
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return true;
	}

	@Override
	public int getMaxLevel() {
		return 6;
	}

	@Override
	public boolean isAllowedOnBooks() {
		return true;
	}

	@Override
	public void doPostAttack(LivingEntity user, Entity target, int damage) {
		target.hurt(DamageSource.mobAttack(user), 1.1f * damage);
	}
}