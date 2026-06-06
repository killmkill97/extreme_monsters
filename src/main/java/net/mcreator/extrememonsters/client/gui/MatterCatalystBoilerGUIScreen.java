package net.mcreator.extrememonsters.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.world.inventory.MatterCatalystBoilerGUIMenu;
import net.mcreator.extrememonsters.procedures.WorngPositionDisplayProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MatterCatalystBoilerGUIScreen extends AbstractContainerScreen<MatterCatalystBoilerGUIMenu> {
	private final static HashMap<String, Object> guistate = MatterCatalystBoilerGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public MatterCatalystBoilerGUIScreen(MatterCatalystBoilerGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/matter_catalyst_boiler_gui.png");

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

		double Progress_bar_display = 0;
		double local_progress_bar = 0;
		local_progress_bar = (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "progress")) / 12.5;

		int scrprogressint = (int) local_progress_bar;

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/mpbar_back.png"), this.leftPos + 24, this.topPos + 61, 0, 0, 128, 12, 128, 12);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/mpbar_fill.png"), this.leftPos + 24, this.topPos + 61, 0, 0, (int) scrprogressint, 12, (int) scrprogressint, 12);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/mpbar_nagertive.png"), this.leftPos + 24, this.topPos + 61, 0, 0, 128, 12, 128, 12);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.matter_catalyst_boiler_gui.label_nothing_here_yet"), 6, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.matter_catalyst_boiler_gui.label_matter_catalyst_boiler"), 6, 7, -12829636, false);
		guiGraphics.drawString(this.font,

				WorngPositionDisplayProcedure.execute(world, x, y, z), 96, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.matter_catalyst_boiler_gui.label_progress"), 6, 43, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
