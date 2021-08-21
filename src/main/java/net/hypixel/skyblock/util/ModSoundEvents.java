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

	public static final RegistryObject<SoundEvent> goblin_grunt = sounds.register("goblin.grunt",
			() -> new SoundEvent(new ResourceLocation(HypixelSkyBlockMod.MOD_ID, "goblin.grunt")));

}