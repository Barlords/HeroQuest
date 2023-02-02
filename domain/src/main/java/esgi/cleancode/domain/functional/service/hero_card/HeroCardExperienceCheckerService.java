package esgi.cleancode.domain.functional.service.hero_card;

import esgi.cleancode.domain.functional.model.HeroCard;

public class HeroCardExperienceCheckerService {

    static public boolean canLevelUp(HeroCard given) {
        return given.getExperience() >= 5;
    }

}
