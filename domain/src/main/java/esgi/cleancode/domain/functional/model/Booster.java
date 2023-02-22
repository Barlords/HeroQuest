package esgi.cleancode.domain.functional.model;

import lombok.Getter;

public enum Booster {
    SILVER(1, 3, 0.75, 0.20, 0.05),
    DIAMOND(2, 5, 0.5, 0.35, 0.15);

    @Getter
    final int cost;

    @Getter
    final int nbCard;

    @Getter
    final double probabilityOfCommon;

    @Getter
    final double probabilityOfRare;

    @Getter
    final double probabilityOfLegendary;

    Booster(int cost,
            int nbCard,
            double probabilityOfCommon,
            double probabilityOfRare,
            double probabilityOfLegendary) {
        this.cost = cost;
        this.nbCard = nbCard;
        this.probabilityOfCommon = probabilityOfCommon;
        this.probabilityOfRare = probabilityOfRare;
        this.probabilityOfLegendary = probabilityOfLegendary;
    }

}
