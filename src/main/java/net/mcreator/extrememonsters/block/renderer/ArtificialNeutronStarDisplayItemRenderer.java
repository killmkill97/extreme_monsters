package net.mcreator.extrememonsters.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.extrememonsters.block.model.ArtificialNeutronStarDisplayModel;
import net.mcreator.extrememonsters.block.display.ArtificialNeutronStarDisplayItem;

public class ArtificialNeutronStarDisplayItemRenderer extends GeoItemRenderer<ArtificialNeutronStarDisplayItem> {
	public ArtificialNeutronStarDisplayItemRenderer() {
		super(new ArtificialNeutronStarDisplayModel());
	}

	@Override
	public RenderType getRenderType(ArtificialNeutronStarDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
