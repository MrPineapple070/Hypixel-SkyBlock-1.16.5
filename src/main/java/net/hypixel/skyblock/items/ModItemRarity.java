package net.hypixel.skyblock.items;

import java.util.Objects;

import javax.annotation.Nonnull;

import org.openjdk.nashorn.internal.ir.annotations.Immutable;

import com.google.common.collect.ImmutableList;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * A mod version of {@link net.minecraft.item.Rarity}
 *
 * @author MrPineapple070
 * @version 26 July 2020
 */
public enum ModItemRarity {
	Common(TextFormatting.WHITE, 0), Uncommon(TextFormatting.GREEN, 1), Rare(TextFormatting.BLUE, 2),
	Epic(TextFormatting.DARK_PURPLE, 3), Legendary(TextFormatting.GOLD, 4), Mythic(TextFormatting.LIGHT_PURPLE, 5),
	Supreme(TextFormatting.DARK_RED, 5), Special(TextFormatting.RED, 6), Very_Special(TextFormatting.RED, 7);
	
	public static final ITextComponent common		= new TranslationTextComponent("rarity.common").withStyle(Common.color);
	public static final ITextComponent uncommon		= new TranslationTextComponent("rarity.uncommon").withStyle(Uncommon.color);
	public static final ITextComponent rare			= new TranslationTextComponent("rarity.rare").withStyle(Rare.color);
	public static final ITextComponent epic			= new TranslationTextComponent("rarity.epic").withStyle(Epic.color);
	public static final ITextComponent legendary	= new TranslationTextComponent("rarity.legendary").withStyle(Legendary.color);
	public static final ITextComponent mythic		= new TranslationTextComponent("rarity.mythic").withStyle(Mythic.color);
	public static final ITextComponent supreme		= new TranslationTextComponent("rarity.supreme").withStyle(Supreme.color);
	public static final ITextComponent special		= new TranslationTextComponent("rarity.special").withStyle(Special.color);
	public static final ITextComponent very_special	= new TranslationTextComponent("rarity.very_special").withStyle(Very_Special.color);

	/**
	 * A {@link ImmutableList} of {@link ModItemRarity} that are higher rarities.
	 */
	@Nonnull
	@Immutable
	public static final ModItemRarity[] high = new ModItemRarity[] { Epic, Legendary, Mythic };

	/**
	 * A {@link ImmutableList} of {@link ModItemRarity} that are lower rarities.
	 */
	@Nonnull
	@Immutable
	public static final ModItemRarity[] low = new ModItemRarity[] { Common, Uncommon, Rare };

	/**
	 * A {@link ImmutableList} of {@link ModItemRarity} that are only obtained
	 * through artificial means.
	 */
	@Nonnull
	@Immutable
	public static final ModItemRarity[] artificial = new ModItemRarity[] { Supreme, Special, Very_Special };

	/**
	 * The {@link TextFormatting} of this {@code ModItemRarity}
	 */
	@Nonnull
	public final TextFormatting color;
	
	/**
	 * This number should be identical to {@link #ordinal()}
	 */
	public final int rank;

	private ModItemRarity(TextFormatting color, int rank) {
		this.color = Objects.requireNonNull(color, "TextFormatting cannot be null");
		this.rank = rank;
	}

	/**
	 * Determines the next tier of {@link ModItemRarity}
	 *
	 * @return the next {@code ModItemRarity}.
	 */
	public ModItemRarity getNext() {
		switch (this) {
		case Common:
			return Uncommon;
		case Uncommon:
			return Rare;
		case Rare:
			return Epic;
		case Epic:
			return Legendary;
		case Legendary:
			return Mythic;
		case Mythic:
			return Supreme;
		case Special:
			return Very_Special;
		default:
			throw new IllegalStateException(this.name() + " does not have an upgrade.");
		}
	}
	
	/**
	 * Determines the previous tier of {@link ModItemRarity}
	 * 
	 * @return the previous {@link ModItemRarity}
	 */
	public ModItemRarity getPrevious() {
		switch (this) {
		case Uncommon:
			return Common;
		case Rare:
			return Uncommon;
		case Epic:
			return Rare;
		case Legendary:
			return Epic;
		case Mythic:
			return Legendary;
		case Supreme:
			return Mythic;
		case Very_Special:
			return Special;
		default:
			throw new IllegalStateException(this.name() + " does not have a previous.");
		}
	}
}