package esgi.cleancode.service.hero;

import esgi.cleancode.domain.HeroCard;

public class HeroCardExperienceCheckerService {

    static public boolean canLevelUp(HeroCard given) {
        return given.getExperience() >= 5;
    }

}
