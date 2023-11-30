package baseball.util;

import static baseball.constants.InputStrings.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.constants.Integers;

public class Validation {

	public static boolean isThreeDigit(String str) {
		if (str.length() != Integers.STRIKE_ZONE_NUMBER.getNumber()) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
			if (str.charAt(i) == '0') {
				return false;
			}
		}
		return true;
	}

	public static void isValidAnswer(String str) {
		if (str.length() != 1) {
			throw (new IllegalArgumentException("Error"));
		}
		if (str.compareTo(INPUT_YES.getText()) != 0 && str.compareTo(INPUT_NO.getText()) != 0) {
			throw (new IllegalArgumentException("Error"));
		}
	}

	public static void isValidPitch(List<Integer> ballPitch) {
		Set<Integer> set = new HashSet<>(ballPitch);
		if (set.size() != Integers.STRIKE_ZONE_NUMBER.getNumber()) {
			throw (new IllegalArgumentException("Error"));
		}
	}

	public static void isValidPitchInput(String input) {
		if (!isThreeDigit(input)) {
			throw (new IllegalArgumentException("Error"));
		}
	}
}
