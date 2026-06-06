package net.mcreator.extrememonsters.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.block.display.PlanetaryRegulatorDisplayItem;

public class PlanetaryRegulatorDisplayModel extends GeoModel<PlanetaryRegulatorDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(PlanetaryRegulatorDisplayItem animatable) {
		return ResourceLocation.parse("extreme_monsters:animations/planetary_regulator.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PlanetaryRegulatorDisplayItem animatable) {
		return ResourceLocation.parse("extreme_monsters:geo/planetary_regulator.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PlanetaryRegulatorDisplayItem entity) {
		return ResourceLocation.parse("extreme_monsters:textures/block/planetary_regulator.png");
	}
}
