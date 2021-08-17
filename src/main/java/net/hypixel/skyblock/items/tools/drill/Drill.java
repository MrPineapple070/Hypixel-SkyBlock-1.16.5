package net.hypixel.skyblock.items.tools.drill;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

import net.hypixel.skyblock.blocks.ModMaterial;
import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.tools.ModPickaxeItem;
import net.hypixel.skyblock.items.tools.ModToolTier;
import net.hypixel.skyblock.util.ItemProperties;
import net.hypixel.skyblock.util.StatString;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

/**
 * <a href="https://hypixel-skyblock.fandom.com/wiki/Drills">Drill</a>.<br>
 * 
 * 
 * @author MrPineapple070
 * @version 01 August 2021
 * @since 11 July 2019
 */
public class Drill extends ModPickaxeItem {
	/**
	 * 
	 */
	@Nonnull
	protected static final List<ITextComponent> de_none = Arrays.asList(new TranslationTextComponent("drill.de.1"),
			new TranslationTextComponent("drill.de.2", StatString.mining_speed));

	/**
	 * The default amount of fuel in a drill.
	 */
	protected static final int default_fuel = 3000;
	
	/**
	 * 
	 */
	@Nonnull
	protected static final ITextComponent drill_dm = new TranslationTextComponent("drill.dm");
	
	/**
	 * 
	 */
	@Nonnull
	protected static final List<ITextComponent> ft_none = Arrays.asList(new TranslationTextComponent("drill.ft.1"),
			new TranslationTextComponent("drill.ft.2"));
	
	/**
	 * 
	 */
	@Nonnull
	protected static final List<ITextComponent> up_none = Arrays.asList(new TranslationTextComponent("drill.up.1"),
			new TranslationTextComponent("drill.up.2"));

	/**
	 * {@link Engine} that this drill holds.
	 */
	@Nonnull
	protected Engine engine;

	/**
	 * {@link FuelTank} that this drill holds.
	 */
	@Nonnull
	protected FuelTank fuel_tank;

	/**
	 * Tick
	 */
	protected int tick;

	/**
	 * The total amount of fuel a drill has
	 */
	protected int total_fuel;

	/**
	 * {@link UpgradeModule} that this drill holds.
	 */
	@Nonnull
	protected UpgradeModule upgrade;

	public Drill(IItemTier tier, ModItemRarity rarity) {
		super(tier, ItemProperties.mine_1, rarity);
		this.fuel_tank = FuelTank.None;
		this.total_fuel = default_fuel + this.fuel_tank.fuel;
		this.tick = 0;
		this.engine = Engine.None;
		this.upgrade = UpgradeModule.None;
	}

	@Override
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
		tooltip.add(new TranslationTextComponent("pick.bp", this.getTier().getLevel()));
		tooltip.add(blank);
		tooltip.add(new TranslationTextComponent("pick.ms", this.getTier().getSpeed()));
		tooltip.add(new TranslationTextComponent("pick.mf", 0));
		tooltip.add(blank);
		switch (this.fuel_tank) {
		case Gemstone:
			break;
		case Mithril:
			break;
		case None:
			tooltip.addAll(ft_none);
			break;
		case Perfect:
			break;
		case Titanium:
			break;
		default:
			throw new IllegalStateException("Illegal FuelTank:\t" + this.fuel_tank.name());
		}
		tooltip.add(blank);
		switch (this.engine) {
		case Amber:
			break;
		case Mithril:
			break;
		case None:
			tooltip.addAll(de_none);
			break;
		case Ruby:
			break;
		case Sapphire:
			break;
		case Titanium:
			break;
		default:
			throw new IllegalStateException("Illegal Engine:\t" + this.engine.name());
		}
		tooltip.add(blank);
		switch (this.upgrade) {
		case Blue:
			break;
		case Goblin:
			break;
		case None:
			tooltip.addAll(up_none);
			break;
		case Pesto:
			break;
		case Spicy:
			break;
		case Sunny:
			break;
		default:
			throw new IllegalStateException("Illegal UpgradeModule:\t" + this.upgrade.name());
		}
		tooltip.add(blank);
		tooltip.add(drill_dm);
		tooltip.add(new TranslationTextComponent("drill.fuel",
				new StringTextComponent(String.valueOf(this.total_fuel)).withStyle(TextFormatting.DARK_GREEN)));
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		float speed = super.getDestroySpeed(stack, state);
		if (state.getMaterial() == ModMaterial.Gemstone) {
			speed += ModToolTier.speed(this.getTier());
		}
		return speed;
	}

	public void incrementFuel(int fuel) {
		this.total_fuel += fuel;
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity user, int slot, boolean selected) {
		if (!(user instanceof PlayerEntity))
			return;
		PlayerEntity player = (PlayerEntity) user;
		if (selected)
			player.displayClientMessage(
					new StringTextComponent(this.total_fuel + "/3k").withStyle(TextFormatting.DARK_GREEN), true);
		this.tick = ++this.tick % 100;
		if (this.tick == 0)
			switch (this.upgrade) {
			case Goblin:
				this.total_fuel += 1;
			case Pesto:
				this.total_fuel += 5;
			default:
				return;
			}
	}

	@Override
	public boolean mineBlock(ItemStack stack, World world, BlockState block, BlockPos pos, LivingEntity user) {
		if (this.total_fuel < 1)
			return false;
		if (user instanceof ServerPlayerEntity) {
			ServerPlayerEntity player = (ServerPlayerEntity) user;
			if (player.gameMode.isSurvival()) {
				this.total_fuel--;
				if (this.upgrade == UpgradeModule.Sunny)
					this.total_fuel--;
			}
		}
		return super.mineBlock(stack, world, block, pos, user);
	}
	
	/**
	 * Set {@link Engine}
	 * 
	 * @param engine new {@link Engine}
	 */
	public void setEngine(Engine engine) {
		this.engine = Objects.requireNonNull(engine, "Engine cannot be null");
	}

	/**
	 * Set {@link #fuel_tank}.<br>
	 * Also updates {@link #total_fuel}.
	 * 
	 * @param fuel_tank new {@link FuelTank}
	 */
	public void setFuelTank(FuelTank fuel_tank) {
		this.total_fuel -= this.fuel_tank == FuelTank.None ? this.fuel_tank.fuel : 0;
		this.fuel_tank = Objects.requireNonNull(fuel_tank, "FuelTank cannot be null");
		this.total_fuel += this.fuel_tank.fuel;
	}

	/**
	 * Set {@link #upgrade}
	 * 
	 * @param upgrade new {@link UpgradeModule}
	 */
	public void setUpgrade(UpgradeModule upgrade) {
		this.upgrade = Objects.requireNonNull(upgrade, "UpgradeModule cannot be null");
	}
}