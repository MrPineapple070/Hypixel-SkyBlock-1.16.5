package net.hypixel.skyblock.command;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.world.gen.feature.WarpLocation;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * Allows {@link PlayerEntity} to warp between locations held in
 * {@link WarpLocation}
 * 
 * @author MrPineapple070
 * @version 13 May 2020
 * @since 13 May 2020
 */
public class WarpCommand {
	/**
	 * {@link DynamicCommandExceptionType}
	 */
	protected static final DynamicCommandExceptionType ERROR_LOCATION_INVALID = new DynamicCommandExceptionType(
			(location) -> new TranslationTextComponent("command.warp.fail", location));

	protected static final DynamicCommandExceptionType ERROR_DIM_DNE = new DynamicCommandExceptionType(
			(dimention) -> new TranslationTextComponent("command.warp.dimention.dne", dimention));

	/**
	 * {@link Logger}
	 */
	@Nonnull
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Registers this command.
	 * 
	 * @param dispatcher {@link CommandDispatcher}
	 */
	public static final void register(CommandDispatcher<CommandSource> dispatcher) {
		LOGGER.debug("Register /warp");
		LiteralArgumentBuilder<CommandSource> command = Commands.literal("warp");
		command.requires((source) -> {
			return source.hasPermission(0);
		});
		for (WarpLocation location : WarpLocation.values())
			command.then(Commands.literal(location.name().toLowerCase()).executes((ctx) -> {
				return execute(ctx.getSource(), location);
			}));
		dispatcher.register(command);
	}

	/**
	 * Executes command.
	 * 
	 * @param source   {@link CommandSource} of this
	 * @param location {@link WarpLocation} to warp to
	 * @return {@link Command#SINGLE_SUCCESS} upon success. -1 otherwise.
	 * @throws CommandSyntaxException if {@link WarpLocation} is invalid
	 */
	// TODO Fix coords and resource
	private static int execute(CommandSource source, WarpLocation location) throws CommandSyntaxException {
		LOGGER.debug("Execute /warp " + location.toString());
		Entity entity = source.getEntity();
		if (!(entity instanceof PlayerEntity))
			return -1;
		PlayerEntity player = (PlayerEntity) entity;
		ResourceLocation resource;
		String coords;
		switch (location) {
		case Barn:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Castle:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Crypt:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Da:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Deep:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Desert:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Drag:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Dungeon_Hub:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case End:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Forge:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Gold:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Home:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Howl:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Hub:
			resource = new ResourceLocation("overworld");
			break;
		case Jerry:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Jungle:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Magma:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Mines:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Nest:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Nether:
			resource = new ResourceLocation("nether");
			break;
		case Park:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		case Spider:
			resource = new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "private_island");
			break;
		default:
			throw ERROR_LOCATION_INVALID.create(location);
		}
		coords = "0 5 0";
		player.getServer().getCommands().performCommand(player.createCommandSourceStack(), "execute in " + resource.toString() + " run teleport @s " + coords);
		player.displayClientMessage(new TranslationTextComponent("commands.warp.pass", location.name()), false);
		return Command.SINGLE_SUCCESS;
	}
}