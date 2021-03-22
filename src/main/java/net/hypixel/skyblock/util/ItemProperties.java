package net.hypixel.skyblock.util;

import net.hypixel.skyblock.items.itemgroup.CombatGroup;
import net.hypixel.skyblock.items.itemgroup.DungeonGroup;
import net.hypixel.skyblock.items.itemgroup.FarmingGroup;
import net.hypixel.skyblock.items.itemgroup.FishingGroup;
import net.hypixel.skyblock.items.itemgroup.ForagingGroup;
import net.hypixel.skyblock.items.itemgroup.MiningGroup;
import net.hypixel.skyblock.items.itemgroup.MinionGroup;
import net.hypixel.skyblock.items.itemgroup.MiscellaneousGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;

/**
 * This class holds {@link Properties} for this Mod.
 *
 * @author MrPineapple070
 * @version 07 July 2020
 * @since 11 June 2019
 */
public class ItemProperties {
	/**
	 * {@link Properties} for {@link Item}<br>
	 * {@link CombatGroup}
	 */
	public static final Properties combat = new Properties().tab(CombatGroup.instance).fireResistant();
	
	/**
	 * {@link #combat} that {@link Properties#stacksTo(int)} 1
	 */
	public static final Properties combat_1 = combat.stacksTo(1);

	/**
	 * {@link #combat} that {@link Properties#stacksTo(int)} 64
	 */
	public static final Properties combat_64 = combat.stacksTo(64);
	
	/**
	 * {@link Properties} for {@link Item}<br>
	 * {@link DungeonGroup}
	 */
	public static final Properties dungeon = new Properties().tab(DungeonGroup.instance).fireResistant();
	
	/**
	 * {@link #dungeon} that {@link Properties#stacksTo(int)} 1
	 */
	public static final Properties dungeon_1 = dungeon.stacksTo(1);

	/**
	 * {@link #dungeon} that {@link Properties#stacksTo(int)} 64
	 */
	public static final Properties dungeon_64 = dungeon.stacksTo(64);
	
	/**
	 * {@link Properties} for {@link Item}<br>
	 * {@link FarmingGroup}
	 */
	public static final Properties farm = new Properties().tab(FarmingGroup.instance).fireResistant();

	/**
	 * {@link #farm} that {@link Properties#stacksTo(int)} 1
	 */
	public static final Properties farm_1 = new Properties().stacksTo(0x01).tab(FarmingGroup.instance);

	/**
	 * {@link #farm} that {@link Properties#stacksTo(int)} 64
	 */
	public static final Properties farm_64 = new Properties().stacksTo(0x40).tab(FarmingGroup.instance);
	
	/**
	 * {@link Properties} for {@link Item}<br>
	 * {@link ForagingGroup}
	 */
	public static final Properties foraging = new Properties().tab(ForagingGroup.instance).fireResistant();
	
	/**
	 * {@link #foraging} that {@link Properties#stacksTo(int)} 1
	 */
	public static final Properties foraging_1 = foraging.stacksTo(1);

	/**
	 * {@link #foraging} that {@link Properties#stacksTo(int)} 64
	 */
	public static final Properties foraging_64 = foraging.stacksTo(64);
	
	/**
	 * {@link Properties} for {@link Item}<br>
	 * {@link FishingGroup}
	 */
	public static final Properties fish = new Properties().tab(FishingGroup.instance).fireResistant();

	/**
	 * {@link #fish} that {@link Properties#stacksTo(int)} 1
	 */
	public static final Properties fish_1 = fish.stacksTo(1);

	/**
	 * {@link #fish} that {@link Properties#stacksTo(int)} 64
	 */
	public static final Properties fish_64 = fish.stacksTo(0x40);
	
	/**
	 * {@link Properties} for {@link Item}<br>
	 * {@link MiningGroup}
	 */
	public static final Properties mine = new Properties().tab(MiningGroup.instance).fireResistant();
	
	/**
	 * {@link #mine} that {@link Properties#stacksTo(int)} 1
	 */
	public static final Properties mine_1 = mine.stacksTo(1);

	/**
	 * {@link #mine} that {@link Properties#stacksTo(int)} 64
	 */
	public static final Properties mine_64 = mine.stacksTo(64);
	
	/**
	 * {@link Properties} for the {@link Item}<br>
	 * {@link MinionGroup}
	 */
	public static final Properties minion = new Properties().tab(MinionGroup.instance).fireResistant();
	
	/**
	 * {@link #minion} that {@link Properties#stacksTo(int)} 1
	 */
	public static final Properties minion_1 = minion.stacksTo(1);

	/**
	 * {@link #minion} that {@link Properties#stacksTo(int)} 64
	 */
	public static final Properties minion_64 = minion.stacksTo(64);
	
	/**
	 * {@link Properties} for the {@link Item}<br>
	 * {@link MiscellaneousGroup}
	 */
	public static final Properties miscellaneous = new Properties().tab(MiscellaneousGroup.instance).fireResistant();
	
	/**
	 * {@link #miscellaneous} that {@link Properties#stacksTo(int)} 1
	 */
	public static final Properties miscellaneous_1 = miscellaneous.stacksTo(1);

	/**
	 * {@link #miscellaneous} that {@link Properties#stacksTo(int)} 64
	 */
	public static final Properties miscellaneous_64 = miscellaneous.stacksTo(64);
}