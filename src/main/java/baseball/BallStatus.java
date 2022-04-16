package baseball;

public enum BallStatus {
    NOTHING, BALL, STRIKE;

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
