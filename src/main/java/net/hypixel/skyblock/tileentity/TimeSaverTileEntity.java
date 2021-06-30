package net.hypixel.skyblock.tileentity;

import java.util.Objects;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.hypixel.skyblock.blocks.TimeSaver.TimeSaverType;
import net.hypixel.skyblock.inventory.container.init.ModContainerTypes;
import net.hypixel.skyblock.util.TimeConverter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.storage.IServerWorldInfo;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

/**
 * @author MrPineapple070
 * @version 07 October 2020
 * @since 07 October 2020
 */
public class TimeSaverTileEntity extends LockableLootTileEntity implements ITickableTileEntity, INamedContainerProvider {
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

	/**
	 * {@link ItemStack} used in {@link #getItem(int)}, {@link #removeItem(int, int)}, and {@link #removeItemNoUpdate(int)}
	 */
	@Nonnull
	protected static final ItemStack stack = new ItemStack(Items.DAYLIGHT_DETECTOR);

	/**
	 * {@link TranslationTextComponent} for the name of day time
	 */
	@Nonnull
	protected static final ITextComponent day = new TranslationTextComponent("container.time_saver.day");

	/**
	 * {@link TranslationTextComponent} for the name of night time
	 */
	@Nonnull
	protected static final ITextComponent night = new TranslationTextComponent("container.time_saver.night");

	/**
	 * {@link Logger}
	 */
	@Nonnull
	protected static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * {@link LazyOptional} of {@link IItemHandlerModifiable}
	 */
	@Nonnull
	protected LazyOptional<IItemHandlerModifiable> saverHandler = LazyOptional.of(() -> new InvWrapper(this));

	/**
	 * {@link TimeSaverType} to handle day or night.
	 */
	@Nonnull
	public final TimeSaverType type;
	
	/**
	 * Index that holds time selected;
	 */
	protected int selected;

	public TimeSaverTileEntity(TileEntityType<? extends TimeSaverTileEntity> typeIn, TimeSaverType type) {
		super(typeIn);
		this.type = Objects.requireNonNull(type, "TimeSaverType cannot be null");
	}

	@Override
	protected Container createMenu(int windowId, PlayerInventory inventory) {
		return ModContainerTypes.time_saver.get().create(windowId, inventory);
	}

	@Override
	public int getContainerSize() {
		return 12;
	}

	@Override
	protected ITextComponent getDefaultName() {
		switch (this.type) {
		case Day:
			return day;
		case Night:
			return night;
		default:
			throw new IllegalStateException("Illegal TimeSaverType:\t" + this.type.name());
		}
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return NonNullList.create();
	}

	@Override
	protected void setItems(NonNullList<ItemStack> list) {
	}
	
	public void setSelected(int selected) {
		this.selected = selected;
	}

	@Override
	public boolean stillValid(PlayerEntity player) {
		return true;
	}

	@Override
	public void tick() {
		if (this.level.isClientSide)
			return;
		IServerWorldInfo world = (IServerWorldInfo) this.level.getLevelData();
		world.setGameTime(TimeConverter.hours.get(this.selected));
		
	}
	
	@Override
	public String toString() {
		return "TimeSaverTileEntity[type=" + this.type.name() + ", worldPosition=" + this.worldPosition.toShortString() + "]";
	}
}