package net.hypixel.skyblock.util;

import java.lang.reflect.Field;

import javax.annotation.concurrent.Immutable;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.blocks.init.BlockInit;
import net.hypixel.skyblock.blocks.init.MinionBlockInit;
import net.hypixel.skyblock.client.gui.screen.AbstractMinionScreen;
import net.hypixel.skyblock.client.gui.screen.MinionChestScreen.LargeMCS;
import net.hypixel.skyblock.client.gui.screen.MinionChestScreen.MediumMCS;
import net.hypixel.skyblock.client.gui.screen.MinionChestScreen.SmallMCS;
import net.hypixel.skyblock.client.gui.screen.ModAnvilScreen;
import net.hypixel.skyblock.client.gui.screen.TimeSaverScreen;
import net.hypixel.skyblock.client.render.entity.VillageNPCRender;
import net.hypixel.skyblock.entity.ModEntityTypes;
import net.hypixel.skyblock.inventory.container.init.MinionContainerTypes;
import net.hypixel.skyblock.inventory.container.init.ModContainerTypes;
import net.hypixel.skyblock.inventory.container.minion.AbstractMinionContainer;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.ChestTileEntityRenderer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * {@link EventBusSubscriber} for Client.<br>
 * Activates on {@link FMLClientSetupEvent}
 *
 * @author MrPineapple070
 * @version 8 June 2020
 * @since 11 June 2019
 */
@Mod.EventBusSubscriber(modid = HypixelSkyBlockMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
@Immutable
public final class ClientEventBusSubscriber {
	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public static final void clientSetup(FMLClientSetupEvent event) {
		for (Field field : MinionContainerTypes.class.getDeclaredFields())
			if (field.getType() == RegistryObject.class)
				try {
					RegistryObject<ContainerType<AbstractMinionContainer>> obj = null;
					obj = (RegistryObject<ContainerType<AbstractMinionContainer>>) field.get(obj);
					ScreenManager.register(obj.get(), AbstractMinionScreen::new);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					continue;
				}

		ScreenManager.register(ModContainerTypes.small_mcc.get(), SmallMCS::new);
		ScreenManager.register(ModContainerTypes.medium_mcc.get(), MediumMCS::new);
		ScreenManager.register(ModContainerTypes.large_mcc.get(), LargeMCS::new);
		ScreenManager.register(ModContainerTypes.anvil.get(), ModAnvilScreen::new);
		ScreenManager.register(ModContainerTypes.time_saver.get(), TimeSaverScreen::new);

		for (RegistryObject<Block> obj : MinionBlockInit.minionBlocks.getEntries())
			RenderTypeLookup.setRenderLayer(obj.get(), RenderType.solid());
		
		RenderTypeLookup.setRenderLayer(BlockInit.day_saver.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.night_saver.get(), RenderType.translucent());

		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.small_mcte.get(), ChestTileEntityRenderer::new);
		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.medium_mcte.get(), ChestTileEntityRenderer::new);
		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.large_mcte.get(), ChestTileEntityRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.Andrew.get(), VillageNPCRender::new);
		// RenderingRegistry.registerEntityRenderingHandler(null, null);
	}
}