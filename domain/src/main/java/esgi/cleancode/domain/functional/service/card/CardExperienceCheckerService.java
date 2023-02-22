package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;

public class CardExperienceCheckerService {

    static public boolean canLevelUp(Card given) {
        return given.getExperience() >= 5;
    }

}
