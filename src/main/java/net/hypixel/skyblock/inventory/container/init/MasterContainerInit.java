package net.hypixel.skyblock.inventory.container.init;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.minecraftforge.eventbus.api.IEventBus;

public class MasterContainerInit {
	public static final void register(IEventBus bus) {
		HypixelSkyBlockMod.LOGGER.debug("MasterContainerInit registering");
		MinionContainerTypes.container_types.register(bus);
		ModContainerTypes.container_types.register(bus);
	}
}