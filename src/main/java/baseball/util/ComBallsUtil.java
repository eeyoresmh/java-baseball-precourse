package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class ComBallsUtil {

	public static String create() {
		String number;

		do {
			number = makeNumber();
		} while (!ValidationNo.checkDuplicateNumber(number));

		return number;
	}

	private static String makeNumber() {
		StringBuilder numberSb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			numberSb.append(Randoms.pickNumberInRange(0, 9));
		}

		return numberSb.toString();
	}
}
