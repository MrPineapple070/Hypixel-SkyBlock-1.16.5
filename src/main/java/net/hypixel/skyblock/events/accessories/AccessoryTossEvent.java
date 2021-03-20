package net.hypixel.skyblock.events.accessories;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.items.accessories.Accessory;
import net.hypixel.skyblock.items.accessories.CatTalisman;
import net.hypixel.skyblock.items.accessories.CheetahTalisman;
import net.hypixel.skyblock.items.accessories.LynxTalisman;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/**
 * Handle removing effects applied by {@link Accessory}
 *
 * @author MrPineapple070
 * @version 10 September 2020
 * @since 10 September 2020
 */
@Mod.EventBusSubscriber(modid = HypixelSkyBlockMod.MOD_ID, bus = Bus.FORGE)
public class AccessoryTossEvent {
	@SubscribeEvent
	public static void catAccessoryEvent(ItemTossEvent event) {
		final Item thrown = event.getEntityItem().getItem().getItem();
		final PlayerEntity player = event.getPlayer();
		final ModifiableAttributeInstance spd = player.getAttribute(Attributes.MOVEMENT_SPEED);
		if (thrown instanceof CheetahTalisman)
			spd.removeModifier(CheetahTalisman.speed_mod);
		else if (thrown instanceof LynxTalisman)
			spd.removeModifier(LynxTalisman.speed_mod);
		else if (thrown instanceof CatTalisman)
			spd.removeModifier(CatTalisman.speed_mod);
	}

	@SubscribeEvent
	public static void farmingTalismanEvent(ItemTossEvent event) {
		event.getEntityItem().getItem().getItem();
		final PlayerEntity player = event.getPlayer();
		player.level.getBiome(player.blockPosition());
	}
}