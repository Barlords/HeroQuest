package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;

public class CardExperienceAdderService {

    public static Card addExperience(Card card, int amount) {
        return card.withExperience(card.getExperience()+amount);
    }
}
