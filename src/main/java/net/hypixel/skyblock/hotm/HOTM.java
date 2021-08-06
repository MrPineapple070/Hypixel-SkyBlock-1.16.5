package net.hypixel.skyblock.hotm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

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
	 * {@link File}
	 */
	@Nonnull
	public final File file;
	
	/**
	 * {@link World}
	 */
	@Nonnull
	public final World world;
	
	public HOTM(PlayerEntity player, World world) throws IOException {
		this.world = Objects.requireNonNull(world, "World cannot be null");
		String name = this.world.toString();
		name = name.substring(12, name.length() - 1);
		this.file = new File("./saves/" + name + "/hotm.txt");
		if (!this.file.exists())
			file.createNewFile();
		LOGGER.debug(this.file.getCanonicalPath());
		this.writer = new FileWriter(this.file);
	}
	
	public void save() {
		
	}
	
	public void load(File file) {
		
	}

	@Override
	public String toString() {
		return "HOTM [writer=" + this.writer.toString() + ", file=" + this.file.toString() + ", world=" + this.world.toString() + "]";
	}
}