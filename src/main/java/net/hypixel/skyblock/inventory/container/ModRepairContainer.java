package net.hypixel.skyblock.inventory.container;

import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.hypixel.skyblock.inventory.container.init.ModContainerTypes;
import net.hypixel.skyblock.items.init.MenuItemInit;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.RepairContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;

/**
 * Override {@link RepairContainer}
 * 
 * @author MrPineapple070
 * @version 30 March 2021
 * @since 11 July 2019
 */
public class ModRepairContainer extends Container {
	/**
	 * {@link Logger} for this
	 */
	private static final Logger LOGGER = LogManager.getLogger();

	public static int calculateIncreasedRepairCost(int cost) {
		return cost * 2 + 1;
	}

	public static boolean onAnvilChange(ModRepairContainer container, ItemStack left, ItemStack right,
			IInventory outputSlot, int baseCost, PlayerEntity player) {
		AnvilUpdateEvent e = new AnvilUpdateEvent(left, right, left.getDisplayName().getString(), baseCost, player);
		if (MinecraftForge.EVENT_BUS.post(e))
			return false;
		if (e.getOutput().isEmpty())
			return true;

		outputSlot.setItem(0, e.getOutput());
		container.setMaximumCost(e.getCost());
		container.repairItemCountCost = e.getMaterialCost();
		return false;
	}

	/**
	 * {@link IWorldPosCallable} access to this
	 */
	protected final IWorldPosCallable access;

	/**
	 * {@link IntReferenceHolder} for this
	 */
	protected final IntReferenceHolder cost = IntReferenceHolder.standalone();

	/**
	 * Input {@link IInventory}
	 */
	protected final IInventory inputSlots = new Inventory(2) {
		public void setChanged() {
			super.setChanged();
			ModRepairContainer.this.slotsChanged(this);
		}
	};

	/**
	 * {@link IInventory} to hold gui
	 */
	protected final IInventory close = new Inventory(1);

	/**
	 * {@link PlayerEntity} interacting with this
	 */
	protected final PlayerEntity player;

	/**
	 * Cost to repair item
	 */
	public int repairItemCountCost;

	/**
	 * {@link CraftResultInventory}
	 */
	protected final CraftResultInventory resultSlots = new CraftResultInventory();

	public ModRepairContainer(int windowId, PlayerInventory inventory) {
		this(windowId, inventory, IWorldPosCallable.NULL);
	}

	public ModRepairContainer(int windowId, PlayerInventory inventory, IWorldPosCallable access) {
		super(ModContainerTypes.anvil.get(), windowId);
		this.access = Objects.requireNonNull(access, "IWorldPosCallable cannot be null");
		this.player = Objects.requireNonNull(inventory, "PlayerInventory cannot be null").player;
		this.addSlot(new Slot(inputSlots, 0, 0, 0));
		this.addSlot(new GUISlot(close, 4, 0, 0, MenuItemInit.close.get()));
		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 9; ++j)
				this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
		for (int k = 0; k < 9; ++k)
			this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
		LOGGER.debug(this.getType().toString());
	}

	public ModRepairContainer(int windowId, PlayerInventory inventory, PacketBuffer buffer) {
		this(windowId, inventory);
	}

	/**
	 * Creates {@link ItemStack} and places it into {@link #resultSlots}
	 */
	public void createResult() {
		LOGGER.debug("Creating Result");
		ItemStack left = this.inputSlots.getItem(0);
		this.cost.set(1);
		int i = 0;
		int j = 0;
		int k = 0;
		if (left.isEmpty()) {
			this.resultSlots.setItem(0, ItemStack.EMPTY);
			this.cost.set(0);
		} else {
			ItemStack left_copy = left.copy();
			ItemStack right = this.inputSlots.getItem(1);
			Map<Enchantment, Integer> left_enchantments = EnchantmentHelper.getEnchantments(left_copy);
			j = j + left.getBaseRepairCost() + (right.isEmpty() ? 0 : right.getBaseRepairCost());
			this.repairItemCountCost = 0;
			boolean isBook = false;

			if (!right.isEmpty())
				if (!onAnvilChange(this, left, right, resultSlots, j, this.player))
					return;
			isBook = right.getItem() == Items.ENCHANTED_BOOK && !EnchantedBookItem.getEnchantments(right).isEmpty();
			if (left_copy.isDamageableItem() && left_copy.getItem().isValidRepairItem(left, right)) {
				int damage_value = Math.min(left_copy.getDamageValue(), left_copy.getMaxDamage() / 4);
				if (damage_value <= 0) {
					this.resultSlots.setItem(0, ItemStack.EMPTY);
					this.cost.set(0);
					return;
				}
				int repair_cost;
				for (repair_cost = 0; damage_value > 0 && repair_cost < right.getCount(); ++repair_cost) {
					left_copy.setDamageValue(left_copy.getDamageValue() - damage_value);
					++i;
					damage_value = Math.min(left_copy.getDamageValue(), left_copy.getMaxDamage() / 4);
				}

				this.repairItemCountCost = repair_cost;
			} else {
				if (!isBook && (left_copy.getItem() != right.getItem() || !left_copy.isDamageableItem())) {
					this.resultSlots.setItem(0, ItemStack.EMPTY);
					this.cost.set(0);
					return;
				}

				if (left_copy.isDamageableItem() && !isBook) {
					int left_damage = left.getMaxDamage() - left.getDamageValue();
					int right_damage = right.getMaxDamage() - right.getDamageValue();
					int damage = left_copy.getMaxDamage()
							- (left_damage + right_damage + left_copy.getMaxDamage() * 12 / 100);
					if (damage < 0)
						damage = 0;

					if (damage < left_copy.getDamageValue()) {
						left_copy.setDamageValue(damage);
						i += 2;
					}
				}

				Map<Enchantment, Integer> right_enchantments = EnchantmentHelper.getEnchantments(right);
				boolean flag2 = false;
				boolean flag3 = false;

				for (Enchantment ench : right_enchantments.keySet()) {
					if (ench != null) {
						int left_lvl = left_enchantments.getOrDefault(ench, 0);
						int right_lvl = right_enchantments.get(ench);
						right_lvl = left_lvl == right_lvl ? right_lvl + 1 : Math.max(right_lvl, left_lvl);
						boolean canEnchant = ench.canEnchant(left);
						if (this.player.abilities.instabuild || left.getItem() == Items.ENCHANTED_BOOK)
							canEnchant = true;

						for (Enchantment enchantment : left_enchantments.keySet())
							if (enchantment != ench && !ench.isCompatibleWith(enchantment)) {
								canEnchant = false;
								++i;
							}

						if (!canEnchant)
							flag3 = true;
						else {
							flag2 = true;
							if (right_lvl > ench.getMaxLevel())
								right_lvl = ench.getMaxLevel();

							left_enchantments.put(ench, right_lvl);
							int rarity = 0;
							switch (ench.getRarity()) {
							case COMMON:
								rarity = 1;
								break;
							case UNCOMMON:
								rarity = 2;
								break;
							case RARE:
								rarity = 4;
								break;
							case VERY_RARE:
								rarity = 8;
							}

							if (isBook)
								rarity = Math.max(1, rarity / 2);
							i += rarity * right_lvl;
							if (left.getCount() > 1)
								i = 40;
						}
					}
				}

				if (flag3 && !flag2) {
					this.resultSlots.setItem(0, ItemStack.EMPTY);
					this.cost.set(0);
					return;
				}
			}
			if (isBook && !left_copy.isBookEnchantable(right))
				left_copy = ItemStack.EMPTY;
			this.cost.set(j + i);
			if (i <= 0)
				left_copy = ItemStack.EMPTY;
			if (k == i && k > 0 && this.cost.get() >= 40)
				this.cost.set(39);
			if (this.cost.get() >= 40 && !this.player.abilities.instabuild)
				left_copy = ItemStack.EMPTY;
			if (!left_copy.isEmpty()) {
				int repairCost = left_copy.getBaseRepairCost();
				if (!right.isEmpty() && repairCost < right.getBaseRepairCost())
					repairCost = right.getBaseRepairCost();
				if (k != i || k == 0)
					repairCost = calculateIncreasedRepairCost(repairCost);
				left_copy.setRepairCost(repairCost);
				EnchantmentHelper.setEnchantments(left_enchantments, left_copy);
			}
			this.resultSlots.setItem(0, left_copy);
			this.broadcastChanges();
		}
	}

	public ItemStack quickMoveStack(PlayerEntity player, int index) {
		ItemStack output = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack stack = slot.getItem();
			output = stack.copy();
			if (index == 2) {
				if (!this.moveItemStackTo(stack, 3, 39, true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(stack, output);
			} else if (index != 0 && index != 1) {
				if (index >= 3 && index < 39)
					if (!this.moveItemStackTo(stack, 0, 2, false))
						return ItemStack.EMPTY;
			} else if (!this.moveItemStackTo(stack, 3, 39, false))
				return ItemStack.EMPTY;

			if (stack.isEmpty())
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();

			if (stack.getCount() == output.getCount())
				return ItemStack.EMPTY;

			slot.onTake(player, stack);
		}

		return output;
	}

	public void setMaximumCost(int value) {
		this.cost.set(value);
	}

	@Override
	public boolean stillValid(PlayerEntity player) {
		return true;
	}
}