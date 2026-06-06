package net.mcreator.extrememonsters.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.block.display.ArtificialNeutronStarDisplayItem;

public class ArtificialNeutronStarDisplayModel extends GeoModel<ArtificialNeutronStarDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ArtificialNeutronStarDisplayItem animatable) {
		return ResourceLocation.parse("extreme_monsters:animations/artificial_sun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ArtificialNeutronStarDisplayItem animatable) {
		return ResourceLocation.parse("extreme_monsters:geo/artificial_sun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ArtificialNeutronStarDisplayItem entity) {
		return ResourceLocation.parse("extreme_monsters:textures/block/artificial_neutron_star.png");
	}
}
