package esgi.cleancode.domain.functional.model;

import lombok.Getter;

public enum Rarity {
    COMMON(1),
    RARE(1.1),
    LEGENDARY(1.2);

    @Getter
    final double coefficient;

    Rarity(double coefficient) {
        this.coefficient = coefficient;
    }
}
