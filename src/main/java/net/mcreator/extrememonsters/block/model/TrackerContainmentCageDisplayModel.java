package net.mcreator.extrememonsters.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.block.display.TrackerContainmentCageDisplayItem;

public class TrackerContainmentCageDisplayModel extends GeoModel<TrackerContainmentCageDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(TrackerContainmentCageDisplayItem animatable) {
		return ResourceLocation.parse("extreme_monsters:animations/planetary_regulator.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TrackerContainmentCageDisplayItem animatable) {
		return ResourceLocation.parse("extreme_monsters:geo/planetary_regulator.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TrackerContainmentCageDisplayItem entity) {
		return ResourceLocation.parse("extreme_monsters:textures/block/tracker_containment_cage.png");
	}
}
