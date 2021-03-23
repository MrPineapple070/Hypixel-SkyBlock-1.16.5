package net.hypixel.skyblock.client.render.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.hypixel.skyblock.client.render.entity.model.MayorModel;
import net.hypixel.skyblock.entity.npc.MayorEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;

public abstract class MayorEntityRender extends EntityRenderer<MayorEntity> {
	protected static final Logger LOGGER = LogManager.getLogger();
	protected final MayorModel model = new MayorModel();
	
	public MayorEntityRender(EntityRendererManager manager) {
		super(manager);
		LOGGER.info("MoyorEntityRender created");
		this.shadowRadius = .8f;
	}
	
	@Override
	public void render(MayorEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.pushPose();
		this.model.renderToBuffer(matrixStackIn,
				bufferIn.getBuffer(this.model.renderType(this.getTextureLocation(entityIn))), packedLightIn,
				OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
		matrixStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
}