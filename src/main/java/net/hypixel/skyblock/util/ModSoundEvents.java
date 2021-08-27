package net.hypixel.skyblock.util;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holding {@link SoundEvent} for {@link HypixelSkyBlockMod}
 * 
 * @author MrPineapple070
 * @version 18 August 2021
 * @since 11 July 2019
 */
public class ModSoundEvents {
	public static final DeferredRegister<SoundEvent> sounds = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
			HypixelSkyBlockMod.MOD_ID);
	
	public static final RegistryObject<SoundEvent> goblin_grunt = sounds.register("entity.goblin.grunt",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "entity.goblin.grunt")));

	public static final RegistryObject<SoundEvent> music_barn = sounds.register("music.barn",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.barn")));
	public static final RegistryObject<SoundEvent> music_bonzo = sounds.register("music.bonzo",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.bonzo")));
	public static final RegistryObject<SoundEvent> music_crystal = sounds.register("music.crystal",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.crystal")));
	public static final RegistryObject<SoundEvent> music_dungeon = sounds.register("music.dungeon",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.dungeon")));
	public static final RegistryObject<SoundEvent> music_dwarven = sounds.register("music.dwarven",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.dwarven")));
	public static final RegistryObject<SoundEvent> music_ender_dragon = sounds.register("music.ender_dragon",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.ender_dragon")));
	public static final RegistryObject<SoundEvent> music_gold = sounds.register("music.gold",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.gold")));
	public static final RegistryObject<SoundEvent> music_jerry = sounds.register("music.jerry",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.jerry")));
	public static final RegistryObject<SoundEvent> music_jerry_boss = sounds.register("music.jerry_boss",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.jerry_boss")));
	public static final RegistryObject<SoundEvent> music_necron = sounds.register("music.necron",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.necron")));
	public static final RegistryObject<SoundEvent> music_park = sounds.register("music.park",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.park")));
	public static final RegistryObject<SoundEvent> music_spider = sounds.register("music.spider",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.spider")));
	public static final RegistryObject<SoundEvent> music_spooky = sounds.register("music.spooky",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.spooky")));
	public static final RegistryObject<SoundEvent> music_watcher = sounds.register("music.watcher",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.watcher")));
	public static final RegistryObject<SoundEvent> music_wilderness = sounds.register("music.wilderness",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "music.wilderness")));
}