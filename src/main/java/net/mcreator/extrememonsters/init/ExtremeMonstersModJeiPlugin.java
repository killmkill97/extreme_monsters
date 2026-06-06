
package net.mcreator.extrememonsters.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.extrememonsters.jei_recipes.SoulInsertJEIRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.SoulInsertJEIRecipe;
import net.mcreator.extrememonsters.jei_recipes.SimulationJEIRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.SimulationJEIRecipe;
import net.mcreator.extrememonsters.jei_recipes.MolecularMatterResynthesizeRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.MolecularMatterResynthesizeRecipe;
import net.mcreator.extrememonsters.jei_recipes.MolecularDissolveRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.MolecularDissolveRecipe;
import net.mcreator.extrememonsters.jei_recipes.MolecularCompressRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.MolecularCompressRecipe;
import net.mcreator.extrememonsters.jei_recipes.MolecularAssembleRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.MolecularAssembleRecipe;
import net.mcreator.extrememonsters.jei_recipes.IncubateRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.IncubateRecipe;
import net.mcreator.extrememonsters.jei_recipes.EnergizingRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.EnergizingRecipe;
import net.mcreator.extrememonsters.jei_recipes.DuplicateRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.DuplicateRecipe;
import net.mcreator.extrememonsters.jei_recipes.DarkMatterGenerateRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.DarkMatterGenerateRecipe;
import net.mcreator.extrememonsters.jei_recipes.CompressionRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.CompressionRecipe;
import net.mcreator.extrememonsters.jei_recipes.AssemblerRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.AssemblerRecipe;
import net.mcreator.extrememonsters.jei_recipes.AppleCultivateRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.AppleCultivateRecipe;
import net.mcreator.extrememonsters.jei_recipes.AlloySmelteRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.AlloySmelteRecipe;
import net.mcreator.extrememonsters.jei_recipes.AdvancedDarkMatterGenerateRecipeCategory;
import net.mcreator.extrememonsters.jei_recipes.AdvancedDarkMatterGenerateRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.stream.Collectors;
import java.util.Objects;
import java.util.List;

@JeiPlugin
public class ExtremeMonstersModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<SimulationJEIRecipe> SimulationJEI_Type = new mezz.jei.api.recipe.RecipeType<>(SimulationJEIRecipeCategory.UID, SimulationJEIRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<AssemblerRecipe> Assembler_Type = new mezz.jei.api.recipe.RecipeType<>(AssemblerRecipeCategory.UID, AssemblerRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<CompressionRecipe> Compression_Type = new mezz.jei.api.recipe.RecipeType<>(CompressionRecipeCategory.UID, CompressionRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<DuplicateRecipe> Duplicate_Type = new mezz.jei.api.recipe.RecipeType<>(DuplicateRecipeCategory.UID, DuplicateRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<IncubateRecipe> Incubate_Type = new mezz.jei.api.recipe.RecipeType<>(IncubateRecipeCategory.UID, IncubateRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<AlloySmelteRecipe> AlloySmelte_Type = new mezz.jei.api.recipe.RecipeType<>(AlloySmelteRecipeCategory.UID, AlloySmelteRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<EnergizingRecipe> Energizing_Type = new mezz.jei.api.recipe.RecipeType<>(EnergizingRecipeCategory.UID, EnergizingRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<AppleCultivateRecipe> AppleCultivate_Type = new mezz.jei.api.recipe.RecipeType<>(AppleCultivateRecipeCategory.UID, AppleCultivateRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<DarkMatterGenerateRecipe> DarkMatterGenerate_Type = new mezz.jei.api.recipe.RecipeType<>(DarkMatterGenerateRecipeCategory.UID, DarkMatterGenerateRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<AdvancedDarkMatterGenerateRecipe> AdvancedDarkMatterGenerate_Type = new mezz.jei.api.recipe.RecipeType<>(AdvancedDarkMatterGenerateRecipeCategory.UID, AdvancedDarkMatterGenerateRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<SoulInsertJEIRecipe> SoulInsertJEI_Type = new mezz.jei.api.recipe.RecipeType<>(SoulInsertJEIRecipeCategory.UID, SoulInsertJEIRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<MolecularAssembleRecipe> MolecularAssemble_Type = new mezz.jei.api.recipe.RecipeType<>(MolecularAssembleRecipeCategory.UID, MolecularAssembleRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<MolecularDissolveRecipe> MolecularDissolve_Type = new mezz.jei.api.recipe.RecipeType<>(MolecularDissolveRecipeCategory.UID, MolecularDissolveRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<MolecularMatterResynthesizeRecipe> MolecularMatterResynthesize_Type = new mezz.jei.api.recipe.RecipeType<>(MolecularMatterResynthesizeRecipeCategory.UID, MolecularMatterResynthesizeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<MolecularCompressRecipe> MolecularCompress_Type = new mezz.jei.api.recipe.RecipeType<>(MolecularCompressRecipeCategory.UID, MolecularCompressRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("extreme_monsters:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new SimulationJEIRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new AssemblerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new CompressionRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new DuplicateRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new IncubateRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new AlloySmelteRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new EnergizingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new AppleCultivateRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new DarkMatterGenerateRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new AdvancedDarkMatterGenerateRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new SoulInsertJEIRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new MolecularAssembleRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new MolecularDissolveRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new MolecularMatterResynthesizeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new MolecularCompressRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<SimulationJEIRecipe> SimulationJEIRecipes = recipeManager.getAllRecipesFor(SimulationJEIRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(SimulationJEI_Type, SimulationJEIRecipes);
		List<AssemblerRecipe> AssemblerRecipes = recipeManager.getAllRecipesFor(AssemblerRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(Assembler_Type, AssemblerRecipes);
		List<CompressionRecipe> CompressionRecipes = recipeManager.getAllRecipesFor(CompressionRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(Compression_Type, CompressionRecipes);
		List<DuplicateRecipe> DuplicateRecipes = recipeManager.getAllRecipesFor(DuplicateRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(Duplicate_Type, DuplicateRecipes);
		List<IncubateRecipe> IncubateRecipes = recipeManager.getAllRecipesFor(IncubateRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(Incubate_Type, IncubateRecipes);
		List<AlloySmelteRecipe> AlloySmelteRecipes = recipeManager.getAllRecipesFor(AlloySmelteRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(AlloySmelte_Type, AlloySmelteRecipes);
		List<EnergizingRecipe> EnergizingRecipes = recipeManager.getAllRecipesFor(EnergizingRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(Energizing_Type, EnergizingRecipes);
		List<AppleCultivateRecipe> AppleCultivateRecipes = recipeManager.getAllRecipesFor(AppleCultivateRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(AppleCultivate_Type, AppleCultivateRecipes);
		List<DarkMatterGenerateRecipe> DarkMatterGenerateRecipes = recipeManager.getAllRecipesFor(DarkMatterGenerateRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(DarkMatterGenerate_Type, DarkMatterGenerateRecipes);
		List<AdvancedDarkMatterGenerateRecipe> AdvancedDarkMatterGenerateRecipes = recipeManager.getAllRecipesFor(AdvancedDarkMatterGenerateRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(AdvancedDarkMatterGenerate_Type, AdvancedDarkMatterGenerateRecipes);
		List<SoulInsertJEIRecipe> SoulInsertJEIRecipes = recipeManager.getAllRecipesFor(SoulInsertJEIRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(SoulInsertJEI_Type, SoulInsertJEIRecipes);
		List<MolecularAssembleRecipe> MolecularAssembleRecipes = recipeManager.getAllRecipesFor(MolecularAssembleRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(MolecularAssemble_Type, MolecularAssembleRecipes);
		List<MolecularDissolveRecipe> MolecularDissolveRecipes = recipeManager.getAllRecipesFor(MolecularDissolveRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(MolecularDissolve_Type, MolecularDissolveRecipes);
		List<MolecularMatterResynthesizeRecipe> MolecularMatterResynthesizeRecipes = recipeManager.getAllRecipesFor(MolecularMatterResynthesizeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(MolecularMatterResynthesize_Type, MolecularMatterResynthesizeRecipes);
		List<MolecularCompressRecipe> MolecularCompressRecipes = recipeManager.getAllRecipesFor(MolecularCompressRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(MolecularCompress_Type, MolecularCompressRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.SIMULATION_CHAMBER.get().asItem()), SimulationJEI_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.SIMULATION_CHAMBER_MK_2.get().asItem()), SimulationJEI_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.SIMULATION_CHAMBER_MK_3.get().asItem()), SimulationJEI_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.DRAGON_QSS_CONTROLLER.get().asItem()), SimulationJEI_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.INFINITY_SIMULATION_CHAMBER.get().asItem()), SimulationJEI_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_ASSEMBLER.get().asItem()), Assembler_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_ASSEMBLER.get().asItem()), Assembler_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.INFERNO_MATTER_ASSEMBLER.get().asItem()), Assembler_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.DUPLICATOR.get().asItem()), Duplicate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.DUPLICATOR_MK_2.get().asItem()), Duplicate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.TRACKER_INCUBATOR.get().asItem()), Incubate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.DRAGON_INCUBATOR.get().asItem()), Incubate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.WITHER_INCUBATOR.get().asItem()), Incubate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.ALLOY_SMELTER.get().asItem()), AlloySmelte_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.MOLECULAR_ALLOYING_FORGE.get().asItem()), AlloySmelte_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.PERFECT_MATTER_FOUNDATION.get().asItem()), Energizing_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.QUANTUM_INFUSER.get().asItem()), Energizing_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.ENERGY_STABILIZER.get().asItem()), Energizing_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.APPLE_CULTIVATOR_MK_1.get().asItem()), AppleCultivate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.APPLE_CULTIVATOR_MK_2.get().asItem()), AppleCultivate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_GENERATOR.get().asItem()), DarkMatterGenerate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_GENERATOR_MK_2.get().asItem()), DarkMatterGenerate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_GENERATOR_MK_3.get().asItem()), DarkMatterGenerate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_GENERATOR_MK_4.get().asItem()), DarkMatterGenerate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_GENERATOR_MK_5.get().asItem()), DarkMatterGenerate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_GENERATOR_MK_4.get().asItem()), AdvancedDarkMatterGenerate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_GENERATOR_MK_5.get().asItem()), AdvancedDarkMatterGenerate_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.SOUL_INSERT_MACHINE.get().asItem()), SoulInsertJEI_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.SOUL_INSERT_MACHINE_MK_2.get().asItem()), SoulInsertJEI_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.SOUL_INSERT_MACHINE_MK_3.get().asItem()), SoulInsertJEI_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.MOLECULAR_ASSEMBLER.get().asItem()), MolecularAssemble_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.MOLECULAR_DISSOLVER.get().asItem()), MolecularDissolve_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.MOLECULAR_MATTER_RESYNTHESIZER.get().asItem()), MolecularMatterResynthesize_Type);
		registration.addRecipeCatalyst(new ItemStack(ExtremeMonstersModBlocks.MOLECULAR_COMPRESSION_STATION.get().asItem()), MolecularCompress_Type);
	}
}
