package esgi.cleancode.service.hero;

import esgi.cleancode.domain.HeroCard;

public class HeroCardLevelAdderService {

    public HeroCard levelUp(HeroCard given) {
        return given
                .withExperience(given.getExperience() - 5)
                .withLevel(given.getLevel() + 1)
                .withLife((int) (given.getLife() * 1.1))
                .withPower((int) (given.getPower() * 1.1))
                .withArmor((int) (given.getArmor() * 1.1));
    }
}
