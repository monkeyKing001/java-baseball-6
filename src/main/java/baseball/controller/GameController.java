package baseball.controller;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import baseball.constants.InputStrings;
import baseball.constants.Integers;
import baseball.constants.OutputStrings;
import baseball.model.Game;
import baseball.model.Result;
import baseball.services.GameService;
import baseball.util.StringUtil;
import baseball.util.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
	private final InputView inputView;
	private final OutputView outputView;
	private final GameService gameService;
	private final Game game;

	public GameController() {
		inputView = new InputView();
		outputView = new OutputView();
		game = new Game();
		gameService = new GameService();
	}

	public void start() {
		List<Integer> ballPitch = new ArrayList<>();
		try {
			String input = inputView.inputStr();
			Validation.isValidPitchInput(input);
			ballPitch = StringUtil.strToList(input);
			Validation.isValidPitch(ballPitch);
			//validation
		} catch (Exception e) {
			outputView.println(e.getMessage());
			start();
		}
		EnumMap<Result, Integer> result = gameService.getResult(game.getStrikeZone(), ballPitch);
		reportResult(result);
		askGame(result);
	}

	public void greetingGameStart() {
		outputView.println(OutputStrings.START_MESSAGE.getText());
	}

	public void reportResult(EnumMap<Result, Integer> result) {
		if (result.getOrDefault(Result.STRIKE, 0) == 0 && result.getOrDefault(Result.BALL, 0) == 0) {
			outputView.print(Result.NOTHING.getName());
		}
		if (result.getOrDefault(Result.BALL, 0) != 0) {
			reportBall(result);
		}
		if (result.getOrDefault(Result.STRIKE, 0) != 0) {
			reportStrike(result);
		}
		outputView.println("");
	}

	public void reportStrike(EnumMap<Result, Integer> result) {
		outputView.print(result.get(Result.STRIKE) + Result.STRIKE.getName());
		if (result.get(Result.STRIKE) == Integers.STRIKE_ZONE_NUMBER.getNumber()) {
			outputView.print(OutputStrings.END.getText());
		}
	}

	public void reportBall(EnumMap<Result, Integer> result) {
		outputView.print(result.get(Result.BALL) + Result.BALL.getName() + " ");
	}

	public void askGame(EnumMap<Result, Integer> result) {
		if (result.getOrDefault(Result.STRIKE, 0) == Integers.STRIKE_ZONE_NUMBER.getNumber()) {
			askTerminate();
		} else if (result.getOrDefault(Result.STRIKE, 0) != Integers.STRIKE_ZONE_NUMBER.getNumber()) {
			start();
		}
	}

	public void askTerminate() {
		try {
			String answer = inputView.askGame();
			Validation.isValidAnswer(answer);
			if (answer.compareTo(InputStrings.INPUT_YES.getText()) == 0) {
				game.generateStrikeZone();
				start();
			}
		} catch (Exception e) {
			outputView.println(e.getMessage());
			askTerminate();
		}
	}
}
