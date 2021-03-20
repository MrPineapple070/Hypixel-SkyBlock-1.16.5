package net.hypixel.skyblock.events.enchantments;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.enchantment.EnchantmentInit;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/**
 * Handle {@link EnchantmentInit#life_steal}
 *
 * @author MrPineapple070
 * @version 16 May 2020
 */
@Mod.EventBusSubscriber(modid = HypixelSkyBlockMod.MOD_ID, bus = Bus.FORGE)
public class LifeStealEvent {
	/**
	 * Call this method whenever {@link LivingAttackEvent} is fired. <br>
	 * Heal the player by .1% of the damage dealt per level.
	 *
	 * @param event {@code LivingAttackEvent}
	 */
	@SubscribeEvent
	public static void lifeSteal(LivingAttackEvent event) {
		final Entity le = event.getSource().getDirectEntity();

		if (le instanceof PlayerEntity) {
			final PlayerEntity p = (PlayerEntity) le;
			if (p.level.isClientSide)
				p.heal(event.getAmount() * 0.001f * EnchantmentHelper.getItemEnchantmentLevel(
						EnchantmentInit.life_steal.get(), p.getItemBySlot(EquipmentSlotType.MAINHAND)));
			else
				return;
		} else
			return;
	}
}
