package net.hypixel.skyblock.client.render.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.hypixel.skyblock.client.render.entity.model.VillageNPCModel;
import net.hypixel.skyblock.entity.npc.VillageNPC;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

public class VillageNPCRender extends MobRenderer<VillageNPC, VillageNPCModel> {
	protected static final ResourceLocation texture = new ResourceLocation("textures/entity/villager/villager.png");
	protected static final Logger LOGGER = LogManager.getLogger();
	protected final VillageNPCModel model = new VillageNPCModel();

	public VillageNPCRender(EntityRendererManager renderManager) {
		super(renderManager, new VillageNPCModel(), .5f);
		LOGGER.info("VillageNPCRender created");
	}

	@Override
	public void render(VillageNPC entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		LOGGER.info("Rendering " + entityIn.toString());
		matrixStackIn.pushPose();
		this.model.renderToBuffer(matrixStackIn,
				bufferIn.getBuffer(this.model.renderType(this.getTextureLocation(entityIn))), packedLightIn,
				OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
		matrixStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(VillageNPC entity) {
		return texture;
	}
}