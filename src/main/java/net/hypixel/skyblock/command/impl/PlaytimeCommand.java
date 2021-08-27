package net.hypixel.skyblock.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.hypixel.skyblock.command.CommonErrors;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.stats.ServerStatisticsManager;
import net.minecraft.stats.Stats;
import net.minecraft.util.text.TranslationTextComponent;

public class PlaytimeCommand {
	private static final Logger LOGGER = LogManager.getLogger();

	private static final int execute(CommandContext<CommandSource> ctx) throws CommandSyntaxException {
		LOGGER.debug("execute /playtime");
		Entity entity = ctx.getSource().getEntity();
		if (!(entity instanceof ServerPlayerEntity))
			CommonErrors.ERROR_EXECUTER_NOT_PLAYER.create();
		ServerPlayerEntity player = (ServerPlayerEntity) entity;
		ServerStatisticsManager stats = player.getStats();
		player.displayClientMessage(
				new TranslationTextComponent("commands.playtime.pass", stats.getValue(Stats.CUSTOM.get(Stats.PLAY_ONE_MINUTE))),
				false);
		return Command.SINGLE_SUCCESS;
	}

	public static final void register(CommandDispatcher<CommandSource> dispatcher) {
		LOGGER.debug("Register /playtime");
		LiteralArgumentBuilder<CommandSource> command = Commands.literal("playtime").requires((source) -> {
			return source.hasPermission(0);
		}).executes(PlaytimeCommand::execute);

		dispatcher.register(command);
	}
}