package net.hypixel.skyblock.entity.npc;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.world.World;

public class MayorEntity extends Entity {
	public MayorEntity(EntityType<? extends Entity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void defineSynchedData() {
		this.setInvulnerable(true);
		this.setNoGravity(true);
		this.setSilent(true);
		this.setCustomNameVisible(true);
	}

	@Override
	protected void readAdditionalSaveData(CompoundNBT nbt) {
		LOGGER.info("Reading:\t" + nbt.toString());
	}

	@Override
	protected void addAdditionalSaveData(CompoundNBT nbt) {
		LOGGER.info("Adding:\t" + nbt.toString());
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		return new SSpawnObjectPacket(this);
	}
}