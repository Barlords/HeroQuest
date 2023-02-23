package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Booster;
import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.service.card.CardExperienceCheckerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AccountTokenCheckerServiceTest {

    @Test
    void should_have_enough_token_for_silver_booster() {
        var given = Account.builder().nbToken(1).build();
        Assertions.assertTrue(AccountTokenCheckerService.haveEnoughToken(given, Booster.SILVER));
    }

    @Test
    void should_not_have_enough_token_for_silver_booster() {
        var given = Account.builder().nbToken(0).build();
        Assertions.assertFalse(AccountTokenCheckerService.haveEnoughToken(given, Booster.SILVER));
    }

    @Test
    void should_have_enough_token_for_diamond_booster() {
        var given = Account.builder().nbToken(2).build();
        Assertions.assertTrue(AccountTokenCheckerService.haveEnoughToken(given, Booster.DIAMOND));
    }

    @Test
    void should_not_have_enough_token_for_diamond_booster() {
        var given = Account.builder().nbToken(1).build();
        Assertions.assertFalse(AccountTokenCheckerService.haveEnoughToken(given, Booster.DIAMOND));
    }
}
