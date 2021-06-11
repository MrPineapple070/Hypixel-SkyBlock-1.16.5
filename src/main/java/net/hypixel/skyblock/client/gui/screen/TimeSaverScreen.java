package net.hypixel.skyblock.client.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.blocks.TimeSaver;
import net.hypixel.skyblock.inventory.container.TimeSaverContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

/**
 * A {@link ContainerScreen} that allows the {@link PlayerEntity} to interact
 * with {@link TimeSaver}.
 *
 * @author MrPineapple070
 * @version 07 October 2020
 * @since 07 October 2020
 */
public class TimeSaverScreen extends ContainerScreen<TimeSaverContainer> {
	/**
	 * The texture for this screen.
	 */
	public static final ResourceLocation background_texture = new ResourceLocation(HypixelSkyBlockMod.MOD_ID,
			"textures/gui/time_saver_screen.png");

	/**
	 * @param screenContainer {@link TimeSaverContainer} containing this.
	 * @param inv             {@link PlayerInventory} of {@link PlayerEntity}
	 *                        interacting with this
	 * @param titleIn         {@link ITextComponent} of the title for this screen
	 */
	public TimeSaverScreen(TimeSaverContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.leftPos = 0;
		this.topPos = 0;
		this.width = 256;
		this.height = 256;
	}

	public void renderTooltip(StringTextComponent stringTextComponent, int width, int height) {
	}

	@Override
	protected void renderBg(MatrixStack stack, float partialTicks, int x, int y) {
		RenderSystem.blendColor(1f, 1f, 1f, 1f);
		this.minecraft.getTextureManager().bind(background_texture);
		this.blit(stack, (this.width - this.imageWidth) / 2, (this.height - this.imageHeight) / 2, 0, 0,
				this.imageWidth, this.imageHeight);
		this.itemRenderer.blitOffset = 100f;
		for (int t = 0; t < 9; t++)
			this.itemRenderer.renderGuiItem(new ItemStack(Items.DAYLIGHT_DETECTOR), 48 + 18 * t, 51);
		for (int t = 0; t < 7; t++)
			this.itemRenderer.renderGuiItem(new ItemStack(Items.DAYLIGHT_DETECTOR), 66 + 18 * t, 69);
		this.itemRenderer.blitOffset = 0f;
	}

	@Override
	protected void renderLabels(MatrixStack stack, int mouseX, int mouseY) {
		for (final Widget widget : this.buttons)
			if (widget.isHovered()) {
				widget.renderToolTip(stack, mouseX - this.leftPos, mouseY - this.topPos);
				break;
			}
	}

	@Override
	protected void init() {
		super.init();
	}

	@Override
	public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(stack);
		super.render(stack, mouseX, mouseY, partialTicks);
		this.renderTooltip(stack, mouseX, mouseY);
	}

	@Override
	public void tick() {
		super.tick();
	}
}