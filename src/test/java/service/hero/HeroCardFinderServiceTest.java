package service.hero;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.exception.ResourceNotFoundException;
import esgi.cleancode.service.hero.HeroCardFinderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HeroCardFinderServiceTest
{
    @InjectMocks
    HeroCardFinderService service;

    @Mock
    InMemoryDatabase database;

    @Test
    void should_find()
    {
        final var id = UUID.randomUUID();
        final var given = HeroCard.builder().id(id).build();
        when(database.findHeroCardById(id)).thenReturn(Optional.ofNullable(given));
        var actual = service.findById(id);

        Assertions.assertEquals(given, actual);
    }

    @Test
    void should_not_find()
    {
        final var id = UUID.randomUUID();
        when(database.findHeroCardById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class, () -> service.findById(id));
    }
}
