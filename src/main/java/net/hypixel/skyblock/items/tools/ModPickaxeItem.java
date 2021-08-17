package net.hypixel.skyblock.items.tools;

import java.io.IOException;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.hypixel.skyblock.hotm.HOTM;
import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.ReforgableItem;
import net.hypixel.skyblock.items.Reforge;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class ModPickaxeItem extends PickaxeItem implements ReforgableItem {
	/**
	 * {@link StringTextComponent} holding just a newline character.
	 */
	@Nonnull
	protected static final StringTextComponent blank = new StringTextComponent("\u0020");

	/**
	 * {@link Logger}
	 */
	@Nonnull
	protected static final Logger LOGGER = LogManager.getLogger();

	/**
	 * {@link ITextComponent} for {@link PickAbility#ManicMiner}
	 */
	@Nonnull
	protected static final ITextComponent manic_miner = new TranslationTextComponent("pick.manic_miner");

	/**
	 * {@link ITextComponent} for {@link PickAbility#MSB}
	 */
	@Nonnull
	protected static final ITextComponent msb = new TranslationTextComponent("pick.msb");

	/**
	 * {@link ITextComponent} for {@link PickAbility#Pickobulus}
	 */
	@Nonnull
	protected static final ITextComponent pickobulus = new TranslationTextComponent("pick.pickobulus");

	/**
	 * {@link ITextComponent} for {@link PickAbility#VeinSeeker}
	 */
	@Nonnull
	protected static final ITextComponent vein_seeker = new TranslationTextComponent("pick.vein_seeker");

	/**
	 * {@link PickAbility}
	 */
	@Nonnull
	protected PickAbility ability;

	/**
	 * Determines if {@link #ability} is active.
	 */
	protected boolean active;

	/**
	 * {@link HOTM} for this.
	 */
	protected HOTM hotm;

	/**
	 * {@link ModItemRarity}
	 */
	@Nonnull
	protected ModItemRarity rarity;

	/**
	 * {@link Reforge} that this has.
	 */
	@Nullable
	protected Reforge reforge;

	/**
	 * {@link TimerTask}
	 */
	protected final TimerTask task = new TimerTask() {
		@Override
		public void run() {
			ModPickaxeItem.this.active = false;
		}
	};

	/**
	 * {@link Timer}
	 */
	protected Timer timer = new Timer();

	public ModPickaxeItem(IItemTier tier, Properties properties, ModItemRarity rarity) {
		super(tier, 0, Float.POSITIVE_INFINITY, properties);
		this.rarity = Objects.requireNonNull(rarity, "ModItemRarity cannot be null");
		this.reforge = Reforge.None;
		this.ability = PickAbility.MSB;
		this.active = false;
	}

	@Override
	public boolean canHarvestBlock(ItemStack stack, BlockState state) {
		if (state.getHarvestTool() != ToolType.PICKAXE)
			return false;
		if (this.getTier().getLevel() < state.getHarvestLevel())
			return false;
		return true;
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		Material material = state.getMaterial();
		return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE
				? super.getDestroySpeed(stack, state)
				: this.speed;
	}

	@Override
	public ITextComponent getName(ItemStack stack) {
		return new TranslationTextComponent(this.getOrCreateDescriptionId()).withStyle(this.rarity.color);
	}

	@Override
	public Reforge getReforge() {
		return this.reforge;
	}

	/**
	 * Initializes {@link #hotm}
	 * 
	 * @param world  {@link World} for {@link HOTM}
	 * @param player {@link PlayerEntity} for {@link HOTM}
	 */
	private void hotm(World world, PlayerEntity player) {
		if (this.hotm == null)
			try {
				this.hotm = new HOTM(player);
			} catch (IOException e) {
				LOGGER.error(e.getLocalizedMessage());
				return;
			}
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState state) {
		int level = this.getTier().getLevel();
		if (state.getHarvestTool() == ToolType.PICKAXE)
			return level >= state.getHarvestLevel();
		Material material = state.getMaterial();
		return material == Material.STONE || material == Material.METAL || material == Material.HEAVY_METAL;
	}

	@Override
	public boolean isDamageable(ItemStack stack) {
		return false;
	}

	@Override
	public boolean mineBlock(ItemStack stack, World world, BlockState block, BlockPos pos, LivingEntity user) {
		if (user instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) user;
			this.hotm(world, player);
			try {
				this.hotm.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public void reforge() {
		LOGGER.error("Reforge method called on ModPickaxeItem. This is irregular behavior");
	}

	@Override
	public void setReforge(Reforge reforge) {
		this.reforge = reforge;
	}

	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack held = player.getItemInHand(hand);
		if (world.isClientSide)
			return ActionResult.pass(held);
		LOGGER.debug("Using PickAbility:\t" + this.ability.name());
		switch (this.ability) {
		case MSB:
			player.sendMessage(msb, player.getUUID());
			this.timer.schedule(this.task, 120000);
			player.getCooldowns().addCooldown(this, 20 * 120);
			return ActionResult.success(held);
		case ManicMiner:
			player.displayClientMessage(manic_miner, false);
			return ActionResult.success(held);
		case None:
			return ActionResult.pass(held);
		case Pickobulus:
			player.displayClientMessage(pickobulus, false);
			return ActionResult.success(held);
		case VeinSeeker:
			player.displayClientMessage(vein_seeker, false);
			return ActionResult.success(held);
		default:
			throw new IllegalStateException("Illegal PickAbility:\t" + this.ability.name());
		}
	}
}