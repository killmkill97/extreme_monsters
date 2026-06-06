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
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.extrememonsters.world.inventory.FictionalPlanetModifierGUIMenu;
import net.mcreator.extrememonsters.procedures.RarityDisplayProcedure;
import net.mcreator.extrememonsters.procedures.RFPpointDisplayProcedure;
import net.mcreator.extrememonsters.procedures.FPStatPointDisplayProcedure;
import net.mcreator.extrememonsters.procedures.DepthDisplayProcedure;
import net.mcreator.extrememonsters.procedures.DensityDisplayProcedure;
import net.mcreator.extrememonsters.network.FictionalPlanetModifierGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FictionalPlanetModifierGUIScreen extends AbstractContainerScreen<FictionalPlanetModifierGUIMenu> {
	private final static HashMap<String, Object> guistate = FictionalPlanetModifierGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_apply;
	ImageButton imagebutton_plus_button;
	ImageButton imagebutton_plus_button1;
	ImageButton imagebutton_plus_button2;
	ImageButton imagebutton_minus_button;
	ImageButton imagebutton_minus_button1;
	ImageButton imagebutton_minus_button2;

	public FictionalPlanetModifierGUIScreen(FictionalPlanetModifierGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 178;
		this.imageHeight = 173;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/fictional_planet_modifier_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.fictional_planet_modifier_gui.label_fictional_model_modifier"), 7, 6, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.fictional_planet_modifier_gui.label_stat_point"), 34, 19, -12829636, false);
		guiGraphics.drawString(this.font,

				FPStatPointDisplayProcedure.execute(world, x, y, z), 88, 19, -12829636, false);
		guiGraphics.drawString(this.font,

				DepthDisplayProcedure.execute(world, x, y, z), 97, 37, -12829636, false);
		guiGraphics.drawString(this.font,

				DensityDisplayProcedure.execute(world, x, y, z), 97, 55, -12829636, false);
		guiGraphics.drawString(this.font,

				RarityDisplayProcedure.execute(world, x, y, z), 97, 73, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.fictional_planet_modifier_gui.label_required"), 7, 37, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.fictional_planet_modifier_gui.label_fp_pointe"), 7, 46, -12829636, false);
		guiGraphics.drawString(this.font,

				RFPpointDisplayProcedure.execute(world, x, y, z), 7, 55, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_apply = Button.builder(Component.translatable("gui.extreme_monsters.fictional_planet_modifier_gui.button_apply"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FictionalPlanetModifierGUIButtonMessage(0, x, y, z));
				FictionalPlanetModifierGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 7, this.topPos + 68, 51, 20).build();
		guistate.put("button:button_apply", button_apply);
		this.addRenderableWidget(button_apply);
		imagebutton_plus_button = new ImageButton(this.leftPos + 61, this.topPos + 33, 16, 16,
				new WidgetSprites(ResourceLocation.parse("extreme_monsters:textures/screens/plus_button.png"), ResourceLocation.parse("extreme_monsters:textures/screens/plus_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FictionalPlanetModifierGUIButtonMessage(1, x, y, z));
						FictionalPlanetModifierGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_plus_button", imagebutton_plus_button);
		this.addRenderableWidget(imagebutton_plus_button);
		imagebutton_plus_button1 = new ImageButton(this.leftPos + 61, this.topPos + 51, 16, 16,
				new WidgetSprites(ResourceLocation.parse("extreme_monsters:textures/screens/plus_button.png"), ResourceLocation.parse("extreme_monsters:textures/screens/plus_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FictionalPlanetModifierGUIButtonMessage(2, x, y, z));
						FictionalPlanetModifierGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_plus_button1", imagebutton_plus_button1);
		this.addRenderableWidget(imagebutton_plus_button1);
		imagebutton_plus_button2 = new ImageButton(this.leftPos + 61, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("extreme_monsters:textures/screens/plus_button.png"), ResourceLocation.parse("extreme_monsters:textures/screens/plus_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FictionalPlanetModifierGUIButtonMessage(3, x, y, z));
						FictionalPlanetModifierGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_plus_button2", imagebutton_plus_button2);
		this.addRenderableWidget(imagebutton_plus_button2);
		imagebutton_minus_button = new ImageButton(this.leftPos + 79, this.topPos + 33, 16, 16,
				new WidgetSprites(ResourceLocation.parse("extreme_monsters:textures/screens/minus_button.png"), ResourceLocation.parse("extreme_monsters:textures/screens/minus_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FictionalPlanetModifierGUIButtonMessage(4, x, y, z));
						FictionalPlanetModifierGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_minus_button", imagebutton_minus_button);
		this.addRenderableWidget(imagebutton_minus_button);
		imagebutton_minus_button1 = new ImageButton(this.leftPos + 79, this.topPos + 51, 16, 16,
				new WidgetSprites(ResourceLocation.parse("extreme_monsters:textures/screens/minus_button.png"), ResourceLocation.parse("extreme_monsters:textures/screens/minus_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FictionalPlanetModifierGUIButtonMessage(5, x, y, z));
						FictionalPlanetModifierGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_minus_button1", imagebutton_minus_button1);
		this.addRenderableWidget(imagebutton_minus_button1);
		imagebutton_minus_button2 = new ImageButton(this.leftPos + 79, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("extreme_monsters:textures/screens/minus_button.png"), ResourceLocation.parse("extreme_monsters:textures/screens/minus_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FictionalPlanetModifierGUIButtonMessage(6, x, y, z));
						FictionalPlanetModifierGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_minus_button2", imagebutton_minus_button2);
		this.addRenderableWidget(imagebutton_minus_button2);
	}
}
