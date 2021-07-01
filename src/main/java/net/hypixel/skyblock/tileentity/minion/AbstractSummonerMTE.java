package net.hypixel.skyblock.tileentity.minion;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public abstract class AbstractSummonerMTE extends AbstractMinionTileEntity {
	protected final EntityType<? extends Entity> summon;

	protected final Queue<Entity> summoned = new LinkedList<>();

	public AbstractSummonerMTE(TileEntityType<? extends AbstractSummonerMTE> typeIn, MinionTier tier,
			EntityType<? extends Entity> summon) {
		super(typeIn, tier);
		this.summon = Objects.requireNonNull(summon, "Entity to summon cannot be null");
	}
	
	protected abstract void removeEntity();

	@Override
	protected Item[] getCompactor() {
		return COMP;
	}

	@Override
	protected BlockPos[][][] initSurround() {
		return new BlockPos[0][0][0];
	}

	@Override
	protected BlockPos pickBlockPos() {
		return this.worldPosition;
	}
	
	@Override
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
		
		ListNBT listnbt = new ListNBT();
		
		for (Entity entity : this.summoned) {
			CompoundNBT nbt = new CompoundNBT();
			entity.save(nbt);
			listnbt.add(nbt);
		}
		
		compound.put("Entities", listnbt);
		LOGGER.debug("NBT:\t" + compound.toString());
		return compound;
	}
	
	@Override
	public void load(BlockState blockState, CompoundNBT compound) {
		if (!(this.level instanceof ServerWorld))
			return;
		super.load(blockState, compound);
		
		ListNBT list = compound.getList("Entities", 10);
		ServerWorld world = (ServerWorld) this.level;
		
		for (int i = 0; i < list.size(); ++i)
			this.summoned.offer(world.getEntity(list.getCompound(i).getUUID("UUID")));
		
		LOGGER.debug(this.summoned.toString());
	}

	@Override
	protected void setSurround() {
		return;
	}

	@Override
	protected void setValidSurround() {
		return;
	}

	@Override
	public void tick() {
		if (this.level.isClientSide)
			return;
		if (!this.isTicking)
			this.init();
		if (this.isCompletlyFull())
			return;
		this.tick = ++this.tick % (int) (this.getSpeed(this.tier) * this.getFuelSpeed());
		if (this.tick != 0)
			return;
		if (this.summoned.size() < 5)
			this.summoned.offer(summon.spawn((ServerWorld) this.level, null, null, null, this.pickBlockPos(),
					SpawnReason.TRIGGERED, true, true));
		else
			this.removeEntity();
	}
}