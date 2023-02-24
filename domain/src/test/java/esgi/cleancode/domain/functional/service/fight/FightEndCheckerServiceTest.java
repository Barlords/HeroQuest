package esgi.cleancode.domain.functional.service.fight;

import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.service.fight.FightEndCheckerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FightEndCheckerServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -10})
    void should_be_end(int life) {
        var hero1 = Card.builder().name("Kratos").life(100).power(10).armor(5).build();
        var hero2 = Card.builder().name("Absol").life(life).power(10).armor(5).build();

        var result = FightEndCheckerService.isEnd(hero1, hero2);
        Assertions.assertTrue(result);
    }

    @Test
    void should_not_be_end() {
        var hero1 = Card.builder().name("Kratos").life(100).power(10).armor(5).build();
        var hero2 = Card.builder().name("Absol").life(50).power(10).armor(5).build();

        var result = FightEndCheckerService.isEnd(hero1, hero2);
        Assertions.assertFalse(result);
    }

}
