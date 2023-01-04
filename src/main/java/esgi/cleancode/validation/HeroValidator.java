package esgi.cleancode.validation;

import esgi.cleancode.domain.Hero;

public class HeroValidator {

    public static boolean isValidHero(Hero given) {
        return (
                null != given.getName()
                && 0 < given.getName().length()
                && 0 < given.getLife()
                && 0 < given.getPower()
                && 0 <= given.getArmor()
        );
    }

}
