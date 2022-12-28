package service;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.service.HeroCardCreatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HeroCardCreatorServiceTest
{

    @InjectMocks
    private HeroCardCreatorService service;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_create_and_save_hero_card_in_database()
    {
        var given = HeroCard.builder().build();
        when(database.saveHeroCard(given)).thenReturn(given);
        var actual = service.create("Kratos");

        Assertions.assertEquals(given, actual);
    }

}
