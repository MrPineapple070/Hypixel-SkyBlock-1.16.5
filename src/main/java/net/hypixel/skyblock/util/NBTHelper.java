package net.hypixel.skyblock.util;

import java.util.Objects;

import javax.annotation.Nullable;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * This class helps read and write {@link CompoundNBT}
 *
 * @author MrPineapple070
 * @version 27 May 2020.
 */
public class NBTHelper {
	/**
	 * Read {@code c}. The reverse of {@link #toNBT(Object)}
	 *
	 * @param c is the {@link CompoundNBT} to read from.
	 * @return the object read from {@code c}
	 */
	@Nullable
	public static ItemStack fromNBT(CompoundNBT c) {
		Objects.requireNonNull(c, "CompoundNBT cannot be null");
		switch (c.getByte("type")) {
		case 0:
			return new ItemStack(
					ForgeRegistries.ITEMS.getValue(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, c.getString("item"))),
					c.getInt("count"));
		default:
			return null;
		}
	}

	/**
	 * Creates {@link CompoundNBT} from {@code o}
	 *
	 * @param o the {@link Object} to write {@code CompoundNBT} for.
	 * @return the written {@code CompoundNBT}
	 * @throws IllegalAccessException if {@link #writeItemStack(ItemStack)} throws
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private static CompoundNBT toNBT(Object o) throws IllegalAccessException {
		if (o instanceof ItemStack)
			return writeItemStack((ItemStack) o);
		if (o instanceof AbstractMinionTileEntity)
			return writeMinion((AbstractMinionTileEntity) o);
		return null;
	}

	/**
	 * Write {@link CompoundNBT} for {@link ItemStack}
	 *
	 * @param stack the {@code ItemStack} to write {@code CompoundNBT} for.
	 * @return the written {@code CompoundNBT}
	 * @throws IllegalAccessException if stack is {@link ItemStack#isEmpty()}
	 */
	public static CompoundNBT writeItemStack(ItemStack stack) throws IllegalAccessException {
		Objects.requireNonNull(stack, "ItemStack cannot be null");
		if (stack.isEmpty())
			throw new IllegalAccessException("ItemStack cannot be empty");
		;
		final CompoundNBT c = new CompoundNBT();
		c.putInt("count", stack.getCount());
		c.putString("item", stack.getItem().getRegistryName().toString());
		c.putByte("type", (byte) 0);
		return c;
	}

	/**
	 * Write {@link CompoundNBT} for {@link AbstractMinionTileEntity}
	 *
	 * @param minion the {@code AbstractMinionTileEntity} to write
	 *               {@code CompoundNBT} for.
	 * @return the written {@code CompoundNBT}
	 */
	@Deprecated
	private static CompoundNBT writeMinion(AbstractMinionTileEntity minion) {
		Objects.requireNonNull(minion, "Minion cannot be null");
		final CompoundNBT c = new CompoundNBT();
		// c.putInt("x", minion.x);
		// c.putInt("y", minion.y);
		// c.putInt("z", minion.z);
		return c;
	}
}