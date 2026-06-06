package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.extrememonsters.jei_recipes.SoulInsertJEIRecipe;
import net.mcreator.extrememonsters.jei_recipes.SimulationJEIRecipe;
import net.mcreator.extrememonsters.jei_recipes.MolecularMatterResynthesizeRecipe;
import net.mcreator.extrememonsters.jei_recipes.MolecularDissolveRecipe;
import net.mcreator.extrememonsters.jei_recipes.MolecularCompressRecipe;
import net.mcreator.extrememonsters.jei_recipes.MolecularAssembleRecipe;
import net.mcreator.extrememonsters.jei_recipes.IncubateRecipe;
import net.mcreator.extrememonsters.jei_recipes.EnergizingRecipe;
import net.mcreator.extrememonsters.jei_recipes.DuplicateRecipe;
import net.mcreator.extrememonsters.jei_recipes.DarkMatterGenerateRecipe;
import net.mcreator.extrememonsters.jei_recipes.CompressionRecipe;
import net.mcreator.extrememonsters.jei_recipes.AssemblerRecipe;
import net.mcreator.extrememonsters.jei_recipes.AppleCultivateRecipe;
import net.mcreator.extrememonsters.jei_recipes.AlloySmelteRecipe;
import net.mcreator.extrememonsters.jei_recipes.AdvancedDarkMatterGenerateRecipe;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

@EventBusSubscriber(modid = ExtremeMonstersMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ExtremeMonstersModRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "extreme_monsters");
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "extreme_monsters");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = ModList.get().getModContainerById("extreme_monsters").get().getEventBus();
		event.enqueueWork(() -> {
			RECIPE_TYPES.register(bus);
			SERIALIZERS.register(bus);
			RECIPE_TYPES.register("simulation_jei", () -> SimulationJEIRecipe.Type.INSTANCE);
			SERIALIZERS.register("simulation_jei", () -> SimulationJEIRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("assembler", () -> AssemblerRecipe.Type.INSTANCE);
			SERIALIZERS.register("assembler", () -> AssemblerRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("compression", () -> CompressionRecipe.Type.INSTANCE);
			SERIALIZERS.register("compression", () -> CompressionRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("duplicate", () -> DuplicateRecipe.Type.INSTANCE);
			SERIALIZERS.register("duplicate", () -> DuplicateRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("incubate", () -> IncubateRecipe.Type.INSTANCE);
			SERIALIZERS.register("incubate", () -> IncubateRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("alloy_smelte", () -> AlloySmelteRecipe.Type.INSTANCE);
			SERIALIZERS.register("alloy_smelte", () -> AlloySmelteRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("energizing", () -> EnergizingRecipe.Type.INSTANCE);
			SERIALIZERS.register("energizing", () -> EnergizingRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("apple_cultivate", () -> AppleCultivateRecipe.Type.INSTANCE);
			SERIALIZERS.register("apple_cultivate", () -> AppleCultivateRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("dark_matter_generate", () -> DarkMatterGenerateRecipe.Type.INSTANCE);
			SERIALIZERS.register("dark_matter_generate", () -> DarkMatterGenerateRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("advanced_dark_matter_generate", () -> AdvancedDarkMatterGenerateRecipe.Type.INSTANCE);
			SERIALIZERS.register("advanced_dark_matter_generate", () -> AdvancedDarkMatterGenerateRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("soul_insert_jei", () -> SoulInsertJEIRecipe.Type.INSTANCE);
			SERIALIZERS.register("soul_insert_jei", () -> SoulInsertJEIRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("molecular_assemble", () -> MolecularAssembleRecipe.Type.INSTANCE);
			SERIALIZERS.register("molecular_assemble", () -> MolecularAssembleRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("molecular_dissolve", () -> MolecularDissolveRecipe.Type.INSTANCE);
			SERIALIZERS.register("molecular_dissolve", () -> MolecularDissolveRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("molecular_matter_resynthesize", () -> MolecularMatterResynthesizeRecipe.Type.INSTANCE);
			SERIALIZERS.register("molecular_matter_resynthesize", () -> MolecularMatterResynthesizeRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("molecular_compress", () -> MolecularCompressRecipe.Type.INSTANCE);
			SERIALIZERS.register("molecular_compress", () -> MolecularCompressRecipe.Serializer.INSTANCE);
		});
	}
}
