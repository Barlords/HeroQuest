package esgi.cleancode.domain.functional.service.validation;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.functional.service.validation.HeroValidator;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static esgi.cleancode.domain.functional.service.validation.HeroValidator.validate;
import static org.assertj.vavr.api.VavrAssertions.assertThat;

public class HeroValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"Kratos", "Waramer - 40000"})
    void should_be_valid(String name) {
        val actual = validate(Hero.builder().name(name).build());
        assertThat(actual).containsValidInstanceOf(Hero.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"czce@ ecc", "vervez_vezxr", "{vrev)]", "=revrez"})
    void should_be_not_valid(String name) {
        val actual = validate(Hero.builder().name(name).build());
        assertThat(actual).containsInvalidInstanceOf(ApplicationError.class);
    }
}
