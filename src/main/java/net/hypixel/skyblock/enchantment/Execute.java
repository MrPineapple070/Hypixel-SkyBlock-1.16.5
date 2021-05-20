package net.hypixel.skyblock.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;

public class Execute extends ModEnchantment {

	public Execute() {
		super(Rarity.COMMON, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND);
	}
	
	@Override
	public void doPostAttack(LivingEntity attacker, Entity attacked, int lvl) {
		if (!(attacked instanceof MobEntity))
			return;
		attacked.hurt(DamageSource.mobAttack(attacker), 1 - attacker.getHealth()/attacker.getMaxHealth());
	}
	
	@Override
	public float getDamageBonus(int lvl, CreatureAttribute attribute) {
		return .2f * lvl;
	}
	
	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return ench != EnchantmentInit.prosecute.get();
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}