package esgi.cleancode.service;

import esgi.cleancode.domain.HeroCard;

public class HeroCardValidatorService {

    public static boolean isValidHeroCard(HeroCard given) {
        return (
                null != given.getName()
                && 0 < given.getName().length()
                && 0 < given.getLife()
                && 0 <= given.getExperience()
                && 5 > given.getExperience()
                && 0 < given.getPower()
                && 0 <= given.getArmor()
                && 0 < given.getLevel()
                && 100 >= given.getLevel()
        );
    }

}
