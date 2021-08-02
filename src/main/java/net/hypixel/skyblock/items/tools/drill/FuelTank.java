package net.hypixel.skyblock.items.tools.drill;

public enum FuelTank {
	None(0),
	Mithril(10000),
	Titanium(25000),
	Gemstone(50000),
	Perfect(100000);
	
	public final int fuel;
	
	private FuelTank(int fuel) {
		this.fuel = fuel;
	}
}