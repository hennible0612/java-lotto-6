package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    Rank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NONE);
    }
}
