package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;

public class CardLevelAdderService {

    public static Card levelUp(Card given) {
        return given
                .withExperience(given.getExperience() - 5)
                .withLevel(given.getLevel() + 1)
                .withLife((int) (given.getLife() * 1.1))
                .withPower((int) (given.getPower() * 1.1))
                .withArmor((int) (given.getArmor() * 1.1));
    }
}
