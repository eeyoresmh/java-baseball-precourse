package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class Numbers {
	private static final String BALLS_SIZE_EXCEPTION_MESSAGE = "3자리 숫자로 입력하십시오.";
	private static final String DUPLICATE_EXCEPTION_MESSAGE = "중복 값이 존재합니다.";
	private static final int BALLS_SIZE = 3;

	private String numbers;

	public Numbers(String numbers) {
		checkSize(numbers);
		checkDuplicateNumber(numbers);

		this.numbers = numbers;
	}

	public String getNumbers() {
		return numbers;
	}

	public void checkSize(String numbers) {
		if (isWrongSize(numbers.length())) {
			throw new IllegalArgumentException(BALLS_SIZE_EXCEPTION_MESSAGE);
		}
	}

	public void checkDuplicateNumber(String numbers) {
		if (!isDuplicateNumber(numbers)) {
			throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
		}
	}

	private boolean isDuplicateNumber(String numbers) {
		Set<Integer> checkedNum = new HashSet<>();

		for (int i = 0; i < numbers.length(); i++) {
			checkedNum.add(checkNumeric(numbers.charAt(i)));
		}

		if (isWrongSize(checkedNum.size())) {
			return false;
		}

		return true;
	}

	private boolean isWrongSize(int size) {
		return size != BALLS_SIZE;
	}

	private int checkNumeric(char targetChar) {
		if (!Character.isDigit(targetChar)) {
			throw new IllegalArgumentException(BALLS_SIZE_EXCEPTION_MESSAGE);
		}
		return Character.getNumericValue(targetChar);
	}
}
