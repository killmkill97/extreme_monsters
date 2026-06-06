package net.mcreator.extrememonsters.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.block.display.FictionalPlanetDisplayItem;

public class FictionalPlanetDisplayModel extends GeoModel<FictionalPlanetDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(FictionalPlanetDisplayItem animatable) {
		return ResourceLocation.parse("extreme_monsters:animations/fictional_planet.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FictionalPlanetDisplayItem animatable) {
		return ResourceLocation.parse("extreme_monsters:geo/fictional_planet.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FictionalPlanetDisplayItem entity) {
		return ResourceLocation.parse("extreme_monsters:textures/block/mine_travelling_block.png");
	}
}
