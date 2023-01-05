package application.services.hero_card;

import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.application.services.hero_card.HeroCardExperienceCheckerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeroCardExperienceCheckerServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {5, 10})
    void should_level_up(int exp) {
        var given = HeroCard.builder().experience(exp).build();
        Assertions.assertTrue(HeroCardExperienceCheckerService.canLevelUp(given));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,0,1,2,3,4})
    void should_not_level_up(int exp) {
        var given = HeroCard.builder().experience(exp).build();
        Assertions.assertFalse(HeroCardExperienceCheckerService.canLevelUp(given));
    }
}
