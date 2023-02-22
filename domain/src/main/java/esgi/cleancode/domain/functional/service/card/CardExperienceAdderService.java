package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;

public class CardExperienceAdderService {

    public Card winExp(Card hero, int amount) {
        return hero.withExperience(hero.getExperience()+amount);
    }
}
