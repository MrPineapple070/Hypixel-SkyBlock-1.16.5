package net.hypixel.skyblock.entity.npc;

import java.util.Arrays;
import java.util.List;

import net.hypixel.skyblock.entity.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

/**
 * 
 * @author MrPineapple070
 * @version 03 March 2021
 * @since 11 July 2019
 */
public class Andrew extends VillageNPC {
	public static final TranslationTextComponent name = new TranslationTextComponent("npc.andrew");
	public static final List<TranslationTextComponent> speach = Arrays
			.asList(new TranslationTextComponent("npc.andrew.0"), new TranslationTextComponent("npc.andrew.1"));

	public Andrew(EntityType<? extends VillageNPC> entityType, World world) {
		this(world);
	}

	public Andrew(World worldIn) {
		super(ModEntityTypes.Andrew.get(), worldIn);
		this.setPosRaw(38, 68, -46);
		this.setCustomName(name);
	}

	@Override
	protected ActionResultType mobInteract(PlayerEntity player, Hand hand) {
		LOGGER.debug("Player:\t" + player.toString());
		LOGGER.debug("Hand:\t" + hand.name());
		player.sendMessage(speach.get(random.nextInt(2)), this.uuid);
		return ActionResultType.SUCCESS;
	}
}