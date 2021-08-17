package net.hypixel.skyblock.items.tools;

import net.minecraft.block.Block;

/**
 * Pickaxe Abilities.
 * 
 * @author MrPineapple070
 * @version 27 July 2021
 * @since 15 January 2021
 */
public enum PickAbility {
	/**
	 * No Pickaxe Ability
	 */
	None,
	
	/**
	 * Increases Mining Speed by 300.
	 * Lasts for 120 seconds.
	 */
	MSB,
	
	/**
	 * Throws pick and creates an explosion on impact that destroys all
	 * {@link Block}s within a 2 meter radius.
	 */
	Pickobulus,
	
	/**
	 * Converts 10 mana into 1 mining speed.
	 */
	ManicMiner,
	
	/**
	 * Points to the nearest ore vein and grants +2 mining speed
	 */
	VeinSeeker;
}