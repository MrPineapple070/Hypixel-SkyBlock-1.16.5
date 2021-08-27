package net.hypixel.skyblock.command.impl;

import java.io.IOException;

import javax.annotation.Nonnull;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

import net.hypixel.skyblock.command.CommonErrors;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * Opens the Auctions menu (requires Booster Cookie).<br>
 * Unlike /ah [username] allows full access including searching listings and
 * managing auctions.
 * 
 * @author MrPineapple070
 * @version 08 September 2020
 * @since 11 July 2019
 */
public class AuctionCommand {
	private static final SimpleCommandExceptionType ERROR_API_FAIL = new SimpleCommandExceptionType(
			new TranslationTextComponent("command.auction.fail.api"));

	/**
	 * {@link SimpleCommandExceptionType} to throw when {@link PlayerEntity} does
	 * not have a BoosterCookie active.
	 */
	@Nonnull
	private static final SimpleCommandExceptionType ERROR_NO_BOOSTER_COOKIE = new SimpleCommandExceptionType(
			new TranslationTextComponent("command.auction.fail.no_cookie"));

	/**
	 * {@link SimpleCommandExceptionType} to throw when {@link PlayerEntity} has no
	 * auctions.
	 */
	@Nonnull
	private static final SimpleCommandExceptionType ERROR_PLAYER_NO_AUCTION = new SimpleCommandExceptionType(
			new TranslationTextComponent("command.auction.fail.no_acution"));

	/**
	 * {@link Logger}
	 */
	@Nonnull
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Execute when no arguments are passed.
	 * 
	 * @param ctx
	 * @return
	 * @throws CommandSyntaxException
	 */
	private static final int openMenu(CommandContext<CommandSource> ctx) throws CommandSyntaxException {
		LOGGER.debug("Execute /auction no argument");
		Entity entity = ctx.getSource().getEntity();
		if (!(entity instanceof PlayerEntity))
			throw CommonErrors.ERROR_EXECUTER_NOT_PLAYER.create();
		PlayerEntity player = (PlayerEntity) entity;
		LOGGER.debug(player.toString());
		return Command.SINGLE_SUCCESS;
	}

	/**
	 * Execute when {@link PlayerEntity} is in argument
	 * 
	 * @param ctx {@link CommandContext} of {@link CommandSource}
	 * @return {@link Command#SINGLE_SUCCESS}
	 * @throws CommandSyntaxException if executor is not {@link PlayerEntity}
	 */
	private static final int player(CommandContext<CommandSource> ctx) throws CommandSyntaxException {
		LOGGER.debug("Execute /auction with argument");
		Entity entity = ctx.getSource().getEntity();
		if (!(entity instanceof PlayerEntity))
			throw CommonErrors.ERROR_EXECUTER_NOT_PLAYER.create();
		PlayerEntity target = ctx.getArgument("player", PlayerEntity.class);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet(
				"https://api.hypixel.net/skyblock/auction?key=API Key&player=" + target.getStringUUID());
		try (CloseableHttpResponse response = client.execute(request)) {
			LOGGER.debug(response.getStatusLine().toString());
			HttpEntity http_entity = response.getEntity();
			Header headers = http_entity.getContentType();
			LOGGER.debug(headers);

			if (http_entity != null) {
				String result = EntityUtils.toString(http_entity);
				LOGGER.debug(result);
			}
		} catch (ClientProtocolException e) {
			throw ERROR_API_FAIL.create();
		} catch (IOException e) {
			throw ERROR_API_FAIL.create();
		}
		return Command.SINGLE_SUCCESS;
	}

	/**
	 * Register command
	 * 
	 * @param dispatcher {@link CommandDispatcher} of {@link CommandSource}
	 */
	public static final void register(CommandDispatcher<CommandSource> dispatcher) {
		LOGGER.debug("Register /auction");
		LiteralArgumentBuilder<CommandSource> command = Commands.literal("auction").executes(AuctionCommand::openMenu)
				.then(Commands.argument("player", EntityArgument.player())).executes(AuctionCommand::player);
		dispatcher.register(command);
	}
}