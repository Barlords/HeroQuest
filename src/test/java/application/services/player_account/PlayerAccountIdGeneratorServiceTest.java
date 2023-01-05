package application.services.player_account;

import esgi.cleancode.application.services.player_account.PlayerAccountIdGeneratorService;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerAccountIdGeneratorServiceTest {
    private final PlayerAccountIdGeneratorService service = new PlayerAccountIdGeneratorService();

    @Test
    void should_generate_valid_UUID() {
        final var actual = service.generateNewPlayerAccountId();
        assertThat(actual)
                .isNotNull()
                .isEqualTo(UUID.fromString(actual.toString()));
    }

}
