package service.hero;

import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.service.hero.HeroCardCreatorService;
import esgi.cleancode.service.hero.HeroCardExperienceCheckerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeroCardExperienceCheckerServiceTest {

    private HeroCardExperienceCheckerService service;

    @ParameterizedTest
    @ValueSource(ints = {5, 10})
    void should_level_up() {
        var given = HeroCard.builder().experience(5).build();
        Assertions.assertTrue(service.canLevelUp(given));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,0,1,2,3,4})
    void should_not_level_up(int exp) {
        var given = HeroCard.builder().experience(exp).build();
        Assertions.assertFalse(service.canLevelUp(given));
    }
}
