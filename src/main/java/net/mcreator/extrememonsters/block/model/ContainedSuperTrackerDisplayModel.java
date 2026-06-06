package net.mcreator.extrememonsters.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.block.display.ContainedSuperTrackerDisplayItem;

public class ContainedSuperTrackerDisplayModel extends GeoModel<ContainedSuperTrackerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ContainedSuperTrackerDisplayItem animatable) {
		return ResourceLocation.parse("extreme_monsters:animations/planetary_regulator.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ContainedSuperTrackerDisplayItem animatable) {
		return ResourceLocation.parse("extreme_monsters:geo/planetary_regulator.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ContainedSuperTrackerDisplayItem entity) {
		return ResourceLocation.parse("extreme_monsters:textures/block/contained_tracker.png");
	}
}
