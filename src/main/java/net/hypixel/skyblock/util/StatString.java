package net.hypixel.skyblock.util;

import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class StatString {
	public static final IFormattableTextComponent attack_speed = new TranslationTextComponent("stat.attack_speed")
			.withStyle(TextFormatting.YELLOW);
	public static final IFormattableTextComponent ability_damage = new TranslationTextComponent("stat.ability_damage")
			.withStyle(TextFormatting.RED);
	public static final IFormattableTextComponent breaking_power = new TranslationTextComponent("stat.breaking_power")
			.withStyle(TextFormatting.GRAY);
	public static final String complete = FormatingCodes.green + SpecialCharacters.complete + FormatingCodes.reset;
	public static final IFormattableTextComponent crit_chance = new TranslationTextComponent("stat.crit_chance")
			.withStyle(TextFormatting.BLUE);
	public static final IFormattableTextComponent crit_damage = new TranslationTextComponent("stat.crit_damage")
			.withStyle(TextFormatting.BLUE);
	public static final String day = FormatingCodes.yellow + SpecialCharacters.day + FormatingCodes.reset;
	public static final IFormattableTextComponent defense = new TranslationTextComponent("stat.defense")
			.withStyle(TextFormatting.GREEN);
	public static final String dungeon_star_1 = FormatingCodes.gold + SpecialCharacters.dungeon_star
			+ FormatingCodes.reset;
	public static final String dungeon_star_2 = FormatingCodes.gold + SpecialCharacters.dungeon_star
			+ SpecialCharacters.dungeon_star + FormatingCodes.reset;
	public static final String dungeon_star_3 = FormatingCodes.gold + SpecialCharacters.dungeon_star
			+ SpecialCharacters.dungeon_star + SpecialCharacters.dungeon_star + FormatingCodes.reset;
	public static final String dungeon_star_4 = FormatingCodes.gold + SpecialCharacters.dungeon_star
			+ SpecialCharacters.dungeon_star + SpecialCharacters.dungeon_star + SpecialCharacters.dungeon_star
			+ FormatingCodes.reset;
	public static final String dungeon_star_5 = FormatingCodes.gold + SpecialCharacters.dungeon_star
			+ SpecialCharacters.dungeon_star + SpecialCharacters.dungeon_star + SpecialCharacters.dungeon_star
			+ SpecialCharacters.dungeon_star + FormatingCodes.reset;
	public static final IFormattableTextComponent farming_fortune = new TranslationTextComponent("stat.farming_fortune")
			.withStyle(TextFormatting.GOLD);
	public static final IFormattableTextComponent ferocity = new TranslationTextComponent("stat.ferocity")
			.withStyle(TextFormatting.RED);
	public static final IFormattableTextComponent fishing_speed = new TranslationTextComponent("stat.fishing_speed")
			.withStyle(TextFormatting.GREEN);
	public static final IFormattableTextComponent foraging_fortune = new TranslationTextComponent(
			"stat.foraging_fortune").withStyle(TextFormatting.GOLD);
	public static final IFormattableTextComponent health = new TranslationTextComponent("stat.health")
			.withStyle(TextFormatting.RED);
	public static final String incomplete = FormatingCodes.red + SpecialCharacters.incomplete + FormatingCodes.reset;
	public static final IFormattableTextComponent intelligence = new TranslationTextComponent("stat.intelligence")
			.withStyle(TextFormatting.AQUA);
	public static final String level_up = FormatingCodes.dark_gray + SpecialCharacters.level_up;
	public static final IFormattableTextComponent magic_find = new TranslationTextComponent("stat.magic_find")
			.withStyle(TextFormatting.AQUA);
	public static final IFormattableTextComponent mana = new TranslationTextComponent("stat.mana")
			.withStyle(TextFormatting.AQUA);
	public static final IFormattableTextComponent mining_fortune = new TranslationTextComponent("stat.mining_fortune")
			.withStyle(TextFormatting.GOLD);
	public static final IFormattableTextComponent mining_speed = new TranslationTextComponent("stat.mining_speed")
			.withStyle(TextFormatting.YELLOW);
	public static final String night = FormatingCodes.aqua + SpecialCharacters.night + FormatingCodes.reset;
	public static final IFormattableTextComponent pet_luck = new TranslationTextComponent("stat.pet_luck")
			.withStyle(TextFormatting.LIGHT_PURPLE);
	public static final String reqirement_slayer = FormatingCodes.dark_red + SpecialCharacters.requirement_slayer
			+ " Required" + FormatingCodes.reset;
	public static final String requirement = FormatingCodes.dark_red + SpecialCharacters.requirement + " Required"
			+ FormatingCodes.reset;
	public static final IFormattableTextComponent sea_creature_chance = new TranslationTextComponent(
			"stat.sea_creature_chance").withStyle(TextFormatting.DARK_AQUA);
	public static final IFormattableTextComponent speed = new TranslationTextComponent("stat.speed")
			.withStyle(TextFormatting.WHITE);
	public static final IFormattableTextComponent strength = new TranslationTextComponent("stat.strength")
			.withStyle(TextFormatting.RED);
	public static final String ticker = FormatingCodes.yellow + "%d " + SpecialCharacters.ticker;
	public static final IFormattableTextComponent true_def = new TranslationTextComponent("stat.true_defense")
			.withStyle(TextFormatting.WHITE);
}