package net.hypixel.skyblock.enchantment;

import java.util.function.Predicate;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.common.IExtensibleEnum;

/**
 * A Mod version of {@link Enchantment}
 *
 * @author MrPineapple070
 * @version 11 October 2020
 * @since 11 October 2020
 */
public abstract class ModEnchantment extends Enchantment {
	public static enum ModEnchantmentType implements IExtensibleEnum {
		PICKAXE {
			public boolean canEnchant(Item item) {
				return item instanceof PickaxeItem;
			}
		},
		SHOVEL {
			public boolean canEnchant(Item item) {
				return item instanceof ShovelItem;
			}
		},
		AXE {
			public boolean canEnchant(Item item) {
				return item instanceof AxeItem;
			}
		},
		HOE {
			public boolean canEnchant(Item item) {
				return item instanceof HoeItem;
			}
		};

		private Predicate<Item> delegate;

		private ModEnchantmentType() {
		}

		private ModEnchantmentType(Predicate<Item> delegate) {
			this.delegate = delegate;
		}

		public boolean canEnchant(Item item) {
			return this.delegate.test(item);
		}
	}

	protected static final EquipmentSlotType[] armor = new EquipmentSlotType[] { EquipmentSlotType.HEAD,
			EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET };
	
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
		super(rarity, EnchantmentType.BREAKABLE, slots);
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