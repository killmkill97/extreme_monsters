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

import net.mcreator.extrememonsters.world.inventory.SolarResiduumCollectorGUIMenu;
import net.mcreator.extrememonsters.procedures.EnergyDisplayProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SolarResiduumCollectorGUIScreen extends AbstractContainerScreen<SolarResiduumCollectorGUIMenu> {
	private final static HashMap<String, Object> guistate = SolarResiduumCollectorGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public SolarResiduumCollectorGUIScreen(SolarResiduumCollectorGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/solar_residuum_collector_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 6 && mouseX < leftPos + 30 && mouseY > topPos + 23 && mouseY < topPos + 47)
			guiGraphics.renderTooltip(font, Component.literal(EnergyDisplayProcedure.execute(world, x, y, z)), mouseX, mouseY);
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

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/energy_display.png"), this.leftPos + 1, this.topPos + 19, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/mpbar_back.png"), this.leftPos + 23, this.topPos + 62, 0, 0, 128, 12, 128, 12);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/mpbar_fill.png"), this.leftPos + 23, this.topPos + 62, 0, 0, scrprogressint, 12, scrprogressint, 12);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/mpbar_nagertive.png"), this.leftPos + 23, this.topPos + 62, 0, 0, 128, 12, 128, 12);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.solar_residuum_collector_gui.label_solar_residuum_collector"), 7, 5, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
