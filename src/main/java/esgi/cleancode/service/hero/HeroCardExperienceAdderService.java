package esgi.cleancode.service.hero;

import esgi.cleancode.domain.HeroCard;

public class HeroCardExperienceAdderService {

    public HeroCard winExp(HeroCard hero, int amount) {
        return hero.withExperience(hero.getExperience()+amount);
    }
}
