package net.mcreator.extrememonsters.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.extrememonsters.block.model.ContainedSuperTrackerDisplayModel;
import net.mcreator.extrememonsters.block.display.ContainedSuperTrackerDisplayItem;

public class ContainedSuperTrackerDisplayItemRenderer extends GeoItemRenderer<ContainedSuperTrackerDisplayItem> {
	public ContainedSuperTrackerDisplayItemRenderer() {
		super(new ContainedSuperTrackerDisplayModel());
	}

	@Override
	public RenderType getRenderType(ContainedSuperTrackerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
