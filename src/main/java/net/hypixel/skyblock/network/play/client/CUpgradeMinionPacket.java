package net.hypixel.skyblock.network.play.client;

import java.io.IOException;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.IServerPlayNetHandler;

/**
 * @author MrPineapple070
 * @version 15 December 2020
 * @since 11 July 2019
 */
public class CUpgradeMinionPacket implements IPacket<IServerPlayNetHandler> {
	public CUpgradeMinionPacket() {
	}

	@Override
	public void read(PacketBuffer packet) throws IOException {
		HypixelSkyBlockMod.LOGGER.info(packet.toString());
	}

	@Override
	public void write(PacketBuffer packet) throws IOException {
		HypixelSkyBlockMod.LOGGER.info(packet.toString());
	}

	@Override
	public void handle(IServerPlayNetHandler handler) {
		HypixelSkyBlockMod.LOGGER.info(handler.toString());
	}
}