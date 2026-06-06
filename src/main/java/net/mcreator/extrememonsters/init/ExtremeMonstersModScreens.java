
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.extrememonsters.client.gui.ZioInserterGUIScreen;
import net.mcreator.extrememonsters.client.gui.ZioExporterGUIScreen;
import net.mcreator.extrememonsters.client.gui.WitherIncubatorGUIScreen;
import net.mcreator.extrememonsters.client.gui.TungstenFurnaceGUIScreen;
import net.mcreator.extrememonsters.client.gui.TrackerIncubatorGUIScreen;
import net.mcreator.extrememonsters.client.gui.TrackerDefenderMk2GUIScreen;
import net.mcreator.extrememonsters.client.gui.TrackerDefenderGUIScreen;
import net.mcreator.extrememonsters.client.gui.TearExtractorGUIScreen;
import net.mcreator.extrememonsters.client.gui.TamableTrackerGUIScreen;
import net.mcreator.extrememonsters.client.gui.SuperSmeltingBlockGUIScreen;
import net.mcreator.extrememonsters.client.gui.SoulInputMachineGUIScreen;
import net.mcreator.extrememonsters.client.gui.SolarResiduumCollectorGUIScreen;
import net.mcreator.extrememonsters.client.gui.SimulationChamberGUiScreen;
import net.mcreator.extrememonsters.client.gui.RedstoneGeneratorGUIScreen;
import net.mcreator.extrememonsters.client.gui.QuantumAnchorGUIScreen;
import net.mcreator.extrememonsters.client.gui.QssOutputBlockGUIScreen;
import net.mcreator.extrememonsters.client.gui.QssControllerRScreen;
import net.mcreator.extrememonsters.client.gui.PosTeleporterGUIScreen;
import net.mcreator.extrememonsters.client.gui.PlanetaryRegulatorGUIScreen;
import net.mcreator.extrememonsters.client.gui.PerfectMatterFoundationGUIScreen;
import net.mcreator.extrememonsters.client.gui.OmegaDReactorGUIScreen;
import net.mcreator.extrememonsters.client.gui.NetheriteFusionReactorGUIScreen;
import net.mcreator.extrememonsters.client.gui.MolecularMatterResynthesizerGUIScreen;
import net.mcreator.extrememonsters.client.gui.MolecularDissolverGUIScreen;
import net.mcreator.extrememonsters.client.gui.MolecularCompressionStationGUIScreen;
import net.mcreator.extrememonsters.client.gui.MolecularAssemblerGUIScreen;
import net.mcreator.extrememonsters.client.gui.MolecularAlloyingForgeGUIScreen;
import net.mcreator.extrememonsters.client.gui.MicroverseSimulatorControllerGUIScreen;
import net.mcreator.extrememonsters.client.gui.MicroverseFuelInputBlockGUIScreen;
import net.mcreator.extrememonsters.client.gui.MatterFusionReactorGUIScreen;
import net.mcreator.extrememonsters.client.gui.MatterFusionReactorGUIDarkScreen;
import net.mcreator.extrememonsters.client.gui.MatterCatalystMakerGUIScreen;
import net.mcreator.extrememonsters.client.gui.MatterCatalystCompressorGUIScreen;
import net.mcreator.extrememonsters.client.gui.MatterCatalystBoilerGUIScreen;
import net.mcreator.extrememonsters.client.gui.ItemOutputBlockGUIScreen;
import net.mcreator.extrememonsters.client.gui.IronGeneratorGUIScreen;
import net.mcreator.extrememonsters.client.gui.InfinitySimulationChamberGUIScreen;
import net.mcreator.extrememonsters.client.gui.InfinityMatrixGUIScreen;
import net.mcreator.extrememonsters.client.gui.InfiniteCobblestoneSourceGUIScreen;
import net.mcreator.extrememonsters.client.gui.InfernoMiningControllerGUIScreen;
import net.mcreator.extrememonsters.client.gui.IceMakerGUIScreen;
import net.mcreator.extrememonsters.client.gui.HFEUpScalerGUIScreen;
import net.mcreator.extrememonsters.client.gui.HFEDownScalerGUIScreen;
import net.mcreator.extrememonsters.client.gui.HFEDisplayGUIScreen;
import net.mcreator.extrememonsters.client.gui.FluidInputBlockGUIScreen;
import net.mcreator.extrememonsters.client.gui.FictionalPlanetModifierGUIScreen;
import net.mcreator.extrememonsters.client.gui.DysonRingControllerGUIScreen;
import net.mcreator.extrememonsters.client.gui.DuplicatorGUIScreen;
import net.mcreator.extrememonsters.client.gui.DragonIncubatorGUIScreen;
import net.mcreator.extrememonsters.client.gui.DmqvGUIImsiScreen;
import net.mcreator.extrememonsters.client.gui.DimondGeneratorScreen;
import net.mcreator.extrememonsters.client.gui.DarkMatterQuantumVaultGUIScreen;
import net.mcreator.extrememonsters.client.gui.DarkMatterGeneratorGUIScreen;
import net.mcreator.extrememonsters.client.gui.DarkMatterGeneratorATypeScreen;
import net.mcreator.extrememonsters.client.gui.CopperGeneratorGUIScreen;
import net.mcreator.extrememonsters.client.gui.CombustionGeneratorGUIScreen;
import net.mcreator.extrememonsters.client.gui.BlackHoleMatterRelayGUIScreen;
import net.mcreator.extrememonsters.client.gui.AssemblerGUIScreen;
import net.mcreator.extrememonsters.client.gui.AppleCultivatorGUIScreen;
import net.mcreator.extrememonsters.client.gui.AlloySmelterGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ExtremeMonstersModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(ExtremeMonstersModMenus.DARK_MATTER_GENERATOR_GUI.get(), DarkMatterGeneratorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.BLACK_HOLE_MATTER_RELAY_GUI.get(), BlackHoleMatterRelayGUIScreen::new);
		event.register(ExtremeMonstersModMenus.NETHERITE_FUSION_REACTOR_GUI.get(), NetheriteFusionReactorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.SOUL_INPUT_MACHINE_GUI.get(), SoulInputMachineGUIScreen::new);
		event.register(ExtremeMonstersModMenus.SIMULATION_CHAMBER_G_UI.get(), SimulationChamberGUiScreen::new);
		event.register(ExtremeMonstersModMenus.ASSEMBLER_GUI.get(), AssemblerGUIScreen::new);
		event.register(ExtremeMonstersModMenus.TRACKER_DEFENDER_GUI.get(), TrackerDefenderGUIScreen::new);
		event.register(ExtremeMonstersModMenus.MATTER_FUSION_REACTOR_GUI.get(), MatterFusionReactorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.MATTER_CATALYST_MAKER_GUI.get(), MatterCatalystMakerGUIScreen::new);
		event.register(ExtremeMonstersModMenus.TRACKER_DEFENDER_MK_2_GUI.get(), TrackerDefenderMk2GUIScreen::new);
		event.register(ExtremeMonstersModMenus.COMBUSTION_GENERATOR_GUI.get(), CombustionGeneratorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.DUPLICATOR_GUI.get(), DuplicatorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.DIMOND_GENERATOR.get(), DimondGeneratorScreen::new);
		event.register(ExtremeMonstersModMenus.OMEGA_D_REACTOR_GUI.get(), OmegaDReactorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.ICE_MAKER_GUI.get(), IceMakerGUIScreen::new);
		event.register(ExtremeMonstersModMenus.DRAGON_INCUBATOR_GUI.get(), DragonIncubatorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.ALLOY_SMELTER_GUI.get(), AlloySmelterGUIScreen::new);
		event.register(ExtremeMonstersModMenus.PERFECT_MATTER_FOUNDATION_GUI.get(), PerfectMatterFoundationGUIScreen::new);
		event.register(ExtremeMonstersModMenus.INFINITY_MATRIX_GUI.get(), InfinityMatrixGUIScreen::new);
		event.register(ExtremeMonstersModMenus.INFINITY_SIMULATION_CHAMBER_GUI.get(), InfinitySimulationChamberGUIScreen::new);
		event.register(ExtremeMonstersModMenus.WITHER_INCUBATOR_GUI.get(), WitherIncubatorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.DARK_MATTER_GENERATOR_A_TYPE.get(), DarkMatterGeneratorATypeScreen::new);
		event.register(ExtremeMonstersModMenus.COPPER_GENERATOR_GUI.get(), CopperGeneratorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.DARK_MATTER_QUANTUM_VAULT_GUI.get(), DarkMatterQuantumVaultGUIScreen::new);
		event.register(ExtremeMonstersModMenus.APPLE_CULTIVATOR_GUI.get(), AppleCultivatorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.MATTER_CATALYST_COMPRESSOR_GUI.get(), MatterCatalystCompressorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.IRON_GENERATOR_GUI.get(), IronGeneratorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.REDSTONE_GENERATOR_GUI.get(), RedstoneGeneratorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.ZIO_INSERTER_GUI.get(), ZioInserterGUIScreen::new);
		event.register(ExtremeMonstersModMenus.ZIO_EXPORTER_GUI.get(), ZioExporterGUIScreen::new);
		event.register(ExtremeMonstersModMenus.DMQV_GUI_IMSI.get(), DmqvGUIImsiScreen::new);
		event.register(ExtremeMonstersModMenus.INFINITE_COBBLESTONE_SOURCE_GUI.get(), InfiniteCobblestoneSourceGUIScreen::new);
		event.register(ExtremeMonstersModMenus.INFERNO_MINING_CONTROLLER_GUI.get(), InfernoMiningControllerGUIScreen::new);
		event.register(ExtremeMonstersModMenus.ITEM_OUTPUT_BLOCK_GUI.get(), ItemOutputBlockGUIScreen::new);
		event.register(ExtremeMonstersModMenus.FICTIONAL_PLANET_MODIFIER_GUI.get(), FictionalPlanetModifierGUIScreen::new);
		event.register(ExtremeMonstersModMenus.PLANETARY_REGULATOR_GUI.get(), PlanetaryRegulatorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.QUANTUM_ANCHOR_GUI.get(), QuantumAnchorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.FLUID_INPUT_BLOCK_GUI.get(), FluidInputBlockGUIScreen::new);
		event.register(ExtremeMonstersModMenus.MATTER_CATALYST_BOILER_GUI.get(), MatterCatalystBoilerGUIScreen::new);
		event.register(ExtremeMonstersModMenus.SUPER_SMELTING_BLOCK_GUI.get(), SuperSmeltingBlockGUIScreen::new);
		event.register(ExtremeMonstersModMenus.QSS_CONTROLLER_R.get(), QssControllerRScreen::new);
		event.register(ExtremeMonstersModMenus.QSS_OUTPUT_BLOCK_GUI.get(), QssOutputBlockGUIScreen::new);
		event.register(ExtremeMonstersModMenus.TEAR_EXTRACTOR_GUI.get(), TearExtractorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.POS_TELEPORTER_GUI.get(), PosTeleporterGUIScreen::new);
		event.register(ExtremeMonstersModMenus.TUNGSTEN_FURNACE_GUI.get(), TungstenFurnaceGUIScreen::new);
		event.register(ExtremeMonstersModMenus.TRACKER_INCUBATOR_GUI.get(), TrackerIncubatorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.TAMABLE_TRACKER_GUI.get(), TamableTrackerGUIScreen::new);
		event.register(ExtremeMonstersModMenus.MATTER_FUSION_REACTOR_GUI_DARK.get(), MatterFusionReactorGUIDarkScreen::new);
		event.register(ExtremeMonstersModMenus.SOLAR_RESIDUUM_COLLECTOR_GUI.get(), SolarResiduumCollectorGUIScreen::new);
		event.register(ExtremeMonstersModMenus.HFE_UP_SCALER_GUI.get(), HFEUpScalerGUIScreen::new);
		event.register(ExtremeMonstersModMenus.HFE_DOWN_SCALER_GUI.get(), HFEDownScalerGUIScreen::new);
		event.register(ExtremeMonstersModMenus.HFE_DISPLAY_GUI.get(), HFEDisplayGUIScreen::new);
		event.register(ExtremeMonstersModMenus.DYSON_RING_CONTROLLER_GUI.get(), DysonRingControllerGUIScreen::new);
		event.register(ExtremeMonstersModMenus.MOLECULAR_ASSEMBLER_GUI.get(), MolecularAssemblerGUIScreen::new);
		event.register(ExtremeMonstersModMenus.MOLECULAR_DISSOLVER_GUI.get(), MolecularDissolverGUIScreen::new);
		event.register(ExtremeMonstersModMenus.MOLECULAR_MATTER_RESYNTHESIZER_GUI.get(), MolecularMatterResynthesizerGUIScreen::new);
		event.register(ExtremeMonstersModMenus.MOLECULAR_ALLOYING_FORGE_GUI.get(), MolecularAlloyingForgeGUIScreen::new);
		event.register(ExtremeMonstersModMenus.MOLECULAR_COMPRESSION_STATION_GUI.get(), MolecularCompressionStationGUIScreen::new);
		event.register(ExtremeMonstersModMenus.MICROVERSE_SIMULATOR_CONTROLLER_GUI.get(), MicroverseSimulatorControllerGUIScreen::new);
		event.register(ExtremeMonstersModMenus.MICROVERSE_FUEL_INPUT_BLOCK_GUI.get(), MicroverseFuelInputBlockGUIScreen::new);
	}
}
