package net.hypixel.skyblock.events.armor;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.items.armor.ModArmorMaterial;
import net.hypixel.skyblock.items.armor.golem.GolemSet;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/**
 * This class will handle all {@link LivingEquipmentChangeEvent}. <br>
 *
 * @author MrPineapple070
 * @version 16 May 2020
 */
@Mod.EventBusSubscriber(modid = HypixelSkyBlockMod.MOD_ID, bus = Bus.FORGE)
public class ArmorEquipEvent {
	/**
	 * Handle {@link LivingEquipmentChangeEvent} for the Golem Set.
	 *
	 * @param event {@code LivingEquipmentChangeEvent}
	 */
	@SubscribeEvent
	public static void golemEquip(LivingEquipmentChangeEvent event) {
		final LivingEntity e = event.getEntityLiving();
		if (!(e instanceof PlayerEntity))
			return;
		final PlayerEntity p = (PlayerEntity) e;

		float health = 0f;
		final ModifiableAttributeInstance max_health = p.getAttribute(Attributes.MAX_HEALTH);
		max_health.addTransientModifier(new AttributeModifier(Attributes.MAX_HEALTH.getDescriptionId(),
				-1 * (p.getMaxHealth() - 20), Operation.ADDITION));

		for (final ItemStack stack : p.getArmorSlots()) {
			final Item item = stack.getItem();
			if (!(item instanceof ArmorItem))
				continue;
			final ArmorItem armor = (ArmorItem) item;
			if (armor.getMaterial() != ModArmorMaterial.Golem)
				continue;
			switch (armor.getSlot()) {
			case HEAD:
				health += GolemSet.helmet_hp;
				break;
			case CHEST:
				health += GolemSet.chestplate_hp;
				break;
			case LEGS:
				health += GolemSet.leggings_hp;
				break;
			case FEET:
				health += GolemSet.boots_hp;
				break;
			default:
				continue;
			}
		}
		max_health.addTransientModifier(
				new AttributeModifier(Attributes.MAX_HEALTH.getDescriptionId(), health, Operation.ADDITION));
	}
}