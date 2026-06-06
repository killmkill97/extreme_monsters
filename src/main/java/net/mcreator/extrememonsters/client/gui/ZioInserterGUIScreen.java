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

import net.mcreator.extrememonsters.world.inventory.ZioInserterGUIMenu;
import net.mcreator.extrememonsters.procedures.ZioItemSourceNameDisplayProcedure;
import net.mcreator.extrememonsters.procedures.ZioItemDestinationProcedure;
import net.mcreator.extrememonsters.procedures.ZioConnectDisplayProcedure;
import net.mcreator.extrememonsters.procedures.FilterOnOffDisplayProcedure;
import net.mcreator.extrememonsters.procedures.BlackListDisplayProcedure;
import net.mcreator.extrememonsters.network.ZioInserterGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ZioInserterGUIScreen extends AbstractContainerScreen<ZioInserterGUIMenu> {
	private final static HashMap<String, Object> guistate = ZioInserterGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_paper;
	ImageButton imagebutton_filter;

	public ZioInserterGUIScreen(ZioInserterGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 318;
		this.imageHeight = 160;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/zio_inserter_gui.png");

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

				ZioConnectDisplayProcedure.execute(world, x, y, z), 5, 31, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.zio_inserter_gui.label_item_source_position"), 5, 13, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.zio_inserter_gui.label_item_source_block_name"), 5, 58, -12829636, false);
		guiGraphics.drawString(this.font,

				ZioItemSourceNameDisplayProcedure.execute(world, x, y, z), 5, 76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.zio_inserter_gui.label_item_destination"), 5, 103, -12829636, false);
		guiGraphics.drawString(this.font,

				ZioItemDestinationProcedure.execute(world, x, y, z), 5, 121, -12829636, false);
		guiGraphics.drawString(this.font,

				BlackListDisplayProcedure.execute(world, x, y, z), 148, 34, -12829636, false);
		guiGraphics.drawString(this.font,

				FilterOnOffDisplayProcedure.execute(world, x, y, z), 184, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.zio_inserter_gui.label_filter"), 148, 16, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_paper = new ImageButton(this.leftPos + 229, this.topPos + 55, 16, 16, new WidgetSprites(ResourceLocation.parse("extreme_monsters:textures/screens/paper.png"), ResourceLocation.parse("extreme_monsters:textures/screens/paper.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new ZioInserterGUIButtonMessage(0, x, y, z));
						ZioInserterGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_paper", imagebutton_paper);
		this.addRenderableWidget(imagebutton_paper);
		imagebutton_filter = new ImageButton(this.leftPos + 207, this.topPos + 55, 16, 16,
				new WidgetSprites(ResourceLocation.parse("extreme_monsters:textures/screens/filter.png"), ResourceLocation.parse("extreme_monsters:textures/screens/filter.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ZioInserterGUIButtonMessage(1, x, y, z));
						ZioInserterGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_filter", imagebutton_filter);
		this.addRenderableWidget(imagebutton_filter);
	}
}
