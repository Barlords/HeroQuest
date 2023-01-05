package application.services.hero;

import esgi.cleancode.adapter.out.InMemoryDatabase;
import esgi.cleancode.domain.Hero;
import esgi.cleancode.domain.Rarity;
import esgi.cleancode.domain.Speciality;
import esgi.cleancode.domain.exception.InvalidHeroException;
import esgi.cleancode.application.services.hero.HeroCreatorService;
import esgi.cleancode.application.services.hero.HeroIdGeneratorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HeroCreatorServiceTest
{

    @InjectMocks
    private HeroCreatorService service;

    @Mock
    private HeroIdGeneratorService heroIdGeneratorService;

    @Mock
    private InMemoryDatabase database;

    @Captor
    private ArgumentCaptor<Hero> heroCaptor;

    @Test
    void should_create_and_save_hero_card_in_database()
    {
        var id = UUID.randomUUID();
        var heroGiven = Hero.builder()
                .id(id)
                .name("Kratos")
                .life((int) (Speciality.TANK.getLife() * (1 + Rarity.COMMON.getCoefficient())))
                .power((int) (Speciality.TANK.getPower() * (1 + Rarity.COMMON.getCoefficient())))
                .armor((int) (Speciality.TANK.getArmor() * (1 + Rarity.COMMON.getCoefficient())))
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON)
                .build();
        when(heroIdGeneratorService.generateNewHeroId()).thenReturn(id);
        when(database.saveHero(any(Hero.class))).thenReturn(heroGiven);
        var actual = service.create(heroGiven.getName(), heroGiven.getSpeciality(), heroGiven.getRarity());

        verify(database).saveHero(heroCaptor.capture());
        verifyNoMoreInteractions(database);

        Assertions.assertEquals(heroGiven, actual);
        Assertions.assertEquals(heroCaptor.getValue(), actual);
    }

    @Test()
    void should_not_create()
    {
        Assertions.assertThrows(InvalidHeroException.class, () -> service.create("", Speciality.TANK, Rarity.COMMON));
    }


}
