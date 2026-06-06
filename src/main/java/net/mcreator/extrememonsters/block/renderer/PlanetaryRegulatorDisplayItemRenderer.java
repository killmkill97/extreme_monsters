package net.mcreator.extrememonsters.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.extrememonsters.block.model.PlanetaryRegulatorDisplayModel;
import net.mcreator.extrememonsters.block.display.PlanetaryRegulatorDisplayItem;

public class PlanetaryRegulatorDisplayItemRenderer extends GeoItemRenderer<PlanetaryRegulatorDisplayItem> {
	public PlanetaryRegulatorDisplayItemRenderer() {
		super(new PlanetaryRegulatorDisplayModel());
	}

	@Override
	public RenderType getRenderType(PlanetaryRegulatorDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
