package net.mcreator.extrememonsters.block.listener;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.entity.BlockEntityType;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlockEntities;
import net.mcreator.extrememonsters.block.renderer.TrackerContainmentCageTileRenderer;
import net.mcreator.extrememonsters.block.renderer.PlanetaryRegulatorTileRenderer;
import net.mcreator.extrememonsters.block.renderer.FictionalPlanetTileRenderer;
import net.mcreator.extrememonsters.block.renderer.ContainedSuperTrackerTileRenderer;
import net.mcreator.extrememonsters.block.renderer.ArtificialSunTileRenderer;
import net.mcreator.extrememonsters.block.renderer.ArtificialNeutronStarTileRenderer;
import net.mcreator.extrememonsters.block.entity.TrackerContainmentCageTileEntity;
import net.mcreator.extrememonsters.block.entity.PlanetaryRegulatorTileEntity;
import net.mcreator.extrememonsters.block.entity.FictionalPlanetTileEntity;
import net.mcreator.extrememonsters.block.entity.ContainedSuperTrackerTileEntity;
import net.mcreator.extrememonsters.block.entity.ArtificialSunTileEntity;
import net.mcreator.extrememonsters.block.entity.ArtificialNeutronStarTileEntity;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

@EventBusSubscriber(modid = ExtremeMonstersMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer((BlockEntityType<FictionalPlanetTileEntity>) ExtremeMonstersModBlockEntities.FICTIONAL_PLANET.get(), context -> new FictionalPlanetTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<ArtificialSunTileEntity>) ExtremeMonstersModBlockEntities.ARTIFICIAL_SUN.get(), context -> new ArtificialSunTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<PlanetaryRegulatorTileEntity>) ExtremeMonstersModBlockEntities.PLANETARY_REGULATOR.get(), context -> new PlanetaryRegulatorTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<ContainedSuperTrackerTileEntity>) ExtremeMonstersModBlockEntities.CONTAINED_SUPER_TRACKER.get(), context -> new ContainedSuperTrackerTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<TrackerContainmentCageTileEntity>) ExtremeMonstersModBlockEntities.TRACKER_CONTAINMENT_CAGE.get(), context -> new TrackerContainmentCageTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<ArtificialNeutronStarTileEntity>) ExtremeMonstersModBlockEntities.ARTIFICIAL_NEUTRON_STAR.get(), context -> new ArtificialNeutronStarTileRenderer());
	}
}
