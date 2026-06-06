
package net.mcreator.extrememonsters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SilverfishModel;

import net.mcreator.extrememonsters.entity.HyperTrackerEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class HyperTrackerRenderer extends MobRenderer<HyperTrackerEntity, SilverfishModel<HyperTrackerEntity>> {
	public HyperTrackerRenderer(EntityRendererProvider.Context context) {
		super(context, new SilverfishModel<HyperTrackerEntity>(context.bakeLayer(ModelLayers.SILVERFISH)), 1.2f);
	}

	@Override
	protected void scale(HyperTrackerEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(3f, 3f, 3f);
	}

	@Override
	public ResourceLocation getTextureLocation(HyperTrackerEntity entity) {
		return ResourceLocation.parse("extreme_monsters:textures/entities/silverfish.png");
	}

	@Override
	protected boolean isShaking(HyperTrackerEntity entity) {
		return true;
	}
}
