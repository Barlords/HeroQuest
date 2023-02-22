package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;

public class CardEndFightCheckerService {

    public static boolean isEnd(Card hero1, Card hero2) {
        return (hero1.getLife() <= 0 || hero2.getLife() <= 0);
    }

}
