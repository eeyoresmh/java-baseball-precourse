package baseball;

import baseball.domain.Balls;
import baseball.domain.EndGame;
import baseball.domain.Numbers;
import baseball.domain.Result;
import baseball.util.ComBallsUtil;
import camp.nextstep.edu.missionutils.Console;

public class Game {

	private static final String INPUT_NUMBERS = "숫자를 입력하세요";
	private static final String RE_GAME_OR_END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String END_GAME = "게임 종료";

	public void startGame() {
		Balls comBall = new Balls(ComBallsUtil.create());
		Result result;

		do {
			Balls userBall = new Balls(new Numbers(requestInput(INPUT_NUMBERS)).getNumbers());

			result = comBall.judgeBalls(userBall);
			System.out.println(result.toString());
		} while (!result.isAllStrike());

		restartOrEndGame();
	}

	private void restartOrEndGame() {
		EndGame endGame = new EndGame(requestInput(RE_GAME_OR_END_GAME));

		if (!endGame.isEndGame()) {
			startGame();
		}
	}

	public void endGame() {
		System.out.println(END_GAME);
	}

	private String requestInput(String message) {
		System.out.println(message);
		String answer = Console.readLine();

		return answer;
	}
}
