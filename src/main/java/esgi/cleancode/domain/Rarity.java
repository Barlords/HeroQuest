package esgi.cleancode.domain;

public enum Rarity {
    COMMON(0),
    RARE(0.1),
    LEGENDARY(0.2);

    final double coefficient;

    Rarity(double coefficient) {
        this.coefficient = coefficient;
    }
}
