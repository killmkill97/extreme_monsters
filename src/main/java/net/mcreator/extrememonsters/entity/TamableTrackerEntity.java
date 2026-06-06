
package net.mcreator.extrememonsters.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.EventHooks;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.extrememonsters.procedures.TamableTrackerRightClickOnThisEntityProcedure;
import net.mcreator.extrememonsters.procedures.ReturnFollowingSetProcedure;
import net.mcreator.extrememonsters.init.ExtremeMonstersModEntities;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class TamableTrackerEntity extends TamableAnimal {
	public TamableTrackerEntity(EntityType<TamableTrackerEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		refreshDimensions();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1, (float) 10, (float) 2) {
			@Override
			public boolean canUse() {
				double x = TamableTrackerEntity.this.getX();
				double y = TamableTrackerEntity.this.getY();
				double z = TamableTrackerEntity.this.getZ();
				Entity entity = TamableTrackerEntity.this;
				Level world = TamableTrackerEntity.this.level();
				return super.canUse() && ReturnFollowingSetProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = TamableTrackerEntity.this.getX();
				double y = TamableTrackerEntity.this.getY();
				double z = TamableTrackerEntity.this.getZ();
				Entity entity = TamableTrackerEntity.this;
				Level world = TamableTrackerEntity.this.level();
				return super.canContinueToUse() && ReturnFollowingSetProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.goalSelector.addGoal(3, new TemptGoal(this, 1, Ingredient.of(ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK.get().asItem()), false));
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = TamableTrackerEntity.this.getX();
				double y = TamableTrackerEntity.this.getY();
				double z = TamableTrackerEntity.this.getZ();
				Entity entity = TamableTrackerEntity.this;
				Level world = TamableTrackerEntity.this.level();
				return super.canUse() && ReturnFollowingSetProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = TamableTrackerEntity.this.getX();
				double y = TamableTrackerEntity.this.getY();
				double z = TamableTrackerEntity.this.getZ();
				Entity entity = TamableTrackerEntity.this;
				Level world = TamableTrackerEntity.this.level();
				return super.canContinueToUse() && ReturnFollowingSetProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(5, new OwnerHurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = TamableTrackerEntity.this.getX();
				double y = TamableTrackerEntity.this.getY();
				double z = TamableTrackerEntity.this.getZ();
				Entity entity = TamableTrackerEntity.this;
				Level world = TamableTrackerEntity.this.level();
				return super.canUse() && ReturnFollowingSetProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = TamableTrackerEntity.this.getX();
				double y = TamableTrackerEntity.this.getY();
				double z = TamableTrackerEntity.this.getZ();
				Entity entity = TamableTrackerEntity.this;
				Level world = TamableTrackerEntity.this.level();
				return super.canContinueToUse() && ReturnFollowingSetProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(6, new OwnerHurtTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = TamableTrackerEntity.this.getX();
				double y = TamableTrackerEntity.this.getY();
				double z = TamableTrackerEntity.this.getZ();
				Entity entity = TamableTrackerEntity.this;
				Level world = TamableTrackerEntity.this.level();
				return super.canUse() && ReturnFollowingSetProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = TamableTrackerEntity.this.getX();
				double y = TamableTrackerEntity.this.getY();
				double z = TamableTrackerEntity.this.getZ();
				Entity entity = TamableTrackerEntity.this;
				Level world = TamableTrackerEntity.this.level();
				return super.canContinueToUse() && ReturnFollowingSetProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(7, new LeapAtTargetGoal(this, (float) 0.5));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(9, new FloatGoal(this));
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (damagesource.is(DamageTypes.FALL))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			retval = super.mobInteract(sourceentity, hand);
		} else if (this.level().isClientSide()) {
			retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack)) ? InteractionResult.sidedSuccess(this.level().isClientSide()) : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isOwnedBy(sourceentity)) {
					if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						FoodProperties foodproperties = itemstack.getFoodProperties(this);
						float nutrition = foodproperties != null ? (float) foodproperties.nutrition() : 1;
						this.heal(nutrition);
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal(4);
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else {
						retval = super.mobInteract(sourceentity, hand);
					}
				}
			} else if (this.isFood(itemstack)) {
				this.usePlayerItem(sourceentity, hand, itemstack);
				if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, sourceentity)) {
					this.tame(sourceentity);
					this.level().broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level().broadcastEntityEvent(this, (byte) 6);
				}
				this.setPersistenceRequired();
				retval = InteractionResult.sidedSuccess(this.level().isClientSide());
			} else {
				retval = super.mobInteract(sourceentity, hand);
				if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
					this.setPersistenceRequired();
			}
		}
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		TamableTrackerRightClickOnThisEntityProcedure.execute(world, x, y, z, entity, sourceentity, itemstack);
		return retval;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		TamableTrackerEntity retval = ExtremeMonstersModEntities.TAMABLE_TRACKER.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(new ItemStack(ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK.get())).test(stack);
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pose) {
		return super.getDefaultDimensions(pose).scale(0.5f);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.5);
		builder = builder.add(Attributes.MAX_HEALTH, 200);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}
