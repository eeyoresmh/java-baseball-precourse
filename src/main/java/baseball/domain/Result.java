package baseball.domain;

import baseball.BallStatus;

public class Result {
	private static final String NOTHING = "낫싱";
	private static final String STRIKE_FORMAT = "%d스트라이크";
	private static final String BALL_FORMAT = "%d볼";
	private static final String BALL_AND_STRIKE_FORMAT = "%d볼 %d스트라이크";

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

	public boolean isStrike() {
		return strike > 0;
	}

	public boolean isBall() {
		return ball > 0;
	}

	@Override
	public String toString() {
		if (isStrike() && isBall()) {
			return String.format(BALL_AND_STRIKE_FORMAT, ball, strike);
		}

		if (isBall()) {
			return String.format(BALL_FORMAT, ball);
		}

		if (isStrike()) {
			return String.format(STRIKE_FORMAT, strike);
		}

		return NOTHING;
	}

}
