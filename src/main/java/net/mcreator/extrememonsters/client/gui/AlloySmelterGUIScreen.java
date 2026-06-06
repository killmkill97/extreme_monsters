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

import net.mcreator.extrememonsters.world.inventory.AlloySmelterGUIMenu;
import net.mcreator.extrememonsters.procedures.SuperLavaDisplayReturnProcedure;
import net.mcreator.extrememonsters.procedures.HFEDisplayProcedure;
import net.mcreator.extrememonsters.procedures.EnergyDisplayProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AlloySmelterGUIScreen extends AbstractContainerScreen<AlloySmelterGUIMenu> {
	private final static HashMap<String, Object> guistate = AlloySmelterGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public AlloySmelterGUIScreen(AlloySmelterGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("extreme_monsters:textures/screens/alloy_smelter_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 116 && mouseX < leftPos + 140 && mouseY > topPos + 5 && mouseY < topPos + 29)
			guiGraphics.renderTooltip(font, Component.literal(EnergyDisplayProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 115 && mouseX < leftPos + 139 && mouseY > topPos + 59 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.literal(SuperLavaDisplayReturnProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 145 && mouseX < leftPos + 169 && mouseY > topPos + 5 && mouseY < topPos + 29)
			guiGraphics.renderTooltip(font, Component.literal(HFEDisplayProcedure.execute(world, x, y, z)), mouseX, mouseY);
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
		}.getValue(world, BlockPos.containing(x, y, z), "progress")) / 25;

		int scrprogressint = (int) local_progress_bar;
		
		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/energy_display.png"), this.leftPos + 112, this.topPos + 1, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_arrow_back.png"), this.leftPos + 66, this.topPos + 30, 0, 0, 64, 32, 64, 32);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_arrow_fill.png"), this.leftPos + 66, this.topPos + 30, 0, 0, scrprogressint, 32, scrprogressint, 32);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/progress_arrow_nagertive.png"), this.leftPos + 66, this.topPos + 30, 0, 0, 64, 32, 64, 32);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/super_lava_bucket.png"), this.leftPos + 118, this.topPos + 63, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("extreme_monsters:textures/screens/hfe_display.png"), this.leftPos + 141, this.topPos + 1, 0, 0, 32, 32, 32, 32);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.extreme_monsters.alloy_smelter_gui.label_dark_matter_generator"), 5, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
