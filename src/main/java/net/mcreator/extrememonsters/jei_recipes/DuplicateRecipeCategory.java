
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

public class DuplicateRecipeCategory implements IRecipeCategory<DuplicateRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("extreme_monsters:duplicate");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("extreme_monsters:textures/screens/dpct_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public DuplicateRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 112, 24);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ExtremeMonstersModBlocks.DUPLICATOR.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<DuplicateRecipe> getRecipeType() {
		return ExtremeMonstersModJeiPlugin.Duplicate_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Duplicate");
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
	public void draw(DuplicateRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, DuplicateRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 4, 4).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 92, 4).addItemStack(recipe.getResultItem(null));
	}
}
