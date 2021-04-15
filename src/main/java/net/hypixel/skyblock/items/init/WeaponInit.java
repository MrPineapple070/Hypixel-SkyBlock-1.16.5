package net.hypixel.skyblock.items.init;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.items.bows.Bonemerang;
import net.hypixel.skyblock.items.bows.DeathBow;
import net.hypixel.skyblock.items.bows.EndStoneBow;
import net.hypixel.skyblock.items.bows.EnderBow;
import net.hypixel.skyblock.items.bows.ExplosiveBow;
import net.hypixel.skyblock.items.bows.HurricaneBow;
import net.hypixel.skyblock.items.bows.LastBreath;
import net.hypixel.skyblock.items.bows.MachineGunBow;
import net.hypixel.skyblock.items.bows.MagmaBow;
import net.hypixel.skyblock.items.bows.MosquitoBow;
import net.hypixel.skyblock.items.bows.PrismarineBow;
import net.hypixel.skyblock.items.bows.RunaanBow;
import net.hypixel.skyblock.items.bows.SavannaBow;
import net.hypixel.skyblock.items.bows.ScorpionBow;
import net.hypixel.skyblock.items.bows.SlimeBow;
import net.hypixel.skyblock.items.bows.SniperBow;
import net.hypixel.skyblock.items.bows.SoulsRebound;
import net.hypixel.skyblock.items.bows.SoulstealerBow;
import net.hypixel.skyblock.items.bows.SpiderQueenStinger;
import net.hypixel.skyblock.items.bows.SpiritBow;
import net.hypixel.skyblock.items.bows.SuperUndeadBow;
import net.hypixel.skyblock.items.bows.UndeadBow;
import net.hypixel.skyblock.items.bows.VenomTouch;
import net.hypixel.skyblock.items.bows.WitherBow;
import net.hypixel.skyblock.items.swords.AspectOfTheDragon;
import net.hypixel.skyblock.items.swords.AspectOfTheEnd;
import net.hypixel.skyblock.items.swords.AspectOfTheJerry;
import net.hypixel.skyblock.items.swords.Cleaver;
import net.hypixel.skyblock.items.swords.EdibleMace;
import net.hypixel.skyblock.items.swords.EmberRod;
import net.hypixel.skyblock.items.swords.EmeraldBlade;
import net.hypixel.skyblock.items.swords.EndStoneSword;
import net.hypixel.skyblock.items.swords.EndSword;
import net.hypixel.skyblock.items.swords.FancySword;
import net.hypixel.skyblock.items.swords.FlamingSword;
import net.hypixel.skyblock.items.swords.FrozenScythe;
import net.hypixel.skyblock.items.swords.GolemSword;
import net.hypixel.skyblock.items.swords.HunterKnife;
import net.hypixel.skyblock.items.swords.InkWand;
import net.hypixel.skyblock.items.swords.LeapingSword;
import net.hypixel.skyblock.items.swords.MidasSword;
import net.hypixel.skyblock.items.swords.OrnateZombieSword;
import net.hypixel.skyblock.items.swords.PigmanSword;
import net.hypixel.skyblock.items.swords.PoochSword;
import net.hypixel.skyblock.items.swords.PrismarineBlade;
import net.hypixel.skyblock.items.swords.RaiderAxe;
import net.hypixel.skyblock.items.swords.ReaperFalchion;
import net.hypixel.skyblock.items.swords.ReaperScythe;
import net.hypixel.skyblock.items.swords.RecluseFang;
import net.hypixel.skyblock.items.swords.RevenantFalchion;
import net.hypixel.skyblock.items.swords.RogueSword;
import net.hypixel.skyblock.items.swords.ScorpionFoil;
import net.hypixel.skyblock.items.swords.ShamanSword;
import net.hypixel.skyblock.items.swords.SilkEdgeSword;
import net.hypixel.skyblock.items.swords.SilverFang;
import net.hypixel.skyblock.items.swords.SpiderSword;
import net.hypixel.skyblock.items.swords.TacticianSword;
import net.hypixel.skyblock.items.swords.ThickAspectOfTheJerry;
import net.hypixel.skyblock.items.swords.ThickScorpionFoil;
import net.hypixel.skyblock.items.swords.ThickTacticianSword;
import net.hypixel.skyblock.items.swords.UndeadSword;
import net.hypixel.skyblock.items.swords.YetiSword;
import net.hypixel.skyblock.items.swords.ZombieSword;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Initialize and Register all {@link SwordItem} for this Mod.<br>
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Swords">List of all
 * Swords</a>.
 *
 * @author MrPineapple070
 * @version 18 Decmeber 2019
 * @since 11 November 2019
 */
public class WeaponInit {
	public static final DeferredRegister<Item> weapon = DeferredRegister.create(ForgeRegistries.ITEMS,
			HypixelSkyBlockMod.MOD_ID);

	public static final RegistryObject<SwordItem> aotd = weapon.register("aspect_of_the_dragons",
			AspectOfTheDragon::new);
	public static final RegistryObject<SwordItem> aote = weapon.register("aspect_of_the_end", AspectOfTheEnd::new);
	public static final RegistryObject<SwordItem> aotj = weapon.register("aspect_of_the_jerry", AspectOfTheJerry::new);
	public static final RegistryObject<SwordItem> cleaver = weapon.register("cleaver", Cleaver::new);
	public static final RegistryObject<SwordItem> edible_mace = weapon.register("edible_mace", EdibleMace::new);
	public static final RegistryObject<SwordItem> ember_rod = weapon.register("ember_rod", EmberRod::new);
	public static final RegistryObject<SwordItem> emerald_blade = weapon.register("emerald_blade", EmeraldBlade::new);
	public static final RegistryObject<SwordItem> end_stone_sword = weapon.register("end_stone_sword",
			EndStoneSword::new);
	public static final RegistryObject<SwordItem> end_sword = weapon.register("end_sword", EndSword::new);
	public static final RegistryObject<SwordItem> fancy_sword = weapon.register("fancy_sword", FancySword::new);
	public static final RegistryObject<SwordItem> flaming_sword = weapon.register("flaming_sword", FlamingSword::new);
	public static final RegistryObject<SwordItem> frozen_scythe = weapon.register("frozen_scythe", FrozenScythe::new);
	public static final RegistryObject<SwordItem> golem_sword = weapon.register("golem_sword", GolemSword::new);
	public static final RegistryObject<SwordItem> hunter_knife = weapon.register("hunter_knife", HunterKnife::new);
	public static final RegistryObject<SwordItem> ink_wand = weapon.register("ink_wand", InkWand::new);
	public static final RegistryObject<SwordItem> leaping_sword = weapon.register("leaping_sword", LeapingSword::new);
	public static final RegistryObject<SwordItem> midas_sword = weapon.register("midas_sword", MidasSword::new);
	public static final RegistryObject<SwordItem> ornate_zombie_sword = weapon.register("ornate_zombie_sword",
			OrnateZombieSword::new);
	public static final RegistryObject<SwordItem> pigman_sword = weapon.register("pigman_sword", PigmanSword::new);
	public static final RegistryObject<SwordItem> pooch_sword = weapon.register("pooch_sword", PoochSword::new);
	public static final RegistryObject<SwordItem> prismarine_blade = weapon.register("prismarine_blade",
			PrismarineBlade::new);
	public static final RegistryObject<SwordItem> raider_axe = weapon.register("raider_axe", RaiderAxe::new);
	public static final RegistryObject<SwordItem> reaper_falchion = weapon.register("reaper_falchion",
			ReaperFalchion::new);
	public static final RegistryObject<SwordItem> reaper_scythe = weapon.register("reaper_scythe", ReaperScythe::new);
	public static final RegistryObject<SwordItem> recluse_fang = weapon.register("recluse_fang", RecluseFang::new);
	public static final RegistryObject<SwordItem> revenant_falchion = weapon.register("revenant_falchion",
			RevenantFalchion::new);
	public static final RegistryObject<SwordItem> rogue_sword = weapon.register("rogue_sword", RogueSword::new);
	public static final RegistryObject<SwordItem> scorpion_foil = weapon.register("scorpion_foil", ScorpionFoil::new);
	public static final RegistryObject<SwordItem> shaman_sword = weapon.register("shaman_sword", ShamanSword::new);
	public static final RegistryObject<SwordItem> silk_edge_sword = weapon.register("silk_edge_sword",
			SilkEdgeSword::new);
	public static final RegistryObject<SwordItem> silver_fang = weapon.register("silver_fang", SilverFang::new);
	public static final RegistryObject<SwordItem> spider_sword = weapon.register("spider_sword", SpiderSword::new);
	public static final RegistryObject<SwordItem> tactician_sword = weapon.register("tactician_sword",
			TacticianSword::new);
	public static final RegistryObject<SwordItem> thick_aotj = weapon.register("thick_aspect_of_the_jerry",
			ThickAspectOfTheJerry::new);
	public static final RegistryObject<SwordItem> thick_scorpion_foil = weapon.register("thick_scorpion_foil",
			ThickScorpionFoil::new);
	public static final RegistryObject<SwordItem> thick_tactician_sword = weapon.register("thick_tactician_sword",
			ThickTacticianSword::new);
	public static final RegistryObject<SwordItem> undead_sword = weapon.register("undead_sword", UndeadSword::new);
	public static final RegistryObject<SwordItem> yeti_sword = weapon.register("yeti_sword", YetiSword::new);
	public static final RegistryObject<SwordItem> zombie_sword = weapon.register("zombie_sword", ZombieSword::new);

	// Bows
	public static final RegistryObject<BowItem> bonemerang = weapon.register("bonemerang", Bonemerang::new);
	public static final RegistryObject<BowItem> death_bow = weapon.register("death_bow", DeathBow::new);
	public static final RegistryObject<BowItem> end_stone_bow = weapon.register("end_stone_bow", EndStoneBow::new);
	public static final RegistryObject<BowItem> ender_bow = weapon.register("ender_bow", EnderBow::new);
	public static final RegistryObject<BowItem> explosive_bow = weapon.register("explosive_bow", ExplosiveBow::new);
	public static final RegistryObject<BowItem> hurricane_bow = weapon.register("hurricane_bow", HurricaneBow::new);
	public static final RegistryObject<BowItem> last_breath = weapon.register("last_breath", LastBreath::new);
	public static final RegistryObject<BowItem> machine_gun_bow = weapon.register("machine_gun_bow",
			MachineGunBow::new);
	public static final RegistryObject<BowItem> magma_bow = weapon.register("magma_bow", MagmaBow::new);
	public static final RegistryObject<BowItem> mosquito_bow = weapon.register("mosquito_bow", MosquitoBow::new);
	public static final RegistryObject<BowItem> prismarine_bow = weapon.register("prismarine_bow", PrismarineBow::new);
	public static final RegistryObject<BowItem> runaan_bow = weapon.register("runaan_bow", RunaanBow::new);
	public static final RegistryObject<BowItem> savanna_bow = weapon.register("savanna_bow", SavannaBow::new);
	public static final RegistryObject<BowItem> scorpion_bow = weapon.register("scorpion_bow", ScorpionBow::new);
	public static final RegistryObject<BowItem> slime_bow = weapon.register("slime_bow", SlimeBow::new);
	public static final RegistryObject<BowItem> sniper_bow = weapon.register("sniper_bow", SniperBow::new);
	public static final RegistryObject<BowItem> souls_rebound = weapon.register("souls_rebound", SoulsRebound::new);
	public static final RegistryObject<BowItem> soulstealer_bow = weapon.register("soulstealer_bow",
			SoulstealerBow::new);
	public static final RegistryObject<BowItem> spider_queen_stinger = weapon.register("spider_queen_stinger",
			SpiderQueenStinger::new);
	public static final RegistryObject<BowItem> spirit_bow = weapon.register("spirit_bow", SpiritBow::new);
	public static final RegistryObject<BowItem> super_undead_bow = weapon.register("super_undead_bow",
			SuperUndeadBow::new);
	public static final RegistryObject<BowItem> undead_bow = weapon.register("undead_bow", UndeadBow::new);
	public static final RegistryObject<BowItem> venom_touch = weapon.register("venom_touch", VenomTouch::new);
	public static final RegistryObject<BowItem> wither_bow = weapon.register("wither_bow", WitherBow::new);
}