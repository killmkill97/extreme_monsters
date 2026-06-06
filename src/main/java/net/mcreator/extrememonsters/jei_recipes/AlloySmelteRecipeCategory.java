
package net.mcreator.extrememonsters.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.extrememonsters.init.ExtremeMonstersModJeiPlugin;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class AlloySmelteRecipeCategory implements IRecipeCategory<AlloySmelteRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("extreme_monsters:alloy_smelte");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("extreme_monsters:textures/screens/alloy_smelte_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public AlloySmelteRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 170, 66);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ExtremeMonstersModBlocks.ALLOY_SMELTER.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<AlloySmelteRecipe> getRecipeType() {
		return ExtremeMonstersModJeiPlugin.AlloySmelte_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Alloy Smelte");
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public int getWidth() {
		return this.background.getWidth();
	}

	@Override
	public int getHeight() {
		return this.background.getHeight();
	}

	@Override
	public void draw(AlloySmelteRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, AlloySmelteRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 16, 16).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 34, 16).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 52, 16).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 16, 34).addIngredients(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 34, 34).addIngredients(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 52, 34).addIngredients(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 136, 25).addItemStack(recipe.getResultItem(null));
	}
}
