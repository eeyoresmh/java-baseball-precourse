package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class ValidationNo {
    private final static String SIZE_EXCEPTION_MESSAGE = "3자리 숫자로 입력하십시오.";
    private final static String NO_EXCEPTION_MESSAGE = "중복 값이 존재합니다.";
    private final static int SIZE = 3;

    public boolean isOk(String numbers) throws IllegalArgumentException {
        checkSize(numbers);
        checkDuplicateNumberThrowException(numbers);

        return true;
    }

    public boolean checkSize(String numbers) {
        if (isWrongSize(numbers.length())) {
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }

        return true;
    }

    public boolean checkDuplicateNumberThrowException(String numbers) throws IllegalArgumentException {

        if (!isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(NO_EXCEPTION_MESSAGE);
        }

        return true;
    }

    public boolean checkDuplicateNumber(String numbers) {

        if (!isDuplicateNumber(numbers)) {
            return false;
        }

        return true;
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
        return size != SIZE;
    }

    private int checkNumeric(char targetChar) {
        if (!Character.isDigit(targetChar)) {
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }
        return Character.getNumericValue(targetChar);
    }
}
