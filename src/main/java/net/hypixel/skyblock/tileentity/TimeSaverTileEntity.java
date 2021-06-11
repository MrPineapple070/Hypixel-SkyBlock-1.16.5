package net.hypixel.skyblock.tileentity;

import java.util.Objects;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.hypixel.skyblock.blocks.TimeSaver;
import net.hypixel.skyblock.blocks.TimeSaver.TimeSaverType;
import net.hypixel.skyblock.inventory.container.TimeSaverContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

/**
 * @author MrPineapple070
 * @version 07 October 2020
 * @since 07 October 2020
 */
public class TimeSaverTileEntity extends TileEntity implements IInventory, INamedContainerProvider {
	public static final class DaySaverTileEntity extends TimeSaverTileEntity {
		public DaySaverTileEntity() {
			super(ModTileEntityTypes.day_saver.get(), TimeSaverType.Day);
		}
	}

	public static final class NightSaverTileEntity extends TimeSaverTileEntity {
		public NightSaverTileEntity() {
			super(ModTileEntityTypes.night_saver.get(), TimeSaverType.Night);
		}
	}
	
	@Nonnull
	protected static final ItemStack stack = new ItemStack(Items.DAYLIGHT_DETECTOR);
	
	@Nonnull
	protected static final ITextComponent day = new TranslationTextComponent("container.time_saver.day");
	
	@Nonnull
	protected static final ITextComponent night = new TranslationTextComponent("container.time_saver.night");
	
	@Nonnull
	protected static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * {@link LazyOptional} of {@link IItemHandlerModifiable}
	 */
	@Nonnull
	protected LazyOptional<IItemHandlerModifiable> saverHandler = LazyOptional.of(() -> new InvWrapper(this));
	
	public final TimeSaverType type;
	
	public TimeSaverTileEntity(TileEntityType<? extends TimeSaverTileEntity> typeIn, TimeSaverType type) {
		super(typeIn);
		this.type = Objects.requireNonNull(type, "TimeSaverType cannot be null");
		LOGGER.debug(this.getType().getRegistryName().toString());
	}

	@Override
	public void clearContent() {
		return;
	}

	@Override
	public int getContainerSize() {
		return 12;
	}

	@Override
	public ItemStack getItem(int index) {
		return stack;
	}
	
	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public ItemStack removeItem(int index, int slot) {
		return ItemStack.EMPTY;
	}

	@Override
	public ItemStack removeItemNoUpdate(int index) {
		return ItemStack.EMPTY;
	}

	@Override
	public void setItem(int index, ItemStack item) {
		return;
	}

	public void setSelected(int index) {
		((TimeSaver) this.level.getBlockState(this.worldPosition).getBlock()).setSelected(index);
	}

	@Override
	public boolean stillValid(PlayerEntity player) {
		return true;
	}

	@Override
	public Container createMenu(int windowId, PlayerInventory inventory, PlayerEntity player) {
		return new TimeSaverContainer(windowId, inventory, this);
	}

	@Override
	public ITextComponent getDisplayName() {
		switch (this.type) {
		case Day:
			return day;
		case Night:
			return night;
		default:
			throw new IllegalStateException("Illegal TimeSaverType:\t" + this.type.name());
		}
	}
}