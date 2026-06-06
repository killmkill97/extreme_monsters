package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.configuration.ExtremeMonstersConfigurationConfiguration;

import java.util.ArrayList;

public class WirelessAutoMenderWorkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double SlotCheck = 0;
		ItemStack paste_item = ItemStack.EMPTY;
		if (blockstate.getBlock().getStateDefinition().getProperty("work") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) {
			if (new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getEnergyStored();
					}
					return 0;
				}
			}.getEnergyStored(world, BlockPos.containing(x, y, z)) >= 1000000) {
				if (world instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
					if (_entityStorage != null)
						_entityStorage.extractEnergy(1000000, false);
				}
				if (ExtremeMonstersConfigurationConfiguration.MACHINE_PARTICLE.get()) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 1), (z + 0.5), 5, 0.25, 0.125, 0.2, 0);
				}
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).isDamaged()) {
						if (world instanceof ServerLevel _level) {
							(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(-150, _level, null, _stkprov -> {
							});
						}
					}
					if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).isDamaged()) {
						if (world instanceof ServerLevel _level) {
							(entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).hurtAndBreak(-150, _level, null, _stkprov -> {
							});
						}
					}
					if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).isDamaged()) {
						if (world instanceof ServerLevel _level) {
							(entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).hurtAndBreak(-150, _level, null, _stkprov -> {
							});
						}
					}
					if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).isDamaged()) {
						if (world instanceof ServerLevel _level) {
							(entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).hurtAndBreak(-150, _level, null, _stkprov -> {
							});
						}
					}
					if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).isDamaged()) {
						if (world instanceof ServerLevel _level) {
							(entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).hurtAndBreak(-150, _level, null, _stkprov -> {
							});
						}
					}
					for (int index0 = 0; index0 < 35; index0++) {
						if (!((new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									return _modHandler.getStackInSlot(sltid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) SlotCheck, entityiterator)).is(ItemTags.create(ResourceLocation.parse("extreme_monsters:soul"))))) {
							if (!((new Object() {
								public ItemStack getItemStack(int sltid, Entity entity) {
									if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
										return _modHandler.getStackInSlot(sltid).copy();
									}
									return ItemStack.EMPTY;
								}
							}.getItemStack((int) SlotCheck, entityiterator)).getItem() == ExtremeMonstersModItems.TOTEM_OF_BLACKHOLE.get())) {
								if ((new Object() {
									public ItemStack getItemStack(int sltid, Entity entity) {
										if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
											return _modHandler.getStackInSlot(sltid).copy();
										}
										return ItemStack.EMPTY;
									}
								}.getItemStack((int) SlotCheck, entityiterator)).isDamaged()) {
									paste_item = (new Object() {
										public ItemStack getItemStack(int sltid, Entity entity) {
											if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
												return _modHandler.getStackInSlot(sltid).copy();
											}
											return ItemStack.EMPTY;
										}
									}.getItemStack((int) SlotCheck, entityiterator)).copy();
									paste_item.applyComponents((new Object() {
										public ItemStack getItemStack(int sltid, Entity entity) {
											if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
												return _modHandler.getStackInSlot(sltid).copy();
											}
											return ItemStack.EMPTY;
										}
									}.getItemStack((int) SlotCheck, entityiterator)).getComponents());
									if (world instanceof ServerLevel _level) {
										paste_item.hurtAndBreak(-150, _level, null, _stkprov -> {
										});
									}
									if (entityiterator.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
										ItemStack _setstack = paste_item.copy();
										_setstack.setCount(paste_item.getCount());
										_modHandler.setStackInSlot((int) SlotCheck, _setstack);
									}
								}
							}
						}
						SlotCheck = SlotCheck + 1;
					}
				}
			}
		}
	}
}
