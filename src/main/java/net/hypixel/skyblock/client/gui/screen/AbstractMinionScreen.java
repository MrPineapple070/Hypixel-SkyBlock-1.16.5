package net.hypixel.skyblock.client.gui.screen;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.blocks.minion.AbstractMinionBlock;
import net.hypixel.skyblock.blocks.minion.MinionChestBlock;
import net.hypixel.skyblock.inventory.container.minion.AbstractMinionContainer;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity.MinionTier;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerListener;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Serve as a basis for all Minion Screens
 *
 * @author MrPineapple070
 * @version 6 June 2020
 * @since 6 June 2020
 */
@OnlyIn(Dist.CLIENT)
public final class AbstractMinionScreen extends ContainerScreen<AbstractMinionContainer> {
	/**
	 * Serve as a base for buttons to be displayed on this screen.
	 */
	@OnlyIn(Dist.CLIENT)
	abstract static class Button extends AbstractButton {
		/**
		 * Construct this.
		 *
		 * @param xIn  x coordinate
		 * @param yIn  y coordinate
		 * @param name {@link String} to display on the button.
		 */
		public Button(int xIn, int yIn, String name) {
			super(xIn, yIn + 77, 18, 18, new StringTextComponent(name));
		}
	}

	/**
	 * When this {@link Button} is pressed, automatically empty all {@link Item}
	 * from this {@link AbstractMinionBlock}.<br>
	 * Also empties {@link MinionChestBlock} if the {@link AbstractMinionBlock} has
	 * one. This {@link Button} will not do anything is the
	 * {@link AbstractMinionBlock} is empty.
	 */
	class EmptyButton extends Button {
		private final StringTextComponent tooltip = new StringTextComponent("Empty the Minion of contents");

		public EmptyButton(int x, int y) {
			super(x + 126, y, "\u2193");
		}

		@Override
		public void onPress() {
			LOGGER.info(EmptyButton.class.getSimpleName() + " pressed.");
			// AbstractMinionScreen.this.minecraft.getConnection().sendPacket(null);
		}

		@Override
		public void renderToolTip(MatrixStack stack, int x, int y) {
			AbstractMinionScreen.this.renderTooltip(stack, tooltip, x, y);
		}
	}

	/**
	 * When this {@link Button} is pressed, automatically upgrade this
	 * {@link AbstractMinionBlock} to the next {@link MinionTier}.<br>
	 * This {@link Button} will not do anything if the {@link AbstractMinionBlock}
	 * is at the maximum {@link MinionTier}<br>
	 * or if the {@link PlayerEntity} does not have the required materials.
	 */
	class UpgradeButton extends Button {
		private final StringTextComponent tooltip = new StringTextComponent("Upgrade to next Tier");

		public UpgradeButton(int x, int y) {
			super(x + 90, y, "\u2191");
		}

		@Override
		public void onPress() {
			LOGGER.info(UpgradeButton.class.getSimpleName() + " pressed.");
			// AbstractMinionScreen.this.minecraft.getConnection().sendPacket(new
			// CEmptyMinionPacket());
		}

		@Override
		public void renderToolTip(MatrixStack stack, int x, int y) {
			AbstractMinionScreen.this.renderTooltip(stack, tooltip, x, y);
		}
	}

	/**
	 * The texture for this screen.
	 */
	@Nonnull
	public static final ResourceLocation background_texture = new ResourceLocation(HypixelSkyBlockMod.MOD_ID,
			"textures/gui/abstract_minion_screen.png");

	protected static final TranslationTextComponent fuel = new TranslationTextComponent("gui.minion.fuel");
	protected static final TranslationTextComponent seller = new TranslationTextComponent("gui.minion.seller");
	protected static final TranslationTextComponent boost_0 = new TranslationTextComponent("gui.minion.boost.0");
	protected static final TranslationTextComponent boost_1 = new TranslationTextComponent("gui.minion.boost.1");

	/**
	 * {@link Logger} for this
	 */
	@Nonnull
	protected static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Determine if {@link #upgrade} and {@link #empty} are drawn to the screen.
	 */
	private boolean buttonsNotDrawn;

	/**
	 * {@link EmptyButton} to display on this screen.
	 */
	private EmptyButton empty;

	/**
	 * {@link UpgradeButton} to display on this screen.
	 */
	private UpgradeButton upgrade;

	/**
	 * Construct this.
	 *
	 * @param screenContainer {@link AbstractMinionContainer} to holds this.
	 * @param inv             {@link PlayerInventory} of the player viewing this.
	 * @param titleIn         {@link ITextComponent} for the title.
	 */
	public AbstractMinionScreen(AbstractMinionContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.leftPos = 0;
		this.topPos = 0;
		this.imageHeight = 184;
		this.imageWidth = 176;
		this.width = 256;
		this.height = 256;
		this.menu.addSlotListener(new IContainerListener() {
			@Override
			public void refreshContainer(Container p_71110_1_, NonNullList<ItemStack> p_71110_2_) {
			}

			@Override
			public void setContainerData(Container p_71112_1_, int p_71112_2_, int p_71112_3_) {
				AbstractMinionScreen.this.buttonsNotDrawn = true;
			}

			@Override
			public void slotChanged(Container p_71111_1_, int p_71111_2_, ItemStack p_71111_3_) {
			}
		});
	}

	@Override
	protected void init() {
		super.init();
		this.upgrade = this.addButton(new UpgradeButton(this.leftPos, this.topPos));
		this.empty = this.addButton(new EmptyButton(this.leftPos, this.topPos));
		this.buttonsNotDrawn = true;
		this.upgrade.active = true;
		this.empty.active = true;
	}

	@Override
	public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(stack);
		super.render(stack, mouseX, mouseY, partialTicks);
		this.renderTooltip(stack, mouseX, mouseY);
	}

	@Override
	protected void renderBg(MatrixStack stack, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.blendColor(1f, 1f, 1f, 1f);
		this.minecraft.getTextureManager().bind(background_texture);
		this.blit(stack, (this.width - this.imageWidth) / 2, (this.height - this.imageHeight) / 2, 0, 0,
				this.imageWidth, this.imageHeight);
	}

	@Override
	protected void renderLabels(MatrixStack stack, int mouseX, int mouseY) {
		this.font.draw(stack, this.title, 8, 3, 0x404040);
		this.font.draw(stack, fuel, 8, 19, 0x404040);
		this.font.draw(stack, seller, 8, 37, 0x404040);
		this.font.draw(stack, boost_0, 8, 55, 0x404040);
		this.font.draw(stack, boost_1, 8, 73, 0x404040);
		this.font.draw(stack, this.inventory.getDisplayName(), 8, 91, 0x404040);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.buttonsNotDrawn)
			this.buttonsNotDrawn = false;
	}
}