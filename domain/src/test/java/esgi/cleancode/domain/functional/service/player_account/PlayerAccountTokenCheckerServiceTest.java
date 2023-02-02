package esgi.cleancode.domain.functional.service.player_account;

import esgi.cleancode.domain.functional.model.PlayerAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerAccountTokenCheckerServiceTest {
    @ParameterizedTest
    @ValueSource(ints = {1,4})
    void should_have_enough_token(int nbToken) {
        var given = PlayerAccount.builder().pseudo("Barlords").build();
        Assertions.assertTrue(PlayerAccountTokenCheckerService.haveEnoughtToken(given, nbToken));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,5})
    void should_not_level_up(int nbToken) {
        var given = PlayerAccount.builder().pseudo("Barlords").build();
        Assertions.assertFalse(PlayerAccountTokenCheckerService.haveEnoughtToken(given, nbToken));
    }
}
