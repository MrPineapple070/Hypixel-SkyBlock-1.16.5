package net.hypixel.skyblock.enchantment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

/**
 * A Mod version of {@link Enchantment}
 *
 * @author MrPineapple070
 * @version 11 October 2020
 * @since 11 October 2020
 */
public abstract class ModEnchantment extends Enchantment {
	protected static final EquipmentSlotType[] armor = new EquipmentSlotType[] { EquipmentSlotType.HEAD,
			EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET };
	
	protected static final Logger LOGGER = LogManager.getLogger();
	
	protected final ModEnchantmentType type;
	
	/**
	 * @param rarityIn {@link Rarity} of this
	 * @param typeIn   {@link EnchantmentType} of this
	 * @param slots    {@link EquipmentSlotType}[] of this
	 */
	protected ModEnchantment(Rarity rarity, EnchantmentType type, EquipmentSlotType slots) {
		this(rarity, type, new EquipmentSlotType[] { slots });
	}
	
	protected ModEnchantment(Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		super(rarity, type, slots);
		this.type = null;
	}
	
	protected ModEnchantment(Rarity rarity, ModEnchantmentType type, EquipmentSlotType... slots) {
		super(rarity, EnchantmentType.VANISHABLE, slots);
		this.type = type;
	}

	@Override
	protected abstract boolean checkCompatibility(Enchantment ench);

	@Override
	public abstract int getMaxLevel();

	@Override
	public boolean isAllowedOnBooks() {
		return true;
	}
}