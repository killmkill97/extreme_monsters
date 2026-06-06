package net.mcreator.extrememonsters.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.extrememonsters.block.model.FictionalPlanetBlockModel;
import net.mcreator.extrememonsters.block.entity.FictionalPlanetTileEntity;

public class FictionalPlanetTileRenderer extends GeoBlockRenderer<FictionalPlanetTileEntity> {
	public FictionalPlanetTileRenderer() {
		super(new FictionalPlanetBlockModel());
	}

	@Override
	public RenderType getRenderType(FictionalPlanetTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
