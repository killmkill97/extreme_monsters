
package net.mcreator.extrememonsters.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;

import net.mcreator.extrememonsters.procedures.ShieldCapacityDisplayProcedure;
import net.mcreator.extrememonsters.procedures.ShieldCapacityDiplayLogicProcedure;
import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber({Dist.CLIENT})
public class ShieldCapacityDisplayScreenOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {

			if (entity == null)
				return;
			double Progress_bar_display = 0;
			double local_progress_bar = 0;
			local_progress_bar = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).shield_capacity / 2.34375;

			int scrprogressint = (int) local_progress_bar;
			
			if (ShieldCapacityDiplayLogicProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("extreme_monsters:textures/screens/shiled_bar_back.png"), 4, h - 17, 0, 0, 128, 12, 128, 12);
			}
			if (ShieldCapacityDiplayLogicProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("extreme_monsters:textures/screens/shiled_bar_fill.png"), 4, h - 17, 0, 0, (int)local_progress_bar, 12, (int)local_progress_bar, 12);
			}
			if (ShieldCapacityDiplayLogicProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("extreme_monsters:textures/screens/shiled_bar_nagertive.png"), 4, h - 17, 0, 0, 128, 12, 128, 12);
			}
			if (ShieldCapacityDiplayLogicProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ShieldCapacityDisplayProcedure.execute(entity), 33, h - 15, -7306, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
