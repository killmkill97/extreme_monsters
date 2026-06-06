package net.mcreator.extrememonsters.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.extrememonsters.world.inventory.QuantumAnchorGUIMenu;
import net.mcreator.extrememonsters.network.QuantumAnchorGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class QuantumAnchorGUIScreen extends AbstractContainerScreen<QuantumAnchorGUIMenu> {
	private final static HashMap<String, Object> guistate = QuantumAnchorGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox displayName;
	Button button_apply;

	public QuantumAnchorGUIScreen(QuantumAnchorGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/quantum_anchor_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		displayName.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/entangle_arrow.png"), this.leftPos + 151, this.topPos + 35, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (displayName.isFocused())
			return displayName.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String displayNameValue = displayName.getValue();
		super.resize(minecraft, width, height);
		displayName.setValue(displayNameValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		displayName = new EditBox(this.font, this.leftPos + 6, this.topPos + 8, 118, 18, Component.translatable("gui.extreme_monsters.quantum_anchor_gui.displayName")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.extreme_monsters.quantum_anchor_gui.displayName").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.extreme_monsters.quantum_anchor_gui.displayName").getString());
				else
					setSuggestion(null);
			}
		};
		displayName.setMaxLength(32767);
		displayName.setSuggestion(Component.translatable("gui.extreme_monsters.quantum_anchor_gui.displayName").getString());
		guistate.put("text:displayName", displayName);
		this.addWidget(this.displayName);
		button_apply = Button.builder(Component.translatable("gui.extreme_monsters.quantum_anchor_gui.button_apply"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new QuantumAnchorGUIButtonMessage(0, x, y, z));
				QuantumAnchorGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 56, 51, 20).build();
		guistate.put("button:button_apply", button_apply);
		this.addRenderableWidget(button_apply);
	}
}
