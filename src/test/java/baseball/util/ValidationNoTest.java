package baseball.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidationNoTest {

    ValidationNo validationNo = new ValidationNo();

    @Test
    public void 자릿수_체크() {
        String numbers = "123";

        assertThat(validationNo.isOk(numbers)).isEqualTo(true);
    }

    @Test
    public void 자릿수_fail_체크() {
        String numbers = "12";

        assertThatIllegalArgumentException()
            .isThrownBy(() -> validationNo.isOk(numbers));
    }

    @Test
    public void 정상숫자_성공_체크() {
        String numbers = "123";
        assertThat(validationNo.isOk(numbers)).isEqualTo(true);
    }

    @Test
    public void 중복숫자_fail_체크() {
        String numbers = "121";
        assertThatIllegalArgumentException()
            .isThrownBy(() -> validationNo.isOk(numbers));
    }

    @Test
    public void 문자포함_fail_체크() {
        String numbers = "일23";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validationNo.isOk(numbers));
    }

    @Test
    public void 음수포함_fail_체크() {
        String numbers = "-123";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validationNo.isOk(numbers));
    }

    @Test
    public void 음수포함_2자리_fail_체크() {
        String numbers = "-23";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validationNo.isOk(numbers));
    }
}
