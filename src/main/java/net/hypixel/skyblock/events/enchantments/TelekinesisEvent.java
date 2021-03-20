package net.hypixel.skyblock.events.enchantments;

import java.util.List;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.enchantment.EnchantmentInit;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.LootTable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/**
 * Handle {@link EnchantmentInit#telekinesis_tool} and
 * {@link EnchantmentInit#telekinesis_weapon}.
 *
 * @author MrPineapple070
 * @version 16 May 2020
 */
@Mod.EventBusSubscriber(modid = HypixelSkyBlockMod.MOD_ID, bus = Bus.FORGE)
public class TelekinesisEvent {
	/**
	 * Called whenever {@link BreakEvent} is fired. <br>
	 * Move all Block Drops into the Player's inventory if Telekinesis is detected.
	 * <br>
	 * Also add any experience dropped to the player.
	 *
	 * @param event {@code BreakEvent}
	 */
	@SubscribeEvent
	public static void telekinesis(BreakEvent event) {
		final PlayerEntity player = event.getPlayer();
		if (player.isCreative() || player.isSpectator())
			return;
		final int lt = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.telekinesis_tool.get(),
				player.getMainHandItem());
		final int lw = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.telekinesis_weapon.get(),
				player.getMainHandItem());
		if (lt <= 0 && lw <= 0)
			return;
		final IWorld world = event.getWorld();
		final BlockPos pos = event.getPos();
		for (final ItemStack stack : Block.getDrops(world.getBlockState(pos), (ServerWorld) world, pos, null))
			player.addItem(stack);

		world.destroyBlock(pos, false);
		player.giveExperiencePoints(event.getExpToDrop());
		return;
	}

	/**
	 * Called whenever {@link LivingDeathEvent} is fired. <br>
	 * Move all Mob Drops into the Player's inventory if Telekinesis is detected.
	 * <br>
	 * Also add any experience dropped to the player.
	 *
	 * @param event {@code LivingDeathEvent}
	 */
	@SubscribeEvent
	public static void telekinesis(LivingDeathEvent event) {
		final LivingEntity entity = event.getEntityLiving();
		final LivingEntity attacker = entity.getKillCredit();
		final DamageSource source = event.getSource();
		if (!(attacker instanceof PlayerEntity))
			return;
		final PlayerEntity player = (PlayerEntity) attacker;
		if (player.isCreative() || player.isSpectator())
			return;
		final int lt = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.telekinesis_tool.get(),
				player.getMainHandItem());
		final int lw = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.telekinesis_weapon.get(),
				player.getMainHandItem());
		if (lt <= 0 && lw <= 0)
			return;
		LootTable table = entity.level.getServer().getLootTables().get(entity.getLootTable());
		LootContext.Builder builder = (new LootContext.Builder((ServerWorld) entity.level))
				.withRandom(entity.getRandom()).withParameter(LootParameters.THIS_ENTITY, entity)
				.withParameter(LootParameters.ORIGIN, entity.position())
				.withParameter(LootParameters.DAMAGE_SOURCE, source)
				.withOptionalParameter(LootParameters.KILLER_ENTITY, player)
				.withOptionalParameter(LootParameters.DIRECT_KILLER_ENTITY, player)
				.withParameter(LootParameters.LAST_DAMAGE_PLAYER, player).withLuck(player.getLuck());
		LootContext ctx = builder.create(LootParameterSets.ENTITY);
		List<ItemStack> drops = table.getRandomItems(ctx);
		HypixelSkyBlockMod.LOGGER.info(drops.toString());
		for (ItemStack item : drops)
			player.addItem(item);
	}
}