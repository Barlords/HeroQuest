package service;

import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.service.hero.HeroCardValidatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class HeroCardValidatorServiceTest {

    @Test
    void should_be_valid() {
        var given = HeroCard.builder().name("Kratos").life(100).power(10).armor(5).build();
        var result = HeroCardValidatorService.isValidHeroCard(given);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void should_be_not_valid_name(String name) {
        var given = HeroCard.builder().name(name).life(100).power(10).armor(5).build();
        var result = HeroCardValidatorService.isValidHeroCard(given);
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0})
    void should_be_not_valid_life(int life) {
        var given = HeroCard.builder().name("Kratos").life(life).power(10).armor(5).build();
        var result = HeroCardValidatorService.isValidHeroCard(given);
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0})
    void should_be_not_valid_power(int power) {
        var given = HeroCard.builder().name("Kratos").life(100).power(power).armor(5).build();
        var result = HeroCardValidatorService.isValidHeroCard(given);
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10})
    void should_be_not_valid_armor(int armor) {
        var given = HeroCard.builder().name("Kratos").life(100).power(10).armor(armor).build();
        var result = HeroCardValidatorService.isValidHeroCard(given);
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 110})
    void should_be_not_valid_level(int level) {
        var given = HeroCard.builder().name("Kratos").life(100).power(10).armor(5).level(level).build();
        var result = HeroCardValidatorService.isValidHeroCard(given);
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 5})
    void should_be_not_valid_experience(int experience) {
        var given = HeroCard.builder().name("Kratos").life(100).power(10).armor(5).experience(experience).build();
        var result = HeroCardValidatorService.isValidHeroCard(given);
        Assertions.assertFalse(result);
    }
}
