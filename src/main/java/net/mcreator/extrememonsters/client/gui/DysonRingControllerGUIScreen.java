package net.mcreator.extrememonsters.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.extrememonsters.world.inventory.DysonRingControllerGUIMenu;
import net.mcreator.extrememonsters.procedures.DysonRingValidDisplayProcedure;
import net.mcreator.extrememonsters.procedures.DysonRingSolarPanelsDisplayProcedure;
import net.mcreator.extrememonsters.procedures.DysonRingEstimatedFEDisplayProcedure;
import net.mcreator.extrememonsters.procedures.DysonRingEstimatedEnergyDisplayProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class DysonRingControllerGUIScreen extends AbstractContainerScreen<DysonRingControllerGUIMenu> {
	private final static HashMap<String, Object> guistate = DysonRingControllerGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public DysonRingControllerGUIScreen(DysonRingControllerGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 205;
		this.imageHeight = 142;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/dyson_ring_controller_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.dyson_ring_controller_gui.label_nothing_in_here_yet"), 12, 9, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.dyson_ring_controller_gui.label_multiblock_status"), 12, 27, -12829636, false);
		guiGraphics.drawString(this.font,

				DysonRingValidDisplayProcedure.execute(world, x, y, z), 102, 27, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.dyson_ring_controller_gui.label_solar_panels"), 12, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.dyson_ring_controller_gui.label_estimated_energy_output"), 12, 58, -12829636, false);
		guiGraphics.drawString(this.font,

				DysonRingSolarPanelsDisplayProcedure.execute(world, x, y, z), 89, 40, -12829636, false);
		guiGraphics.drawString(this.font,

				DysonRingEstimatedEnergyDisplayProcedure.execute(world, x, y, z), 12, 72, -12829636, false);
		guiGraphics.drawString(this.font,

				DysonRingEstimatedFEDisplayProcedure.execute(world, x, y, z), 12, 85, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
