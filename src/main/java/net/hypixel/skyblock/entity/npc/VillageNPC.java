package net.hypixel.skyblock.entity.npc;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.INPC;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap.MutableAttribute;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public abstract class VillageNPC extends Entity implements INPC {
	public VillageNPC(EntityType<? extends Entity> type, World worldIn) {
		super(type, worldIn);
		LOGGER.info(type.getRegistryName().toString() + " created");
	}

	public static MutableAttribute createAttributes() {
		return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, Double.MAX_VALUE)
				.add(Attributes.MOVEMENT_SPEED, 0);
	}

	@Override
	protected final void defineSynchedData() {
		this.setInvulnerable(true);
		this.setNoGravity(true);
		this.setSilent(true);
		this.setCustomNameVisible(true);
	}

	@Override
	public abstract ActionResultType interact(PlayerEntity player, Hand hand);

	@Override
	protected void readAdditionalSaveData(CompoundNBT compound) {
		LOGGER.info("Reading:\t" + compound.toString());
	}

	@Override
	protected void addAdditionalSaveData(CompoundNBT compound) {
		LOGGER.info("Writing:\t" + compound.toString());
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		return new SSpawnObjectPacket(this);
	}
}