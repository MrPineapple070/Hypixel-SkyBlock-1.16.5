package net.hypixel.skyblock.tileentity.minion;

import javax.annotation.Nonnull;

import net.hypixel.skyblock.inventory.container.minion.BlazeMinionContainer.BlazeMC1;
import net.hypixel.skyblock.inventory.container.minion.BlazeMinionContainer.BlazeMC2;
import net.hypixel.skyblock.inventory.container.minion.BlazeMinionContainer.BlazeMC3;
import net.hypixel.skyblock.inventory.container.minion.BlazeMinionContainer.BlazeMC4;
import net.hypixel.skyblock.inventory.container.minion.BlazeMinionContainer.BlazeMC5;
import net.hypixel.skyblock.inventory.container.minion.BlazeMinionContainer.BlazeMC6;
import net.hypixel.skyblock.inventory.container.minion.BlazeMinionContainer.BlazeMC7;
import net.hypixel.skyblock.inventory.container.minion.BlazeMinionContainer.BlazeMC8;
import net.hypixel.skyblock.inventory.container.minion.BlazeMinionContainer.BlazeMC9;
import net.hypixel.skyblock.inventory.container.minion.BlazeMinionContainer.BlazeMCa;
import net.hypixel.skyblock.inventory.container.minion.BlazeMinionContainer.BlazeMCb;
import net.hypixel.skyblock.items.init.ItemInit;
import net.hypixel.skyblock.tileentity.ModTileEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.StringTextComponent;

public class BlazeMinionTileEntity extends AbstractSummonerMTE {
	@Nonnull
	protected static final int[] speed = { 660, 660, 620, 620, 570, 570, 500, 500, 420, 420, 330 };
	
	@Nonnull
	protected static final ItemStack drop = new ItemStack(Items.BLAZE_ROD);

	public static class BlazeMTE1 extends BlazeMinionTileEntity {
		public BlazeMTE1() {
			super(ModTileEntityTypes.blaze_minion_1.get(), MinionTier.I);
		}
	}

	public static class BlazeMTE2 extends BlazeMinionTileEntity {
		public BlazeMTE2() {
			super(ModTileEntityTypes.blaze_minion_2.get(), MinionTier.II);
		}
	}

	public static class BlazeMTE3 extends BlazeMinionTileEntity {
		public BlazeMTE3() {
			super(ModTileEntityTypes.blaze_minion_3.get(), MinionTier.III);
		}
	}

	public static class BlazeMTE4 extends BlazeMinionTileEntity {
		public BlazeMTE4() {
			super(ModTileEntityTypes.blaze_minion_4.get(), MinionTier.IV);
		}
	}

	public static class BlazeMTE5 extends BlazeMinionTileEntity {
		public BlazeMTE5() {
			super(ModTileEntityTypes.blaze_minion_5.get(), MinionTier.V);
		}
	}

	public static class BlazeMTE6 extends BlazeMinionTileEntity {
		public BlazeMTE6() {
			super(ModTileEntityTypes.blaze_minion_6.get(), MinionTier.VI);
		}
	}

	public static class BlazeMTE7 extends BlazeMinionTileEntity {
		public BlazeMTE7() {
			super(ModTileEntityTypes.blaze_minion_7.get(), MinionTier.VII);
		}
	}

	public static class BlazeMTE8 extends BlazeMinionTileEntity {
		public BlazeMTE8() {
			super(ModTileEntityTypes.blaze_minion_8.get(), MinionTier.VIII);
		}
	}

	public static class BlazeMTE9 extends BlazeMinionTileEntity {
		public BlazeMTE9() {
			super(ModTileEntityTypes.blaze_minion_9.get(), MinionTier.IX);
		}
	}

	public static class BlazeMTEa extends BlazeMinionTileEntity {
		public BlazeMTEa() {
			super(ModTileEntityTypes.blaze_minion_a.get(), MinionTier.X);
		}
	}

	public static class BlazeMTEb extends BlazeMinionTileEntity {
		public BlazeMTEb() {
			super(ModTileEntityTypes.blaze_minion_b.get(), MinionTier.XI);
		}
	}

	public BlazeMinionTileEntity(TileEntityType<? extends AbstractSummonerMTE> type, MinionTier tier) {
		super(type, tier, EntityType.BLAZE);
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		switch (this.tier) {
		case I:
			return new BlazeMC1(id, player);
		case II:
			return new BlazeMC2(id, player);
		case III:
			return new BlazeMC3(id, player);
		case IV:
			return new BlazeMC4(id, player);
		case V:
			return new BlazeMC5(id, player);
		case VI:
			return new BlazeMC6(id, player);
		case VII:
			return new BlazeMC7(id, player);
		case VIII:
			return new BlazeMC8(id, player);
		case IX:
			return new BlazeMC9(id, player);
		case X:
			return new BlazeMCa(id, player);
		case XI:
			return new BlazeMCb(id, player);
		default:
			throw new IllegalStateException("Illegal MinionTier:\t" + this.tier.name());
		}
	}

	@Override
	protected Item[] getSuperCompactor() {
		return new Item[] { Items.DIAMOND, Items.DIAMOND_BLOCK, ItemInit.enchanted_diamond.get(), Items.BLAZE_ROD };
	}

	@Override
	protected StringTextComponent initDisplayName() {
		return new StringTextComponent("Blaze Minion Tier " + this.tier.name());
	}

	@Override
	protected int getSpeed(MinionTier tier) {
		return speed[tier.asInt];
	}

	@Override
	protected void removeEntity() {
		this.summoned.poll().remove();
		this.addItemStacks(drop);
	}
}