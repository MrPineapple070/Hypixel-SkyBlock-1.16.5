package net.hypixel.skyblock.client.gui.screen;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.hypixel.skyblock.inventory.container.HOTMContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;

/**
 * Screen for Heart of the Mountain
 * 
 * @author MrPineapple070
 * @version 14 July 2021
 * @since 15 January 2021
 */
public class HOTMScreen extends ContainerScreen<HOTMContainer> {
	/**
	 * {@link Logger}
	 */
	@Nonnull
	private static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * {@link ResourceLocation} for background texture
	 */
	@Nonnull
	private static final ResourceLocation texture = new ResourceLocation("textures/gui/container/hotm_screen.png");
	
	public HOTMScreen(HOTMContainer container, PlayerInventory inventory) {
		super(container, inventory, HOTMContainer.title);
		this.width = 256;
		this.height = 256;
		this.leftPos = 0;
		this.topPos = 0;
	}
	
	@Override
	protected void renderLabels(MatrixStack stack, int mouseX, int mouseY) {
		this.font.draw(stack, this.title.getString(), 8f, 6f, 0x404040);
		this.font.draw(stack, this.inventory.getDisplayName().getString(), 8f, this.height - 94, 0x404040);
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
		this.minecraft.getTextureManager().bind(texture);
		this.blit(stack, (this.width - this.imageWidth) / 2, (this.height - this.imageHeight) / 2, 0, 0,
				this.imageWidth, this.imageHeight);
	}
}