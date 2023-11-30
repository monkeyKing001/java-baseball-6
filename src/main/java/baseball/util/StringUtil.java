package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	public static List<Integer> strToList(String str) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			arr.add(str.charAt(i) - '0');
		}
		return (arr);
	}
}
