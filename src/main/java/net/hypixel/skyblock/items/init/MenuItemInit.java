package net.hypixel.skyblock.items.init;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.items.menu.MenuItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MenuItemInit {
	public static final DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, HypixelSkyBlockMod.MOD_ID);

	public static final RegistryObject<MenuItem> close = items.register("close", MenuItem::new);
}