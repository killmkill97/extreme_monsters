package net.mcreator.extrememonsters.procedures;

import org.checkerframework.checker.units.qual.min;

public class ClampToMcreatorProdProcedure {
	public static double execute(double current, double max, double min) {
		if (current <= max && current >= min) {
			return current;
		} else if (current > max) {
			return max;
		} else if (current < min) {
			return min;
		}
		return Double.NaN;
	}
}
