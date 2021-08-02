package net.hypixel.skyblock.items.init;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.items.tools.ModToolTier;
import net.hypixel.skyblock.items.tools.drill.Drill;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ToolInit {
	public static final DeferredRegister<Item> tools = DeferredRegister.create(ForgeRegistries.ITEMS, HypixelSkyBlockMod.MOD_ID);
	
	public static final RegistryObject<Item> divian_drill = tools.register("divian_drill", () -> new Drill(ModToolTier.Divian));
}