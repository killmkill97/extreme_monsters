
package net.mcreator.extrememonsters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PigModel;

import net.mcreator.extrememonsters.entity.FlyingTrackerEntity;

public class FlyingTrackerRenderer extends MobRenderer<FlyingTrackerEntity, PigModel<FlyingTrackerEntity>> {
	public FlyingTrackerRenderer(EntityRendererProvider.Context context) {
		super(context, new PigModel<FlyingTrackerEntity>(context.bakeLayer(ModelLayers.PIG)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FlyingTrackerEntity entity) {
		return ResourceLocation.parse("extreme_monsters:textures/entities/cda.png");
	}
}
