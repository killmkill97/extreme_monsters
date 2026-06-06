
package net.mcreator.extrememonsters.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class ExtremeMonstersModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("extreme_monsters:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.extreme_monsters.black_hole_matter_info"));
		registration.addIngredientInfo(List.of(new ItemStack(ExtremeMonstersModItems.TRACKERS_SOUL.get()), new ItemStack(ExtremeMonstersModItems.HYPER_ZOMBIES_SOUL.get()), new ItemStack(ExtremeMonstersModItems.HYPER_SKELETONS_SOUL.get()),
				new ItemStack(ExtremeMonstersModItems.HYPER_CREEPERS_SOUL.get()), new ItemStack(ExtremeMonstersModItems.HYPER_SPIDERS_SOUL.get()), new ItemStack(ExtremeMonstersModItems.HYPER_ZOMBIFIED_PIGLINS_SOUL.get()),
				new ItemStack(ExtremeMonstersModItems.HYPER_WITHER_SKELETONS_SOUL.get()), new ItemStack(ExtremeMonstersModItems.HYPER_BLAZES_SOUL.get()), new ItemStack(ExtremeMonstersModItems.HYPER_ENDERMANS_SOUL.get()),
				new ItemStack(ExtremeMonstersModItems.HYPER_MAGMA_CUBES_SOUL.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.extreme_monsters.soul_info"));
		registration.addIngredientInfo(List.of(new ItemStack(ExtremeMonstersModBlocks.DUPLICATED_BEDROCK.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.extreme_monsters.duplicated_bedrock_info"));
		registration.addIngredientInfo(List.of(new ItemStack(ExtremeMonstersModItems.SUPER_LAVA_BUCKET.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.extreme_monsters.how_to_make_super_lava"));
		registration.addIngredientInfo(List.of(new ItemStack(ExtremeMonstersModBlocks.MYSTERY_CUBE.get()), new ItemStack(ExtremeMonstersModBlocks.HYPER_STONE.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.extreme_monsters.meteor_items_info"));
		registration.addIngredientInfo(List.of(new ItemStack(ExtremeMonstersModBlocks.MYSTERY_CUBE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.extreme_monsters.mystery_cube_info"));
	}
}
