package net.mcreator.extrememonsters.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.extrememonsters.world.inventory.MicroverseSimulatorControllerGUIMenu;
import net.mcreator.extrememonsters.procedures.WElementDisplayProcedure;
import net.mcreator.extrememonsters.procedures.SiElementDisplayProcedure;
import net.mcreator.extrememonsters.procedures.OElementDisplayProcedure;
import net.mcreator.extrememonsters.procedures.MvsStructureStateReturnProcedure;
import net.mcreator.extrememonsters.procedures.MVSPrimordialProgressReturnProcedure;
import net.mcreator.extrememonsters.procedures.MVSPrimordialProgressDisplayProcedure;
import net.mcreator.extrememonsters.procedures.MVSEraReturnProcedure;
import net.mcreator.extrememonsters.procedures.MVSEarlyStellarProgressReturnProcedure;
import net.mcreator.extrememonsters.procedures.MVSEarlyStellarProgressDisplayProcedure;
import net.mcreator.extrememonsters.procedures.MVSDegenerateProgressReturnProcedure;
import net.mcreator.extrememonsters.procedures.MVSDegenerateProgressDisplayProcedure;
import net.mcreator.extrememonsters.procedures.HeElementDisplayProcedure;
import net.mcreator.extrememonsters.procedures.HFEDisplayProcedure;
import net.mcreator.extrememonsters.procedures.HElementDisplayProcedure;
import net.mcreator.extrememonsters.procedures.FeElementDisplayProcedure;
import net.mcreator.extrememonsters.procedures.EnergyDisplayProcedure;
import net.mcreator.extrememonsters.procedures.CuElementDisplayProcedure;
import net.mcreator.extrememonsters.procedures.CElementDisplayProcedure;
import net.mcreator.extrememonsters.procedures.AuElementDisplayProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MicroverseSimulatorControllerGUIScreen extends AbstractContainerScreen<MicroverseSimulatorControllerGUIMenu> {
	private final static HashMap<String, Object> guistate = MicroverseSimulatorControllerGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public MicroverseSimulatorControllerGUIScreen(MicroverseSimulatorControllerGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/microverse_simulator_controller_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 119 && mouseX < leftPos + 143 && mouseY > topPos + 12 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.literal(EnergyDisplayProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 146 && mouseX < leftPos + 170 && mouseY > topPos + 12 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.literal(HFEDisplayProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/energy_display.png"), this.leftPos + 114, this.topPos + 7, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/hfe_display.png"), this.leftPos + 141, this.topPos + 7, 0, 0, 32, 32, 32, 32);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.microverse_simulator_controller_gui.label_nothing_here_yet"), 6, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.microverse_simulator_controller_gui.label_multiblock_state"), 6, 21, -12829636, false);
		guiGraphics.drawString(this.font,

				MvsStructureStateReturnProcedure.execute(world, x, y, z), 6, 30, -12829636, false);
		guiGraphics.drawString(this.font,

				MVSEraReturnProcedure.execute(world, x, y, z), 6, 43, -12829636, false);
		if (MVSPrimordialProgressDisplayProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font,

					MVSPrimordialProgressReturnProcedure.execute(world, x, y, z), 105, 43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.microverse_simulator_controller_gui.label_stored_elements"), 6, 66, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.microverse_simulator_controller_gui.label_h"), 6, 79, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.microverse_simulator_controller_gui.label_he"), 6, 88, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.microverse_simulator_controller_gui.label_c"), 6, 97, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.microverse_simulator_controller_gui.label_o"), 6, 106, -12829636, false);
		guiGraphics.drawString(this.font,

				HElementDisplayProcedure.execute(world, x, y, z), 24, 79, -12829636, false);
		guiGraphics.drawString(this.font,

				HeElementDisplayProcedure.execute(world, x, y, z), 24, 88, -12829636, false);
		guiGraphics.drawString(this.font,

				CElementDisplayProcedure.execute(world, x, y, z), 24, 97, -12829636, false);
		guiGraphics.drawString(this.font,

				OElementDisplayProcedure.execute(world, x, y, z), 24, 106, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.microverse_simulator_controller_gui.label_fe"), 6, 124, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.microverse_simulator_controller_gui.label_au"), 6, 142, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.microverse_simulator_controller_gui.label_w"), 6, 151, -12829636, false);
		guiGraphics.drawString(this.font,

				FeElementDisplayProcedure.execute(world, x, y, z), 24, 124, -12829636, false);
		guiGraphics.drawString(this.font,

				AuElementDisplayProcedure.execute(world, x, y, z), 24, 142, -12829636, false);
		guiGraphics.drawString(this.font,

				WElementDisplayProcedure.execute(world, x, y, z), 24, 151, -12829636, false);
		if (MVSEarlyStellarProgressDisplayProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font,

					MVSEarlyStellarProgressReturnProcedure.execute(world, x, y, z), 105, 43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.microverse_simulator_controller_gui.label_si"), 6, 115, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.microverse_simulator_controller_gui.label_cu"), 6, 133, -12829636, false);
		guiGraphics.drawString(this.font,

				SiElementDisplayProcedure.execute(world, x, y, z), 24, 115, -12829636, false);
		guiGraphics.drawString(this.font,

				CuElementDisplayProcedure.execute(world, x, y, z), 24, 133, -12829636, false);
		if (MVSDegenerateProgressDisplayProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font,

					MVSDegenerateProgressReturnProcedure.execute(world, x, y, z), 105, 43, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
