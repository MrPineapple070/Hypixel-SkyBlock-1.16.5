package net.hypixel.skyblock.items.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.command.arguments.ItemInput;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MenuItem extends Item {
	protected static final Logger LOGGER = LogManager.getLogger();
	protected static final Properties properties = new Properties().stacksTo(1);

	public MenuItem() {
		super(properties);
	}

	public void inventoryTick(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean selected) {
		if (world.isClientSide)
			return;
		LOGGER.debug("Removing " + this.getRegistryName().toString());
		if (!(entity instanceof PlayerEntity))
			return;
		PlayerEntity player = (PlayerEntity) entity;
		player.inventory.clearOrCountMatchingItems(new ItemInput(this, null), Integer.MAX_VALUE,
				player.inventoryMenu.getCraftSlots());
	}
}