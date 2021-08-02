package net.hypixel.skyblock.events.accessories;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.items.accessories.HealingRing;
import net.hypixel.skyblock.items.accessories.HealingTalisman;
import net.hypixel.skyblock.items.init.AccessoriesInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/**
 * Handles the effects applied by the {@link HealingRing} and
 * {@link HealingTalisman}.
 *
 * @author MrPineapple070
 * @version 10 September 2020
 * @since 10 September 2020
 */
@Mod.EventBusSubscriber(modid = HypixelSkyBlockMod.MOD_ID, bus = Bus.FORGE)
public class HealingAccessoryEvent {
	private static ItemStack Ring;
	private static ItemStack Talisman;

	private static void init() {
		if (Ring == null)
			Ring = new ItemStack(AccessoriesInit.healing_ring.get());
		if (Talisman == null)
			Talisman = new ItemStack(AccessoriesInit.healing_talisman.get());
	}
	
	// TODO Change to Accessory Bag
	@SubscribeEvent
	public static void healEvent(LivingHealEvent event) {
		init();
		final LivingEntity entity = event.getEntityLiving();
		if (!(entity instanceof PlayerEntity))
			return;
		final PlayerEntity player = (PlayerEntity) entity;
		float heal = event.getAmount();
		final PlayerInventory inv = player.inventory;
		for (int i = 0; i < inv.getContainerSize(); i++) {
			ItemStack stack = inv.getItem(i);
			if (stack.sameItem(Ring)) {
				heal *= 1.1f;
				break;
			} else if (stack.sameItem(Talisman)) {
				heal *= 1.05f;
				break;
			} else
				continue;
		}
		event.setAmount(heal);
	}
}
