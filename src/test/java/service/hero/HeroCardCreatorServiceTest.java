package service.hero;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.Rarity;
import esgi.cleancode.domain.Speciality;
import esgi.cleancode.exception.InvalidHeroCardException;
import esgi.cleancode.service.hero.HeroCardCreatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HeroCardCreatorServiceTest
{

    @InjectMocks
    private HeroCardCreatorService service;

    @Mock
    private InMemoryDatabase database;

    @Captor
    private ArgumentCaptor<HeroCard> heroCardCaptor;

    @Test
    void should_create_and_save_hero_card_in_database()
    {
        var given = HeroCard.builder()
                .name("Kratos")
                .life((int) (Speciality.TANK.getLife() * (1 + Rarity.COMMON.getCoefficient())))
                .power((int) (Speciality.TANK.getPower() * (1 + Rarity.COMMON.getCoefficient())))
                .armor((int) (Speciality.TANK.getArmor() * (1 + Rarity.COMMON.getCoefficient())))
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON).build();
        when(database.saveHeroCard(any(HeroCard.class))).thenReturn(given);
        var actual = service.create(given.getName(), given.getSpeciality(), given.getRarity());

        verify(database).saveHeroCard(heroCardCaptor.capture());
        verifyNoMoreInteractions(database);

        Assertions.assertEquals(given, actual);
        Assertions.assertEquals(heroCardCaptor.getValue(), actual);
    }

    @Test()
    void should_not_create()
    {
        Assertions.assertThrows(InvalidHeroCardException.class, () -> service.create("", Speciality.TANK, Rarity.COMMON));
    }


}
