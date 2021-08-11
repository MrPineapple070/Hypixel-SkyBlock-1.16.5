package net.hypixel.skyblock.items.tools;

import java.io.IOException;
import java.util.Objects;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class ModPickaxeItem extends PickaxeItem implements ReforgableItem {
	/**
	 * {@link Logger}
	 */
	@Nonnull
	protected static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * {@link Reforge} that this has.
	 */
	@Nullable
	protected Reforge reforge;
	
	/**
	 * {@link ModItemRarity}
	 */
	@Nonnull
	protected ModItemRarity rarity;
	
	/**
	 * {@link HOTM} for this.
	 */
	protected HOTM hotm;
	
	public ModPickaxeItem(IItemTier tier, Properties properties, ModItemRarity rarity) {
		super(tier, 0, Float.POSITIVE_INFINITY, properties);
		this.rarity = Objects.requireNonNull(rarity, "ModItemRarity cannot be null");
		this.reforge = Reforge.None;
	}
	
	@Override
	public boolean isDamageable(ItemStack stack) {
		return false;
	}
	
	@Override
	public boolean canHarvestBlock(ItemStack stack, BlockState state) {
		if (state.getHarvestTool() != ToolType.PICKAXE)
			return false;
		if (this.getTier().getLevel() < state.getHarvestLevel())
			return false;
		/**
		Material material = state.getMaterial();
		if (material == Material.HEAVY_METAL)
			return true;
		if (material == Material.METAL)
			return true;
		if (material == Material.STONE)
			return true;
		if (material == Material.SHULKER_SHELL)
			return true;
		if (!DIGGABLES.contains(state.getBlock()))
			return false;
		*/
		return true;
	}
	
	@Override
	public ITextComponent getName(ItemStack stack) {
		return new TranslationTextComponent(this.getOrCreateDescriptionId()).withStyle(this.rarity.color);
	}
	
	/**
	 * Initializes {@link #hotm}
	 * 
	 * @param world {@link World} for {@link HOTM}
	 * @param player {@link PlayerEntity} for {@link HOTM}
	 */
	private void hotm(World world, PlayerEntity player) {
		if (this.hotm == null)
			try {
				this.hotm = new HOTM(player, world);
			} catch (IOException e) {
				LOGGER.error(e.getLocalizedMessage());
				return;
			}
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		Material material = state.getMaterial();
		return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE
				? super.getDestroySpeed(stack, state)
				: this.speed;
	}
	
	@Override
	public Reforge getReforge() {
		return this.reforge;
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
}