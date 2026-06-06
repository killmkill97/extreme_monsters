package net.mcreator.extrememonsters.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.extrememonsters.world.inventory.SimulationChamberGUiMenu;
import net.mcreator.extrememonsters.procedures.ProgressDDisplayOProcedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay9Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay8Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay7Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay6Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay5Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay4Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay3Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay2Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay1Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay15Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay14Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay13Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay12Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay11Procedure;
import net.mcreator.extrememonsters.procedures.ProgressDDisplay10Procedure;
import net.mcreator.extrememonsters.procedures.EnergyDisplayProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SimulationChamberGUiScreen extends AbstractContainerScreen<SimulationChamberGUiMenu> {
	private final static HashMap<String, Object> guistate = SimulationChamberGUiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public SimulationChamberGUiScreen(SimulationChamberGUiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/simulation_chamber_g_ui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 6 && mouseX < leftPos + 30 && mouseY > topPos + 51 && mouseY < topPos + 75)
			guiGraphics.renderTooltip(font, Component.literal(EnergyDisplayProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (ProgressDDisplayOProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_0.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_1.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_2.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_3.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_4.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_5.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_6.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_8.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_9.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_10.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_11.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay11Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_12.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay12Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_13.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay13Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_14.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay14Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_15.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}
		if (ProgressDDisplay15Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_bar_16.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 64, 32, 64, 32);
		}

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/energy_display.png"), this.leftPos + 2, this.topPos + 47, 0, 0, 32, 32, 32, 32);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.simulation_chamber_g_ui.label_dark_matter_generator"), 5, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
