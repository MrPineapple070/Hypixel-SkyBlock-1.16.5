package net.hypixel.skyblock.command.impl;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class ViewCommand {
	private static enum View {
		Achievements, Boss, Collection, Commissions, Craft, DungeonClass, DungeonType, ExtraStats, HOTM, Menu, Pet,
		Potion, Profile, Quests, Recipe, Rewards, Settings, Skill, Stash;
	}

	/**
	 * {@link Logger}
	 */
	@Nonnull
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Execute command
	 * 
	 * @param ctx {@link CommandContext} of {@link CommandSource}
	 * @param view {@link View} for more efficient {@link Screen} selection
	 * @return {@link Command#SINGLE_SUCCESS}
	 * @throws CommandSyntaxException when execution fails
	 */
	private static final int execute(CommandContext<CommandSource> ctx, View view) throws CommandSyntaxException {
		//TODO FIX
		return Command.SINGLE_SUCCESS;
	}

	/**
	 * Register command
	 * 
	 * @param dispatcher {@link CommandDispatcher} of {@link CommandSource}
	 */
	public static final void register(CommandDispatcher<CommandSource> dispatcher) {
		LiteralArgumentBuilder<CommandSource> command = Commands.literal("view").requires((source) -> {
			return source.hasPermission(0);
		});
		for (View v : View.values())
			command.then(Commands.literal(v.name().toLowerCase())).executes((ctx) -> execute(ctx, v));
		dispatcher.register(command);
	}
}