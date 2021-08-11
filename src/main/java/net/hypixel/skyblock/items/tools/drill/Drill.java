package net.hypixel.skyblock.items.tools.drill;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

import net.hypixel.skyblock.items.ModItemRarity;
import net.hypixel.skyblock.items.tools.ModPickaxeItem;
import net.hypixel.skyblock.util.ItemProperties;
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
import net.minecraft.world.World;

/**
 * 
 * 
 * @author MrPineapple070
 * @version 01 August 2021
 * @since 11 July 2019
 */
public class Drill extends ModPickaxeItem {
	/**
	 * The default amount of fuel in a drill.
	 */
	protected static final int default_fuel = 3000;

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
					new StringTextComponent(this.total_fuel + "/3k").withStyle(TextFormatting.DARK_GREEN),
					true);
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
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip,	ITooltipFlag flag) {
		
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