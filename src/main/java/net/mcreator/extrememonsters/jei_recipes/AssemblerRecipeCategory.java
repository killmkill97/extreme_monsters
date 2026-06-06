
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

public class AssemblerRecipeCategory implements IRecipeCategory<AssemblerRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("extreme_monsters:assembler");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("extreme_monsters:textures/screens/jei_assembler.png");
	private final IDrawable background;
	private final IDrawable icon;

	public AssemblerRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 80);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_ASSEMBLER.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<AssemblerRecipe> getRecipeType() {
		return ExtremeMonstersModJeiPlugin.Assembler_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Assembler");
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
	public void draw(AssemblerRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, AssemblerRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 21, 19).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 39, 19).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 21, 37).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 39, 37).addIngredients(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 21, 55).addIngredients(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 39, 55).addIngredients(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 125, 37).addItemStack(recipe.getResultItem(null));
		builder.addSlot(RecipeIngredientRole.INPUT, 108, 58).addIngredients(recipe.getIngredients().get(6));
	}
}
