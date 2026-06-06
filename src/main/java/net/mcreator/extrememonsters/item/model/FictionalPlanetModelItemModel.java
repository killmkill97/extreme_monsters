package net.mcreator.extrememonsters.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.item.FictionalPlanetModelItem;

public class FictionalPlanetModelItemModel extends GeoModel<FictionalPlanetModelItem> {
	@Override
	public ResourceLocation getAnimationResource(FictionalPlanetModelItem animatable) {
		return ResourceLocation.parse("extreme_monsters:animations/fictional_planet_model.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FictionalPlanetModelItem animatable) {
		return ResourceLocation.parse("extreme_monsters:geo/fictional_planet_model.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FictionalPlanetModelItem animatable) {
		return ResourceLocation.parse("extreme_monsters:textures/item/fictional_planet_model.png");
	}
}
