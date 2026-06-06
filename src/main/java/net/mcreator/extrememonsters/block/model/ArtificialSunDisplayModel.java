package net.mcreator.extrememonsters.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.block.display.ArtificialSunDisplayItem;

public class ArtificialSunDisplayModel extends GeoModel<ArtificialSunDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ArtificialSunDisplayItem animatable) {
		return ResourceLocation.parse("extreme_monsters:animations/artificial_sun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ArtificialSunDisplayItem animatable) {
		return ResourceLocation.parse("extreme_monsters:geo/artificial_sun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ArtificialSunDisplayItem entity) {
		return ResourceLocation.parse("extreme_monsters:textures/block/artificial_sun.png");
	}
}
