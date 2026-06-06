package net.mcreator.extrememonsters.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.item.InfernoRailGunItem;

public class InfernoRailGunItemModel extends GeoModel<InfernoRailGunItem> {
	@Override
	public ResourceLocation getAnimationResource(InfernoRailGunItem animatable) {
		return ResourceLocation.parse("extreme_monsters:animations/dragon_railgun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(InfernoRailGunItem animatable) {
		return ResourceLocation.parse("extreme_monsters:geo/dragon_railgun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(InfernoRailGunItem animatable) {
		return ResourceLocation.parse("extreme_monsters:textures/item/dragon_railgun.png");
	}
}
