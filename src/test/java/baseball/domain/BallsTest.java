package baseball.domain;

import baseball.BallStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    public void nothing() {
        Ball userBall = new Ball(5, 1);
        Balls comBalls = new Balls("123");

        assertThat(comBalls.judgeBall(userBall)).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    public void ball() {
        Ball userBall = new Ball(1, 2);
        Balls comBalls = new Balls("123");

        assertThat(comBalls.judgeBall(userBall)).isEqualTo(BallStatus.BALL);
    }

    @Test
    public void strike() {
        Ball userBall = new Ball(3, 3);
        Balls comBalls = new Balls("123");

        assertThat(comBalls.judgeBall(userBall)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    public void result_1Strike_2Ball() {
        Balls comBalls = new Balls("123");
        Balls userBalls = new Balls("321");

        Result result = comBalls.judgeBalls(userBalls);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    public void result_2Strike() {
        Balls comBalls = new Balls("123");
        Balls userBalls = new Balls("423");

        Result result = comBalls.judgeBalls(userBalls);
        assertThat(result.getStrike()).isEqualTo(2);
    }

    @Test
    public void result_3Strike() {
        Balls comBalls = new Balls("123");
        Balls userBalls = new Balls("123");

        Result result = comBalls.judgeBalls(userBalls);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.isAllStrike()).isEqualTo(true);
    }

    @Test
    public void result_3Ball() {
        Balls comBalls = new Balls("123");
        Balls userBalls = new Balls("312");

        Result result = comBalls.judgeBalls(userBalls);
        assertThat(result.getBall()).isEqualTo(3);
    }

    @Test
    public void result_nothing() {
        Balls comBalls = new Balls("123");
        Balls userBalls = new Balls("456");

        Result result = comBalls.judgeBalls(userBalls);
        assertThat(result.isNothing()).isEqualTo(true);
    }
}
