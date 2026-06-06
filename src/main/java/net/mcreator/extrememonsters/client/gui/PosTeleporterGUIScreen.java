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
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.extrememonsters.world.inventory.PosTeleporterGUIMenu;
import net.mcreator.extrememonsters.procedures.CurrentZReturnProcedure;
import net.mcreator.extrememonsters.procedures.CurrentYReturnProcedure;
import net.mcreator.extrememonsters.procedures.CurrentXReturnProcedure;
import net.mcreator.extrememonsters.network.PosTeleporterGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PosTeleporterGUIScreen extends AbstractContainerScreen<PosTeleporterGUIMenu> {
	private final static HashMap<String, Object> guistate = PosTeleporterGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox tx;
	EditBox ty;
	EditBox tz;
	ImageButton imagebutton_ender_pearl;
	ImageButton imagebutton_gear;

	public PosTeleporterGUIScreen(PosTeleporterGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 190;
		this.imageHeight = 197;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/pos_teleporter_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		tx.render(guiGraphics, mouseX, mouseY, partialTicks);
		ty.render(guiGraphics, mouseX, mouseY, partialTicks);
		tz.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 18 && mouseY < topPos + 42)
			guiGraphics.renderTooltip(font, Component.translatable("gui.extreme_monsters.pos_teleporter_gui.tooltip_go"), mouseX, mouseY);
		if (mouseX > leftPos + 9 && mouseX < leftPos + 33 && mouseY > topPos + 18 && mouseY < topPos + 42)
			guiGraphics.renderTooltip(font, Component.translatable("gui.extreme_monsters.pos_teleporter_gui.tooltip_y_pos_auto_setting"), mouseX, mouseY);
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
		if (tx.isFocused())
			return tx.keyPressed(key, b, c);
		if (ty.isFocused())
			return ty.keyPressed(key, b, c);
		if (tz.isFocused())
			return tz.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String txValue = tx.getValue();
		String tyValue = ty.getValue();
		String tzValue = tz.getValue();
		super.resize(minecraft, width, height);
		tx.setValue(txValue);
		ty.setValue(tyValue);
		tz.setValue(tzValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.pos_teleporter_gui.label_pos_teleporter"), 4, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.pos_teleporter_gui.label_x"), 22, 49, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.pos_teleporter_gui.label_y"), 22, 72, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.pos_teleporter_gui.label_z"), 22, 94, -12829636, false);
		guiGraphics.drawString(this.font,

				CurrentXReturnProcedure.execute(entity), 112, 13, -12829636, false);
		guiGraphics.drawString(this.font,

				CurrentYReturnProcedure.execute(entity), 112, 22, -12829636, false);
		guiGraphics.drawString(this.font,

				CurrentZReturnProcedure.execute(entity), 112, 31, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.pos_teleporter_gui.label_current_pos"), 112, 4, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		tx = new EditBox(this.font, this.leftPos + 37, this.topPos + 46, 118, 18, Component.translatable("gui.extreme_monsters.pos_teleporter_gui.tx"));
		tx.setMaxLength(32767);
		guistate.put("text:tx", tx);
		this.addWidget(this.tx);
		ty = new EditBox(this.font, this.leftPos + 37, this.topPos + 68, 118, 18, Component.translatable("gui.extreme_monsters.pos_teleporter_gui.ty"));
		ty.setMaxLength(32767);
		guistate.put("text:ty", ty);
		this.addWidget(this.ty);
		tz = new EditBox(this.font, this.leftPos + 37, this.topPos + 91, 118, 18, Component.translatable("gui.extreme_monsters.pos_teleporter_gui.tz"));
		tz.setMaxLength(32767);
		guistate.put("text:tz", tz);
		this.addWidget(this.tz);
		imagebutton_ender_pearl = new ImageButton(this.leftPos + 45, this.topPos + 13, 32, 32,
				new WidgetSprites(ResourceLocation.parse("extreme_monsters:textures/screens/ender_pearl.png"), ResourceLocation.parse("extreme_monsters:textures/screens/ender_pearl.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new PosTeleporterGUIButtonMessage(0, x, y, z));
						PosTeleporterGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_ender_pearl", imagebutton_ender_pearl);
		this.addRenderableWidget(imagebutton_ender_pearl);
		imagebutton_gear = new ImageButton(this.leftPos + 9, this.topPos + 18, 24, 24, new WidgetSprites(ResourceLocation.parse("extreme_monsters:textures/screens/gear.png"), ResourceLocation.parse("extreme_monsters:textures/screens/gear.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new PosTeleporterGUIButtonMessage(1, x, y, z));
						PosTeleporterGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_gear", imagebutton_gear);
		this.addRenderableWidget(imagebutton_gear);
	}
}
