package net.hypixel.skyblock.items.crafting;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.hypixel.skyblock.enchantment.ModEnchantment;
import net.hypixel.skyblock.util.ListUtil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.minecraftforge.registries.ForgeRegistryEntry;

/**
 * A {@link IEnchantmentRecipe} that handles craftable {@link ModEnchantment}
 * and {@link Enchantment}.
 *
 * @author MrPineapple070
 * @version 11 October 2020
 * @since 11 October 2020
 */
public class EnchantmentRecipe implements IEnchantmentRecipe {
	/**
	 * {@link ForgeRegistryEntry} of {@link IRecipeSerializer} implementing
	 * {@link IRecipeSerializer} of {@link EnchantmentRecipe} for
	 * {@link EnchantmentRecipe}
	 */
	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
			implements IRecipeSerializer<EnchantmentRecipe> {
		@Override
		public EnchantmentRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
			final String group = JSONUtils.getAsString(json, "group", "");
			final NonNullList<Ingredient> ingredients = ListUtil
					.readIngredients(JSONUtils.getAsJsonArray(json, "ingredients"));
			if (ingredients.isEmpty())
				throw new JsonParseException("No ingredients for recipe");
			else if (ingredients.size() > 9)
				throw new JsonParseException("Too many ingredients for recipe the max is " + 9);
			else
				return new EnchantmentRecipe(recipeId, group, ingredients,
						ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "result")));
		}

		@Override
		public EnchantmentRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
			final NonNullList<Ingredient> ingredients = NonNullList.withSize(buffer.readVarInt(), Ingredient.EMPTY);
			for (int j = 0; j < ingredients.size(); ++j)
				ingredients.set(j, Ingredient.fromNetwork(buffer));
			return new EnchantmentRecipe(recipeId, buffer.readUtf(0x7FFF), ingredients, buffer.readItem());
		}

		@Override
		public void toNetwork(PacketBuffer buffer, EnchantmentRecipe recipe) {
			buffer.writeUtf(recipe.group);
			buffer.writeVarInt(recipe.inputs.size());
			for (final Ingredient ingredient : recipe.inputs)
				ingredient.toNetwork(buffer);
			buffer.writeItem(recipe.output);
		}
	}

	/**
	 * {@link String} that is the name for the group that this is in.
	 */
	@Nonnull
	private final String group;

	/**
	 * {@link ResourceLocation} for the id.
	 */
	@Nonnull
	private final ResourceLocation id;

	/**
	 * A {@link NonNullList} of {@link Ingredient} for this
	 * {@link IEnchantedItemRecipe}.
	 */
	@Nonnull
	private final NonNullList<Ingredient> inputs;

	/**
	 * Output {@link ItemStack} for this {@link IEnchantedItemRecipe}
	 */
	@Nonnull
	private final ItemStack output;

	public EnchantmentRecipe(@Nonnull ResourceLocation id, @Nonnull String group,
			@Nonnull NonNullList<Ingredient> input, @Nonnull ItemStack output) {
		this.id = id;
		this.group = group;
		this.inputs = input;
		this.output = output;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return this.inputs;
	}

	@Override
	public ItemStack getResultItem() {
		return this.output;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return RecipeSerializerInit.enchantment_serializer.get();
	}

	@Override
	public boolean matches(RecipeWrapper inv, World worldIn) {
		return true;
	}

	@Override
	public ItemStack assemble(RecipeWrapper p_77572_1_) {
		return this.output;
	}
}