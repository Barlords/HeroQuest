package esgi.cleancode.domain.functional.service.hero_card;

import esgi.cleancode.domain.functional.model.HeroCard;

public class HeroCardEndFightCheckerService {

    public static boolean isEnd(HeroCard hero1, HeroCard hero2) {
        return (hero1.getLife() <= 0 || hero2.getLife() <= 0);
    }

}
