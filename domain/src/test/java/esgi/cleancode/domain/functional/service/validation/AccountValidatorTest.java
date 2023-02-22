package esgi.cleancode.domain.functional.service.validation;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static esgi.cleancode.domain.functional.service.validation.AccountValidator.validate;
import static org.assertj.vavr.api.VavrAssertions.assertThat;

public class AccountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"Barlords", "Narady"})
    void should_be_valid(String pseudo) {
        val actual = validate(Account.builder().pseudo(pseudo).build());
        assertThat(actual).containsValidInstanceOf(Account.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void should_be_not_valid(String pseudo) {
        val actual = validate(Account.builder().pseudo(pseudo).build());
        assertThat(actual).containsInvalidInstanceOf(ApplicationError.class);
    }

}
