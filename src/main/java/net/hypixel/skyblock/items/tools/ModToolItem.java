package net.hypixel.skyblock.items.tools;

import java.util.Objects;
import java.util.Set;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.UpgradableItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

/**
 * Mod version of {@link ToolItem}
 * 
 * @author MrPineapple070
 * @version 03 December 2020
 * @since 11 July 2019
 */
@Deprecated
public class ModToolItem extends TieredItem implements UpgradableItem {
	/**
	 * {@link Logger}
	 */
	@Nonnull
	protected static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * {@link Set} of {@link Block} that this tool can break.
	 */
	@Nonnull
	private final Set<Block> blocks;
	
	/**
	 * {@link Multimap} from {@link Attribute} to {@link AttributeModifier}
	 */
	@Nonnull
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;
	
	/**
	 * {@link ModItemRarity}
	 */
	@Nonnull
	protected ModItemRarity rarity;
	
	/**
	 * Speed that this tool can break.
	 */
	protected final float speed;

	public ModToolItem(IItemTier tier, Set<Block> effectiveOn, Properties properties, ModItemRarity rarity) {
		super(tier, properties);
		this.blocks = Objects.requireNonNull(effectiveOn, "Effective blocks cannot be null");
		this.speed = tier.getSpeed();
		this.rarity = Objects.requireNonNull(rarity, "ModItemRarity cannot be null");
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		this.defaultModifiers = builder.build();
	}
	
	@Override
	@Deprecated
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slot) {
		return slot == EquipmentSlotType.MAINHAND ? this.defaultModifiers
				: super.getDefaultAttributeModifiers(slot);
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, BlockState block) {
		if (getToolTypes(stack).stream().anyMatch(e -> block.isToolEffective(e)))
			return this.speed;
		return this.blocks.contains(block.getBlock()) ? this.speed : 1f;
	}
	
	@Override
	public ITextComponent getName(ItemStack stack) {
		return new TranslationTextComponent(this.getOrCreateDescriptionId()).withStyle(this.rarity.color);
	}

	@Override
	public ModItemRarity getRarity() {
		return null;
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity attacker, LivingEntity attacked) {
		stack.hurtAndBreak(2, attacked, (entity) -> {
			entity.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
		});
		return true;
	}
	
	@Override
	public boolean mineBlock(ItemStack stack, World world, BlockState block, BlockPos pos, LivingEntity user) {
		if (!world.isClientSide && block.getDestroySpeed(world, pos) != 0f)
			stack.hurtAndBreak(1, user, (entity) -> {
				entity.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
			});
		return this.getTier().getLevel() <= block.getHarvestLevel();
	}

	@Override
	public void setRarity(ModItemRarity rarity) {
		this.rarity = Objects.requireNonNull(rarity, "ModItemRarity cannot be null");
	}

	@Override
	public boolean upgrade() {
		switch (this.rarity) {
		case Legendary:
		case Mythic:
			return false;
		default:
			this.rarity = this.rarity.getNext();
			return true;
		}
	}
}