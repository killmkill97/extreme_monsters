package net.mcreator.extrememonsters.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.extrememonsters.block.model.FictionalPlanetDisplayModel;
import net.mcreator.extrememonsters.block.display.FictionalPlanetDisplayItem;

public class FictionalPlanetDisplayItemRenderer extends GeoItemRenderer<FictionalPlanetDisplayItem> {
	public FictionalPlanetDisplayItemRenderer() {
		super(new FictionalPlanetDisplayModel());
	}

	@Override
	public RenderType getRenderType(FictionalPlanetDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
