package net.hypixel.skyblock.items.accessories;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.accessories.PersonalCompactor.PersonalComp4000;
import net.hypixel.skyblock.items.accessories.PersonalCompactor.PersonalComp5000;
import net.hypixel.skyblock.items.accessories.PersonalCompactor.PersonalComp6000;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public abstract class PersonalAccessory extends Accessory {
	public static enum Type {
		Type4, Type5, Type6, Type7;
	}

	/**
	 * The list of {@link ItemStack}
	 */
	@Nonnull
	public final NonNullList<ItemStack> items;

	/**
	 * An int that differentiates {@link PersonalComp4000},
	 * {@link PersonalComp5000}, and {@link PersonalComp6000}.<br>
	 * This value is expected to be 0xFA0 (4000), 0x1388 (5000), or 0x1770 (6000).
	 */
	@Nonnull
	protected final Type type;

	public PersonalAccessory(Properties properties, ModItemRarity rarity, Type type) {
		super(properties, rarity);
		this.type = Objects.requireNonNull(type, "PersonalAccessory.Type cannot be null");
		switch (this.type) {
		case Type4:
			this.items = NonNullList.withSize(1, ItemStack.EMPTY);
			break;
		case Type5:
			this.items = NonNullList.withSize(3, ItemStack.EMPTY);
			break;
		case Type6:
			this.items = NonNullList.withSize(7, ItemStack.EMPTY);
			break;
		case Type7:
			this.items = NonNullList.withSize(12, ItemStack.EMPTY);
			break;
		default:
			throw new IllegalArgumentException("Illegal Personal Compactor type:\t" + this.type.name());
		}
	}

	/**
	 * Decreases {@link ItemStack} in indicated index by count. Edits {@link #items}
	 * 
	 * @param index index to decrease
	 * @param count amount to decrease by
	 * @return {@link ItemStackHelper#removeItem(List, int, int)}
	 */
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.removeItem(this.items, index, count);
	}

	/**
	 * Removed {@link ItemStack} in indecated index. Edits {@link #items}
	 * 
	 * @param index index to remove
	 * @return removed {@link ItemStack}
	 */
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.takeItem(this.items, index);
	}

	@Override
	public abstract void inventoryTick(ItemStack stack, World world, Entity entity, int tick, boolean selected);
}