package net.hypixel.skyblock.tileentity;

import javax.annotation.Nonnull;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

/**
 * @author MrPineapple070
 * @version 07 October 2020
 * @since 07 October 2020
 */
public class TimeSaverTileEntity extends TileEntity implements IInventory {
	public static final class DaySaverTileEntity extends TimeSaverTileEntity {
		public DaySaverTileEntity() {
			super(ModTileEntityTypes.day_saver.get());
		}
	}

	public static final class NightSaverTileEntity extends TimeSaverTileEntity {
		public NightSaverTileEntity() {
			super(ModTileEntityTypes.night_saver.get());
		}
	}

	protected static final ItemStack stack = new ItemStack(Items.DAYLIGHT_DETECTOR);

	/**
	 * {@link LazyOptional} of {@link IItemHandlerModifiable}
	 */
	@Nonnull
	protected LazyOptional<IItemHandlerModifiable> saverHandler = LazyOptional.of(() -> new InvWrapper(this));

	public TimeSaverTileEntity(TileEntityType<? extends TimeSaverTileEntity> typeIn) {
		super(typeIn);
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void clearContent() {
	}

	@Override
	public int getContainerSize() {
		return 12;
	}

	@Override
	public ItemStack getItem(int p_70301_1_) {
		return stack;
	}

	@Override
	public ItemStack removeItem(int p_70298_1_, int p_70298_2_) {
		return ItemStack.EMPTY;
	}

	@Override
	public ItemStack removeItemNoUpdate(int p_70304_1_) {
		return ItemStack.EMPTY;
	}

	@Override
	public void setItem(int p_70299_1_, ItemStack p_70299_2_) {
	}

	@Override
	public boolean stillValid(PlayerEntity p_70300_1_) {
		return true;
	}
}