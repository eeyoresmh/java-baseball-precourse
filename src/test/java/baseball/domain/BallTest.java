package baseball.domain;

import baseball.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    public void ball_strike() {
        Ball userBall = new Ball(1, 0);
        Ball comBall = new Ball(1, 0);

        BallStatus ballStatus = userBall.judgeBall(comBall);

        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    public void ball_ball() {
        Ball userBall = new Ball(1, 0);
        Ball comBall = new Ball(1, 3);

        BallStatus ballStatus = userBall.judgeBall(comBall);

        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    public void ball_nothing() {
        Ball userBall = new Ball(1, 0);
        Ball comBall = new Ball(2, 0);

        BallStatus ballStatus = userBall.judgeBall(comBall);

        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
