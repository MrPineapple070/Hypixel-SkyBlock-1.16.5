package net.hypixel.skyblock.blocks.init;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.blocks.HardGlass;
import net.hypixel.skyblock.blocks.TimeSaver;
import net.hypixel.skyblock.blocks.TimeSaver.TimeSaverType;
import net.hypixel.skyblock.blocks.minion.MinionChestBlock.LargeMCB;
import net.hypixel.skyblock.blocks.minion.MinionChestBlock.MediumMCB;
import net.hypixel.skyblock.blocks.minion.MinionChestBlock.SmallMCB;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Initialize and Register all {@link Block} for this Mod. <br>
 * Some {@code Blocks} are Initialized and Registered in other classes.
 *
 * @author MrPineapple070
 * @version 31 May 2020
 */
public class BlockInit {
	/**
	 * A {@code DeferredRegister} for {@code Block}.
	 */
	public static final DeferredRegister<Block> blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, HypixelSkyBlockMod.MOD_ID);
	public static final RegistryObject<Block> hard_glass	= blocks.register("hard_glass"		, HardGlass::new);
	public static final RegistryObject<Block> haste_block	= blocks.register("haste_block"		, () -> new Block(Properties.copy(Blocks.END_STONE)));
	public static final RegistryObject<Block> silence_block = blocks.register("silence_block"	, () -> new Block(Properties.copy(Blocks.JUKEBOX)));
	public static final RegistryObject<Block> night_saver	= blocks.register("night_saver"		, () -> new TimeSaver(TimeSaverType.Night));
	public static final RegistryObject<Block> day_saver		= blocks.register("day_saver"		, () -> new TimeSaver(TimeSaverType.Day));
	
	public static final RegistryObject<Block> small_mcb		= blocks.register("small_mcb"	, SmallMCB::new);
	public static final RegistryObject<Block> medium_mcb	= blocks.register("medium_mcb"	, MediumMCB::new);
	public static final RegistryObject<Block> large_mcb		= blocks.register("large_mcb"	, LargeMCB::new);
}