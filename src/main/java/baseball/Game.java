package baseball;

import java.sql.SQLOutput;

import baseball.domain.Balls;
import baseball.domain.Result;
import baseball.util.ComBallsUtil;
import baseball.util.ValidationNo;
import camp.nextstep.edu.missionutils.Console;

public class Game {

	public void startGame() {
		Balls comBall = new Balls(ComBallsUtil.create());
		Result result;

		do {
			System.out.println("숫자를 입력하세요");
			String userNumber = Console.readLine();
			ValidationNo.isOk(userNumber);

			Balls userBall = new Balls(userNumber);

			result = comBall.judgeBalls(userBall);
			System.out.println(result.toString());
		} while (!result.isAllStrike());

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");

		restartOrEndGame();
	}

	public void restartOrEndGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String answer = Console.readLine();

		ValidationNo.checkOneOrTwo(answer);

		if (answer.equals("1")) {
			startGame();
		}

		return;
	}
}
