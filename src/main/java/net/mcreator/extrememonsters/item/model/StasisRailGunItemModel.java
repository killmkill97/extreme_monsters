package net.mcreator.extrememonsters.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.item.StasisRailGunItem;

public class StasisRailGunItemModel extends GeoModel<StasisRailGunItem> {
	@Override
	public ResourceLocation getAnimationResource(StasisRailGunItem animatable) {
		return ResourceLocation.parse("extreme_monsters:animations/dragon_railgun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StasisRailGunItem animatable) {
		return ResourceLocation.parse("extreme_monsters:geo/dragon_railgun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StasisRailGunItem animatable) {
		return ResourceLocation.parse("extreme_monsters:textures/item/stasis_railgun.png");
	}
}
