package baseball.domain;

public class EndGame {
	private static final String ONE = "1";
	private static final String TWO = "2";
	private static final String ONE_OR_TWO_EXCEPTION_MESSAGE = "1또는 2만 입력가능합니다.";

	private String inputString;

	public EndGame(String inputString) {
		if (!(inputString.equals(ONE) || inputString.equals(TWO))) {
			throw new IllegalArgumentException(ONE_OR_TWO_EXCEPTION_MESSAGE);
		}

		this.inputString = inputString;
	}

	public boolean isEndGame() {
		return this.inputString.equals(TWO) ? true : false;
	}
}
