package esgi.cleancode.application.services.hero_card;

import esgi.cleancode.domain.HeroCard;

public class HeroCardExperienceCheckerService {

    static public boolean canLevelUp(HeroCard given) {
        return given.getExperience() >= 5;
    }

}
