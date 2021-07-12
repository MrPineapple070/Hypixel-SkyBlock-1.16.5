package net.hypixel.skyblock.blocks;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class HardGlass extends AbstractGlassBlock {
	public HardGlass() {
		super(Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion());
	}
}