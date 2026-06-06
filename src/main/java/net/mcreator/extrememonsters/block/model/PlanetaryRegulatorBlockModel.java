package net.mcreator.extrememonsters.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.block.entity.PlanetaryRegulatorTileEntity;

public class PlanetaryRegulatorBlockModel extends GeoModel<PlanetaryRegulatorTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(PlanetaryRegulatorTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return ResourceLocation.parse("extreme_monsters:animations/planetary_regulator.animation.json");
		if (blockstate == 2)
			return ResourceLocation.parse("extreme_monsters:animations/planetary_regulator.animation.json");
		return ResourceLocation.parse("extreme_monsters:animations/planetary_regulator.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PlanetaryRegulatorTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return ResourceLocation.parse("extreme_monsters:geo/planetary_regulator.geo.json");
		if (blockstate == 2)
			return ResourceLocation.parse("extreme_monsters:geo/planetary_regulator.geo.json");
		return ResourceLocation.parse("extreme_monsters:geo/planetary_regulator.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PlanetaryRegulatorTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return ResourceLocation.parse("extreme_monsters:textures/block/planetary_regulator_night.png");
		if (blockstate == 2)
			return ResourceLocation.parse("extreme_monsters:textures/block/planetary_regulator.png");
		return ResourceLocation.parse("extreme_monsters:textures/block/planetary_regulator.png");
	}
}
