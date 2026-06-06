package net.mcreator.extrememonsters.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.block.entity.FictionalPlanetTileEntity;

public class FictionalPlanetBlockModel extends GeoModel<FictionalPlanetTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(FictionalPlanetTileEntity animatable) {
		return ResourceLocation.parse("extreme_monsters:animations/fictional_planet.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FictionalPlanetTileEntity animatable) {
		return ResourceLocation.parse("extreme_monsters:geo/fictional_planet.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FictionalPlanetTileEntity animatable) {
		return ResourceLocation.parse("extreme_monsters:textures/block/mine_travelling_block.png");
	}
}
