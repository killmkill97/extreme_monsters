package net.mcreator.extrememonsters.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.extrememonsters.world.inventory.HFEUpScalerGUIMenu;
import net.mcreator.extrememonsters.procedures.HFEDisplayProcedure;
import net.mcreator.extrememonsters.procedures.EnergyDisplayProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class HFEUpScalerGUIScreen extends AbstractContainerScreen<HFEUpScalerGUIMenu> {
	private final static HashMap<String, Object> guistate = HFEUpScalerGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public HFEUpScalerGUIScreen(HFEUpScalerGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 110;
		this.imageHeight = 55;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/hfe_up_scaler_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 12 && mouseX < leftPos + 36 && mouseY > topPos + 14 && mouseY < topPos + 38)
			guiGraphics.renderTooltip(font, Component.literal(EnergyDisplayProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 70 && mouseX < leftPos + 94 && mouseY > topPos + 14 && mouseY < topPos + 38)
			guiGraphics.renderTooltip(font, Component.literal(HFEDisplayProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/energy_display.png"), this.leftPos + 7, this.topPos + 11, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/hfe_display.png"), this.leftPos + 67, this.topPos + 9, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/craft_arrow.png"), this.leftPos + 37, this.topPos + 9, 0, 0, 32, 32, 32, 32);

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
	}

	@Override
	public void init() {
		super.init();
	}
}
