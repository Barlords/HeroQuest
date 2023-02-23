package esgi.cleancode.domain.functional.service.hero;

import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;
import esgi.cleancode.domain.functional.service.account.AccountFinderService;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import esgi.cleancode.domain.ports.server.HeroPersistenceSpi;
import io.vavr.collection.List;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.vavr.api.VavrAssertions.assertThat;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HeroFinderServiceTest
{

    @InjectMocks
    private HeroFinderService service;

    @Mock
    private HeroPersistenceSpi spi;

    @Test
    void should_have_hero() {
        val id = UUID.randomUUID();
        val hero = Hero.builder()
                .id(id)
                .name("Kratos")
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON)
                .build();
        val given = List.of(hero);
        when(spi.findAll()).thenReturn(given);

        val actual = service.findAll();
        assertThat(actual).isEqualTo(given);
        verifyNoMoreInteractions(spi);
    }

}
