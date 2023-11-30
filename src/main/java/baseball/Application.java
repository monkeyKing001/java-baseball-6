package baseball;

import baseball.controller.GameController;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		GameController gameController = new GameController();
		//Judge judge = new Judge();
		//JudgeController judgeController = new Judge();
		gameController.greetingGameStart();
		gameController.start();
	}
}
