package net.mcreator.extrememonsters.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.extrememonsters.block.model.ArtificialNeutronStarBlockModel;
import net.mcreator.extrememonsters.block.entity.ArtificialNeutronStarTileEntity;

public class ArtificialNeutronStarTileRenderer extends GeoBlockRenderer<ArtificialNeutronStarTileEntity> {
	public ArtificialNeutronStarTileRenderer() {
		super(new ArtificialNeutronStarBlockModel());
	}

	@Override
	public RenderType getRenderType(ArtificialNeutronStarTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
