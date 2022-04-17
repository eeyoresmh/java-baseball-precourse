package baseball.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class ComBallsUtil {

	public static String create() {
		Set<Integer> set = new HashSet<>();

		while (set.size() < 3) {
			set.add(Randoms.pickNumberInRange(0, 9));
		}

		return setToString(set);
	}

	private static String setToString(Set<Integer> set) {
		Iterator<Integer> iterator = set.iterator();
		StringBuilder sb = new StringBuilder();

		while(iterator.hasNext()) {
			sb.append(iterator.next());
		}

		return sb.toString();
	}
}
