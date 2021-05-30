package net.hypixel.skyblock.util;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

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
@Immutable
public final class ItemProperties {
	/**
	 * {@link Properties} for {@link Item}<br>
	 * {@link CombatGroup}
	 */
	@Nonnull
	public static final Properties combat = new Properties().tab(CombatGroup.instance).fireResistant();

	/**
	 * {@link #combat} that {@link Properties#stacksTo(int)} 1
	 */
	@Nonnull
	public static final Properties combat_1 = new Properties().tab(CombatGroup.instance).fireResistant().stacksTo(1);

	/**
	 * {@link #combat} that {@link Properties#stacksTo(int)} 64
	 */
	@Nonnull
	public static final Properties combat_64 = new Properties().tab(CombatGroup.instance).fireResistant().stacksTo(64);

	/**
	 * {@link Properties} for {@link Item}<br>
	 * {@link DungeonGroup}
	 */
	@Nonnull
	public static final Properties dungeon = new Properties().tab(DungeonGroup.instance).fireResistant();

	/**
	 * {@link #dungeon} that {@link Properties#stacksTo(int)} 1
	 */
	@Nonnull
	public static final Properties dungeon_1 = new Properties().tab(DungeonGroup.instance).fireResistant().stacksTo(1);

	/**
	 * {@link #dungeon} that {@link Properties#stacksTo(int)} 64
	 */
	@Nonnull
	public static final Properties dungeon_64 = new Properties().tab(DungeonGroup.instance).fireResistant().stacksTo(64);

	/**
	 * {@link Properties} for {@link Item}<br>
	 * {@link FarmingGroup}
	 */
	@Nonnull
	public static final Properties farm = new Properties().tab(FarmingGroup.instance).fireResistant();

	/**
	 * {@link #farm} that {@link Properties#stacksTo(int)} 1
	 */
	@Nonnull
	public static final Properties farm_1 = new Properties().tab(FarmingGroup.instance).fireResistant().stacksTo(1);

	/**
	 * {@link #farm} that {@link Properties#stacksTo(int)} 64
	 */
	@Nonnull
	public static final Properties farm_64 = new Properties().tab(FarmingGroup.instance).fireResistant().stacksTo(64);

	/**
	 * {@link Properties} for {@link Item}<br>
	 * {@link ForagingGroup}
	 */
	@Nonnull
	public static final Properties foraging = new Properties().tab(ForagingGroup.instance).fireResistant();

	/**
	 * {@link #foraging} that {@link Properties#stacksTo(int)} 1
	 */
	@Nonnull
	public static final Properties foraging_1 = new Properties().tab(ForagingGroup.instance).fireResistant().stacksTo(1);

	/**
	 * {@link #foraging} that {@link Properties#stacksTo(int)} 64
	 */
	@Nonnull
	public static final Properties foraging_64 = new Properties().tab(ForagingGroup.instance).fireResistant().stacksTo(64);

	/**
	 * {@link Properties} for {@link Item}<br>
	 * {@link FishingGroup}
	 */
	@Nonnull
	public static final Properties fish = new Properties().tab(FishingGroup.instance).fireResistant();

	/**
	 * {@link #fish} that {@link Properties#stacksTo(int)} 1
	 */
	@Nonnull
	public static final Properties fish_1 = new Properties().tab(FishingGroup.instance).fireResistant().stacksTo(1);

	/**
	 * {@link #fish} that {@link Properties#stacksTo(int)} 64
	 */
	@Nonnull
	public static final Properties fish_64 = new Properties().tab(FishingGroup.instance).fireResistant().stacksTo(64);

	/**
	 * {@link Properties} for {@link Item}<br>
	 * {@link MiningGroup}
	 */
	@Nonnull
	public static final Properties mine = new Properties().tab(MiningGroup.instance).fireResistant();

	/**
	 * {@link #mine} that {@link Properties#stacksTo(int)} 1
	 */
	@Nonnull
	public static final Properties mine_1 = new Properties().tab(MiningGroup.instance).fireResistant().stacksTo(1);

	/**
	 * {@link #mine} that {@link Properties#stacksTo(int)} 64
	 */
	@Nonnull
	public static final Properties mine_64 = new Properties().tab(MiningGroup.instance).fireResistant().stacksTo(64);

	/**
	 * {@link Properties} for the {@link Item}<br>
	 * {@link MinionGroup}
	 */
	@Nonnull
	public static final Properties minion = new Properties().tab(MinionGroup.instance).fireResistant();

	/**
	 * {@link #minion} that {@link Properties#stacksTo(int)} 1
	 */
	@Nonnull
	public static final Properties minion_1 = new Properties().tab(MinionGroup.instance).fireResistant().stacksTo(1);

	/**
	 * {@link #minion} that {@link Properties#stacksTo(int)} 64
	 */
	@Nonnull
	public static final Properties minion_64 = new Properties().tab(MinionGroup.instance).fireResistant().stacksTo(64);

	/**
	 * {@link Properties} for the {@link Item}<br>
	 * {@link MiscellaneousGroup}
	 */
	@Nonnull
	public static final Properties miscellaneous = new Properties().tab(MiscellaneousGroup.instance).fireResistant();

	/**
	 * {@link #miscellaneous} that {@link Properties#stacksTo(int)} 1
	 */
	@Nonnull
	public static final Properties miscellaneous_1 = new Properties().tab(MiscellaneousGroup.instance).fireResistant().stacksTo(1);

	/**
	 * {@link #miscellaneous} that {@link Properties#stacksTo(int)} 64
	 */
	@Nonnull
	public static final Properties miscellaneous_64 = new Properties().tab(MiscellaneousGroup.instance).fireResistant().stacksTo(64);
}