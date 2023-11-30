package baseball.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	private final ArrayList<Integer> strikeZone;
	private final EnumMap<Result, Integer> result;

	public Game() {
		strikeZone = new ArrayList<>();
		while (strikeZone.size() != 3) {
			int num = Randoms.pickNumberInRange(1, 9);
			if (!strikeZone.contains(num)) {
				strikeZone.add(num);
			}
		}
		result = new EnumMap<>(Result.class);
	}

	public void generateStrikeZone() {
		strikeZone.clear();
		while (strikeZone.size() != 3) {
			int num = Randoms.pickNumberInRange(1, 9);
			if (!strikeZone.contains(num)) {
				strikeZone.add(num);
			}
		}
	}

	public List<Integer> getStrikeZone() {
		List<Integer> zone = new ArrayList<>(this.strikeZone);
		return zone;
	}
}
