package net.mcreator.extrememonsters.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.block.entity.ArtificialSunTileEntity;

public class ArtificialSunBlockModel extends GeoModel<ArtificialSunTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ArtificialSunTileEntity animatable) {
		return ResourceLocation.parse("extreme_monsters:animations/artificial_sun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ArtificialSunTileEntity animatable) {
		return ResourceLocation.parse("extreme_monsters:geo/artificial_sun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ArtificialSunTileEntity animatable) {
		return ResourceLocation.parse("extreme_monsters:textures/block/artificial_sun.png");
	}
}
