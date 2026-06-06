package net.mcreator.extrememonsters.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.extrememonsters.block.model.TrackerContainmentCageDisplayModel;
import net.mcreator.extrememonsters.block.display.TrackerContainmentCageDisplayItem;

public class TrackerContainmentCageDisplayItemRenderer extends GeoItemRenderer<TrackerContainmentCageDisplayItem> {
	public TrackerContainmentCageDisplayItemRenderer() {
		super(new TrackerContainmentCageDisplayModel());
	}

	@Override
	public RenderType getRenderType(TrackerContainmentCageDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
