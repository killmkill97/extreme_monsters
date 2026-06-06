package net.mcreator.extrememonsters.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.extrememonsters.block.model.ArtificialSunDisplayModel;
import net.mcreator.extrememonsters.block.display.ArtificialSunDisplayItem;

public class ArtificialSunDisplayItemRenderer extends GeoItemRenderer<ArtificialSunDisplayItem> {
	public ArtificialSunDisplayItemRenderer() {
		super(new ArtificialSunDisplayModel());
	}

	@Override
	public RenderType getRenderType(ArtificialSunDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
