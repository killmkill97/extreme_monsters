
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

public class MolecularAssembleRecipeCategory implements IRecipeCategory<MolecularAssembleRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("extreme_monsters:molecular_assemble");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("extreme_monsters:textures/screens/molecular_assemble_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public MolecularAssembleRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 154, 62);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ExtremeMonstersModBlocks.MOLECULAR_ASSEMBLER.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<MolecularAssembleRecipe> getRecipeType() {
		return ExtremeMonstersModJeiPlugin.MolecularAssemble_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Molecular Assemble");
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
	public void draw(MolecularAssembleRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, MolecularAssembleRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 5, 5).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 23, 5).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 41, 5).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 5, 23).addIngredients(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 41, 23).addIngredients(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 5, 41).addIngredients(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.INPUT, 23, 41).addIngredients(recipe.getIngredients().get(6));
		builder.addSlot(RecipeIngredientRole.INPUT, 41, 41).addIngredients(recipe.getIngredients().get(7));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 131, 23).addItemStack(recipe.getResultItem(null));
	}
}
