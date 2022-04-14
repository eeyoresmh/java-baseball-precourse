package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class ValidationNo {
    private final static String SIZE_EXCEPTION_MESSAGE = "3자리 숫자로 입력하십시오.";
    private final static String NO_EXCEPTION_MESSAGE = "중복 값이 존재합니다.";
    private final static int SIZE = 3;

    public boolean isOk(String numbers) {
        checkSize(numbers);
        checkDuplicateNumber(numbers);

        return true;
    }

    private void checkSize(String numbers) {
        if (isWrongSize(numbers.length())) {
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void checkDuplicateNumber(String numbers) {
        Set<Integer> checkedNum = new HashSet<>();

        for (int i = 0; i < numbers.length(); i++) {
            checkedNum.add(checkNumeric(numbers.charAt(i)));
        }

        if (isWrongSize(checkedNum.size())) {
            throw new IllegalArgumentException(NO_EXCEPTION_MESSAGE);
        }
    }

    private boolean isWrongSize(int size) {
        return size != SIZE;
    }

    private int checkNumeric(char targetChar) {
        if (!Character.isDigit(targetChar)) {
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }
        return Character.getNumericValue(targetChar);
    }
}
