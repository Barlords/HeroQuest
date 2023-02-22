package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CardExperienceCheckerServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {5, 10})
    void should_level_up(int exp) {
        var given = Card.builder().experience(exp).build();
        Assertions.assertTrue(CardExperienceCheckerService.canLevelUp(given));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,0,1,2,3,4})
    void should_not_level_up(int exp) {
        var given = Card.builder().experience(exp).build();
        Assertions.assertFalse(CardExperienceCheckerService.canLevelUp(given));
    }
}
