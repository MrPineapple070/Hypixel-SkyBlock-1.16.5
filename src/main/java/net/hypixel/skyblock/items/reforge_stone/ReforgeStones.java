package net.hypixel.skyblock.items.reforge_stone;

import net.hypixel.skyblock.items.accessories.AccessoryReforge;
import net.hypixel.skyblock.items.armor.ArmorReforge;
import net.hypixel.skyblock.items.tools.ToolReforge;
import net.hypixel.skyblock.util.ItemProperties;

/**
 * Holds all {@link ReforgeStone}
 * 
 * @since 01 July 2020
 * @version 14 July 2021
 * @author MrPineapple070
 */
public class ReforgeStones {
	// Accessories Reforge Stones
	public static final ReforgeStone beating_heart		= new ReforgeStone(ItemProperties.dungeon_64		, AccessoryReforge.Bloody);
	public static final ReforgeStone luxurious_spool	= new ReforgeStone(ItemProperties.combat_64			, AccessoryReforge.Silky);
	public static final ReforgeStone dark_orb			= new ReforgeStone(ItemProperties.miscellaneous_64	, AccessoryReforge.Shaded);
	public static final ReforgeStone rock_candy			= new ReforgeStone(ItemProperties.miscellaneous_64	, AccessoryReforge.Sweet);
	
	// Armor Reforge Stones
	public static final ReforgeStone candy_corn			= new ReforgeStone(ItemProperties.combat_64		, ArmorReforge.Candied);
	public static final ReforgeStone deep_sea_orb		= new ReforgeStone(ItemProperties.fish_64		, ArmorReforge.Submerged);
	public static final ReforgeStone rare_diamond		= new ReforgeStone(ItemProperties.mine_64		, ArmorReforge.Reinforced);
	public static final ReforgeStone molten_cube		= new ReforgeStone(ItemProperties.combat_64		, ArmorReforge.Cubic);
	public static final ReforgeStone end_stone_geode	= new ReforgeStone(ItemProperties.mine_64		, ArmorReforge.Warped);
	public static final ReforgeStone premium_flesh		= new ReforgeStone(ItemProperties.combat_64		, ArmorReforge.Undead);
	public static final ReforgeStone red_nose			= new ReforgeStone(ItemProperties.dungeon_64	, ArmorReforge.Ridiculous);
	public static final ReforgeStone necromancer_brooch	= new ReforgeStone(ItemProperties.dungeon_64	, ArmorReforge.Necrotic);
	public static final ReforgeStone dragon_scale		= new ReforgeStone(ItemProperties.combat_64		, ArmorReforge.Spiked);
	public static final ReforgeStone jaderald			= new ReforgeStone(ItemProperties.mine_64		, ArmorReforge.Jaded);
	public static final ReforgeStone red_scarf			= new ReforgeStone(ItemProperties.dungeon_64	, ArmorReforge.Loving);
	public static final ReforgeStone diamond_atom		= new ReforgeStone(ItemProperties.dungeon_64	, ArmorReforge.Perfect);
	public static final ReforgeStone dragon_horn		= new ReforgeStone(ItemProperties.combat_64		, ArmorReforge.Renowned);
	public static final ReforgeStone giant_tooth		= new ReforgeStone(ItemProperties.dungeon_64	, ArmorReforge.Giant);
	public static final ReforgeStone sadan_brooch		= new ReforgeStone(ItemProperties.mine_64		, ArmorReforge.Empowered);
	public static final ReforgeStone precursor_gear		= new ReforgeStone(ItemProperties.mine_64		, ArmorReforge.Ancient);
	
	// Axe / How Reforge Stones
	public static final ReforgeStone moil_log		= new ReforgeStone(ItemProperties.foraging_64	, ToolReforge.Moil);
	public static final ReforgeStone blessed_fruit	= new ReforgeStone(ItemProperties.farm_64		, ToolReforge.Blessed);
	public static final ReforgeStone toil_log		= new ReforgeStone(ItemProperties.foraging_64	, ToolReforge.Toil);
	public static final ReforgeStone golden_ball	= new ReforgeStone(ItemProperties.farm_64		, ToolReforge.Bountiful);
}