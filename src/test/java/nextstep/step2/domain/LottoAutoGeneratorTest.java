package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoAutoGeneratorTest {
	private LottoAutoGenerator underTest = new LottoAutoGenerator();
	@Test
	@DisplayName("로또 자동번호는 1~45 사이의 수이다.")
	public void getLottoRandomNumberTest() {
		Set<Integer> autoNumbers = underTest.getAutoNumbers();
		autoNumbers.forEach(number -> {
			assertAll(() -> assertTrue(number <= Lotto.LOTTO_MAX_NUMBER),
					() -> assertTrue(number >= Lotto.LOTTO_MIN_NUMBER));
		});
	}

	@Test
	@DisplayName("로또 자동번호는 불변객체이다.")
	public void getLottoNumberImmutableTest() {
		Set<Integer> autoNumbers = new LottoAutoGenerator().getAutoNumbers();
		Assertions.assertThatExceptionOfType(UnsupportedOperationException.class)
				.isThrownBy(() -> autoNumbers.add(1));
	}
}
