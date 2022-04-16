package baseball.domain;

import baseball.BallStatus;

public class Result {
	private int strike = 0;
	private int ball = 0;

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public void setData(BallStatus judgeBall) {
		if (judgeBall.isStrike()) {
			strike++;
		}

		if (judgeBall.isBall()) {
			ball++;
		}
	}

	public boolean isNothing() {
		return strike == 0 && ball == 0;
	}

	public boolean isAllStrike() {
		return strike == 3;
	}
}
