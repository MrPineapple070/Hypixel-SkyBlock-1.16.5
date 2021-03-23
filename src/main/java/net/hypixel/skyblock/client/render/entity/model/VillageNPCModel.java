package net.hypixel.skyblock.client.render.entity.model;

import net.hypixel.skyblock.entity.npc.VillageNPC;
import net.minecraft.client.renderer.entity.model.VillagerModel;
import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public class VillageNPCModel extends VillagerModel<VillageNPC> {
	public VillageNPCModel() {
		super(0f);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}