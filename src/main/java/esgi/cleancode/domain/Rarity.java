package esgi.cleancode.domain;

import lombok.Getter;

public enum Rarity {
    COMMON(0),
    RARE(0.1),
    LEGENDARY(0.2);

    @Getter
    final double coefficient;

    Rarity(double coefficient) {
        this.coefficient = coefficient;
    }
}
