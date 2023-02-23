package esgi.cleancode.domain.functional.service.validation;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;
import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static esgi.cleancode.domain.functional.service.validation.CardValidator.validate;
import static org.assertj.vavr.api.VavrAssertions.assertThat;

public class CardValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"Kratos", "Waramer - 40000"})
    void should_be_valid(String name) {
        val actual = validate(
                Card.builder()
                        .name(name)
                        .speciality(Speciality.TANK)
                        .rarity(Rarity.COMMON)
                        .life((int) (Speciality.TANK.getLife() * Rarity.COMMON.getCoefficient()))
                        .power((int) (Speciality.TANK.getPower() * Rarity.COMMON.getCoefficient()))
                        .armor((int) (Speciality.TANK.getArmor() * Rarity.COMMON.getCoefficient()))
                        .build()
        );
        assertThat(actual).containsValidInstanceOf(Card.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"czce@ ecc", "vervez_vezxr", "{vrev)]", "=revrez"})
    void should_be_not_valid_name(String name) {
        val actual = validate(Card.builder().name(name).build());
        assertThat(actual).containsInvalidInstanceOf(ApplicationError.class);
    }
}
