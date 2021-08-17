package net.hypixel.skyblock.hotm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.entity.player.PlayerEntity;

/**
 * Handle Heart of the Mountain Logic.
 * 
 * @author MrPineapple070
 * @version 05 August 2021
 * @since 11 July 2019
 */
public class HOTM {
	/**
	 * {@link Logger}
	 */
	@Nonnull
	protected static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * {@link FileWriter}
	 */
	@Nonnull
	public FileWriter writer;
	
	/**
	 * {@link PlayerEntity}
	 */
	@Nonnull
	public final PlayerEntity player;
	
	/**
	 * {@link File}
	 */
	@Nonnull
	public final File file;
	
	public HOTM(PlayerEntity player) throws IOException {
		this.player = Objects.requireNonNull(player, "Player cannot be null");
		String name = this.player.level.toString();
		name = name.substring(12, name.length() - 1);
		this.file = new File("./saves/" + name + "/" + this.player.getStringUUID() + ".hotm");
		if (!this.file.exists())
			file.createNewFile();
	}
	
	public void save() throws IOException {
		LOGGER.debug("Saving");
		this.writer = new FileWriter(this.file, false);
		this.writer.close();
	}
	
	public void load() {
		LOGGER.debug("Loading");
		if (!this.file.exists())
			return;
		
	}
}