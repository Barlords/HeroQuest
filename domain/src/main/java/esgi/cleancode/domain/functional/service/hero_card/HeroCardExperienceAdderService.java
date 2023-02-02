package esgi.cleancode.domain.functional.service.hero_card;

import esgi.cleancode.domain.functional.model.HeroCard;

public class HeroCardExperienceAdderService {

    public HeroCard winExp(HeroCard hero, int amount) {
        return hero.withExperience(hero.getExperience()+amount);
    }
}
