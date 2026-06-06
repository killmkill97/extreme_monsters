package net.mcreator.extrememonsters.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.extrememonsters.block.model.ContainedSuperTrackerBlockModel;
import net.mcreator.extrememonsters.block.entity.ContainedSuperTrackerTileEntity;

public class ContainedSuperTrackerTileRenderer extends GeoBlockRenderer<ContainedSuperTrackerTileEntity> {
	public ContainedSuperTrackerTileRenderer() {
		super(new ContainedSuperTrackerBlockModel());
	}

	@Override
	public RenderType getRenderType(ContainedSuperTrackerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
