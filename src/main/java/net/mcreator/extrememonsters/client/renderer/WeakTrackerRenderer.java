
package net.mcreator.extrememonsters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CreeperModel;

import net.mcreator.extrememonsters.entity.WeakTrackerEntity;

public class WeakTrackerRenderer extends MobRenderer<WeakTrackerEntity, CreeperModel<WeakTrackerEntity>> {
	public WeakTrackerRenderer(EntityRendererProvider.Context context) {
		super(context, new CreeperModel<WeakTrackerEntity>(context.bakeLayer(ModelLayers.CREEPER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WeakTrackerEntity entity) {
		return ResourceLocation.parse("extreme_monsters:textures/entities/weak_trackers.png");
	}
}
