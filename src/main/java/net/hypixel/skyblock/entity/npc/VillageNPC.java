package net.hypixel.skyblock.entity.npc;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.INPC;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.MerchantOffer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public abstract class VillageNPC extends AbstractVillagerEntity implements INPC {
	public VillageNPC(EntityType<? extends AbstractVillagerEntity> type, World worldIn) {
		super(type, worldIn);
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(Double.POSITIVE_INFINITY);
		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0d);
		LOGGER.info(type.getRegistryName().toString() + " created");
	}

	@Override
	protected final void defineSynchedData() {
		this.setInvulnerable(true);
		this.setNoGravity(true);
		this.setSilent(true);
		this.setCustomNameVisible(true);
	}
	
	@Override
	protected abstract ActionResultType mobInteract(PlayerEntity player, Hand hand);

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
		LOGGER.info("Reading:\t" + compound.toString());
	}

	@Override
	public void addAdditionalSaveData(CompoundNBT compound) {
		LOGGER.info("Writing:\t" + compound.toString());
	}
	
	@Override
	protected void rewardTradeXp(MerchantOffer p_213713_1_) {
	}

	@Override
	protected void updateTrades() {
	}

	@Override
	public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		return this;
	}
}