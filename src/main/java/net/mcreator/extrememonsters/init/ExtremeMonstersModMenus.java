
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.extrememonsters.world.inventory.ZioInserterGUIMenu;
import net.mcreator.extrememonsters.world.inventory.ZioExporterGUIMenu;
import net.mcreator.extrememonsters.world.inventory.WitherIncubatorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.TungstenFurnaceGUIMenu;
import net.mcreator.extrememonsters.world.inventory.TrackerIncubatorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.TrackerDefenderMk2GUIMenu;
import net.mcreator.extrememonsters.world.inventory.TrackerDefenderGUIMenu;
import net.mcreator.extrememonsters.world.inventory.TearExtractorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.TamableTrackerGUIMenu;
import net.mcreator.extrememonsters.world.inventory.SuperSmeltingBlockGUIMenu;
import net.mcreator.extrememonsters.world.inventory.SoulInputMachineGUIMenu;
import net.mcreator.extrememonsters.world.inventory.SolarResiduumCollectorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.SimulationChamberGUiMenu;
import net.mcreator.extrememonsters.world.inventory.RedstoneGeneratorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.QuantumAnchorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.QssOutputBlockGUIMenu;
import net.mcreator.extrememonsters.world.inventory.QssControllerRMenu;
import net.mcreator.extrememonsters.world.inventory.PosTeleporterGUIMenu;
import net.mcreator.extrememonsters.world.inventory.PlanetaryRegulatorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.PerfectMatterFoundationGUIMenu;
import net.mcreator.extrememonsters.world.inventory.OmegaDReactorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.NetheriteFusionReactorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.MolecularMatterResynthesizerGUIMenu;
import net.mcreator.extrememonsters.world.inventory.MolecularDissolverGUIMenu;
import net.mcreator.extrememonsters.world.inventory.MolecularCompressionStationGUIMenu;
import net.mcreator.extrememonsters.world.inventory.MolecularAssemblerGUIMenu;
import net.mcreator.extrememonsters.world.inventory.MolecularAlloyingForgeGUIMenu;
import net.mcreator.extrememonsters.world.inventory.MicroverseSimulatorControllerGUIMenu;
import net.mcreator.extrememonsters.world.inventory.MicroverseFuelInputBlockGUIMenu;
import net.mcreator.extrememonsters.world.inventory.MatterFusionReactorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.MatterFusionReactorGUIDarkMenu;
import net.mcreator.extrememonsters.world.inventory.MatterCatalystMakerGUIMenu;
import net.mcreator.extrememonsters.world.inventory.MatterCatalystCompressorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.MatterCatalystBoilerGUIMenu;
import net.mcreator.extrememonsters.world.inventory.ItemOutputBlockGUIMenu;
import net.mcreator.extrememonsters.world.inventory.IronGeneratorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.InfinitySimulationChamberGUIMenu;
import net.mcreator.extrememonsters.world.inventory.InfinityMatrixGUIMenu;
import net.mcreator.extrememonsters.world.inventory.InfiniteCobblestoneSourceGUIMenu;
import net.mcreator.extrememonsters.world.inventory.InfernoMiningControllerGUIMenu;
import net.mcreator.extrememonsters.world.inventory.IceMakerGUIMenu;
import net.mcreator.extrememonsters.world.inventory.HFEUpScalerGUIMenu;
import net.mcreator.extrememonsters.world.inventory.HFEDownScalerGUIMenu;
import net.mcreator.extrememonsters.world.inventory.HFEDisplayGUIMenu;
import net.mcreator.extrememonsters.world.inventory.FluidInputBlockGUIMenu;
import net.mcreator.extrememonsters.world.inventory.FictionalPlanetModifierGUIMenu;
import net.mcreator.extrememonsters.world.inventory.DysonRingControllerGUIMenu;
import net.mcreator.extrememonsters.world.inventory.DuplicatorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.DragonIncubatorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.DmqvGUIImsiMenu;
import net.mcreator.extrememonsters.world.inventory.DimondGeneratorMenu;
import net.mcreator.extrememonsters.world.inventory.DarkMatterQuantumVaultGUIMenu;
import net.mcreator.extrememonsters.world.inventory.DarkMatterGeneratorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.DarkMatterGeneratorATypeMenu;
import net.mcreator.extrememonsters.world.inventory.CopperGeneratorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.CombustionGeneratorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.BlackHoleMatterRelayGUIMenu;
import net.mcreator.extrememonsters.world.inventory.AssemblerGUIMenu;
import net.mcreator.extrememonsters.world.inventory.AppleCultivatorGUIMenu;
import net.mcreator.extrememonsters.world.inventory.AlloySmelterGUIMenu;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

public class ExtremeMonstersModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, ExtremeMonstersMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<DarkMatterGeneratorGUIMenu>> DARK_MATTER_GENERATOR_GUI = REGISTRY.register("dark_matter_generator_gui", () -> IMenuTypeExtension.create(DarkMatterGeneratorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BlackHoleMatterRelayGUIMenu>> BLACK_HOLE_MATTER_RELAY_GUI = REGISTRY.register("black_hole_matter_relay_gui", () -> IMenuTypeExtension.create(BlackHoleMatterRelayGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<NetheriteFusionReactorGUIMenu>> NETHERITE_FUSION_REACTOR_GUI = REGISTRY.register("netherite_fusion_reactor_gui", () -> IMenuTypeExtension.create(NetheriteFusionReactorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SoulInputMachineGUIMenu>> SOUL_INPUT_MACHINE_GUI = REGISTRY.register("soul_input_machine_gui", () -> IMenuTypeExtension.create(SoulInputMachineGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SimulationChamberGUiMenu>> SIMULATION_CHAMBER_G_UI = REGISTRY.register("simulation_chamber_g_ui", () -> IMenuTypeExtension.create(SimulationChamberGUiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AssemblerGUIMenu>> ASSEMBLER_GUI = REGISTRY.register("assembler_gui", () -> IMenuTypeExtension.create(AssemblerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TrackerDefenderGUIMenu>> TRACKER_DEFENDER_GUI = REGISTRY.register("tracker_defender_gui", () -> IMenuTypeExtension.create(TrackerDefenderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MatterFusionReactorGUIMenu>> MATTER_FUSION_REACTOR_GUI = REGISTRY.register("matter_fusion_reactor_gui", () -> IMenuTypeExtension.create(MatterFusionReactorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MatterCatalystMakerGUIMenu>> MATTER_CATALYST_MAKER_GUI = REGISTRY.register("matter_catalyst_maker_gui", () -> IMenuTypeExtension.create(MatterCatalystMakerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TrackerDefenderMk2GUIMenu>> TRACKER_DEFENDER_MK_2_GUI = REGISTRY.register("tracker_defender_mk_2_gui", () -> IMenuTypeExtension.create(TrackerDefenderMk2GUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CombustionGeneratorGUIMenu>> COMBUSTION_GENERATOR_GUI = REGISTRY.register("combustion_generator_gui", () -> IMenuTypeExtension.create(CombustionGeneratorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DuplicatorGUIMenu>> DUPLICATOR_GUI = REGISTRY.register("duplicator_gui", () -> IMenuTypeExtension.create(DuplicatorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DimondGeneratorMenu>> DIMOND_GENERATOR = REGISTRY.register("dimond_generator", () -> IMenuTypeExtension.create(DimondGeneratorMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OmegaDReactorGUIMenu>> OMEGA_D_REACTOR_GUI = REGISTRY.register("omega_d_reactor_gui", () -> IMenuTypeExtension.create(OmegaDReactorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<IceMakerGUIMenu>> ICE_MAKER_GUI = REGISTRY.register("ice_maker_gui", () -> IMenuTypeExtension.create(IceMakerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DragonIncubatorGUIMenu>> DRAGON_INCUBATOR_GUI = REGISTRY.register("dragon_incubator_gui", () -> IMenuTypeExtension.create(DragonIncubatorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AlloySmelterGUIMenu>> ALLOY_SMELTER_GUI = REGISTRY.register("alloy_smelter_gui", () -> IMenuTypeExtension.create(AlloySmelterGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PerfectMatterFoundationGUIMenu>> PERFECT_MATTER_FOUNDATION_GUI = REGISTRY.register("perfect_matter_foundation_gui", () -> IMenuTypeExtension.create(PerfectMatterFoundationGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<InfinityMatrixGUIMenu>> INFINITY_MATRIX_GUI = REGISTRY.register("infinity_matrix_gui", () -> IMenuTypeExtension.create(InfinityMatrixGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<InfinitySimulationChamberGUIMenu>> INFINITY_SIMULATION_CHAMBER_GUI = REGISTRY.register("infinity_simulation_chamber_gui",
			() -> IMenuTypeExtension.create(InfinitySimulationChamberGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<WitherIncubatorGUIMenu>> WITHER_INCUBATOR_GUI = REGISTRY.register("wither_incubator_gui", () -> IMenuTypeExtension.create(WitherIncubatorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DarkMatterGeneratorATypeMenu>> DARK_MATTER_GENERATOR_A_TYPE = REGISTRY.register("dark_matter_generator_a_type", () -> IMenuTypeExtension.create(DarkMatterGeneratorATypeMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CopperGeneratorGUIMenu>> COPPER_GENERATOR_GUI = REGISTRY.register("copper_generator_gui", () -> IMenuTypeExtension.create(CopperGeneratorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DarkMatterQuantumVaultGUIMenu>> DARK_MATTER_QUANTUM_VAULT_GUI = REGISTRY.register("dark_matter_quantum_vault_gui", () -> IMenuTypeExtension.create(DarkMatterQuantumVaultGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AppleCultivatorGUIMenu>> APPLE_CULTIVATOR_GUI = REGISTRY.register("apple_cultivator_gui", () -> IMenuTypeExtension.create(AppleCultivatorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MatterCatalystCompressorGUIMenu>> MATTER_CATALYST_COMPRESSOR_GUI = REGISTRY.register("matter_catalyst_compressor_gui",
			() -> IMenuTypeExtension.create(MatterCatalystCompressorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<IronGeneratorGUIMenu>> IRON_GENERATOR_GUI = REGISTRY.register("iron_generator_gui", () -> IMenuTypeExtension.create(IronGeneratorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RedstoneGeneratorGUIMenu>> REDSTONE_GENERATOR_GUI = REGISTRY.register("redstone_generator_gui", () -> IMenuTypeExtension.create(RedstoneGeneratorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ZioInserterGUIMenu>> ZIO_INSERTER_GUI = REGISTRY.register("zio_inserter_gui", () -> IMenuTypeExtension.create(ZioInserterGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ZioExporterGUIMenu>> ZIO_EXPORTER_GUI = REGISTRY.register("zio_exporter_gui", () -> IMenuTypeExtension.create(ZioExporterGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DmqvGUIImsiMenu>> DMQV_GUI_IMSI = REGISTRY.register("dmqv_gui_imsi", () -> IMenuTypeExtension.create(DmqvGUIImsiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<InfiniteCobblestoneSourceGUIMenu>> INFINITE_COBBLESTONE_SOURCE_GUI = REGISTRY.register("infinite_cobblestone_source_gui",
			() -> IMenuTypeExtension.create(InfiniteCobblestoneSourceGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<InfernoMiningControllerGUIMenu>> INFERNO_MINING_CONTROLLER_GUI = REGISTRY.register("inferno_mining_controller_gui", () -> IMenuTypeExtension.create(InfernoMiningControllerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ItemOutputBlockGUIMenu>> ITEM_OUTPUT_BLOCK_GUI = REGISTRY.register("item_output_block_gui", () -> IMenuTypeExtension.create(ItemOutputBlockGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FictionalPlanetModifierGUIMenu>> FICTIONAL_PLANET_MODIFIER_GUI = REGISTRY.register("fictional_planet_modifier_gui", () -> IMenuTypeExtension.create(FictionalPlanetModifierGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PlanetaryRegulatorGUIMenu>> PLANETARY_REGULATOR_GUI = REGISTRY.register("planetary_regulator_gui", () -> IMenuTypeExtension.create(PlanetaryRegulatorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuantumAnchorGUIMenu>> QUANTUM_ANCHOR_GUI = REGISTRY.register("quantum_anchor_gui", () -> IMenuTypeExtension.create(QuantumAnchorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FluidInputBlockGUIMenu>> FLUID_INPUT_BLOCK_GUI = REGISTRY.register("fluid_input_block_gui", () -> IMenuTypeExtension.create(FluidInputBlockGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MatterCatalystBoilerGUIMenu>> MATTER_CATALYST_BOILER_GUI = REGISTRY.register("matter_catalyst_boiler_gui", () -> IMenuTypeExtension.create(MatterCatalystBoilerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SuperSmeltingBlockGUIMenu>> SUPER_SMELTING_BLOCK_GUI = REGISTRY.register("super_smelting_block_gui", () -> IMenuTypeExtension.create(SuperSmeltingBlockGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QssControllerRMenu>> QSS_CONTROLLER_R = REGISTRY.register("qss_controller_r", () -> IMenuTypeExtension.create(QssControllerRMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QssOutputBlockGUIMenu>> QSS_OUTPUT_BLOCK_GUI = REGISTRY.register("qss_output_block_gui", () -> IMenuTypeExtension.create(QssOutputBlockGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TearExtractorGUIMenu>> TEAR_EXTRACTOR_GUI = REGISTRY.register("tear_extractor_gui", () -> IMenuTypeExtension.create(TearExtractorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PosTeleporterGUIMenu>> POS_TELEPORTER_GUI = REGISTRY.register("pos_teleporter_gui", () -> IMenuTypeExtension.create(PosTeleporterGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TungstenFurnaceGUIMenu>> TUNGSTEN_FURNACE_GUI = REGISTRY.register("tungsten_furnace_gui", () -> IMenuTypeExtension.create(TungstenFurnaceGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TrackerIncubatorGUIMenu>> TRACKER_INCUBATOR_GUI = REGISTRY.register("tracker_incubator_gui", () -> IMenuTypeExtension.create(TrackerIncubatorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TamableTrackerGUIMenu>> TAMABLE_TRACKER_GUI = REGISTRY.register("tamable_tracker_gui", () -> IMenuTypeExtension.create(TamableTrackerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MatterFusionReactorGUIDarkMenu>> MATTER_FUSION_REACTOR_GUI_DARK = REGISTRY.register("matter_fusion_reactor_gui_dark", () -> IMenuTypeExtension.create(MatterFusionReactorGUIDarkMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SolarResiduumCollectorGUIMenu>> SOLAR_RESIDUUM_COLLECTOR_GUI = REGISTRY.register("solar_residuum_collector_gui", () -> IMenuTypeExtension.create(SolarResiduumCollectorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HFEUpScalerGUIMenu>> HFE_UP_SCALER_GUI = REGISTRY.register("hfe_up_scaler_gui", () -> IMenuTypeExtension.create(HFEUpScalerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HFEDownScalerGUIMenu>> HFE_DOWN_SCALER_GUI = REGISTRY.register("hfe_down_scaler_gui", () -> IMenuTypeExtension.create(HFEDownScalerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HFEDisplayGUIMenu>> HFE_DISPLAY_GUI = REGISTRY.register("hfe_display_gui", () -> IMenuTypeExtension.create(HFEDisplayGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DysonRingControllerGUIMenu>> DYSON_RING_CONTROLLER_GUI = REGISTRY.register("dyson_ring_controller_gui", () -> IMenuTypeExtension.create(DysonRingControllerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MolecularAssemblerGUIMenu>> MOLECULAR_ASSEMBLER_GUI = REGISTRY.register("molecular_assembler_gui", () -> IMenuTypeExtension.create(MolecularAssemblerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MolecularDissolverGUIMenu>> MOLECULAR_DISSOLVER_GUI = REGISTRY.register("molecular_dissolver_gui", () -> IMenuTypeExtension.create(MolecularDissolverGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MolecularMatterResynthesizerGUIMenu>> MOLECULAR_MATTER_RESYNTHESIZER_GUI = REGISTRY.register("molecular_matter_resynthesizer_gui",
			() -> IMenuTypeExtension.create(MolecularMatterResynthesizerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MolecularAlloyingForgeGUIMenu>> MOLECULAR_ALLOYING_FORGE_GUI = REGISTRY.register("molecular_alloying_forge_gui", () -> IMenuTypeExtension.create(MolecularAlloyingForgeGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MolecularCompressionStationGUIMenu>> MOLECULAR_COMPRESSION_STATION_GUI = REGISTRY.register("molecular_compression_station_gui",
			() -> IMenuTypeExtension.create(MolecularCompressionStationGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MicroverseSimulatorControllerGUIMenu>> MICROVERSE_SIMULATOR_CONTROLLER_GUI = REGISTRY.register("microverse_simulator_controller_gui",
			() -> IMenuTypeExtension.create(MicroverseSimulatorControllerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MicroverseFuelInputBlockGUIMenu>> MICROVERSE_FUEL_INPUT_BLOCK_GUI = REGISTRY.register("microverse_fuel_input_block_gui",
			() -> IMenuTypeExtension.create(MicroverseFuelInputBlockGUIMenu::new));
}
