package net.hypixel.skyblock.events.accessories;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.items.init.AccessoriesInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.entity.living.PotionEvent.PotionAddedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/**
 * @author MrPineapple070
 * @version 11 September 2020
 * @since 11 September 2020
 */
@Mod.EventBusSubscriber(modid = HypixelSkyBlockMod.MOD_ID, bus = Bus.FORGE)
public class PotionAffinityAccessoryEvent {
	private static ItemStack Artifact;
	private static ItemStack Ring;
	private static ItemStack Talisman;

	private static void initItemStack() {
		if (Artifact == null)
			Artifact = new ItemStack(AccessoriesInit.potion_affinity_artifact.get());
		if (Ring == null)
			Ring = new ItemStack(AccessoriesInit.potion_affinity_ring.get());
		if (Talisman == null)
			Talisman = new ItemStack(AccessoriesInit.potion_affinity_talisman.get());
	}

	// TODO Change to Accessory Bag
	@SubscribeEvent
	public static void potionAffinityEvent(PotionAddedEvent event) {
		initItemStack();
		final EffectInstance effect = event.getPotionEffect();
		final LivingEntity entity = event.getEntityLiving();
		if (!(entity instanceof PlayerEntity))
			return;
		final PlayerEntity player = (PlayerEntity) entity;
		final PlayerInventory inv = player.inventory;
		float scaler = 1f;
		for (int i = 0; i < inv.getContainerSize(); ++i) {
			ItemStack stack = inv.getItem(i);
			if (stack.sameItem(Artifact)) {
				scaler = 1.5f;
				break;
			} else if (stack.sameItem(Ring)) {
				scaler = 1.25f;
				break;
			} else if (stack.sameItem(Talisman)) {
				scaler = 1.1f;
			} else
				continue;
		}
		int duration = effect.getDuration();
		effect.update(new EffectInstance(effect.getEffect(), (int) (duration * scaler), effect.getAmplifier()));
	}
}