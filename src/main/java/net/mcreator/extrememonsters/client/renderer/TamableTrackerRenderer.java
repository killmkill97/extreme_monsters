
package net.mcreator.extrememonsters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SpiderModel;

import net.mcreator.extrememonsters.entity.TamableTrackerEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class TamableTrackerRenderer extends MobRenderer<TamableTrackerEntity, SpiderModel<TamableTrackerEntity>> {
	public TamableTrackerRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel<TamableTrackerEntity>(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
	}

	@Override
	protected void scale(TamableTrackerEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.5f, 0.5f, 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TamableTrackerEntity entity) {
		return ResourceLocation.parse("extreme_monsters:textures/entities/cda.png");
	}
}
