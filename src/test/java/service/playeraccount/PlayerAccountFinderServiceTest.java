package service.playeraccount;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.exception.ResourceNotFoundException;
import esgi.cleancode.service.playeraccount.PlayerAccountFinderService;
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
public class PlayerAccountFinderServiceTest
{

    @InjectMocks
    PlayerAccountFinderService service;

    @Mock
    InMemoryDatabase database;

    @Test
    void should_find()
    {
        final var id = UUID.randomUUID();
        final var given = PlayerAccount.builder().id(id).build();
        when(database.findPlayerAccountById(id)).thenReturn(Optional.ofNullable(given));
        var actual = service.findById(id);

        Assertions.assertEquals(given, actual);
    }

    @Test
    void should_not_find()
    {
        final var id = UUID.randomUUID();
        when(database.findPlayerAccountById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class, () -> service.findById(id));
    }
}
