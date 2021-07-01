package net.hypixel.skyblock.items.tools.drill;

import net.hypixel.skyblock.items.tools.ModPickaxeItem;
import net.hypixel.skyblock.util.ItemProperties;
import net.minecraft.item.IItemTier;

public class Drill extends ModPickaxeItem {
	public Drill(IItemTier tier) {
		super(tier, ItemProperties.mine_1);
	}
}