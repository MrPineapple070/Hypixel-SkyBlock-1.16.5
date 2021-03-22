package net.hypixel.skyblock.items.bows;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.items.HotPotatoBook;
import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.PotatoBookableItem;
import net.hypixel.skyblock.items.ReforgableItem;
import net.hypixel.skyblock.items.Reforge;
import net.hypixel.skyblock.items.UpgradableItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

/**
 * Serve as a base for {@link BowItem}.
 *
 * @author MrPineapple070
 * @version 13 August 2020
 * @since 13 August 2020
 */
public abstract class ModBowItem extends ShootableItem implements ReforgableItem, UpgradableItem, PotatoBookableItem {
	protected static final ITextComponent item_ability = new TranslationTextComponent("bow.ability");
	
	/**
	 * Calculates the power of an arrow based on how long the bow has been pulled.
	 * @param time how long the bow has been pulled.
	 * @return power
	 */
	public static float getPowerForTime(float time) {
		float power = time / 20f;
		power = (power * power + power * 2f) / 3f;
		if (power > 1f)
			power = 1f;
		return power;
	}

	/**
	 * Determine if {@link #rarity} has been changed.
	 */
	protected boolean isUpgraded;

	/**
	 * The number of {@link HotPotatoBook} applied.
	 */
	@Nonnegative
	protected int numPotatoBook;

	/**
	 * {@link ModItemRarity} of this.
	 */
	@Nonnull
	protected ModItemRarity rarity;

	/**
	 * {@link Reforge} of this.
	 */
	@Nullable
	protected Reforge reforge = Reforge.None;

	@Nonnull
	protected ITextComponent reforge_display = StringTextComponent.EMPTY;

	protected ModBowItem(Properties builder, ModItemRarity rarity) {
		super(builder);
		this.rarity = Objects.requireNonNull(rarity, "ModItemRarity cannot be null");
		this.isUpgraded = false;
		this.numPotatoBook = 0;
	}

	@Override
	public abstract void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn);

	@Override
	public final boolean apply() {
		if (this.numPotatoBook == 10)
			return false;
		++this.numPotatoBook;
		return true;
	}

	@Override
	public boolean canBeDepleted() {
		return false;
	}

	/**
	 * Creates a {@link AbstractArrowEntity} to shoot from this.<br>
	 * By default this method does nothing.
	 * 
	 * @param arrow {@link AbstractArrowEntity} to modify
	 * @return modified {@link AbstractArrowEntity}
	 */
	public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
		return arrow;
	}

	@Override
	public final Predicate<ItemStack> getAllSupportedProjectiles() {
		return ARROW_ONLY;
	}
	
	@Override
	public int getDefaultProjectileRange() {
		return 15;
	}

	@Override
	public final ITextComponent getName(ItemStack stack) {
		return ((IFormattableTextComponent) super.getName(stack)).withStyle(this.rarity.color);
	}

	@Override
	public final ModItemRarity getRarity() {
		return this.rarity;
	}

	@Override
	public final Reforge getReforge() {
		return this.reforge;
	}

	@Override
	public final UseAction getUseAnimation(ItemStack stack) {
		return UseAction.BOW;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public final void reforge() {
		this.reforge = BowReforge.getRandomReforge();
		try {
			this.reforge_display = new StringTextComponent(
					this.reforge.getClass().getMethod("name", (Class<?>[]) null).invoke(this.reforge) + "");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			HypixelSkyBlockMod.LOGGER.error(e.getLocalizedMessage());
			for (StackTraceElement element : e.getStackTrace())
				HypixelSkyBlockMod.LOGGER.error(element.toString());
		}
	}

	@Override
	public final void releaseUsing(ItemStack stack, World world, LivingEntity entity, int progress) {
		if (!(entity instanceof PlayerEntity))
			return;
		PlayerEntity player = (PlayerEntity) entity;
		boolean consume_arrow = player.abilities.instabuild
				|| EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
		ItemStack projectile = player.getProjectile(stack);
		Item proj_item = projectile.getItem();
		ArrowItem arrow = (ArrowItem) (proj_item instanceof ArrowItem ? proj_item : Items.ARROW);
		int use_duration = this.getUseDuration(stack) - progress;
		boolean has_ammo = !projectile.isEmpty() || consume_arrow;
		use_duration = ForgeEventFactory.onArrowLoose(stack, world, player, use_duration, has_ammo);
		if (use_duration < 0)
			return;
		if (has_ammo) {
			if (projectile.isEmpty()) {
				projectile = new ItemStack(Items.ARROW);
				float power = getPowerForTime(use_duration);
				if (power >= .1f) {
					boolean is_arrow = player.abilities.instabuild || (arrow.isInfinite(projectile, stack, player));
					if (!world.isClientSide) {
						AbstractArrowEntity arrow_entity = arrow.createArrow(world, projectile, player);
						arrow_entity = customArrow(arrow_entity);
						arrow_entity.shootFromRotation(player, player.xRot, player.yRot, 0f, power * 3f, 1f);
						arrow_entity.setCritArrow(power == 1f);
						int power_level = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
						if (power_level > 0)
							arrow_entity.setBaseDamage(arrow_entity.getBaseDamage() + (double) power_level * .5d + .5d);
						arrow_entity.setKnockback(
								EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack));
						arrow_entity.setSecondsOnFire(
								EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0 ? 100
										: 0);
						stack.hurtAndBreak(1, player, (p_220009_1_) -> {
							p_220009_1_.broadcastBreakEvent(player.getUsedItemHand());
						});
						if (is_arrow || player.abilities.instabuild
								&& (proj_item == Items.SPECTRAL_ARROW || proj_item == Items.TIPPED_ARROW))
							arrow_entity.pickup = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
						world.addFreshEntity(arrow_entity);
					}
					world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT,
							SoundCategory.PLAYERS, 1f, 1f / (random.nextFloat() * .4f + 1.2f) + power * .5f);
					if (!is_arrow && !player.abilities.instabuild) {
						projectile.shrink(1);
						if (projectile.isEmpty())
							player.inventory.removeItem(projectile);
					}
					player.awardStat(Stats.ITEM_USED.get(this));
				}
			}
		}
	}

	@Override
	public final void setRarity(ModItemRarity rarity) {
		HypixelSkyBlockMod.LOGGER.warn("Setting rarity:\t" + rarity.getNext());
		this.rarity = rarity;
	}

	@Override
	public final void setReforge(Reforge reforge) {
		this.reforge = reforge;
	}

	@Override
	public final boolean upgrade() {
		if (this.isUpgraded)
			return false;
		this.rarity = this.rarity.getNext();
		return true;
	}

	public final ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack held = player.getItemInHand(hand);
		boolean isProjectileEmpty = !player.getProjectile(held).isEmpty();
		ActionResult<ItemStack> nock_result = ForgeEventFactory.onArrowNock(held, world, player, hand, isProjectileEmpty);
		if (nock_result != null)
			return nock_result;
		if (!player.abilities.instabuild && !isProjectileEmpty)
			return ActionResult.fail(held);
		player.startUsingItem(hand);
		return ActionResult.consume(held);
	}
}