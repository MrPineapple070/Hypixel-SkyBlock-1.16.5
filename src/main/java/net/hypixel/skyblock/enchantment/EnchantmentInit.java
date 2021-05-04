package net.hypixel.skyblock.enchantment;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Initialize and Register all the {@link Enchantment} for this Mod.<br>
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Enchantments">Click here
 * for a description of the Enchantments</a>
 *
 * @author MrPineapple070
 * @version 17 September 2020
 * @since 11 June 2019
 */
public class EnchantmentInit {
	/**
	 * A {@code DeferredRegister} for {@code Enchantment}
	 */
	public static final DeferredRegister<Enchantment> enchantments = DeferredRegister
			.create(ForgeRegistries.ENCHANTMENTS, HypixelSkyBlockMod.MOD_ID);
	
	// General
	public static final RegistryObject<Enchantment> telekinesis = enchantments.register("telekinesis", Telekinesis::new);
	
	//Weapons
	public static final RegistryObject<ModDamageEnchantment> cubism = enchantments.register("cubism",
			() -> new ModDamageEnchantment(Rarity.COMMON, 3));
	public static final RegistryObject<Enchantment> dragon_hunter = enchantments.register("dragon_hunter",
			() -> new ModDamageEnchantment(Rarity.VERY_RARE, 4));
	public static final RegistryObject<Enchantment> impaling = enchantments.register("impaling", Impaling::new);
	
	// Sword
	public static final RegistryObject<Enchantment> critical = enchantments.register("critical", Critical::new);
	public static final RegistryObject<Enchantment> ender_slayer = enchantments.register("ender_slayer",
			() -> new ModDamageEnchantment(Rarity.UNCOMMON, 5));
	public static final RegistryObject<Enchantment> execute = enchantments.register("execute", Execute::new);
	public static final RegistryObject<Enchantment> experience = enchantments.register("experience", Experience::new);
	public static final RegistryObject<Enchantment> first_strike = enchantments.register("first_strike",
			FirstStrike::new);
	public static final RegistryObject<Enchantment> giant_killer = enchantments.register("giant_killer",
			GiantKiller::new);
	public static final RegistryObject<Enchantment> lethality = enchantments.register("lethality", Lethality::new);
	public static final RegistryObject<Enchantment> life_steal = enchantments.register("life_steal", LifeSteal::new);
	public static final RegistryObject<Enchantment> luck = enchantments.register("luck", Luck::new);
	public static final RegistryObject<Enchantment> prosecute = enchantments.register("prosecute", Prosecute::new);
	public static final RegistryObject<Enchantment> scavenger = enchantments.register("scavenger", Scavenger::new);
	public static final RegistryObject<Enchantment> syphon = enchantments.register("syphon", Syphon::new);
	public static final RegistryObject<Enchantment> thunderbolt = enchantments.register("thunderbolt",
			Thunderbolt::new);
	public static final RegistryObject<Enchantment> thunderlord = enchantments.register("thunderlord",
			Thunderlord::new);
	public static final RegistryObject<Enchantment> titan_killer = enchantments.register("titan_killer",
			TitanKiller::new);
	public static final RegistryObject<Enchantment> triple_strike = enchantments.register("triple_strike",
			TripleStrike::new);
	public static final RegistryObject<Enchantment> vampirism = enchantments.register("vampirism", Vampirism::new);
	public static final RegistryObject<Enchantment> venomous = enchantments.register("venomous", Venomous::new);
	public static final RegistryObject<Enchantment> vicious = enchantments.register("vicious", Vicious::new);

	// Bow
	// public static final RegistryObject<Enchantment> aiming = enchantments.register("aiming", Aiming::new);
	// public static final RegistryObject<Enchantment> chance = enchantments.register("chance", Chance::new);
	// public static final RegistryObject<Enchantment> piercing = enchantments.register("piercing", Piercing::new);
	// public static final RegistryObject<Enchantment> snipe = enchantments.register("snipe", Snipe::new);

	// Tools
	// public static final RegistryObject<Enchantment> experience = enchantments.register("experience" , Experience::new);
	// public static final RegistryObject<Enchantment> harvesting = enchantments.register("harvesting" , Harvesting::new);
	// public static final RegistryObject<Enchantment> rainbow = enchantments.register("rainbow" , Rainbow::new);
	// public static final RegistryObject<Enchantment> replenish = enchantments.register("replenish" , Replenish::new);
	public static final RegistryObject<Enchantment> smelting_touch = enchantments.register("smelting_touch", SmeltingTouch::new);

	// Armor
	// public static final RegistryObject<Enchantment> big_brain = enchantments.register("big_brain", BigBrain::new);
	// public static final RegistryObject<Enchantment> counter_strike = enchantments.register("counter_strike", CounterStrike::new);
	public static final RegistryObject<Enchantment> growth = enchantments.register("growth", Growth::new);
	// public static final RegistryObject<Enchantment> rejuvenate = enchantments.register("rejuvenate", Rejuvenate::new);
	// public static final RegistryObject<Enchantment> true_protection = enchantments.register("true_protection", TrueProtection::new);
	public static final RegistryObject<Enchantment> sugar_rush = enchantments.register("sugar_rush", SugarRush::new);

	// Fishing Rod
	// public static final RegistryObject<Enchantment> angler = enchantments.register("angler" , Angler::new);
	// public static final RegistryObject<Enchantment> blessing = enchantments.register("blessing" , Blessing::new);
	// public static final RegistryObject<Enchantment> caster = enchantments.register("caster" , Caster::new);
	// public static final RegistryObject<Enchantment> frail = enchantments.register("frail" , Frail::new);
	// public static final RegistryObject<Enchantment> magnent = enchantments.register("magnent" , Magnet::new);
	// public static final RegistryObject<Enchantment> spiked_hook = enchantments.register("spiked_hook" , SpikedHook);
	
	//Ultimate Enchantment
	public static final RegistryObject<Enchantment> bank = enchantments.register("bank", Bank::new);
	public static final RegistryObject<Enchantment> chimera = enchantments.register("chimera", Chimera::new);
	public static final RegistryObject<Enchantment> combo = enchantments.register("combo", Combo::new);
	public static final RegistryObject<Enchantment> last_stand = enchantments.register("last_stand", LastStand::new);
	public static final RegistryObject<Enchantment> legion = enchantments.register("legion", Legion::new);
	public static final RegistryObject<Enchantment> npng = enchantments.register("npng", NoPainNoGain::new);
	public static final RegistryObject<Enchantment> ofa = enchantments.register("ofa", OneForAll::new);
	public static final RegistryObject<Enchantment> rend = enchantments.register("rend", Rend::new);
	public static final RegistryObject<Enchantment> soul_eater = enchantments.register("soul_eater", SoulEater::new);
	public static final RegistryObject<Enchantment> swarm = enchantments.register("swarm", Swarm::new);
	public static final RegistryObject<Enchantment> ult_jerry = enchantments.register("ult_jerry", UltJerry::new);
	public static final RegistryObject<Enchantment> ult_wise = enchantments.register("ult_wise", UltWise::new);
	public static final RegistryObject<Enchantment> wisdom = enchantments.register("wisdom", Wisdom::new);
}