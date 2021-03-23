package net.hypixel.skyblock.client.render.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * 
 * @author MrPineapple070
 * @version 23 March 2021
 * @since 11 July 2019
 */
public class MayorModel extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public MayorModel() {
		this.texWidth = 64;
		this.texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(-4f, 0f, 4f);
		Head.texOffs(0, 0).addBox(-4f, -8f, -4f, 8f, 8f, 8f, 0f, false);
		Head.texOffs(32, 0).addBox(-4f, -8f, -4f, 8f, 8f, 8f, .5F, false);

		Body = new ModelRenderer(this);
		Body.setPos(-4f, 6f, 4f);
		Body.texOffs(16, 16).addBox(-4f, -6f, -2f, 8f, 12f, 4f, 0f, false);
		Body.texOffs(16, 33).addBox(-4f, -6f, -2f, 8f, 12f, 4f, .25f, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-9f, 0f, 4f);
		RightArm.texOffs(0, 16).addBox(-3f, 0f, -2f, 4f, 12f, 4f, 0f, false);
		RightArm.texOffs(40, 32).addBox(-3f, 0f, -2f, 4f, 12f, 4f, .25f, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(0f, 0f, 4f);
		LeftArm.texOffs(32, 48).addBox(0f, 0f, -2f, 4f, 12f, 4f, 0f, false);
		LeftArm.texOffs(48, 48).addBox(0f, 0f, -2f, 4f, 12f, 4f, .25f, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-6f, 12f, 4f);
		RightLeg.texOffs(0, 16).addBox(-2f, 0f, -2f, 4f, 12f, 4f, 0f, false);
		RightLeg.texOffs(0, 32).addBox(-2f, 0f, -2f, 4f, 12f, 4f, .25f, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(-2f, 13f, 4f);
		LeftLeg.texOffs(16, 48).addBox(-2f, -1f, -2f, 4f, 12f, 4f, 0f, false);
		LeftLeg.texOffs(0, 48).addBox(-2f, -1f, -2f, 4f, 12f, 4f, .25f, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}