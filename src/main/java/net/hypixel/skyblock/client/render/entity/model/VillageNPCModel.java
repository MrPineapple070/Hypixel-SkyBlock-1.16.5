package net.hypixel.skyblock.client.render.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.hypixel.skyblock.entity.npc.VillageNPC;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public class VillageNPCModel extends EntityModel<VillageNPC> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer Legs;
	private final ModelRenderer Arm;
	private final ModelRenderer bb_main;
	private final ModelRenderer hands_r1;

	public VillageNPCModel() {
		this.texWidth = 64;
		this.texHeight = 64;

		this.Head = new ModelRenderer(this);
		this.Head.setPos(-4f, .5f, 1f);
		this.Head.texOffs(0, 0).addBox(-4f, -9.5f, -3f, 8f, 10f, 8f, 0f, false);
		this.Head.texOffs(24, 0).addBox(-1f, -3.5f, -4f, 2f, 4f, 2f, 0f, false);

		this.Body = new ModelRenderer(this);
		this.Body.setPos(0f, 24f, 0f);
		this.Body.texOffs(16, 20).addBox(-8f, -23f, -1f, 8f, 12f, 6f, 0f, false);
		this.Body.texOffs(0, 38).addBox(-8f, -23f, -1f, 8f, 20f, 6f, 0f, false);

		this.Legs = new ModelRenderer(this);
		this.Legs.setPos(-4f, 18.5f, 2f);
		this.Legs.texOffs(0, 23).addBox(-4f, -5.5f, -2f, 4f, 11f, 4f, 0f, false);
		this.Legs.texOffs(0, 23).addBox(0f, -5.5f, -2f, 4f, 11f, 4f, 0f, false);

		this.Arm = new ModelRenderer(this);
		this.Arm.setPos(-4f, 2f, 3f);
		this.setRotationAngle(this.Arm, -.7854F, 0f, 0f);
		this.Arm.texOffs(44, 22).addBox(-8f, 0f, -2f, 4f, 8f, 4f, 0f, false);
		this.Arm.texOffs(44, 22).addBox(4f, 0f, -2f, 4f, 8f, 4f, 0f, false);

		this.bb_main = new ModelRenderer(this);
		this.bb_main.setPos(0f, 24f, 0f);

		this.hands_r1 = new ModelRenderer(this);
		this.hands_r1.setPos(-4f, -17.4038f, -1.682f);
		this.bb_main.addChild(this.hands_r1);
		this.setRotationAngle(this.hands_r1, -.7854f, 0f, 0f);
		this.hands_r1.texOffs(40, 38).addBox(-4f, -2.5607f, -1.9393f, 8f, 4f, 4f, 0f, false);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void setupAnim(VillageNPC entity, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_,
			float p_225597_6_) {
	}

	@Override
	public void renderToBuffer(MatrixStack stack, IVertexBuilder builder, int light, int overlay, float red,
			float green, float blue, float alpha) {
		this.Head.render(stack, builder, light, overlay);
		this.Body.render(stack, builder, light, overlay);
		this.Legs.render(stack, builder, light, overlay);
		this.Arm.render(stack, builder, light, overlay);
		this.bb_main.render(stack, builder, light, overlay);
	}
}