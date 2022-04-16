package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class ValidationNo {
    private static final String BALLS_SIZE_EXCEPTION_MESSAGE = "3자리 숫자로 입력하십시오.";
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "중복 값이 존재합니다.";
    private static final String ONE_OR_TWO_EXCEPTION_MESSAGE = "1또는 2만 입력가능합니다.";
    private static final int BALLS_SIZE = 3;

    public static boolean isOk(String numbers) throws IllegalArgumentException {
        checkSize(numbers);
        checkDuplicateNumberThrowException(numbers);

        return true;
    }

    public static boolean checkSize(String numbers) {
        if (isWrongSize(numbers.length())) {
            throw new IllegalArgumentException(BALLS_SIZE_EXCEPTION_MESSAGE);
        }

        return true;
    }

    public static boolean checkOneOrTwo(String numbers) throws IllegalArgumentException {
        if (!(numbers.equals("1") || numbers.equals("2"))) {
            throw new IllegalArgumentException(ONE_OR_TWO_EXCEPTION_MESSAGE);
        }

        return true;
    }

    public static void checkDuplicateNumberThrowException(String numbers) {
        if (!isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public static boolean checkDuplicateNumber(String numbers) {
        if (!isDuplicateNumber(numbers)) {
            return false;
        }

        return true;
    }

    private static boolean isDuplicateNumber(String numbers) {
        Set<Integer> checkedNum = new HashSet<>();

        for (int i = 0; i < numbers.length(); i++) {
            checkedNum.add(checkNumeric(numbers.charAt(i)));
        }

        if (isWrongSize(checkedNum.size())) {
            return false;
        }

        return true;
    }

    private static boolean isWrongSize(int size) {
        return size != BALLS_SIZE;
    }

    private static int checkNumeric(char targetChar) {
        if (!Character.isDigit(targetChar)) {
            throw new IllegalArgumentException(BALLS_SIZE_EXCEPTION_MESSAGE);
        }
        return Character.getNumericValue(targetChar);
    }


}
