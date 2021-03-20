package net.hypixel.skyblock.client.gui.screen;

import java.util.Objects;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.blocks.minion.MinionChestBlock.MinionChestType;
import net.hypixel.skyblock.inventory.container.minion.MinionChestContainer;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * A basis for MinionChest Screen.
 *
 * @author MrPineapple070
 * @version 24 June 2020
 * @since 14 June 2019
 */
@OnlyIn(Dist.CLIENT)
public abstract class MinionChestScreen extends ContainerScreen<MinionChestContainer>
		implements IHasContainer<MinionChestContainer> {
	/**
	 * Background Texture for Small Minion Chest
	 */
	@Nonnull
	private static final ResourceLocation small = new ResourceLocation(HypixelSkyBlockMod.MOD_ID,
			"textures/gui/small_minion_chest_screen.png");

	/**
	 * Background Texture for Medium Minion Chest
	 */
	@Nonnull
	private static final ResourceLocation medium = new ResourceLocation(HypixelSkyBlockMod.MOD_ID,
			"textures/gui/medium_minion_chest_screen.png");

	/**
	 * Background Texture for Large Minion Chest
	 */
	@Nonnull
	private static final ResourceLocation large = new ResourceLocation(HypixelSkyBlockMod.MOD_ID,
			"textures/gui/large_minion_chest_screen.png");

	@Nonnull
	private static final ResourceLocation xlarge = new ResourceLocation(HypixelSkyBlockMod.MOD_ID,
			"textures/gui/x_large_minion_chest_screen.png");
	@Nonnull
	private static final ResourceLocation xxlarge = new ResourceLocation(HypixelSkyBlockMod.MOD_ID,
			"textures/gui/xx_large_minion_chest_screen.png");

	/**
	 * The {@link MinionChestType} of this.
	 */
	@Nonnull
	protected final MinionChestType type;

	protected MinionChestScreen(MinionChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn,
			MinionChestType type) {
		super(screenContainer, inv, titleIn);
		this.leftPos = 0;
		this.topPos = 0;
		this.width = 256;
		this.height = 256;
		this.type = Objects.requireNonNull(type, "Type of this MinionChestScreen cannot be null.");
	}

	@Override
	protected void renderLabels(MatrixStack stack, int mouseX, int mouseY) {
		this.font.draw(stack, this.title.getString(), 48, 50, 0x404040);
		this.font.draw(stack, this.inventory.getDisplayName().getString(), 48, 118, 0x404040);
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
		switch (this.type) {
		case Small:
			this.minecraft.getTextureManager().bind(small);
			break;
		case Medium:
			this.minecraft.getTextureManager().bind(medium);
			break;
		case Large:
			this.minecraft.getTextureManager().bind(large);
			break;
		default:
			throw new IllegalStateException("Illegal MinionChestType " + this.type.name());
		}
		this.blit(stack, (this.width - this.imageWidth) / 2, (this.height - this.imageHeight) / 2, 0, 0,
				this.imageWidth, this.imageHeight);
	}

	public static class SmallMCS extends MinionChestScreen {
		public SmallMCS(MinionChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
			super(screenContainer, inv, titleIn, MinionChestType.Small);
		}
	}

	public static class MediumMCS extends MinionChestScreen {
		public MediumMCS(MinionChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
			super(screenContainer, inv, titleIn, MinionChestType.Medium);
		}
	}

	public static class LargeMCS extends MinionChestScreen {
		public LargeMCS(MinionChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
			super(screenContainer, inv, titleIn, MinionChestType.Large);
		}
	}
}