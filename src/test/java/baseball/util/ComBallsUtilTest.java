package baseball.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ComBallsUtilTest {

	@Test
	public void create_numbers() {
		ComBallsUtil comBallsUtil = new ComBallsUtil();

		String number = comBallsUtil.create();

		System.out.println(number);
		assertThat(number.length()).isGreaterThan(0);
	}
}
