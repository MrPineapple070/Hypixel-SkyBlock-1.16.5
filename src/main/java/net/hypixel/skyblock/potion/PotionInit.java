package net.hypixel.skyblock.potion;

import java.util.Objects;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.items.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Initialize and Register all {@link Potion} for this Mod.<br>
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Potions">Click here</a> for
 * a list of all potions.<br>
 * All Potions are named "effect_amplifierduration".<br>
 * Example: {@link #adrenaline_00} is named for {@link #adrenaline_effect} of
 * amplifier 0 lasting for {@link #duration_0}
 * This name does not apply to {@link Effects#HARM} and {@link Effects#HEAL}.
 * These are named "effect_amplifier"
 *
 * @author MrPineapple070
 * @version 11 June 2019
 * @since 02 June 2020
 */
public class PotionInit {
	@Nonnull
	protected static final Logger LOGGER = LogManager.getLogger();

	/**
	 * The default duration for {@link Potion}.<br>
	 * 210 seconds.
	 */
	private static final int duration_0 = 0x1068;

	/**
	 * The primary extended duration for {@link Potion}.<br>
	 * 480 seconds.
	 */
	private static final int duration_1 = 0x2580;

	/**
	 * The secondary extended duration for {@link Potion}.<br>
	 * 960 seconds.
	 */
	private static final int duration_2 = 0x4B00;

	/**
	 * The tertiary extended duration for the {@link Potion}.<br>
	 * 2400 seconds.
	 */
	private static final int duration_3 = 0xBB80;

	@Nonnull
	private static final ItemStack potion = new ItemStack(Items.POTION);

	public static final Potion heal_2 = new Potion(new EffectInstance(Effects.HEAL, 2));
	public static final Potion heal_3 = new Potion(new EffectInstance(Effects.HEAL, 3));
	public static final Potion heal_4 = new Potion(new EffectInstance(Effects.HEAL, 4));
	public static final Potion heal_5 = new Potion(new EffectInstance(Effects.HEAL, 5));
	public static final Potion heal_6 = new Potion(new EffectInstance(Effects.HEAL, 6));
	public static final Potion heal_7 = new Potion(new EffectInstance(Effects.HEAL, 7));

	public static final Potion harm_2 = new Potion(new EffectInstance(Effects.HEAL, 2));
	public static final Potion harm_3 = new Potion(new EffectInstance(Effects.HEAL, 3));
	public static final Potion harm_4 = new Potion(new EffectInstance(Effects.HEAL, 4));
	public static final Potion harm_5 = new Potion(new EffectInstance(Effects.HEAL, 5));
	public static final Potion harm_6 = new Potion(new EffectInstance(Effects.HEAL, 6));
	public static final Potion harm_7 = new Potion(new EffectInstance(Effects.HEAL, 7));

	public static final Potion jump_02 = new Potion(new EffectInstance(Effects.JUMP, duration_0, 2));
	public static final Potion jump_03 = new Potion(new EffectInstance(Effects.JUMP, duration_0, 3));
	public static final Potion jump_12 = new Potion(new EffectInstance(Effects.JUMP, duration_1, 2));
	public static final Potion jump_13 = new Potion(new EffectInstance(Effects.JUMP, duration_1, 3));
	public static final Potion jump_22 = new Potion(new EffectInstance(Effects.JUMP, duration_2, 2));
	public static final Potion jump_23 = new Potion(new EffectInstance(Effects.JUMP, duration_2, 4));
	public static final Potion jump_32 = new Potion(new EffectInstance(Effects.JUMP, duration_3, 2));
	public static final Potion jump_33 = new Potion(new EffectInstance(Effects.JUMP, duration_3, 4));

	public static final DeferredRegister<Effect> effects = DeferredRegister.create(ForgeRegistries.POTIONS,			HypixelSkyBlockMod.MOD_ID);
	public static final DeferredRegister<Potion> potions = DeferredRegister.create(ForgeRegistries.POTION_TYPES,	HypixelSkyBlockMod.MOD_ID);

	public static final RegistryObject<Effect> agility_effect		= effects.register("agility",		 () -> new ModEffect(EffectType.BENEFICIAL, 0x208020));
	public static final RegistryObject<Effect> adrenaline_effect	= effects.register("adrenaline",	 () -> new ModEffect(EffectType.BENEFICIAL, 0xFF5555));
	public static final RegistryObject<Effect> archery_effect		= effects.register("archery",		 () -> new ModEffect(EffectType.BENEFICIAL, 0x55FFFF));
	public static final RegistryObject<Effect> burning_effect		= effects.register("burning",		 () -> new ModEffect(EffectType.HARMFUL	 , 0xFF8000));
	public static final RegistryObject<Effect> critical_effect		= effects.register("critical",		 () -> new ModEffect(EffectType.BENEFICIAL, 0x800000));
	public static final RegistryObject<Effect> dodge_effect			= effects.register("dodge",			 () -> new ModEffect(EffectType.BENEFICIAL, 0x5555FF));
	public static final RegistryObject<Effect> experience_effect	= effects.register("experience",	 () -> new ModEffect(EffectType.BENEFICIAL, 0x0000FF));
	public static final RegistryObject<Effect> fly_effect			= effects.register("fly",			 () -> new ModEffect(EffectType.BENEFICIAL, 0xffffff));
	public static final RegistryObject<Effect> knockback_effect		= effects.register("knockback",		 () -> new ModEffect(EffectType.NEUTRAL	 , 0xFF5555));
	public static final RegistryObject<Effect> pet_luck_effect		= effects.register("pet_luck",		 () -> new ModEffect(EffectType.BENEFICIAL, 0x177217));
	public static final RegistryObject<Effect> mana_effect			= effects.register("mana",			 () -> new ModEffect(EffectType.BENEFICIAL, 0x000080));
	public static final RegistryObject<Effect> rabbit_effect		= effects.register("rabbit",		 () -> new ModEffect(EffectType.BENEFICIAL, 0x008000));
	public static final RegistryObject<Effect> stun_effect			= effects.register("stun",			 () -> new ModEffect(EffectType.HARMFUL	 , 0x800000));
	public static final RegistryObject<Effect> stamina_effect		= effects.register("stamina",		 () -> new ModEffect(EffectType.BENEFICIAL, 0x004000));
	public static final RegistryObject<Effect> tr_effect			= effects.register("true_resistance", () -> new ModEffect(EffectType.BENEFICIAL, 0x088008));
	public static final RegistryObject<Effect> venomous_effect		= effects.register("venomous",		 () -> new ModEffect(EffectType.HARMFUL	 , 0x2E9D22));
	public static final RegistryObject<Effect> wounded_effect		= effects.register("wounded",		 () -> new ModEffect(EffectType.HARMFUL	 , 0x701717));

	public static final RegistryObject<Potion> absorption_00 = potions.register("absorption_00", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_0, 0)));
	public static final RegistryObject<Potion> absorption_01 = potions.register("absorption_01", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_1, 0)));
	public static final RegistryObject<Potion> absorption_02 = potions.register("absorption_02", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_2, 0)));
	public static final RegistryObject<Potion> absorption_03 = potions.register("absorption_03", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_3, 0)));
	public static final RegistryObject<Potion> absorption_10 = potions.register("absorption_10", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_0, 1)));
	public static final RegistryObject<Potion> absorption_11 = potions.register("absorption_11", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_1, 1)));
	public static final RegistryObject<Potion> absorption_12 = potions.register("absorption_12", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_2, 1)));
	public static final RegistryObject<Potion> absorption_13 = potions.register("absorption_13", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_3, 1)));
	public static final RegistryObject<Potion> absorption_20 = potions.register("absorption_20", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_0, 2)));
	public static final RegistryObject<Potion> absorption_21 = potions.register("absorption_21", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_1, 2)));
	public static final RegistryObject<Potion> absorption_22 = potions.register("absorption_22", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_2, 2)));
	public static final RegistryObject<Potion> absorption_23 = potions.register("absorption_23", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_3, 2)));
	public static final RegistryObject<Potion> absorption_30 = potions.register("absorption_30", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_0, 3)));
	public static final RegistryObject<Potion> absorption_31 = potions.register("absorption_31", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_1, 3)));
	public static final RegistryObject<Potion> absorption_32 = potions.register("absorption_32", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_2, 3)));
	public static final RegistryObject<Potion> absorption_33 = potions.register("absorption_33", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_3, 3)));
	public static final RegistryObject<Potion> absorption_40 = potions.register("absorption_40", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_0, 4)));
	public static final RegistryObject<Potion> absorption_41 = potions.register("absorption_41", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_1, 4)));
	public static final RegistryObject<Potion> absorption_42 = potions.register("absorption_42", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_2, 4)));
	public static final RegistryObject<Potion> absorption_43 = potions.register("absorption_43", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_3, 4)));
	public static final RegistryObject<Potion> absorption_50 = potions.register("absorption_50", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_0, 5)));
	public static final RegistryObject<Potion> absorption_51 = potions.register("absorption_51", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_1, 5)));
	public static final RegistryObject<Potion> absorption_52 = potions.register("absorption_52", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_2, 5)));
	public static final RegistryObject<Potion> absorption_53 = potions.register("absorption_53", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_3, 5)));
	public static final RegistryObject<Potion> absorption_60 = potions.register("absorption_60", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_0, 6)));
	public static final RegistryObject<Potion> absorption_61 = potions.register("absorption_61", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_1, 6)));
	public static final RegistryObject<Potion> absorption_62 = potions.register("absorption_62", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_2, 6)));
	public static final RegistryObject<Potion> absorption_63 = potions.register("absorption_63", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_3, 6)));
	public static final RegistryObject<Potion> absorption_70 = potions.register("absorption_70", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_0, 7)));
	public static final RegistryObject<Potion> absorption_71 = potions.register("absorption_71", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_1, 7)));
	public static final RegistryObject<Potion> absorption_72 = potions.register("absorption_72", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_2, 7)));
	public static final RegistryObject<Potion> absorption_73 = potions.register("absorption_73", () -> new Potion(new EffectInstance(Effects.ABSORPTION, duration_3, 7)));

	public static final RegistryObject<Potion> adrenaline_00 = potions.register("adrenaline_00", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> adrenaline_01 = potions.register("adrenaline_01", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> adrenaline_02 = potions.register("adrenaline_02", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> adrenaline_03 = potions.register("adrenaline_03", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> adrenaline_10 = potions.register("adrenaline_10", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> adrenaline_11 = potions.register("adrenaline_11", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> adrenaline_12 = potions.register("adrenaline_12", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> adrenaline_13 = potions.register("adrenaline_13", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> adrenaline_20 = potions.register("adrenaline_20", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> adrenaline_21 = potions.register("adrenaline_21", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> adrenaline_22 = potions.register("adrenaline_22", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> adrenaline_23 = potions.register("adrenaline_23", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> adrenaline_30 = potions.register("adrenaline_30", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> adrenaline_31 = potions.register("adrenaline_31", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> adrenaline_32 = potions.register("adrenaline_32", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> adrenaline_33 = potions.register("adrenaline_33", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_3, 3)));
	public static final RegistryObject<Potion> adrenaline_40 = potions.register("adrenaline_40", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_0, 4)));
	public static final RegistryObject<Potion> adrenaline_41 = potions.register("adrenaline_41", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_1, 4)));
	public static final RegistryObject<Potion> adrenaline_42 = potions.register("adrenaline_42", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_2, 4)));
	public static final RegistryObject<Potion> adrenaline_43 = potions.register("adrenaline_43", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_3, 4)));
	public static final RegistryObject<Potion> adrenaline_50 = potions.register("adrenaline_50", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_0, 5)));
	public static final RegistryObject<Potion> adrenaline_51 = potions.register("adrenaline_51", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_1, 5)));
	public static final RegistryObject<Potion> adrenaline_52 = potions.register("adrenaline_52", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_2, 5)));
	public static final RegistryObject<Potion> adrenaline_53 = potions.register("adrenaline_53", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_3, 5)));
	public static final RegistryObject<Potion> adrenaline_60 = potions.register("adrenaline_60", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_0, 6)));
	public static final RegistryObject<Potion> adrenaline_61 = potions.register("adrenaline_61", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_1, 6)));
	public static final RegistryObject<Potion> adrenaline_62 = potions.register("adrenaline_62", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_2, 6)));
	public static final RegistryObject<Potion> adrenaline_63 = potions.register("adrenaline_63", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_3, 6)));
	public static final RegistryObject<Potion> adrenaline_70 = potions.register("adrenaline_70", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_0, 7)));
	public static final RegistryObject<Potion> adrenaline_71 = potions.register("adrenaline_71", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_1, 7)));
	public static final RegistryObject<Potion> adrenaline_72 = potions.register("adrenaline_72", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_2, 7)));
	public static final RegistryObject<Potion> adrenaline_73 = potions.register("adrenaline_73", () -> new Potion(new EffectInstance(adrenaline_effect.get(), duration_3, 7)));

	public static final RegistryObject<Potion> agility_00 = potions.register("agility_00", () -> new Potion(new EffectInstance(agility_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> agility_01 = potions.register("agility_01", () -> new Potion(new EffectInstance(agility_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> agility_02 = potions.register("agility_02", () -> new Potion(new EffectInstance(agility_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> agility_03 = potions.register("agility_03", () -> new Potion(new EffectInstance(agility_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> agility_10 = potions.register("agility_10", () -> new Potion(new EffectInstance(agility_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> agility_11 = potions.register("agility_11", () -> new Potion(new EffectInstance(agility_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> agility_12 = potions.register("agility_12", () -> new Potion(new EffectInstance(agility_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> agility_13 = potions.register("agility_13", () -> new Potion(new EffectInstance(agility_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> agility_20 = potions.register("agility_20", () -> new Potion(new EffectInstance(agility_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> agility_21 = potions.register("agility_21", () -> new Potion(new EffectInstance(agility_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> agility_22 = potions.register("agility_22", () -> new Potion(new EffectInstance(agility_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> agility_23 = potions.register("agility_23", () -> new Potion(new EffectInstance(agility_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> agility_30 = potions.register("agility_30", () -> new Potion(new EffectInstance(agility_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> agility_31 = potions.register("agility_31", () -> new Potion(new EffectInstance(agility_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> agility_32 = potions.register("agility_32", () -> new Potion(new EffectInstance(agility_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> agility_33 = potions.register("agility_33", () -> new Potion(new EffectInstance(agility_effect.get(), duration_3, 3)));

	public static final RegistryObject<Potion> archery_00 = potions.register("archery_00", () -> new Potion(new EffectInstance(archery_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> archery_01 = potions.register("archery_01", () -> new Potion(new EffectInstance(archery_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> archery_02 = potions.register("archery_02", () -> new Potion(new EffectInstance(archery_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> archery_03 = potions.register("archery_03", () -> new Potion(new EffectInstance(archery_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> archery_10 = potions.register("archery_10", () -> new Potion(new EffectInstance(archery_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> archery_11 = potions.register("archery_11", () -> new Potion(new EffectInstance(archery_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> archery_12 = potions.register("archery_12", () -> new Potion(new EffectInstance(archery_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> archery_13 = potions.register("archery_13", () -> new Potion(new EffectInstance(archery_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> archery_20 = potions.register("archery_20", () -> new Potion(new EffectInstance(archery_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> archery_21 = potions.register("archery_21", () -> new Potion(new EffectInstance(archery_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> archery_22 = potions.register("archery_22", () -> new Potion(new EffectInstance(archery_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> archery_23 = potions.register("archery_23", () -> new Potion(new EffectInstance(archery_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> archery_30 = potions.register("archery_30", () -> new Potion(new EffectInstance(archery_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> archery_31 = potions.register("archery_31", () -> new Potion(new EffectInstance(archery_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> archery_32 = potions.register("archery_32", () -> new Potion(new EffectInstance(archery_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> archery_33 = potions.register("archery_33", () -> new Potion(new EffectInstance(archery_effect.get(), duration_3, 3)));

	public static final RegistryObject<Potion> blindness_00 = potions.register("blindness_00", () -> new Potion(new EffectInstance(Effects.BLINDNESS, duration_0, 0)));
	public static final RegistryObject<Potion> blindness_01 = potions.register("blindness_01", () -> new Potion(new EffectInstance(Effects.BLINDNESS, duration_1, 0)));
	public static final RegistryObject<Potion> blindness_02 = potions.register("blindness_02", () -> new Potion(new EffectInstance(Effects.BLINDNESS, duration_2, 0)));
	public static final RegistryObject<Potion> blindness_03 = potions.register("blindness_03", () -> new Potion(new EffectInstance(Effects.BLINDNESS, duration_3, 0)));
	public static final RegistryObject<Potion> blindness_10 = potions.register("blindness_10", () -> new Potion(new EffectInstance(Effects.BLINDNESS, duration_0, 1)));
	public static final RegistryObject<Potion> blindness_11 = potions.register("blindness_11", () -> new Potion(new EffectInstance(Effects.BLINDNESS, duration_1, 1)));
	public static final RegistryObject<Potion> blindness_12 = potions.register("blindness_12", () -> new Potion(new EffectInstance(Effects.BLINDNESS, duration_2, 1)));
	public static final RegistryObject<Potion> blindness_13 = potions.register("blindness_13", () -> new Potion(new EffectInstance(Effects.BLINDNESS, duration_3, 1)));
	public static final RegistryObject<Potion> blindness_20 = potions.register("blindness_20", () -> new Potion(new EffectInstance(Effects.BLINDNESS, duration_0, 2)));
	public static final RegistryObject<Potion> blindness_21 = potions.register("blindness_21", () -> new Potion(new EffectInstance(Effects.BLINDNESS, duration_1, 2)));
	public static final RegistryObject<Potion> blindness_22 = potions.register("blindness_22", () -> new Potion(new EffectInstance(Effects.BLINDNESS, duration_2, 2)));
	public static final RegistryObject<Potion> blindness_23 = potions.register("blindness_23", () -> new Potion(new EffectInstance(Effects.BLINDNESS, duration_3, 2)));

	public static final RegistryObject<Potion> burning_00 = potions.register("burning_00", () -> new Potion(new EffectInstance(burning_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> burning_01 = potions.register("burning_01", () -> new Potion(new EffectInstance(burning_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> burning_02 = potions.register("burning_02", () -> new Potion(new EffectInstance(burning_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> burning_03 = potions.register("burning_03", () -> new Potion(new EffectInstance(burning_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> burning_10 = potions.register("burning_10", () -> new Potion(new EffectInstance(burning_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> burning_11 = potions.register("burning_11", () -> new Potion(new EffectInstance(burning_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> burning_12 = potions.register("burning_12", () -> new Potion(new EffectInstance(burning_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> burning_13 = potions.register("burning_13", () -> new Potion(new EffectInstance(burning_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> burning_20 = potions.register("burning_20", () -> new Potion(new EffectInstance(burning_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> burning_21 = potions.register("burning_21", () -> new Potion(new EffectInstance(burning_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> burning_22 = potions.register("burning_22", () -> new Potion(new EffectInstance(burning_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> burning_23 = potions.register("burning_23", () -> new Potion(new EffectInstance(burning_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> burning_30 = potions.register("burning_30", () -> new Potion(new EffectInstance(burning_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> burning_31 = potions.register("burning_31", () -> new Potion(new EffectInstance(burning_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> burning_32 = potions.register("burning_32", () -> new Potion(new EffectInstance(burning_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> burning_33 = potions.register("burning_33", () -> new Potion(new EffectInstance(burning_effect.get(), duration_3, 3)));

	public static final RegistryObject<Potion> critical_00 = potions.register("critical_00", () -> new Potion(new EffectInstance(critical_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> critical_01 = potions.register("critical_01", () -> new Potion(new EffectInstance(critical_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> critical_02 = potions.register("critical_02", () -> new Potion(new EffectInstance(critical_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> critical_03 = potions.register("critical_03", () -> new Potion(new EffectInstance(critical_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> critical_10 = potions.register("critical_10", () -> new Potion(new EffectInstance(critical_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> critical_11 = potions.register("critical_11", () -> new Potion(new EffectInstance(critical_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> critical_12 = potions.register("critical_12", () -> new Potion(new EffectInstance(critical_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> critical_13 = potions.register("critical_13", () -> new Potion(new EffectInstance(critical_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> critical_20 = potions.register("critical_20", () -> new Potion(new EffectInstance(critical_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> critical_21 = potions.register("critical_21", () -> new Potion(new EffectInstance(critical_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> critical_22 = potions.register("critical_22", () -> new Potion(new EffectInstance(critical_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> critical_23 = potions.register("critical_23", () -> new Potion(new EffectInstance(critical_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> critical_30 = potions.register("critical_30", () -> new Potion(new EffectInstance(critical_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> critical_31 = potions.register("critical_31", () -> new Potion(new EffectInstance(critical_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> critical_32 = potions.register("critical_32", () -> new Potion(new EffectInstance(critical_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> critical_33 = potions.register("critical_33", () -> new Potion(new EffectInstance(critical_effect.get(), duration_3, 3)));

	public static final RegistryObject<Potion> dodge_00 = potions.register("dodge_00", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> dodge_01 = potions.register("dodge_01", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> dodge_02 = potions.register("dodge_02", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> dodge_03 = potions.register("dodge_03", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> dodge_10 = potions.register("dodge_10", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> dodge_11 = potions.register("dodge_11", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> dodge_12 = potions.register("dodge_12", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> dodge_13 = potions.register("dodge_13", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> dodge_20 = potions.register("dodge_20", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> dodge_21 = potions.register("dodge_21", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> dodge_22 = potions.register("dodge_22", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> dodge_23 = potions.register("dodge_23", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> dodge_30 = potions.register("dodge_30", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> dodge_31 = potions.register("dodge_31", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> dodge_32 = potions.register("dodge_32", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> dodge_33 = potions.register("dodge_33", () -> new Potion(new EffectInstance(dodge_effect.get(), duration_3, 3)));

	public static final RegistryObject<Potion> experience_00 = potions.register("experience_00", () -> new Potion(new EffectInstance(experience_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> experience_01 = potions.register("experience_01", () -> new Potion(new EffectInstance(experience_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> experience_02 = potions.register("experience_02", () -> new Potion(new EffectInstance(experience_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> experience_03 = potions.register("experience_03", () -> new Potion(new EffectInstance(experience_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> experience_10 = potions.register("experience_10", () -> new Potion(new EffectInstance(experience_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> experience_11 = potions.register("experience_11", () -> new Potion(new EffectInstance(experience_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> experience_12 = potions.register("experience_12", () -> new Potion(new EffectInstance(experience_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> experience_13 = potions.register("experience_13", () -> new Potion(new EffectInstance(experience_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> experience_20 = potions.register("experience_20", () -> new Potion(new EffectInstance(experience_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> experience_21 = potions.register("experience_21", () -> new Potion(new EffectInstance(experience_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> experience_22 = potions.register("experience_22", () -> new Potion(new EffectInstance(experience_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> experience_23 = potions.register("experience_23", () -> new Potion(new EffectInstance(experience_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> experience_30 = potions.register("experience_30", () -> new Potion(new EffectInstance(experience_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> experience_31 = potions.register("experience_31", () -> new Potion(new EffectInstance(experience_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> experience_32 = potions.register("experience_32", () -> new Potion(new EffectInstance(experience_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> experience_33 = potions.register("experience_33", () -> new Potion(new EffectInstance(experience_effect.get(), duration_3, 3)));

	public static final RegistryObject<Potion> fly_00 = potions.register("fly_00", () -> new Potion(new EffectInstance(fly_effect.get(), duration_0, 0)));

	public static final RegistryObject<Potion> haste_00 = potions.register("haste_00", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_0, 0)));
	public static final RegistryObject<Potion> haste_01 = potions.register("haste_01", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_0, 1)));
	public static final RegistryObject<Potion> haste_02 = potions.register("haste_02", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_0, 2)));
	public static final RegistryObject<Potion> haste_03 = potions.register("haste_03", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_0, 3)));
	public static final RegistryObject<Potion> haste_10 = potions.register("haste_10", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_1, 0)));
	public static final RegistryObject<Potion> haste_11 = potions.register("haste_11", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_1, 1)));
	public static final RegistryObject<Potion> haste_12 = potions.register("haste_12", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_1, 2)));
	public static final RegistryObject<Potion> haste_13 = potions.register("haste_13", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_1, 3)));
	public static final RegistryObject<Potion> haste_20 = potions.register("haste_20", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_2, 0)));
	public static final RegistryObject<Potion> haste_21 = potions.register("haste_21", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_2, 1)));
	public static final RegistryObject<Potion> haste_22 = potions.register("haste_22", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_2, 2)));
	public static final RegistryObject<Potion> haste_23 = potions.register("haste_23", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_2, 3)));
	public static final RegistryObject<Potion> haste_30 = potions.register("haste_30", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_3, 0)));
	public static final RegistryObject<Potion> haste_31 = potions.register("haste_31", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_3, 1)));
	public static final RegistryObject<Potion> haste_32 = potions.register("haste_32", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_3, 2)));
	public static final RegistryObject<Potion> haste_33 = potions.register("haste_33", () -> new Potion(new EffectInstance(Effects.DIG_SPEED, duration_3, 3)));

	public static final RegistryObject<Potion> knockback_00 = potions.register("knockback_00", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> knockback_01 = potions.register("knockback_01", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> knockback_02 = potions.register("knockback_02", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> knockback_03 = potions.register("knockback_03", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> knockback_10 = potions.register("knockback_10", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> knockback_11 = potions.register("knockback_11", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> knockback_12 = potions.register("knockback_12", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> knockback_13 = potions.register("knockback_13", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> knockback_20 = potions.register("knockback_20", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> knockback_21 = potions.register("knockback_21", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> knockback_22 = potions.register("knockback_22", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> knockback_23 = potions.register("knockback_23", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> knockback_30 = potions.register("knockback_30", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> knockback_31 = potions.register("knockback_31", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> knockback_32 = potions.register("knockback_32", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> knockback_33 = potions.register("knockback_33", () -> new Potion(new EffectInstance(knockback_effect.get(), duration_3, 3)));

	public static final RegistryObject<Potion> mana_00 = potions.register("mana_00", () -> new Potion(new EffectInstance(mana_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> mana_01 = potions.register("mana_01", () -> new Potion(new EffectInstance(mana_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> mana_02 = potions.register("mana_02", () -> new Potion(new EffectInstance(mana_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> mana_03 = potions.register("mana_03", () -> new Potion(new EffectInstance(mana_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> mana_10 = potions.register("mana_10", () -> new Potion(new EffectInstance(mana_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> mana_11 = potions.register("mana_11", () -> new Potion(new EffectInstance(mana_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> mana_12 = potions.register("mana_12", () -> new Potion(new EffectInstance(mana_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> mana_13 = potions.register("mana_13", () -> new Potion(new EffectInstance(mana_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> mana_20 = potions.register("mana_20", () -> new Potion(new EffectInstance(mana_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> mana_21 = potions.register("mana_21", () -> new Potion(new EffectInstance(mana_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> mana_22 = potions.register("mana_22", () -> new Potion(new EffectInstance(mana_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> mana_23 = potions.register("mana_23", () -> new Potion(new EffectInstance(mana_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> mana_30 = potions.register("mana_30", () -> new Potion(new EffectInstance(mana_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> mana_31 = potions.register("mana_31", () -> new Potion(new EffectInstance(mana_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> mana_32 = potions.register("mana_32", () -> new Potion(new EffectInstance(mana_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> mana_33 = potions.register("mana_33", () -> new Potion(new EffectInstance(mana_effect.get(), duration_3, 3)));
	public static final RegistryObject<Potion> mana_40 = potions.register("mana_40", () -> new Potion(new EffectInstance(mana_effect.get(), duration_0, 4)));
	public static final RegistryObject<Potion> mana_41 = potions.register("mana_41", () -> new Potion(new EffectInstance(mana_effect.get(), duration_1, 4)));
	public static final RegistryObject<Potion> mana_42 = potions.register("mana_42", () -> new Potion(new EffectInstance(mana_effect.get(), duration_2, 4)));
	public static final RegistryObject<Potion> mana_43 = potions.register("mana_43", () -> new Potion(new EffectInstance(mana_effect.get(), duration_3, 4)));
	public static final RegistryObject<Potion> mana_50 = potions.register("mana_50", () -> new Potion(new EffectInstance(mana_effect.get(), duration_0, 5)));
	public static final RegistryObject<Potion> mana_51 = potions.register("mana_51", () -> new Potion(new EffectInstance(mana_effect.get(), duration_1, 5)));
	public static final RegistryObject<Potion> mana_52 = potions.register("mana_52", () -> new Potion(new EffectInstance(mana_effect.get(), duration_2, 5)));
	public static final RegistryObject<Potion> mana_53 = potions.register("mana_53", () -> new Potion(new EffectInstance(mana_effect.get(), duration_3, 5)));
	public static final RegistryObject<Potion> mana_60 = potions.register("mana_60", () -> new Potion(new EffectInstance(mana_effect.get(), duration_0, 6)));
	public static final RegistryObject<Potion> mana_61 = potions.register("mana_61", () -> new Potion(new EffectInstance(mana_effect.get(), duration_1, 6)));
	public static final RegistryObject<Potion> mana_62 = potions.register("mana_62", () -> new Potion(new EffectInstance(mana_effect.get(), duration_2, 6)));
	public static final RegistryObject<Potion> mana_63 = potions.register("mana_63", () -> new Potion(new EffectInstance(mana_effect.get(), duration_3, 6)));
	public static final RegistryObject<Potion> mana_70 = potions.register("mana_70", () -> new Potion(new EffectInstance(mana_effect.get(), duration_0, 7)));
	public static final RegistryObject<Potion> mana_71 = potions.register("mana_71", () -> new Potion(new EffectInstance(mana_effect.get(), duration_1, 7)));
	public static final RegistryObject<Potion> mana_72 = potions.register("mana_72", () -> new Potion(new EffectInstance(mana_effect.get(), duration_2, 7)));
	public static final RegistryObject<Potion> mana_73 = potions.register("mana_73", () -> new Potion(new EffectInstance(mana_effect.get(), duration_3, 7)));

	//public static final RegistryObject<Potion> pet_luck_00 = potions.register("pet_luck_00", () -> new Potion(new EffectInstance(pet_luck_effect.get(), duration_0, 0)));

	public static final RegistryObject<Potion> rabbit_00 = potions.register("rabbit_00", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> rabbit_01 = potions.register("rabbit_01", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> rabbit_02 = potions.register("rabbit_02", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> rabbit_03 = potions.register("rabbit_03", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> rabbit_10 = potions.register("rabbit_10", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> rabbit_11 = potions.register("rabbit_11", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> rabbit_12 = potions.register("rabbit_12", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> rabbit_13 = potions.register("rabbit_13", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> rabbit_20 = potions.register("rabbit_20", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> rabbit_21 = potions.register("rabbit_21", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> rabbit_22 = potions.register("rabbit_22", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> rabbit_23 = potions.register("rabbit_23", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> rabbit_30 = potions.register("rabbit_30", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> rabbit_31 = potions.register("rabbit_31", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> rabbit_32 = potions.register("rabbit_32", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> rabbit_33 = potions.register("rabbit_33", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_3, 3)));
	public static final RegistryObject<Potion> rabbit_40 = potions.register("rabbit_40", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_0, 4)));
	public static final RegistryObject<Potion> rabbit_41 = potions.register("rabbit_41", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_1, 4)));
	public static final RegistryObject<Potion> rabbit_42 = potions.register("rabbit_42", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_2, 4)));
	public static final RegistryObject<Potion> rabbit_43 = potions.register("rabbit_43", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_3, 4)));
	public static final RegistryObject<Potion> rabbit_50 = potions.register("rabbit_50", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_0, 5)));
	public static final RegistryObject<Potion> rabbit_51 = potions.register("rabbit_51", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_1, 5)));
	public static final RegistryObject<Potion> rabbit_52 = potions.register("rabbit_52", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_2, 5)));
	public static final RegistryObject<Potion> rabbit_53 = potions.register("rabbit_53", () -> new Potion(new EffectInstance(rabbit_effect.get(), duration_3, 5)));

	public static final RegistryObject<Potion> resistance_00 = potions.register("resistance_00", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_0, 0)));
	public static final RegistryObject<Potion> resistance_01 = potions.register("resistance_01", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_1, 0)));
	public static final RegistryObject<Potion> resistance_02 = potions.register("resistance_02", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_2, 0)));
	public static final RegistryObject<Potion> resistance_03 = potions.register("resistance_03", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_3, 0)));
	public static final RegistryObject<Potion> resistance_10 = potions.register("resistance_10", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_0, 1)));
	public static final RegistryObject<Potion> resistance_11 = potions.register("resistance_11", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_1, 1)));
	public static final RegistryObject<Potion> resistance_12 = potions.register("resistance_12", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_2, 1)));
	public static final RegistryObject<Potion> resistance_13 = potions.register("resistance_13", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_3, 1)));
	public static final RegistryObject<Potion> resistance_20 = potions.register("resistance_20", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_0, 2)));
	public static final RegistryObject<Potion> resistance_21 = potions.register("resistance_21", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_1, 2)));
	public static final RegistryObject<Potion> resistance_22 = potions.register("resistance_22", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_2, 2)));
	public static final RegistryObject<Potion> resistance_23 = potions.register("resistance_23", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_3, 2)));
	public static final RegistryObject<Potion> resistance_30 = potions.register("resistance_30", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_0, 3)));
	public static final RegistryObject<Potion> resistance_31 = potions.register("resistance_31", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_1, 3)));
	public static final RegistryObject<Potion> resistance_32 = potions.register("resistance_32", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_2, 3)));
	public static final RegistryObject<Potion> resistance_33 = potions.register("resistance_33", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_3, 3)));
	public static final RegistryObject<Potion> resistance_40 = potions.register("resistance_40", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_0, 4)));
	public static final RegistryObject<Potion> resistance_41 = potions.register("resistance_41", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_1, 4)));
	public static final RegistryObject<Potion> resistance_42 = potions.register("resistance_42", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_2, 4)));
	public static final RegistryObject<Potion> resistance_43 = potions.register("resistance_43", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_3, 4)));
	public static final RegistryObject<Potion> resistance_50 = potions.register("resistance_50", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_0, 5)));
	public static final RegistryObject<Potion> resistance_51 = potions.register("resistance_51", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_1, 5)));
	public static final RegistryObject<Potion> resistance_52 = potions.register("resistance_52", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_2, 5)));
	public static final RegistryObject<Potion> resistance_53 = potions.register("resistance_53", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_3, 5)));
	public static final RegistryObject<Potion> resistance_60 = potions.register("resistance_60", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_0, 6)));
	public static final RegistryObject<Potion> resistance_61 = potions.register("resistance_61", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_1, 6)));
	public static final RegistryObject<Potion> resistance_62 = potions.register("resistance_62", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_2, 6)));
	public static final RegistryObject<Potion> resistance_63 = potions.register("resistance_63", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_3, 6)));
	public static final RegistryObject<Potion> resistance_70 = potions.register("resistance_70", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_0, 7)));
	public static final RegistryObject<Potion> resistance_71 = potions.register("resistance_71", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_1, 7)));
	public static final RegistryObject<Potion> resistance_72 = potions.register("resistance_72", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_2, 7)));
	public static final RegistryObject<Potion> resistance_73 = potions.register("resistance_73", () -> new Potion(new EffectInstance(Effects.DAMAGE_RESISTANCE, duration_3, 7)));

	public static final RegistryObject<Potion> stamina_00 = potions.register("stamina_00", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> stamina_01 = potions.register("stamina_01", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> stamina_02 = potions.register("stamina_02", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> stamina_03 = potions.register("stamina_03", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> stamina_10 = potions.register("stamina_10", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> stamina_11 = potions.register("stamina_11", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> stamina_12 = potions.register("stamina_12", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> stamina_13 = potions.register("stamina_13", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> stamina_20 = potions.register("stamina_20", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> stamina_21 = potions.register("stamina_21", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> stamina_22 = potions.register("stamina_22", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> stamina_23 = potions.register("stamina_23", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> stamina_30 = potions.register("stamina_30", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> stamina_31 = potions.register("stamina_31", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> stamina_32 = potions.register("stamina_32", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> stamina_33 = potions.register("stamina_33", () -> new Potion(new EffectInstance(stamina_effect.get(), duration_3, 3)));

	public static final RegistryObject<Potion> stun_00 = potions.register("stun_00", () -> new Potion(new EffectInstance(stun_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> stun_01 = potions.register("stun_01", () -> new Potion(new EffectInstance(stun_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> stun_02 = potions.register("stun_02", () -> new Potion(new EffectInstance(stun_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> stun_03 = potions.register("stun_03", () -> new Potion(new EffectInstance(stun_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> stun_10 = potions.register("stun_10", () -> new Potion(new EffectInstance(stun_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> stun_11 = potions.register("stun_11", () -> new Potion(new EffectInstance(stun_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> stun_12 = potions.register("stun_12", () -> new Potion(new EffectInstance(stun_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> stun_13 = potions.register("stun_13", () -> new Potion(new EffectInstance(stun_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> stun_20 = potions.register("stun_20", () -> new Potion(new EffectInstance(stun_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> stun_21 = potions.register("stun_21", () -> new Potion(new EffectInstance(stun_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> stun_22 = potions.register("stun_22", () -> new Potion(new EffectInstance(stun_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> stun_23 = potions.register("stun_23", () -> new Potion(new EffectInstance(stun_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> stun_30 = potions.register("stun_30", () -> new Potion(new EffectInstance(stun_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> stun_31 = potions.register("stun_31", () -> new Potion(new EffectInstance(stun_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> stun_32 = potions.register("stun_32", () -> new Potion(new EffectInstance(stun_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> stun_33 = potions.register("stun_33", () -> new Potion(new EffectInstance(stun_effect.get(), duration_3, 3)));

	public static final RegistryObject<Potion> tr_00 = potions.register("tr_00", () -> new Potion(new EffectInstance(tr_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> tr_01 = potions.register("tr_01", () -> new Potion(new EffectInstance(tr_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> tr_02 = potions.register("tr_02", () -> new Potion(new EffectInstance(tr_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> tr_03 = potions.register("tr_03", () -> new Potion(new EffectInstance(tr_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> tr_10 = potions.register("tr_10", () -> new Potion(new EffectInstance(tr_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> tr_11 = potions.register("tr_11", () -> new Potion(new EffectInstance(tr_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> tr_12 = potions.register("tr_12", () -> new Potion(new EffectInstance(tr_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> tr_13 = potions.register("tr_13", () -> new Potion(new EffectInstance(tr_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> tr_20 = potions.register("tr_20", () -> new Potion(new EffectInstance(tr_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> tr_21 = potions.register("tr_21", () -> new Potion(new EffectInstance(tr_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> tr_22 = potions.register("tr_22", () -> new Potion(new EffectInstance(tr_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> tr_23 = potions.register("tr_23", () -> new Potion(new EffectInstance(tr_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> tr_30 = potions.register("tr_30", () -> new Potion(new EffectInstance(tr_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> tr_31 = potions.register("tr_31", () -> new Potion(new EffectInstance(tr_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> tr_32 = potions.register("tr_32", () -> new Potion(new EffectInstance(tr_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> tr_33 = potions.register("tr_33", () -> new Potion(new EffectInstance(tr_effect.get(), duration_3, 3)));

	public static final RegistryObject<Potion> venomous_00 = potions.register("venomous_00", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> venomous_01 = potions.register("venomous_01", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> venomous_02 = potions.register("venomous_02", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> venomous_03 = potions.register("venomous_03", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> venomous_10 = potions.register("venomous_10", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> venomous_11 = potions.register("venomous_11", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> venomous_12 = potions.register("venomous_12", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> venomous_13 = potions.register("venomous_13", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> venomous_20 = potions.register("venomous_20", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> venomous_21 = potions.register("venomous_21", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> venomous_22 = potions.register("venomous_22", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> venomous_23 = potions.register("venomous_23", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> venomous_30 = potions.register("venomous_30", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> venomous_31 = potions.register("venomous_31", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> venomous_32 = potions.register("venomous_32", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> venomous_33 = potions.register("venomous_33", () -> new Potion(new EffectInstance(venomous_effect.get(), duration_3, 3)));

	public static final RegistryObject<Potion> wounded_00 = potions.register("wounded_00", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_0, 0)));
	public static final RegistryObject<Potion> wounded_01 = potions.register("wounded_01", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_0, 1)));
	public static final RegistryObject<Potion> wounded_02 = potions.register("wounded_02", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_0, 2)));
	public static final RegistryObject<Potion> wounded_03 = potions.register("wounded_03", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_0, 3)));
	public static final RegistryObject<Potion> wounded_10 = potions.register("wounded_10", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_1, 0)));
	public static final RegistryObject<Potion> wounded_11 = potions.register("wounded_11", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_1, 1)));
	public static final RegistryObject<Potion> wounded_12 = potions.register("wounded_12", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_1, 2)));
	public static final RegistryObject<Potion> wounded_13 = potions.register("wounded_13", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_1, 3)));
	public static final RegistryObject<Potion> wounded_20 = potions.register("wounded_20", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_2, 0)));
	public static final RegistryObject<Potion> wounded_21 = potions.register("wounded_21", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_2, 1)));
	public static final RegistryObject<Potion> wounded_22 = potions.register("wounded_22", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_2, 2)));
	public static final RegistryObject<Potion> wounded_23 = potions.register("wounded_23", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_2, 3)));
	public static final RegistryObject<Potion> wounded_30 = potions.register("wounded_30", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_3, 0)));
	public static final RegistryObject<Potion> wounded_31 = potions.register("wounded_31", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_3, 1)));
	public static final RegistryObject<Potion> wounded_32 = potions.register("wounded_32", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_3, 2)));
	public static final RegistryObject<Potion> wounded_33 = potions.register("wounded_33", () -> new Potion(new EffectInstance(wounded_effect.get(), duration_3, 3)));

	/**
	 * Register all {@link Effect} and {@link Potion}.
	 * 
	 * @param bus {@link IEventBus}
	 */
	public static final void register(IEventBus bus) {
		LOGGER.debug("PotionInit registering");
		effects.register(bus);
		potions.register(bus);
	}

	private static final class ModBrewingRecipe implements IBrewingRecipe {
		@Nonnull
		private final Potion potion;

		@Nonnull
		private final Item input;

		@Nonnull
		private final ItemStack output;

		public ModBrewingRecipe(Potion potion, Item input, Potion output) {
			this.potion = Objects.requireNonNull(potion, "potion cannot be null");
			this.input = Objects.requireNonNull(input, "input cannot be null");
			this.output = PotionUtils.setPotion(PotionInit.potion.copy(),
					Objects.requireNonNull(output, "output cannot be null"));
			LOGGER.debug("I effects:\t"	+ this.potion.getEffects().toString());
			LOGGER.debug("Ingredient:\t"+ this.input.toString());
			LOGGER.debug("O effects:\t"	+ PotionUtils.getPotion(this.output).getEffects().toString());

		}

		public ModBrewingRecipe(Potion potion, RegistryObject<Item> input, RegistryObject<Potion> output) {
			this(potion, input.get(), output.get());
		}

		public ModBrewingRecipe(Potion potion, Item input, RegistryObject<Potion> output) {
			this(potion, input, output.get());
		}

		public ModBrewingRecipe(RegistryObject<Potion> potion, Item input, RegistryObject<Potion> output) {
			this(potion.get(), input, output.get());
		}

		public ModBrewingRecipe(RegistryObject<Potion> potion, RegistryObject<Item> input, RegistryObject<Potion> output) {
			this(potion.get(), input.get(), output.get());
		}

		@Override
		public boolean isInput(ItemStack input) {
			return PotionUtils.getPotion(input).equals(this.potion);
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem().equals(this.input);
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (this.isInput(input) && this.isIngredient(ingredient))
				return this.output.copy();
			return ItemStack.EMPTY;
		}
	}

	/**
	 * Adds all potion recipes using
	 * {@link BrewingRecipeRegistry#addRecipe(Ingredient, Ingredient, ItemStack)}.
	 * Also includes {@link Ingredient#of(IItemProvider...)},
	 * {@link Ingredient#of(ItemStack...)}, and
	 * {@link PotionUtils#setPotion(ItemStack, Potion)}
	 */
	public static void addRecipies() {
		//LOGGER.debug("Adding More Vanilla Potion Recipies");

		// Heal
		//BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.enchanted_melon_slice, heal_2));

		LOGGER.debug("Adding Modded Potion Recipies");

		// Absorption
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.GOLD_INGOT					, absorption_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_00	, Items.REDSTONE					, absorption_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_00	, ItemInit.enchanted_redstone		, absorption_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_00	, ItemInit.enchanted_redstone_block	, absorption_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_00	, Items.GLOWSTONE					, absorption_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_10	, Items.REDSTONE					, absorption_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_10	, ItemInit.enchanted_redstone		, absorption_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_10	, ItemInit.enchanted_redstone_block	, absorption_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.enchanted_gold_ingot		, absorption_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_20	, Items.REDSTONE					, absorption_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_20	, ItemInit.enchanted_redstone		, absorption_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_20	, ItemInit.enchanted_redstone_block	, absorption_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_20	, Items.GLOWSTONE					, absorption_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_30	, Items.REDSTONE					, absorption_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_30	, ItemInit.enchanted_redstone		, absorption_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_30	, ItemInit.enchanted_redstone_block	, absorption_33));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.enchanted_gold_block		, absorption_40));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_40	, Items.REDSTONE					, absorption_41));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_40	, ItemInit.enchanted_redstone		, absorption_42));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_40	, ItemInit.enchanted_redstone_block	, absorption_43));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_40	, Items.GLOWSTONE					, absorption_50));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_50	, Items.REDSTONE					, absorption_51));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_50	, ItemInit.enchanted_redstone		, absorption_52));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_50	, ItemInit.enchanted_redstone_block	, absorption_53));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_40	, ItemInit.enchanted_glowstone_dust	, absorption_60));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_60	, Items.REDSTONE					, absorption_61));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_60	, ItemInit.enchanted_redstone		, absorption_62));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_60	, ItemInit.enchanted_redstone_block	, absorption_63));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_40	, ItemInit.enchanted_glowstone		, absorption_70));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_70	, Items.REDSTONE					, absorption_71));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_70	, ItemInit.enchanted_redstone		, absorption_72));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(absorption_70	, ItemInit.enchanted_redstone_block	, absorption_73));

		// Adrenaline
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.COCOA_BEANS					, adrenaline_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_00	, Items.REDSTONE					, adrenaline_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_00	, ItemInit.enchanted_redstone		, adrenaline_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_00	, ItemInit.enchanted_redstone_block	, adrenaline_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_00	, Items.GLOWSTONE_DUST				, adrenaline_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_10	, Items.REDSTONE					, adrenaline_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_10	, ItemInit.enchanted_redstone		, adrenaline_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_10	, ItemInit.enchanted_redstone_block	, adrenaline_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.enchanted_cocoa_beans	, adrenaline_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_20	, Items.REDSTONE					, adrenaline_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_20	, ItemInit.enchanted_redstone		, adrenaline_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_20	, ItemInit.enchanted_redstone_block	, adrenaline_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_20	, Items.GLOWSTONE_DUST				, adrenaline_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_30	, Items.REDSTONE					, adrenaline_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_30	, ItemInit.enchanted_redstone		, adrenaline_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_30	, ItemInit.enchanted_redstone_block	, adrenaline_33));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.enchanted_cookie			, adrenaline_40));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_40	, Items.REDSTONE					, adrenaline_41));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_40	, ItemInit.enchanted_redstone		, adrenaline_42));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_40	, ItemInit.enchanted_redstone_block	, adrenaline_43));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_40	, Items.GLOWSTONE_DUST				, adrenaline_50));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_50	, Items.REDSTONE					, adrenaline_51));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_50	, ItemInit.enchanted_redstone		, adrenaline_52));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_50	, ItemInit.enchanted_redstone_block	, adrenaline_53));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_40	, ItemInit.enchanted_glowstone_dust	, adrenaline_60));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_60	, Items.REDSTONE					, adrenaline_61));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_60	, ItemInit.enchanted_redstone		, adrenaline_62));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_60	, ItemInit.enchanted_redstone_block	, adrenaline_63));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_40	, ItemInit.enchanted_glowstone		, adrenaline_70));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_70	, Items.REDSTONE					, adrenaline_71));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_70	, ItemInit.enchanted_redstone		, adrenaline_72));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(adrenaline_70	, ItemInit.enchanted_redstone_block	, adrenaline_73));

		// Agility
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.enchanted_cake			, agility_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_00		, Items.REDSTONE					, agility_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_00		, ItemInit.enchanted_redstone		, agility_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_00		, ItemInit.enchanted_redstone_block	, agility_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_00		, Items.GLOWSTONE					, agility_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_10		, Items.REDSTONE					, agility_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_10		, ItemInit.enchanted_redstone		, agility_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_10		, ItemInit.enchanted_redstone_block	, agility_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_00		, ItemInit.enchanted_glowstone_dust	, agility_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_20		, Items.REDSTONE					, agility_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_20		, ItemInit.enchanted_redstone		, agility_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_20		, ItemInit.enchanted_redstone_block	, agility_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_00		, ItemInit.enchanted_glowstone		, agility_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_30		, Items.REDSTONE					, agility_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_30		, ItemInit.enchanted_redstone		, agility_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(agility_30		, ItemInit.enchanted_redstone_block	, agility_33));

		// Archery
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.enchanted_cake			, archery_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_00		, Items.REDSTONE					, archery_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_00		, ItemInit.enchanted_redstone		, archery_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_00		, ItemInit.enchanted_redstone_block	, archery_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_00		, Items.GLOWSTONE					, archery_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_10		, Items.REDSTONE					, archery_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_10		, ItemInit.enchanted_redstone		, archery_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_10		, ItemInit.enchanted_redstone_block	, archery_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_00		, ItemInit.enchanted_glowstone_dust	, archery_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_20		, Items.REDSTONE					, archery_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_20		, ItemInit.enchanted_redstone		, archery_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_20		, ItemInit.enchanted_redstone_block	, archery_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_00		, ItemInit.enchanted_glowstone		, archery_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_30		, Items.REDSTONE					, archery_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_30		, ItemInit.enchanted_redstone		, archery_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(archery_30		, ItemInit.enchanted_redstone_block	, archery_33));

		// Blindness
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.INK_SAC						, blindness_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(blindness_00	, Items.REDSTONE					, blindness_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(blindness_00	, ItemInit.enchanted_redstone		, blindness_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(blindness_00	, ItemInit.enchanted_redstone_block	, blindness_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(blindness_00	, Items.GLOWSTONE					, blindness_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(blindness_10	, Items.REDSTONE					, blindness_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(blindness_10	, ItemInit.enchanted_redstone		, blindness_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(blindness_10	, ItemInit.enchanted_redstone_block	, blindness_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.enchanted_ink_sac		, blindness_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(blindness_10	, Items.REDSTONE					, blindness_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(blindness_10	, ItemInit.enchanted_redstone		, blindness_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(blindness_10	, ItemInit.enchanted_redstone_block	, blindness_01));

		// Burning
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.RED_SAND					, burning_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_00		, Items.REDSTONE					, burning_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_00		, ItemInit.enchanted_redstone		, burning_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_00		, ItemInit.enchanted_redstone_block	, burning_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_00		, Items.GLOWSTONE					, burning_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_10		, Items.REDSTONE					, burning_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_10		, ItemInit.enchanted_redstone		, burning_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_10		, ItemInit.enchanted_redstone_block	, burning_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_00		, ItemInit.enchanted_glowstone_dust	, burning_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_20		, Items.REDSTONE					, burning_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_20		, ItemInit.enchanted_redstone		, burning_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_20		, ItemInit.enchanted_redstone_block	, burning_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_00		, ItemInit.enchanted_glowstone		, burning_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_30		, Items.REDSTONE					, burning_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_30		, ItemInit.enchanted_redstone		, burning_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(burning_30		, ItemInit.enchanted_redstone_block	, burning_33));

		// Critical
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.FLINT						, critical_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_00	, Items.REDSTONE					, critical_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_00	, ItemInit.enchanted_redstone		, critical_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_00	, ItemInit.enchanted_redstone_block	, critical_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_00	, Items.GLOWSTONE					, critical_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_10	, Items.REDSTONE					, critical_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_10	, ItemInit.enchanted_redstone		, critical_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_10	, ItemInit.enchanted_redstone_block	, critical_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_00	, ItemInit.enchanted_glowstone_dust	, critical_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_20	, Items.REDSTONE					, critical_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_20	, ItemInit.enchanted_redstone		, critical_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_20	, ItemInit.enchanted_redstone_block	, critical_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_00	, ItemInit.enchanted_glowstone		, critical_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_30	, Items.REDSTONE					, critical_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_30	, ItemInit.enchanted_redstone		, critical_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(critical_30	, ItemInit.enchanted_redstone_block	, critical_33));

		// Dodge
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.SALMON						, dodge_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_00		, Items.REDSTONE					, dodge_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_00		, ItemInit.enchanted_redstone		, dodge_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_00		, ItemInit.enchanted_redstone_block	, dodge_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_00		, Items.GLOWSTONE					, dodge_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_10		, Items.REDSTONE					, dodge_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_10		, ItemInit.enchanted_redstone		, dodge_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_10		, ItemInit.enchanted_redstone_block	, dodge_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_00		, ItemInit.enchanted_glowstone_dust	, dodge_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_20		, Items.REDSTONE					, dodge_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_20		, ItemInit.enchanted_redstone		, dodge_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_20		, ItemInit.enchanted_redstone_block	, dodge_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_00		, ItemInit.enchanted_glowstone		, dodge_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_30		, Items.REDSTONE					, dodge_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_30		, ItemInit.enchanted_redstone		, dodge_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(dodge_30		, ItemInit.enchanted_redstone_block	, dodge_33));

		// Experience
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.LAPIS_LAZULI				, experience_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_00	, Items.REDSTONE					, experience_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_00	, ItemInit.enchanted_redstone		, experience_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_00	, ItemInit.enchanted_redstone_block	, experience_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_00	, Items.GLOWSTONE					, experience_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_10	, Items.REDSTONE					, experience_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_10	, ItemInit.enchanted_redstone		, experience_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_10	, ItemInit.enchanted_redstone_block	, experience_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_00	, ItemInit.enchanted_glowstone_dust	, experience_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_20	, Items.REDSTONE					, experience_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_20	, ItemInit.enchanted_redstone		, experience_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_20	, ItemInit.enchanted_redstone_block	, experience_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_00	, ItemInit.enchanted_glowstone		, experience_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_30	, Items.REDSTONE					, experience_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_30	, ItemInit.enchanted_redstone		, experience_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(experience_30	, ItemInit.enchanted_redstone_block	, experience_33));

		// Haste
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.COAL						, haste_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_00		, Items.REDSTONE					, haste_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_00		, ItemInit.enchanted_redstone		, haste_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_00		, ItemInit.enchanted_redstone_block	, haste_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_00		, Items.GLOWSTONE					, haste_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_10		, Items.REDSTONE					, haste_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_10		, ItemInit.enchanted_redstone		, haste_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_10		, ItemInit.enchanted_redstone_block	, haste_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_00		, ItemInit.enchanted_glowstone_dust	, haste_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_20		, Items.REDSTONE					, haste_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_20		, ItemInit.enchanted_redstone		, haste_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_20		, ItemInit.enchanted_redstone_block	, haste_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_00		, ItemInit.enchanted_glowstone		, haste_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_30		, Items.REDSTONE					, haste_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_30		, ItemInit.enchanted_redstone		, haste_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(haste_30		, ItemInit.enchanted_redstone_block	, haste_33));

		// Knockback
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.SLIME_BALL					, knockback_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_00	, Items.REDSTONE					, knockback_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_00	, ItemInit.enchanted_redstone		, knockback_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_00	, ItemInit.enchanted_redstone_block	, knockback_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_00	, Items.GLOWSTONE					, knockback_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_10	, Items.REDSTONE					, knockback_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_10	, ItemInit.enchanted_redstone		, knockback_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_10	, ItemInit.enchanted_redstone_block	, knockback_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_00	, ItemInit.enchanted_glowstone_dust	, knockback_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_20	, Items.REDSTONE					, knockback_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_20	, ItemInit.enchanted_redstone		, knockback_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_20	, ItemInit.enchanted_redstone_block	, knockback_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_00	, ItemInit.enchanted_glowstone		, knockback_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_30	, Items.REDSTONE					, knockback_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_30	, ItemInit.enchanted_redstone		, knockback_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(knockback_30	, ItemInit.enchanted_redstone_block	, knockback_33));

		// Mana
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.MUTTON						, mana_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_00		, Items.REDSTONE					, mana_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_00		, ItemInit.enchanted_redstone		, mana_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_00		, ItemInit.enchanted_redstone_block	, mana_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_00		, Items.GLOWSTONE					, mana_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_10		, Items.REDSTONE					, mana_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_10		, ItemInit.enchanted_redstone		, mana_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_10		, ItemInit.enchanted_redstone_block	, mana_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.enchanted_mutton			, mana_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_20		, Items.REDSTONE					, mana_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_20		, ItemInit.enchanted_redstone		, mana_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_20		, ItemInit.enchanted_redstone_block	, mana_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_20		, Items.GLOWSTONE					, mana_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_30		, Items.REDSTONE					, mana_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_30		, ItemInit.enchanted_redstone		, mana_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_30		, ItemInit.enchanted_redstone_block	, mana_33));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.enchanted_cooked_mutton	, mana_40));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_40		, Items.REDSTONE					, mana_41));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_40		, ItemInit.enchanted_redstone		, mana_42));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_40		, ItemInit.enchanted_redstone_block	, mana_43));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_40		, Items.GLOWSTONE					, mana_50));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_50		, Items.REDSTONE					, mana_51));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_50		, ItemInit.enchanted_redstone		, mana_52));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_50		, ItemInit.enchanted_redstone_block	, mana_53));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_40		, ItemInit.enchanted_glowstone_dust	, mana_60));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_60		, Items.REDSTONE					, mana_61));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_60		, ItemInit.enchanted_redstone		, mana_62));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_60		, ItemInit.enchanted_redstone_block	, mana_63));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_40		, ItemInit.enchanted_glowstone		, mana_70));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_70		, Items.REDSTONE					, mana_71));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_70		, ItemInit.enchanted_redstone		, mana_72));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(mana_70		, ItemInit.enchanted_redstone_block	, mana_73));

		// Rabbit
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.RABBIT						, rabbit_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_00		, Items.REDSTONE					, rabbit_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_00		, ItemInit.enchanted_redstone		, rabbit_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_00		, ItemInit.enchanted_redstone_block	, rabbit_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_00		, Items.GLOWSTONE					, rabbit_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_10		, Items.REDSTONE					, rabbit_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_10		, ItemInit.enchanted_redstone		, rabbit_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_10		, ItemInit.enchanted_redstone_block	, rabbit_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.enchanted_rabbit_foot	, rabbit_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_20		, Items.REDSTONE					, rabbit_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_20		, ItemInit.enchanted_redstone		, rabbit_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_20		, ItemInit.enchanted_redstone_block	, rabbit_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_20		, Items.GLOWSTONE					, rabbit_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_30		, Items.REDSTONE					, rabbit_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_30		, ItemInit.enchanted_redstone		, rabbit_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_30		, ItemInit.enchanted_redstone_block	, rabbit_33));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_20		, ItemInit.enchanted_glowstone_dust	, rabbit_40));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_40		, Items.REDSTONE					, rabbit_41));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_40		, ItemInit.enchanted_redstone		, rabbit_42));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_40		, ItemInit.enchanted_redstone_block	, rabbit_43));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_20		, ItemInit.enchanted_glowstone		, rabbit_50));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_50		, Items.REDSTONE					, rabbit_51));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_50		, ItemInit.enchanted_redstone		, rabbit_52));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(rabbit_50		, ItemInit.enchanted_redstone_block	, rabbit_53));

		// Resistance
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.CACTUS						, resistance_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_00	, Items.REDSTONE					, resistance_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_00	, ItemInit.enchanted_redstone		, resistance_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_00	, ItemInit.enchanted_redstone_block	, resistance_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_00	, Items.GLOWSTONE					, resistance_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_10	, Items.REDSTONE					, resistance_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_10	, ItemInit.enchanted_redstone		, resistance_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_10	, ItemInit.enchanted_redstone_block	, resistance_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.enchanted_green_dye		, resistance_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_20	, Items.REDSTONE					, resistance_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_20	, ItemInit.enchanted_redstone		, resistance_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_20	, ItemInit.enchanted_redstone_block	, resistance_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_20	, Items.GLOWSTONE					, resistance_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_30	, Items.REDSTONE					, resistance_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_30	, ItemInit.enchanted_redstone		, resistance_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_30	, ItemInit.enchanted_redstone_block	, resistance_33));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.enchanted_cactus			, resistance_40));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_40	, Items.REDSTONE					, resistance_41));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_40	, ItemInit.enchanted_redstone		, resistance_42));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_40	, ItemInit.enchanted_redstone_block	, resistance_43));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_40	, Items.GLOWSTONE					, resistance_50));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_50	, Items.REDSTONE					, resistance_51));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_50	, ItemInit.enchanted_redstone		, resistance_52));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_50	, ItemInit.enchanted_redstone_block	, resistance_53));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_40	, ItemInit.enchanted_glowstone_dust	, resistance_60));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_60	, Items.REDSTONE					, resistance_61));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_60	, ItemInit.enchanted_redstone		, resistance_62));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_60	, ItemInit.enchanted_redstone_block	, resistance_63));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_40	, ItemInit.enchanted_glowstone		, resistance_70));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_70	, Items.REDSTONE					, resistance_71));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_70	, ItemInit.enchanted_redstone		, resistance_72));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(resistance_70	, ItemInit.enchanted_redstone_block	, resistance_73));

		// Stamina
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.foul_flesh				, stamina_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_00		, Items.REDSTONE					, stamina_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_00		, ItemInit.enchanted_redstone		, stamina_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_00		, ItemInit.enchanted_redstone_block	, stamina_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_00		, Items.GLOWSTONE					, stamina_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_10		, Items.REDSTONE					, stamina_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_10		, ItemInit.enchanted_redstone		, stamina_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_10		, ItemInit.enchanted_redstone_block	, stamina_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_00		, ItemInit.enchanted_glowstone_dust	, stamina_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_20		, Items.REDSTONE					, stamina_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_20		, ItemInit.enchanted_redstone		, stamina_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_20		, ItemInit.enchanted_redstone_block	, stamina_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_00		, ItemInit.enchanted_glowstone		, stamina_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_30		, Items.REDSTONE					, stamina_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_30		, ItemInit.enchanted_redstone		, stamina_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stamina_30		, ItemInit.enchanted_redstone_block	, stamina_33));

		// Stun
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.OBSIDIAN					, stun_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, Items.REDSTONE					, stun_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_redstone		, stun_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_redstone_block	, stun_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, Items.GLOWSTONE					, stun_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_10		, Items.REDSTONE					, stun_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_10		, ItemInit.enchanted_redstone		, stun_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_10		, ItemInit.enchanted_redstone_block	, stun_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_glowstone_dust	, stun_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_20		, Items.REDSTONE					, stun_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_20		, ItemInit.enchanted_redstone		, stun_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_20		, ItemInit.enchanted_redstone_block	, stun_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_glowstone		, stun_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_30		, Items.REDSTONE					, stun_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_30		, ItemInit.enchanted_redstone		, stun_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_30		, ItemInit.enchanted_redstone_block	, stun_33));

		// True Resistance
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, ItemInit.true_essence				, stun_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, Items.REDSTONE					, stun_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_redstone		, stun_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_redstone_block	, stun_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, Items.GLOWSTONE					, stun_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_10		, Items.REDSTONE					, stun_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_10		, ItemInit.enchanted_redstone		, stun_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_10		, ItemInit.enchanted_redstone_block	, stun_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_glowstone_dust	, stun_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_20		, Items.REDSTONE					, stun_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_20		, ItemInit.enchanted_redstone		, stun_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_20		, ItemInit.enchanted_redstone_block	, stun_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_glowstone		, stun_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_30		, Items.REDSTONE					, stun_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_30		, ItemInit.enchanted_redstone		, stun_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_30		, ItemInit.enchanted_redstone_block	, stun_33));

		// Venomous
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.POISONOUS_POTATO			, stun_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, Items.REDSTONE					, stun_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_redstone		, stun_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_redstone_block	, stun_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, Items.GLOWSTONE					, stun_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_10		, Items.REDSTONE					, stun_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_10		, ItemInit.enchanted_redstone		, stun_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_10		, ItemInit.enchanted_redstone_block	, stun_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_glowstone_dust	, stun_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_20		, Items.REDSTONE					, stun_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_20		, ItemInit.enchanted_redstone		, stun_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_20		, ItemInit.enchanted_redstone_block	, stun_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_glowstone		, stun_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_30		, Items.REDSTONE					, stun_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_30		, ItemInit.enchanted_redstone		, stun_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_30		, ItemInit.enchanted_redstone_block	, stun_33));

		// Wounded
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.NETHERRACK					, stun_00));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, Items.REDSTONE					, stun_01));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_redstone		, stun_02));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_redstone_block	, stun_03));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, Items.GLOWSTONE					, stun_10));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_10		, Items.REDSTONE					, stun_11));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_10		, ItemInit.enchanted_redstone		, stun_12));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_10		, ItemInit.enchanted_redstone_block	, stun_13));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_glowstone_dust	, stun_20));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_20		, Items.REDSTONE					, stun_21));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_20		, ItemInit.enchanted_redstone		, stun_22));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_20		, ItemInit.enchanted_redstone_block	, stun_23));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_00		, ItemInit.enchanted_glowstone		, stun_30));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_30		, Items.REDSTONE					, stun_31));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_30		, ItemInit.enchanted_redstone		, stun_32));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(stun_30		, ItemInit.enchanted_redstone_block	, stun_33));
	}
}