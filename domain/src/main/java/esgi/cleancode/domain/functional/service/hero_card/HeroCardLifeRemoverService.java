package esgi.cleancode.domain.functional.service.hero_card;

import esgi.cleancode.domain.functional.model.HeroCard;

public class HeroCardLifeRemoverService {

    public HeroCard remove(HeroCard hero, int amount) {
        return hero.withLife(hero.getLife() - amount);
    }

}
