package baseball.view;

import java.util.ArrayList;
import java.util.List;

import baseball.constants.InputStrings;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public void print(String msg) {
		System.out.print(msg);
	}

	public void println(String msg) {
		System.out.println(msg);
	}

	public String inputStr() {
		print(InputStrings.INPUT_NUMBER.getText());
		String input = Console.readLine();
		return (input);
	}

	public List<Integer> inputBall() {
		print(InputStrings.INPUT_NUMBER.getText());
		ArrayList<Integer> ret = new ArrayList<>();
		String input = Console.readLine();
		for (int i = 0; i < input.length(); i++) {
			int number = input.charAt(i) - '0';
			ret.add(number);
		}
		return (ret);
	}

	public String askGame() {
		println(InputStrings.INPUT_START.getText());
		String input = Console.readLine();
		return input;
	}

}
