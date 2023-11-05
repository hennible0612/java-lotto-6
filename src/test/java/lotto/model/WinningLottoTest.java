package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("WinningLotto를 유효한 숫자들로 생성한다")
    @Test
    public void createWinningLottoWithValidNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        assertNotNull(winningLotto);
        assertEquals(7, winningLotto.getBonusNumber());
        assertEquals(winningNumbers, winningLotto.getNumbers());
    }

    @DisplayName("WinningLotto를 중복되는 보너스 넘버로 생성한다")
    @Test
    void createWinningLottoWithDuplicateBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("WinningLotto를 중복되는 넘버로 생성한다")
    @Test
    void createWinningLottoWithDuplicateNumbers() {
        assertThatThrownBy(() -> new WinningLotto(Arrays.asList(1, 2, 3, 5, 5, 6), 45))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("WinningLotto를 유효하지 않은 길이로 생성한다")
    @Test
    void createWinningLottoWithFiveNumbers() {
        assertThatThrownBy(() -> new WinningLotto(Arrays.asList(1, 2, 3, 4, 5), 45))
                .isInstanceOf(IllegalArgumentException.class);
    }


}