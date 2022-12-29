package service;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.Rarity;
import esgi.cleancode.domain.Speciality;
import esgi.cleancode.service.HeroCardCreatorService;
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
        var given = HeroCard.builder().name("Kratos").life(100).power(10).armor(5).speciality(Speciality.TANK).rarity(Rarity.COMMON).build();
        when(database.saveHeroCard(any(HeroCard.class))).thenReturn(given);
        var actual = service.create(given.getName(), given.getLife(), given.getPower(), given.getArmor(), given.getSpeciality(), given.getRarity());

        verify(database).saveHeroCard(heroCardCaptor.capture());
        verifyNoMoreInteractions(database);

        Assertions.assertEquals(given, actual);
        Assertions.assertEquals(heroCardCaptor.getValue(), actual);
    }

}
