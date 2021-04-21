package net.hypixel.skyblock.client.gui.screen;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.inventory.container.minion.AbstractMinionContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
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
}