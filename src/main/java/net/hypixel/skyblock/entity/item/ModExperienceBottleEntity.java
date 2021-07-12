package net.hypixel.skyblock.entity.item;

import net.hypixel.skyblock.items.ModExperienceBottleItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ExperienceBottleEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * A {@link ExperienceBottleEntity} for {@link ModExperienceBottleItem}
 *
 * @author MrPineapple070
 * @version 20 May 2020
 */
public class ModExperienceBottleEntity extends ExperienceBottleEntity {
	/**
	 * The {@link ModExperienceBottleItem.Type} of this.
	 */
	private final ModExperienceBottleItem.Type type;

	public ModExperienceBottleEntity(EntityType<? extends ExperienceBottleEntity> entityTypeIn, World worldIn,
			ModExperienceBottleItem.Type typeIn) {
		super(entityTypeIn, worldIn);
		this.type = typeIn;
	}

	public ModExperienceBottleEntity(World worldIn, double x, double y, double z, ModExperienceBottleItem.Type typeIn) {
		super(worldIn, x, y, z);
		this.type = typeIn;
	}

	public ModExperienceBottleEntity(World worldIn, LivingEntity throwerIn, ModExperienceBottleItem.Type typeIn) {
		super(worldIn, throwerIn);
		this.type = typeIn;
	}

	@Override
	protected void onHit(RayTraceResult result) {
		RayTraceResult.Type type = result.getType();
		if (type == RayTraceResult.Type.ENTITY)
			this.onHitEntity((EntityRayTraceResult)result);
		else if (type == RayTraceResult.Type.BLOCK)
			this.onHitBlock((BlockRayTraceResult)result);
		this.level.levelEvent(2002, this.blockPosition(), PotionUtils.getColor(Potions.WATER));
		int amount;
		switch (this.type) {
		case GRAND:
			amount = 1500;
			break;
		case TITANIC:
			amount = 250000;
			break;
		default:
			throw new IllegalStateException("Illegal ModExperienceBottleItem.Type:\t" + this.type.name());
		}
		this.level.addFreshEntity(new ExperienceOrbEntity(this.level, this.getX(), this.getY(), this.getZ(), amount));
	}
}
