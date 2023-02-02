package esgi.cleancode.domain.functional.service.hero;

import esgi.cleancode.domain.db.InMemoryDatabase;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.exception.ResourceNotFoundException;
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
public class HeroFinderServiceTest
{
    @InjectMocks
    HeroFinderService service;

    @Mock
    InMemoryDatabase database;

    @Test
    void should_find()
    {
        final var heroId = UUID.randomUUID();
        final var heroGiven = Hero.builder().id(heroId).build();
        when(database.findHeroById(heroId)).thenReturn(Optional.ofNullable(heroGiven));
        var actual = service.findById(heroId);

        Assertions.assertEquals(heroGiven, actual);
    }

    @Test
    void should_not_find()
    {
        final var id = UUID.randomUUID();
        when(database.findHeroById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class, () -> service.findById(id));
    }
}
