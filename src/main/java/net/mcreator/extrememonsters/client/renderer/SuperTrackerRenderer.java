
package net.mcreator.extrememonsters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SpiderModel;

import net.mcreator.extrememonsters.entity.SuperTrackerEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class SuperTrackerRenderer extends MobRenderer<SuperTrackerEntity, SpiderModel<SuperTrackerEntity>> {
	public SuperTrackerRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel<SuperTrackerEntity>(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
	}

	@Override
	protected void scale(SuperTrackerEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(2f, 2f, 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(SuperTrackerEntity entity) {
		return ResourceLocation.parse("extreme_monsters:textures/entities/cda.png");
	}

	@Override
	protected boolean isShaking(SuperTrackerEntity entity) {
		return true;
	}
}
