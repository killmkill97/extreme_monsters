package net.mcreator.extrememonsters.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.extrememonsters.block.model.PlanetaryRegulatorBlockModel;
import net.mcreator.extrememonsters.block.entity.PlanetaryRegulatorTileEntity;

public class PlanetaryRegulatorTileRenderer extends GeoBlockRenderer<PlanetaryRegulatorTileEntity> {
	public PlanetaryRegulatorTileRenderer() {
		super(new PlanetaryRegulatorBlockModel());
	}

	@Override
	public RenderType getRenderType(PlanetaryRegulatorTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
