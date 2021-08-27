package net.hypixel.skyblock.command;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.mojang.brigadier.exceptions.CommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * Holds common {@link CommandExceptionType} to throw.
 * 
 * @author MrPineapple070
 * @version 23 August 2021
 * @since 11 July 2019
 */
@Immutable
public class CommonErrors {
	/**
	 * {@link SimpleCommandExceptionType} to throw when executer is not
	 * {@link PlayerEntity}
	 */
	@Nonnull
	public static final SimpleCommandExceptionType ERROR_EXECUTER_NOT_PLAYER = new SimpleCommandExceptionType(
			new TranslationTextComponent("command.auction.fail.not_player"));
}