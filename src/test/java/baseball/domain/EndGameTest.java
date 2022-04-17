package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EndGameTest {

	@Test
	public void 정상_1_입력() {
		String numbers = "1";

		assertAll(() -> new EndGame(numbers));
	}

	@Test
	public void 정상_2_입력() {
		String numbers = "2";

		assertAll(() -> new EndGame(numbers));
	}

	@Test
	public void 비정상_입력() {
		String numbers = "3";

		assertThatIllegalArgumentException()
			.isThrownBy(() -> new EndGame(numbers));
	}
}