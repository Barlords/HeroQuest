package esgi.cleancode.application.services.hero_card;

import esgi.cleancode.application.services.hero_card.HeroCardIdGeneratorService;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class HeroCardIdGeneratorServiceTest {
    private final HeroCardIdGeneratorService service = new HeroCardIdGeneratorService();

    @Test
    void should_generate_valid_UUID() {
        final var actual = service.generateNewHeroCardId();
        assertThat(actual)
                .isNotNull()
                .isEqualTo(UUID.fromString(actual.toString()));
    }

}
