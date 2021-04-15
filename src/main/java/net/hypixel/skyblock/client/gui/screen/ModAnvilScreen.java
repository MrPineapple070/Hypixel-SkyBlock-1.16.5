package net.hypixel.skyblock.client.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.inventory.container.ModRepairContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModAnvilScreen extends ContainerScreen<ModRepairContainer> {
	private static final ResourceLocation texture = new ResourceLocation(HypixelSkyBlockMod.MOD_ID,
			"textures/gui/container/anvil.png");

	public ModAnvilScreen(ModRepairContainer container, PlayerInventory inventory, ITextComponent title) {
		super(container, inventory, title);
		this.leftPos = 0;
		this.topPos = 0;
		this.width = 256;
		this.height = 256;
	}

	@Override
	protected void renderBg(MatrixStack stack, float ticks, int mouseX, int mouseY) {
		this.minecraft.getTextureManager().bind(texture);
	}

	@Override
	public void render(MatrixStack stack, int mouseX, int mouseY, float ticks) {
		this.renderBackground(stack);
		super.render(stack, mouseX, mouseY, ticks);
		RenderSystem.disableBlend();
		this.renderTooltip(stack, mouseX, mouseY);
	}
}