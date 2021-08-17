package net.hypixel.skyblock.blocks;

import javax.annotation.Nonnull;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;

/**
 * Holds more {@link Material}.
 * 
 * @author MrPineapple070
 * @version 16 August 2021
 * @since 11 July 2019
 */
public class ModMaterial {
	/**
	 * Gemstone {@link Material}
	 */
	@Nonnull
	public static final Material Gemstone = new Material(MaterialColor.NONE, false, true, true, false, false, false,
			PushReaction.IGNORE);
}