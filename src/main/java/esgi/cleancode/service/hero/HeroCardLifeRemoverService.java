package esgi.cleancode.service.hero;

import esgi.cleancode.domain.HeroCard;

public class HeroCardLifeRemoverService {

    public HeroCard remove(HeroCard hero, int amount) {
        return hero.withLife(hero.getLife() - amount);
    }

}
