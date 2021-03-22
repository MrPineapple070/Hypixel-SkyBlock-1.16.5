package net.hypixel.skyblock.items.tools;

import java.util.Objects;
import java.util.Set;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Mod version of {@link ToolItem}
 * 
 * @author MrPineapple070
 * @version 03 December 2020
 * @since 11 July 2019
 */
public class ModToolItem extends TieredItem {
	private final Set<Block> blocks;
	protected final float speed;
	private final float attackDamageBaseline;
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;

	public ModToolItem(IItemTier tier, Set<Block> effectiveOn, Properties properties) {
		super(tier, properties);
		this.blocks = Objects.requireNonNull(effectiveOn, "Effective blocks cannot be null");
		this.speed = tier.getSpeed();
		this.attackDamageBaseline = 0f;
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier",
				(double) this.attackDamageBaseline, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier",
				Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}

	public float getDestroySpeed(ItemStack stack, BlockState block) {
		if (getToolTypes(stack).stream().anyMatch(e -> block.isToolEffective(e)))
			return this.speed;
		return this.blocks.contains(block.getBlock()) ? this.speed : 1f;
	}

	public boolean hurtEnemy(ItemStack stack, LivingEntity attacker, LivingEntity attacked) {
		stack.hurtAndBreak(2, attacked, (entity) -> {
			entity.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
		});
		return true;
	}

	public boolean mineBlock(ItemStack stack, World world, BlockState block, BlockPos pos, LivingEntity user) {
		if (!world.isClientSide && block.getDestroySpeed(world, pos) != 0f)
			stack.hurtAndBreak(1, user, (entity) -> {
				entity.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
			});
		return true;
	}

	@SuppressWarnings("deprecation")
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType p_111205_1_) {
		return p_111205_1_ == EquipmentSlotType.MAINHAND ? this.defaultModifiers
				: super.getDefaultAttributeModifiers(p_111205_1_);
	}

	public float getAttackDamage() {
		return this.attackDamageBaseline;
	}
}