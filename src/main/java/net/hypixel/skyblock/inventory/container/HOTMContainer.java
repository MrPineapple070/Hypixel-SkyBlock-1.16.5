package net.hypixel.skyblock.inventory.container;

import javax.annotation.Nonnull;

import net.hypixel.skyblock.inventory.container.init.ModContainerTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class HOTMContainer extends Container implements INamedContainerProvider {
	@Nonnull
	public static final ITextComponent title = new TranslationTextComponent("container.hotm");
	
	public HOTMContainer(int windowID, PlayerInventory inventory) {
		super(ModContainerTypes.hotm.get(), windowID);
		
		// Main Inventory
		
		// Player Inventory
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 9; col++)
				this.addSlot(new Slot(inventory, 9 + col + row * 9, 8 + col * 18, 174 + row * 18));

		// Hotbar
		for (int i = 0; i < 9; i++)
			this.addSlot(new Slot(inventory, i, 8 + i * 18, 232));
	}

	public HOTMContainer(int windowID, PlayerInventory inventory, PacketBuffer data) {
		this(windowID, inventory);
	}

	@Override
	public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
		return this;
	}

	@Override
	public ITextComponent getDisplayName() {
		return title;
	}

	@Override
	public boolean stillValid(PlayerEntity player) {
		return true;
	}
}