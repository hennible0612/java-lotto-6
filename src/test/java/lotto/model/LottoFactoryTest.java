package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.internal.bytebuddy.implementation.attribute.AnnotationValueFilter.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LottoFactoryTest {

    private LottoFactory lottoFactory;
    private LottoNumberGenerator fakeNumberGenerator;

    @BeforeEach
    void setUp() {
        fakeNumberGenerator = new LottoNumberGenerator() {
            @Override
            public List<Integer> generateLottoNumber() {
                return Arrays.asList(1, 2, 3, 4, 5, 6);
            }
        };

        lottoFactory = new LottoFactory(fakeNumberGenerator);
    }

    @DisplayName("6개의 유니크한 숫자를 가진 Lotto 객체를 생성 한다")
    @Test
    void createLotto_ShouldGenerateSixUniqueNumbers() {
        Lotto lotto = lottoFactory.createLotto();

        assertEquals(6, lotto.getNumbers().size());

        long uniqueCount = lotto.getNumbers().stream().distinct().count();

        assertEquals(6, uniqueCount);
    }
}