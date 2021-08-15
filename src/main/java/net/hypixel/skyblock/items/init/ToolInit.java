package net.hypixel.skyblock.items.init;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.tools.ModToolTier;
import net.hypixel.skyblock.items.tools.drill.Drill;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ToolInit {
	public static final DeferredRegister<Item> tools = DeferredRegister.create(ForgeRegistries.ITEMS, HypixelSkyBlockMod.MOD_ID);
	
	public static final RegistryObject<Item> mithril_drill_1	= tools.register("mithril_drill_1"	, () -> new Drill(ModToolTier.Mithril1, ModItemRarity.Rare));
	public static final RegistryObject<Item> mithril_drill_2	= tools.register("mithril_drill_2"	, () -> new Drill(ModToolTier.Mithril2, ModItemRarity.Rare));
	public static final RegistryObject<Item> titanium_drill_1	= tools.register("titanium_drill_1"	, () -> new Drill(ModToolTier.Titanium1, ModItemRarity.Epic));
	public static final RegistryObject<Item> titanium_drill_2	= tools.register("titanium_drill_2"	, () -> new Drill(ModToolTier.Titanium2, ModItemRarity.Epic));
	public static final RegistryObject<Item> titanium_drill_3	= tools.register("titanium_drill_3"	, () -> new Drill(ModToolTier.Titanium3, ModItemRarity.Epic));
	public static final RegistryObject<Item> titanium_drill_4	= tools.register("titanium_drill_4"	, () -> new Drill(ModToolTier.Titanium4, ModItemRarity.Legendary));
	public static final RegistryObject<Item> divian_drill		= tools.register("divan_drill"		, () -> new Drill(ModToolTier.Divan, ModItemRarity.Mythic));
	public static final RegistryObject<Item> ruby_drill			= tools.register("ruby_drill"		, () -> new Drill(ModToolTier.Ruby, ModItemRarity.Rare));
	public static final RegistryObject<Item> gemstone_drill		= tools.register("gemstone_drill"	, () -> new Drill(ModToolTier.Gemstone, ModItemRarity.Rare));
	public static final RegistryObject<Item> topaz_drill		= tools.register("topaz_drill"		, () -> new Drill(ModToolTier.Topaz, ModItemRarity.Epic));
	public static final RegistryObject<Item> jasper_drill		= tools.register("jasper_drill"		, () -> new Drill(ModToolTier.Jasper, ModItemRarity.Epic));
}