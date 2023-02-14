package esgi.cleancode.domain.functional.service.validation;

import esgi.cleancode.domain.functional.model.PlayerAccount;
import esgi.cleancode.domain.functional.service.validation.PlayerAccountValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class PlayerAccountValidatorTest {

    @Test
    void should_be_valid() {
        var given = PlayerAccount.builder().pseudo("Barlords").build();
        var result = PlayerAccountValidator.isValidAccount(given);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void should_be_not_valid_pseudo(String name) {
        var given = PlayerAccount.builder().pseudo(name).build();
        var result = PlayerAccountValidator.isValidAccount(given);
        Assertions.assertFalse(result);
    }

}