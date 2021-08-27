package net.hypixel.skyblock.command.impl;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.command.CommandSource;

public class BestiaryCommand {
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
		return Command.SINGLE_SUCCESS;
	}
	
	/**
	 * Register command
	 * 
	 * @param dispatcher {@link CommandDispatcher} of {@link CommandSource}
	 */
	public static final void register(CommandDispatcher<CommandSource> dispatcher) {
		
	}
}