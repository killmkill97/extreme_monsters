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

import net.mcreator.extrememonsters.world.inventory.OmegaDReactorGUIMenu;
import net.mcreator.extrememonsters.procedures.ShotDownButtonDisplayProcedure;
import net.mcreator.extrememonsters.procedures.OmegaDReactorTemperatureDisplayProcedure;
import net.mcreator.extrememonsters.procedures.OmegaDReactorStateProcedure;
import net.mcreator.extrememonsters.procedures.OmegaDReactorRefrigerantProcedure;
import net.mcreator.extrememonsters.procedures.OmegaDReactorFuelDisplayProcedure;
import net.mcreator.extrememonsters.procedures.ActivateButtonDisplayProcedure;
import net.mcreator.extrememonsters.network.OmegaDReactorGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class OmegaDReactorGUIScreen extends AbstractContainerScreen<OmegaDReactorGUIMenu> {
	private final static HashMap<String, Object> guistate = OmegaDReactorGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_activate;
	Button button_shotdown;

	public OmegaDReactorGUIScreen(OmegaDReactorGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 241;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/omega_d_reactor_gui.png");

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

				OmegaDReactorTemperatureDisplayProcedure.execute(world, x, y, z), 93, 34, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.omega_d_reactor_gui.label_fuel"), 84, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.omega_d_reactor_gui.label_refrigerant"), 138, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.omega_d_reactor_gui.label_t"), 12, 34, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.omega_d_reactor_gui.label_fuel1"), 12, 43, -12829636, false);
		guiGraphics.drawString(this.font,

				OmegaDReactorFuelDisplayProcedure.execute(world, x, y, z), 93, 43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.omega_d_reactor_gui.label_refrigerant1"), 12, 52, -12829636, false);
		guiGraphics.drawString(this.font,

				OmegaDReactorRefrigerantProcedure.execute(world, x, y, z), 93, 52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.omega_d_reactor_gui.label_state"), 12, 70, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.omega_d_reactor_gui.label_empty"), -93, -37, -12829636, false);
		guiGraphics.drawString(this.font,

				OmegaDReactorStateProcedure.execute(world, x, y, z), 48, 70, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_activate = Button.builder(Component.translatable("gui.extreme_monsters.omega_d_reactor_gui.button_activate"), e -> {
			if (ActivateButtonDisplayProcedure.execute(world, x, y, z)) {
				PacketDistributor.sendToServer(new OmegaDReactorGUIButtonMessage(0, x, y, z));
				OmegaDReactorGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 7, 67, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = ActivateButtonDisplayProcedure.execute(world, x, y, z);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_activate", button_activate);
		this.addRenderableWidget(button_activate);
		button_shotdown = Button.builder(Component.translatable("gui.extreme_monsters.omega_d_reactor_gui.button_shotdown"), e -> {
			if (ShotDownButtonDisplayProcedure.execute(world, x, y, z)) {
				PacketDistributor.sendToServer(new OmegaDReactorGUIButtonMessage(1, x, y, z));
				OmegaDReactorGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 7, 67, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = ShotDownButtonDisplayProcedure.execute(world, x, y, z);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_shotdown", button_shotdown);
		this.addRenderableWidget(button_shotdown);
	}
}
