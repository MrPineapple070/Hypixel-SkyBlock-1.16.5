package net.hypixel.skyblock.tileentity.minion;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.LootTable;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.DamageSource;
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
		LOGGER.debug(this.summoned.toString());
		if (this.summoned.isEmpty())
			this.summoned.offer(summon.spawn((ServerWorld) this.level, null, null, null, this.pickBlockPos(),
					SpawnReason.TRIGGERED, true, true));
		else {
			LivingEntity killed = (LivingEntity) this.summoned.poll();
			LootTable table = killed.level.getServer().getLootTables().get(killed.getLootTable());
			LootContext.Builder builder = new LootContext.Builder((ServerWorld) this.level)
					.withRandom(killed.getRandom()).withParameter(LootParameters.THIS_ENTITY, killed)
					.withParameter(LootParameters.ORIGIN, killed.position())
					.withParameter(LootParameters.DAMAGE_SOURCE, DamageSource.GENERIC);
			LootContext ctx = builder.create(LootParameterSets.ENTITY);
			List<ItemStack> drops = table.getRandomItems(ctx);
			LOGGER.info(drops.toString());
			this.addItemStacks(drops);
			killed.remove();
		}
	}
}