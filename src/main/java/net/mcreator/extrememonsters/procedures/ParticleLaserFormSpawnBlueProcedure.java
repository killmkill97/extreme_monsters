package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleLaserFormSpawnBlueProcedure {
	public static void execute(LevelAccessor world, double Pax, double Pay, double Paz, double Pbx, double Pby, double Pbz, double Spacing) {
		double vx = 0;
		double vy = 0;
		double vz = 0;
		double distance = 0;
		double ux = 0;
		double uy = 0;
		double uz = 0;
		double px = 0;
		double py = 0;
		double pz = 0;
		double steps = 0;
		double loop_iterator = 0;
		vx = Pbx - Pax;
		vy = Pby - Pay;
		vz = Pbz - Paz;
		distance = Math.sqrt(vx * vx + vy * vy + vz * vz);
		ux = vx / distance;
		uy = vy / distance;
		uz = vz / distance;
		steps = (int) Math.round(distance / Spacing);
		for (int index0 = 0; index0 < (int) steps; index0++) {
			px = Pax + ux * loop_iterator * Spacing;
			py = Pay + uy * loop_iterator * Spacing;
			pz = Paz + uz * loop_iterator * Spacing;
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.OMINOUS_SPAWNING, px, py, pz, 1, 0.01, 0.01, 0.01, 0.15);
			loop_iterator = loop_iterator + 1;
		}
	}
}
