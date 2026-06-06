package net.mcreator.extrememonsters.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.extrememonsters.world.inventory.ZioExporterGUIMenu;
import net.mcreator.extrememonsters.procedures.ZioItemDestinationExportProcedure;
import net.mcreator.extrememonsters.procedures.ZioItemDestinationDisplayProcedure;
import net.mcreator.extrememonsters.procedures.ZioConnectDisplayExportProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ZioExporterGUIScreen extends AbstractContainerScreen<ZioExporterGUIMenu> {
	private final static HashMap<String, Object> guistate = ZioExporterGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ZioExporterGUIScreen(ZioExporterGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 249;
		this.imageHeight = 160;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/zio_exporter_gui.png");

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
		guiGraphics.drawString(this.font,

				ZioItemDestinationExportProcedure.execute(world, x, y, z), 7, 121, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.zio_exporter_gui.label_item_source_position"), 7, 13, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.zio_exporter_gui.label_item_source_block_name"), 7, 103, -12829636, false);
		guiGraphics.drawString(this.font,

				ZioItemDestinationDisplayProcedure.execute(world, x, y, z), 7, 76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.zio_exporter_gui.label_item_destination"), 7, 58, -12829636, false);
		guiGraphics.drawString(this.font,

				ZioConnectDisplayExportProcedure.execute(world, x, y, z), 7, 31, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
