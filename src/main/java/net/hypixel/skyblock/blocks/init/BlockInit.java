package net.hypixel.skyblock.blocks.init;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.blocks.TimeSaver.DaySaver;
import net.hypixel.skyblock.blocks.TimeSaver.NightSaver;
import net.hypixel.skyblock.blocks.minion.MinionChestBlock.LargeMCB;
import net.hypixel.skyblock.blocks.minion.MinionChestBlock.MediumMCB;
import net.hypixel.skyblock.blocks.minion.MinionChestBlock.SmallMCB;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
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

	public static final RegistryObject<Block> hard_glass	= blocks.register("hard_glass"		, () -> new Block(Properties.of(Material.GLASS).strength(.3f, 1200f).sound(SoundType.GLASS).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> haste_block	= blocks.register("haste_block"		, () -> new Block(Properties.of(Material.STONE).strength(3f, 9f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> silence_block = blocks.register("silence_block"	, () -> new Block(Properties.of(Material.WOOD).strength(.8f, .8f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));
	public static final RegistryObject<Block> night_saver	= blocks.register("night_saver"		, NightSaver::new);
	public static final RegistryObject<Block> day_saver		= blocks.register("day_saver"		, DaySaver::new);
	
	public static final RegistryObject<Block> small_mcb		= blocks.register("small_mcb"	, SmallMCB::new);
	public static final RegistryObject<Block> medium_mcb	= blocks.register("medium_mcb"	, MediumMCB::new);
	public static final RegistryObject<Block> large_mcb		= blocks.register("large_mcb"	, LargeMCB::new);
}