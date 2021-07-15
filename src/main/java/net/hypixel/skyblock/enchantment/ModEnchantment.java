package net.hypixel.skyblock.enchantment;

import javax.annotation.Nonnull;

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
	/**
	 * Primitive type array of {@link EquipmentSlotType} holding all Armor
	 * {@link EquipmentSlotType}
	 */
	@Nonnull
	protected static final EquipmentSlotType[] armor = new EquipmentSlotType[] { EquipmentSlotType.HEAD,
			EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET };

	/**
	 * {@link Logger}
	 */
	@Nonnull
	protected static final Logger LOGGER = LogManager.getLogger();

	/**
	 * {@link ModEnchantmentType}
	 */
	protected final ModEnchantmentType type;

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
	public final boolean isAllowedOnBooks() {
		return true;
	}
}