package baseball.services;

import java.util.EnumMap;
import java.util.List;

import baseball.model.Result;

public class GameService {

	public GameService() {
	}

	public EnumMap<Result, Integer> getResult(List<Integer> strikeZone, List<Integer> pitchBalls) {

		EnumMap<Result, Integer> result = new EnumMap<>(Result.class);
		for (int i = 0; i < pitchBalls.size(); i++) {
			int pitchZone = pitchBalls.get(i);
			if (strikeZone.get(i) == pitchZone) {
				result.put(Result.STRIKE, result.getOrDefault(Result.STRIKE, 0) + 1);
			} else if (strikeZone.contains(pitchZone)) {
				result.put(Result.BALL, result.getOrDefault(Result.BALL, 0) + 1);
			}
		}
		return (result);
	}
}
