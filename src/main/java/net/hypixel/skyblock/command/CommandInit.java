package net.hypixel.skyblock.command;

import com.mojang.brigadier.CommandDispatcher;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.command.impl.AuctionCommand;
import net.hypixel.skyblock.command.impl.DeathCountCommand;
import net.hypixel.skyblock.command.impl.HOTMCommand;
import net.hypixel.skyblock.command.impl.PlaytimeCommand;
import net.hypixel.skyblock.command.impl.WarpCommand;
import net.minecraft.command.CommandSource;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/**
 * Initializes all commands.
 * 
 * @author MrPineapple070
 * @version 31 July 2021
 * @since 11 July 2019
 */
@EventBusSubscriber(bus = Bus.FORGE, modid = HypixelSkyBlockMod.MOD_ID)
public class CommandInit {
	@SubscribeEvent
	public static void register(RegisterCommandsEvent event) {
		CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();
		AuctionCommand.register(dispatcher);
		DeathCountCommand.register(dispatcher);
		HOTMCommand.register(dispatcher);
		PlaytimeCommand.register(dispatcher);
		WarpCommand.register(dispatcher);
	}
}