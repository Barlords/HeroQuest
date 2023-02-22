package esgi.cleancode.domain.functional.service.hero;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;
import esgi.cleancode.domain.functional.service.hero.HeroCreatorService;
import esgi.cleancode.domain.ports.server.HeroPersistenceSpi;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static io.vavr.API.Left;
import static io.vavr.API.Right;
import static org.assertj.vavr.api.VavrAssertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HeroCreatorServiceTest
{

    @InjectMocks
    private HeroCreatorService service;

    @Mock
    private HeroPersistenceSpi spi;

    @Test
    void should_create_hero() {
        val given = Hero.builder()
                .name("Kratos")
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON)
                .build();
        when(spi.save(given)).thenReturn(Right(given));

        val actual = service.create(given);
        assertThat(actual).containsRightSame(given);
        verifyNoMoreInteractions(spi);
    }

    @Test
    void should_not_create_hero_if_name_is_invalid() {
        val given = Hero.builder().name("_invalid_").build();
        val actual = service.create(given);
        assertThat(actual).containsLeftInstanceOf(ApplicationError.class);
        verifyNoInteractions(spi);
    }

    @Test
    void should_not_create_hero_if_technical_error_occurred_in_adapter() {
        val given = Hero.builder().name("valid").build();
        val error = new ApplicationError("An error occurred", null, null, null);
        when(spi.save(given)).thenReturn(Left(error));

        val actual = service.create(given);
        assertThat(actual).containsLeftInstanceOf(ApplicationError.class);
        verifyNoMoreInteractions(spi);
    }

}
