package net.mcreator.extrememonsters.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.extrememonsters.world.inventory.QssControllerRMenu;
import net.mcreator.extrememonsters.procedures.StabilCountReturnProcedure;
import net.mcreator.extrememonsters.procedures.QubitmemCountReturnProcedure;
import net.mcreator.extrememonsters.procedures.QssSrReturnProcedure;
import net.mcreator.extrememonsters.procedures.QssRecReturnProcedure;
import net.mcreator.extrememonsters.procedures.QssRecErrorReturnProcedure;
import net.mcreator.extrememonsters.procedures.QssProgressReturnProcedure;
import net.mcreator.extrememonsters.procedures.QssPrReturnProcedure;
import net.mcreator.extrememonsters.procedures.QssMultiBlockStateReturnProcedure;
import net.mcreator.extrememonsters.procedures.QssErrorReturnProcedure;
import net.mcreator.extrememonsters.procedures.QssErReturnProcedure;
import net.mcreator.extrememonsters.procedures.QssEptReturnProcedure;
import net.mcreator.extrememonsters.procedures.QssDrReturnProcedure;
import net.mcreator.extrememonsters.procedures.ErrsovCountReturnProcedure;
import net.mcreator.extrememonsters.procedures.EnergyDisplayProcedure;
import net.mcreator.extrememonsters.network.QssControllerRButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class QssControllerRScreen extends AbstractContainerScreen<QssControllerRMenu> {
	private final static HashMap<String, Object> guistate = QssControllerRMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_qss_number_state_what_is_this;
	ImageButton imagebutton_wrench;

	public QssControllerRScreen(QssControllerRMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 182;
		this.imageHeight = 234;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/qss_controller_r.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 95 && mouseX < leftPos + 119 && mouseY > topPos + 87 && mouseY < topPos + 111)
			guiGraphics.renderTooltip(font, Component.literal(EnergyDisplayProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 149 && mouseX < leftPos + 173 && mouseY > topPos + 87 && mouseY < topPos + 111)
			guiGraphics.renderTooltip(font, Component.translatable("gui.extreme_monsters.qss_controller_r.tooltip_click_to_show_the_meaning_of_the"), mouseX, mouseY);
		if (mouseX > leftPos + 122 && mouseX < leftPos + 146 && mouseY > topPos + 87 && mouseY < topPos + 111)
			guiGraphics.renderTooltip(font, Component.translatable("gui.extreme_monsters.qss_controller_r.tooltip_manual_repair"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/energy_display.png"), this.leftPos + 91, this.topPos + 83, 0, 0, 32, 32, 32, 32);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_quantum_superposition_simulation"), 5, 2, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_soul"), 100, 114, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_multi_block_state"), 5, 11, -12829636, false);
		guiGraphics.drawString(this.font,

				QssMultiBlockStateReturnProcedure.execute(world, x, y, z), 100, 11, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_stabilizer"), 5, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_qubit_memory"), 5, 29, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_error_solver"), 5, 38, -12829636, false);
		guiGraphics.drawString(this.font,

				StabilCountReturnProcedure.execute(world, x, y, z), 82, 20, -12829636, false);
		guiGraphics.drawString(this.font,

				QubitmemCountReturnProcedure.execute(world, x, y, z), 82, 29, -12829636, false);
		guiGraphics.drawString(this.font,

				ErrsovCountReturnProcedure.execute(world, x, y, z), 82, 38, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_numerical_status"), 5, 74, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_processing_rate"), 5, 87, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_success_rate"), 5, 96, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_error_rate"), 5, 114, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_restoration_error_rate"), 5, 123, -12829636, false);
		guiGraphics.drawString(this.font,

				QssPrReturnProcedure.execute(world, x, y, z), 32, 87, -12829636, false);
		guiGraphics.drawString(this.font,

				QssSrReturnProcedure.execute(world, x, y, z), 32, 96, -12829636, false);
		guiGraphics.drawString(this.font,

				QssErReturnProcedure.execute(world, x, y, z), 32, 114, -12829636, false);
		guiGraphics.drawString(this.font,

				QssRecReturnProcedure.execute(world, x, y, z), 32, 123, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_ept"), 5, 132, -12829636, false);
		guiGraphics.drawString(this.font,

				QssEptReturnProcedure.execute(world, x, y, z), 32, 132, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_dr"), 5, 105, -12829636, false);
		guiGraphics.drawString(this.font,

				QssDrReturnProcedure.execute(world, x, y, z), 32, 105, -12829636, false);
		guiGraphics.drawString(this.font,

				QssProgressReturnProcedure.execute(world, x, y, z), 82, 47, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_progress"), 5, 47, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_error"), 5, 56, -12829636, false);
		guiGraphics.drawString(this.font,

				QssErrorReturnProcedure.execute(world, x, y, z), 82, 56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.qss_controller_r.label_recovery_error"), 5, 65, -12829636, false);
		guiGraphics.drawString(this.font,

				QssRecErrorReturnProcedure.execute(world, x, y, z), 82, 65, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_qss_number_state_what_is_this = new ImageButton(this.leftPos + 154, this.topPos + 92, 16, 16,
				new WidgetSprites(ResourceLocation.parse("extreme_monsters:textures/screens/qss_number_state_what_is_this.png"), ResourceLocation.parse("extreme_monsters:textures/screens/qss_number_state_what_is_this.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new QssControllerRButtonMessage(0, x, y, z));
						QssControllerRButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_qss_number_state_what_is_this", imagebutton_qss_number_state_what_is_this);
		this.addRenderableWidget(imagebutton_qss_number_state_what_is_this);
		imagebutton_wrench = new ImageButton(this.leftPos + 122, this.topPos + 87, 24, 24,
				new WidgetSprites(ResourceLocation.parse("extreme_monsters:textures/screens/wrench.png"), ResourceLocation.parse("extreme_monsters:textures/screens/wrench.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new QssControllerRButtonMessage(1, x, y, z));
						QssControllerRButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_wrench", imagebutton_wrench);
		this.addRenderableWidget(imagebutton_wrench);
	}
}
