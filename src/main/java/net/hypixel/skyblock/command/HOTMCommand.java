package net.hypixel.skyblock.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;

import net.hypixel.skyblock.inventory.container.HOTMContainer;
import net.hypixel.skyblock.inventory.container.init.ModContainerTypes;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;

/**
 * Command that opens the {@link HOTMContainer}
 * 
 * @author MrPineapple070
 * @version 15 January 2021
 * @since 15 January 2021
 */
public class HOTMCommand {
	private static final Logger LOGGER = LogManager.getLogger();
	
	public static final void register(CommandDispatcher<CommandSource> dispatcher) {
		LOGGER.debug("Register /hotm");
		LiteralArgumentBuilder<CommandSource> command = Commands.literal("hotm")
				.requires((commandSource) -> commandSource.hasPermission(0)).executes(HOTMCommand::execute);
		dispatcher.register(command);
	}

	private static int execute(CommandContext<CommandSource> context) {
		LOGGER.debug("Execute /hotm");
		Entity entity = context.getSource().getEntity();
		if (!(entity instanceof PlayerEntity))
			return -1;
		PlayerEntity player = (PlayerEntity) entity;
		Container container = ModContainerTypes.hotm.get().create(player.getId(), player.inventory);
		player.containerMenu = container;
		return 1;
	}
}