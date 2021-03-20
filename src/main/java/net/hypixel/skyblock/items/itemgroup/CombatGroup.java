package net.hypixel.skyblock.items.itemgroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CombatGroup extends ItemGroup {
	public static final CombatGroup instance = new CombatGroup(ItemGroup.TABS.length);

	private CombatGroup(int index) {
		super(index, "Combat");
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public ItemStack makeIcon() {
		return new ItemStack(Items.DIAMOND_SWORD);
	}
}