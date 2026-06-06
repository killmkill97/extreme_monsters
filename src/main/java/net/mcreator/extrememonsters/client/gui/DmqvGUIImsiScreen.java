package net.mcreator.extrememonsters.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.extrememonsters.world.inventory.DmqvGUIImsiMenu;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class DmqvGUIImsiScreen extends AbstractContainerScreen<DmqvGUIImsiMenu> {
	private final static HashMap<String, Object> guistate = DmqvGUIImsiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public DmqvGUIImsiScreen(DmqvGUIImsiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 316;
		this.imageHeight = 240;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/dmqv_gui_imsi.png");

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

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/entangle_arrow.png"), this.leftPos + 268, this.topPos + 181, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.dmqv_gui_imsi.label_dark_matter_quantum_vault"), 90, -12, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
