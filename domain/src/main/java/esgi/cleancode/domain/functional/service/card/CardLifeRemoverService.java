package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;

public class CardLifeRemoverService {

    public Card remove(Card hero, int amount) {
        return hero.withLife(hero.getLife() - amount);
    }

}
