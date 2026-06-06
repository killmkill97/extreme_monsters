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

import net.mcreator.extrememonsters.world.inventory.PlanetaryRegulatorGUIMenu;
import net.mcreator.extrememonsters.procedures.EnergyDisplayProcedure;
import net.mcreator.extrememonsters.network.PlanetaryRegulatorGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PlanetaryRegulatorGUIScreen extends AbstractContainerScreen<PlanetaryRegulatorGUIMenu> {
	private final static HashMap<String, Object> guistate = PlanetaryRegulatorGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_set_to_day;
	Button button_set_to_night;
	Button button_weather_clear;

	public PlanetaryRegulatorGUIScreen(PlanetaryRegulatorGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/planetary_regulator_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 8 && mouseX < leftPos + 32 && mouseY > topPos + 22 && mouseY < topPos + 46)
			guiGraphics.renderTooltip(font, Component.literal(EnergyDisplayProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/energy_display.png"), this.leftPos + 4, this.topPos + 18, 0, 0, 32, 32, 32, 32);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.planetary_regulator_gui.label_planetary_regulator"), 7, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_set_to_day = Button.builder(Component.translatable("gui.extreme_monsters.planetary_regulator_gui.button_set_to_day"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new PlanetaryRegulatorGUIButtonMessage(0, x, y, z));
				PlanetaryRegulatorGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 42, this.topPos + 52, 77, 20).build();
		guistate.put("button:button_set_to_day", button_set_to_day);
		this.addRenderableWidget(button_set_to_day);
		button_set_to_night = Button.builder(Component.translatable("gui.extreme_monsters.planetary_regulator_gui.button_set_to_night"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new PlanetaryRegulatorGUIButtonMessage(1, x, y, z));
				PlanetaryRegulatorGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 37, this.topPos + 79, 87, 20).build();
		guistate.put("button:button_set_to_night", button_set_to_night);
		this.addRenderableWidget(button_set_to_night);
		button_weather_clear = Button.builder(Component.translatable("gui.extreme_monsters.planetary_regulator_gui.button_weather_clear"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new PlanetaryRegulatorGUIButtonMessage(2, x, y, z));
				PlanetaryRegulatorGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 35, this.topPos + 107, 93, 20).build();
		guistate.put("button:button_weather_clear", button_weather_clear);
		this.addRenderableWidget(button_weather_clear);
	}
}
