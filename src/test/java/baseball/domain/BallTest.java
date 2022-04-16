package baseball.domain;

import baseball.BallStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    public void ball_strike() {
        Ball userBall = new Ball(1, 0);
        Ball comBall = new Ball(1, 0);

        BallStatus ballStatus = userBall.judgeBall(comBall);

        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
        assertThat(ballStatus.ordinal()).isEqualTo(2);
    }

    @Test
    public void ball_ball() {
        Ball userBall = new Ball(1, 0);
        Ball comBall = new Ball(1, 3);

        BallStatus ballStatus = userBall.judgeBall(comBall);

        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
        assertThat(ballStatus.ordinal()).isEqualTo(1);
    }

    @Test
    public void ball_nothing() {
        Ball userBall = new Ball(1, 0);
        Ball comBall = new Ball(2, 0);

        BallStatus ballStatus = userBall.judgeBall(comBall);

        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
        assertThat(ballStatus.ordinal()).isEqualTo(0);
    }
}
