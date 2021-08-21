package net.hypixel.skyblock.items.tools.drill;

/**
 * Holds all Drill Engines.<br>
 * Each drill engine increases mining speed by a certain amount.
 * 
 * @author MrPineapple070
 * @version 14 July 2021
 * @since 15 January 2021
 */
public enum Engine {
	None(0f),
	Mithril(50/35f),
	Titanium(100/35f),
	Ruby(150/35f),
	Sapphire(250/35f),
	Amber(400/35f);
	
	public final float speed;
	
	private Engine(float speed) {
		this.speed = speed;
	}
}