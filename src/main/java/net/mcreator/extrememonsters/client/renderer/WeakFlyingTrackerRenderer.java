
package net.mcreator.extrememonsters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PigModel;

import net.mcreator.extrememonsters.entity.WeakFlyingTrackerEntity;

public class WeakFlyingTrackerRenderer extends MobRenderer<WeakFlyingTrackerEntity, PigModel<WeakFlyingTrackerEntity>> {
	public WeakFlyingTrackerRenderer(EntityRendererProvider.Context context) {
		super(context, new PigModel<WeakFlyingTrackerEntity>(context.bakeLayer(ModelLayers.PIG)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WeakFlyingTrackerEntity entity) {
		return ResourceLocation.parse("extreme_monsters:textures/entities/weak_trackers.png");
	}
}
