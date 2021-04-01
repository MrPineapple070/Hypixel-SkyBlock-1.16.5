package net.hypixel.skyblock.inventory.container.init;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.inventory.container.minion.AcaciaMinionContainer;
import net.hypixel.skyblock.inventory.container.minion.BlazeMinionContainer;
import net.hypixel.skyblock.inventory.container.minion.CoalMinionContainer;
import net.hypixel.skyblock.inventory.container.minion.CobblestoneMinionContainer;
import net.hypixel.skyblock.inventory.container.minion.WheatMinionContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MinionContainerTypes {
	public static final DeferredRegister<ContainerType<?>> container_types = DeferredRegister
			.create(ForgeRegistries.CONTAINERS, HypixelSkyBlockMod.MOD_ID);

	public static final RegistryObject<ContainerType<AcaciaMinionContainer>> acacia_minion = container_types
			.register("acacia_minion", () -> IForgeContainerType.create(AcaciaMinionContainer::new));
	public static final RegistryObject<ContainerType<CoalMinionContainer>> coal_minion = container_types
			.register("coal_minion", () -> IForgeContainerType.create(CoalMinionContainer::new));
	public static final RegistryObject<ContainerType<BlazeMinionContainer>> blaze_minion = container_types
			.register("blaze_minion", () -> IForgeContainerType.create(BlazeMinionContainer::new));
	public static final RegistryObject<ContainerType<CobblestoneMinionContainer>> cobblestone_minion = container_types
			.register("cobblestone_minion", () -> IForgeContainerType.create(CobblestoneMinionContainer::new));
	public static final RegistryObject<ContainerType<WheatMinionContainer>> wheat_minion = container_types
			.register("wheat_minion", () -> IForgeContainerType.create(WheatMinionContainer::new));
}