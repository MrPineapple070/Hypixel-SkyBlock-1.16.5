package net.hypixel.skyblock.items.accessories;

import java.util.List;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.util.ItemProperties;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class PersonalDeletor extends PersonalAccessory {

	public static final class PersonalDel4000 extends PersonalDeletor {
		public PersonalDel4000() {
			super(ItemProperties.mine_1, ModItemRarity.Uncommon, Type.Type4);
		}
	}
	
	public static final class PersonalDel5000 extends PersonalDeletor {
		public PersonalDel5000() {
			super(ItemProperties.mine_1, ModItemRarity.Rare, Type.Type5);
		}
	}
	
	public static final class PersonalDel6000 extends PersonalDeletor {
		public PersonalDel6000() {
			super(ItemProperties.mine_1, ModItemRarity.Epic, Type.Type6);
		}
	}
	
	public static final class PersonalDel7000 extends PersonalDeletor {
		public PersonalDel7000() {
			super(ItemProperties.mine_1, ModItemRarity.Legendary, Type.Type7);
		}
	}
	
	private static final ITextComponent disc = new TranslationTextComponent("accessory.del");
	
	public PersonalDeletor(Properties properties, ModItemRarity rarity, Type type) {
		super(properties, rarity, type);
	}

	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(disc);
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int tick, boolean selected) {
		if (world.isClientSide)
			return;
		if (!(entity instanceof PlayerEntity))
			return;
		PlayerEntity player = (PlayerEntity) entity;
		for (ItemStack s : this.items) {
			if (stack.isEmpty())
				continue;
			player.inventory.removeItem(s);
		}
	}
}