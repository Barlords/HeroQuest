package esgi.cleancode.application.services.hero_card;

import esgi.cleancode.domain.HeroCard;

public class HeroCardExperienceAdderService {

    public HeroCard winExp(HeroCard hero, int amount) {
        return hero.withExperience(hero.getExperience()+amount);
    }
}