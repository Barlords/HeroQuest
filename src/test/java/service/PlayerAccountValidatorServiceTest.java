package service;

import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.service.HeroCardValidatorService;
import esgi.cleancode.service.PlayerAccountValidatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class PlayerAccountValidatorServiceTest {

    @Test
    void should_be_valid() {
        var given = PlayerAccount.builder().pseudo("Barlords").build();
        var result = PlayerAccountValidatorService.isValidHeroCard(given);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void should_be_not_valid_pseudo(String name) {
        var given = PlayerAccount.builder().pseudo(name).build();
        var result = PlayerAccountValidatorService.isValidHeroCard(given);
        Assertions.assertFalse(result);
    }

}