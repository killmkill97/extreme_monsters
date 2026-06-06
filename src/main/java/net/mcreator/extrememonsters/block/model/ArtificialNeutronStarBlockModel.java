package net.mcreator.extrememonsters.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.block.entity.ArtificialNeutronStarTileEntity;

public class ArtificialNeutronStarBlockModel extends GeoModel<ArtificialNeutronStarTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ArtificialNeutronStarTileEntity animatable) {
		return ResourceLocation.parse("extreme_monsters:animations/artificial_sun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ArtificialNeutronStarTileEntity animatable) {
		return ResourceLocation.parse("extreme_monsters:geo/artificial_sun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ArtificialNeutronStarTileEntity animatable) {
		return ResourceLocation.parse("extreme_monsters:textures/block/artificial_neutron_star.png");
	}
}
