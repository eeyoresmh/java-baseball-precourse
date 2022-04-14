package baseball.domain;

import baseball.BallStatus;

import java.util.Objects;

public class Ball {
    int no;
    int index;


    public Ball( int no, int index) {
        this.no = no;
        this.index = index;
    }


    public BallStatus judgeBall(Ball comBall) {

        if (this.equals(comBall)) {
            return BallStatus.STRIKE;
        }

        if (this.no == comBall.no) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return no == ball.no && index == ball.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, index);
    }
}
