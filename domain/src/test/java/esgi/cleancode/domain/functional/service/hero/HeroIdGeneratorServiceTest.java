package esgi.cleancode.domain.functional.service.hero;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class HeroIdGeneratorServiceTest {
    private final HeroIdGeneratorService service = new HeroIdGeneratorService();

    @Test
    void should_generate_valid_UUID() {
        final var actual = service.generateNewHeroId();
        assertThat(actual)
                .isNotNull()
                .isEqualTo(UUID.fromString(actual.toString()));
    }

}
