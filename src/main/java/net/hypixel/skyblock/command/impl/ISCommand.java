package net.hypixel.skyblock.command.impl;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.hypixel.skyblock.command.CommonErrors;
import net.hypixel.skyblock.world.util.DimensionResourceLocations;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class ISCommand {
	/**
	 * {@link Logger}
	 */
	@Nonnull
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Execute command
	 * 
	 * @param ctx {@link CommandContext} of {@link CommandSource}
	 * @return {@link Command#SINGLE_SUCCESS}
	 * @throws CommandSyntaxException when execution fails
	 */
	private static final int execute(CommandContext<CommandSource> ctx) throws CommandSyntaxException {
		Entity entity = ctx.getSource().getEntity();
		if (!(entity instanceof PlayerEntity))
			throw CommonErrors.ERROR_EXECUTER_NOT_PLAYER.create();
		PlayerEntity player = (PlayerEntity) entity;
		player.getServer().getCommands().performCommand(player.createCommandSourceStack(),
				"execute in " + DimensionResourceLocations.private_island.toString() + " run teleport @s 0 5 0");
		return Command.SINGLE_SUCCESS;
	}

	/**
	 * Register command
	 * 
	 * @param dispatcher {@link CommandDispatcher} of {@link CommandSource}
	 */
	public static final void register(CommandDispatcher<CommandSource> dispatcher) {
		LiteralArgumentBuilder<CommandSource> command = Commands.literal("is").requires((source) -> {
			return source.hasPermission(0);
		}).executes(ISCommand::execute);
		dispatcher.register(command);
	}
}