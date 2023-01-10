package esgi.cleancode.application.validation;

import esgi.cleancode.domain.Hero;
import esgi.cleancode.application.validation.HeroValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class HeroValidatorTest {

    @Test
    void should_be_valid() {
        var given = Hero.builder().name("Kratos").life(100).power(10).armor(5).build();
        var result = HeroValidator.isValidHero(given);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void should_be_not_valid_name(String name) {
        var given = Hero.builder().name(name).life(100).power(10).armor(5).build();
        var result = HeroValidator.isValidHero(given);
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0})
    void should_be_not_valid_life(int life) {
        var given = Hero.builder().name("Kratos").life(life).power(10).armor(5).build();
        var result = HeroValidator.isValidHero(given);
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0})
    void should_be_not_valid_power(int power) {
        var given = Hero.builder().name("Kratos").life(100).power(power).armor(5).build();
        var result = HeroValidator.isValidHero(given);
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10})
    void should_be_not_valid_armor(int armor) {
        var given = Hero.builder().name("Kratos").life(100).power(10).armor(armor).build();
        var result = HeroValidator.isValidHero(given);
        Assertions.assertFalse(result);
    }
}
