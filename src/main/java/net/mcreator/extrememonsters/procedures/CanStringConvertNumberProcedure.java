package net.mcreator.extrememonsters.procedures;

public class CanStringConvertNumberProcedure {
	public static boolean execute(String StringNumber) {
		if (StringNumber == null)
			return false;
		if (StringNumber.contains("0") || StringNumber.contains("1") || StringNumber.contains("2") || StringNumber.contains("3") || StringNumber.contains("4") || StringNumber.contains("5") || StringNumber.contains("6") || StringNumber.contains("7")
				|| StringNumber.contains("8") || StringNumber.contains("9") || StringNumber.contains("-")) {
			if (!(StringNumber).isEmpty()) {
				return true;
			}
		}
		return false;
	}
}
