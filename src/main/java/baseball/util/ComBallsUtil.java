package baseball.util;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class ComBallsUtil {

	ValidationNo validationNo = new ValidationNo();

	public String create() {
		String number;

		do {
			number = makeNumber();
		} while (!validationNo.checkDuplicateNumber(number));

		return number;
	}

	public String makeNumber() {
		StringBuilder numberSb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			numberSb.append(Randoms.pickNumberInRange(0, 9));
		}

		return numberSb.toString();
	}
}
