
package net.mcreator.extrememonsters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CreeperModel;

import net.mcreator.extrememonsters.entity.TrackerEntity;

public class TrackerRenderer extends MobRenderer<TrackerEntity, CreeperModel<TrackerEntity>> {
	public TrackerRenderer(EntityRendererProvider.Context context) {
		super(context, new CreeperModel<TrackerEntity>(context.bakeLayer(ModelLayers.CREEPER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TrackerEntity entity) {
		return ResourceLocation.parse("extreme_monsters:textures/entities/cda.png");
	}
}
