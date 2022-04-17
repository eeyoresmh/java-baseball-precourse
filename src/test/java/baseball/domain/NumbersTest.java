package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    public void 자릿수_fail_체크() {
        String numbers = "12";

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Numbers(numbers));
    }

    @Test
    public void 정상숫자_성공_체크() {
        String numbers = "123";

        assertAll(() -> new Numbers(numbers));
    }

    @Test
    public void 중복숫자_fail_체크() {
        String numbers = "121";
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Numbers(numbers));
    }

    @Test
    public void 문자포함_fail_체크() {
        String numbers = "일23";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Numbers(numbers));
    }

    @Test
    public void 음수포함_fail_체크() {
        String numbers = "-123";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Numbers(numbers));
    }

    @Test
    public void 음수포함_2자리_fail_체크() {
        String numbers = "-23";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Numbers(numbers));
    }
}
