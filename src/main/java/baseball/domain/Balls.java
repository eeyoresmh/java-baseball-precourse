package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.BallStatus;

public class Balls {
	private List<Ball> balls;

	public Balls(String numbers) {
		this.balls = mapToBalls(numbers);
	}

	private List<Ball> mapToBalls(String numbers) {
		List<Ball> balls = new ArrayList<>();
		for (int i = 0; i < numbers.length(); i++) {
			balls.add(new Ball(Character.getNumericValue(numbers.charAt(i)), i + 1));
		}
		return balls;
	}

	public BallStatus judgeBall(Ball userBall) {
        /*
            enum의 ordinal을 활용한 체크.
            중복 숫자가 없기에 총 가능 케이스는 3가지와 각 ordinal의 합
            1 strike 2 nothing  = 1
            1 ball 2 nothing  = 2
            3 nothing = 0
            각 케이스별로 ordinal 합으로 구분 가능
         */
		int ballStatusValue = 0;
		for (Ball ball : this.balls) {
			ballStatusValue += ball.judgeBall(userBall).ordinal();
		}

		return BallStatus.values()[ballStatusValue];
	}

	public Result judgeBalls(Balls userBalls) {
		Result result = new Result();

		for (Ball userBall : userBalls.balls) {
			result.setData(this.judgeBall(userBall));
		}

		return result;
	}
}
