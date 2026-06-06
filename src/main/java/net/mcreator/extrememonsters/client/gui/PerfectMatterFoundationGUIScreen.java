package net.mcreator.extrememonsters.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.extrememonsters.world.inventory.PerfectMatterFoundationGUIMenu;
import net.mcreator.extrememonsters.procedures.PmfCraftButtonLogicProcedure;
import net.mcreator.extrememonsters.procedures.PerfectMatterFoundationGUIProgressDisplayProcedure;
import net.mcreator.extrememonsters.procedures.CanWorkDisplayProcedure;
import net.mcreator.extrememonsters.network.PerfectMatterFoundationGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PerfectMatterFoundationGUIScreen extends AbstractContainerScreen<PerfectMatterFoundationGUIMenu> {
	private final static HashMap<String, Object> guistate = PerfectMatterFoundationGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_craft;

	public PerfectMatterFoundationGUIScreen(PerfectMatterFoundationGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 166;
		this.imageHeight = 107;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/perfect_matter_foundation_gui.png");

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

				PerfectMatterFoundationGUIProgressDisplayProcedure.execute(world, x, y, z), 10, 13, -12829636, false);
		guiGraphics.drawString(this.font,

				CanWorkDisplayProcedure.execute(world, x, y, z), 10, 31, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_craft = Button.builder(Component.translatable("gui.extreme_monsters.perfect_matter_foundation_gui.button_craft"), e -> {
			if (PmfCraftButtonLogicProcedure.execute(world, x, y, z)) {
				PacketDistributor.sendToServer(new PerfectMatterFoundationGUIButtonMessage(0, x, y, z));
				PerfectMatterFoundationGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 55, this.topPos + 67, 51, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = PmfCraftButtonLogicProcedure.execute(world, x, y, z);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_craft", button_craft);
		this.addRenderableWidget(button_craft);
	}
}
