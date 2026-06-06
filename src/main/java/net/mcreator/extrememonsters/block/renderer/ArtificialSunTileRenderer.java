package net.mcreator.extrememonsters.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.extrememonsters.block.model.ArtificialSunBlockModel;
import net.mcreator.extrememonsters.block.entity.ArtificialSunTileEntity;

public class ArtificialSunTileRenderer extends GeoBlockRenderer<ArtificialSunTileEntity> {
	public ArtificialSunTileRenderer() {
		super(new ArtificialSunBlockModel());
	}

	@Override
	public RenderType getRenderType(ArtificialSunTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
