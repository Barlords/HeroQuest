package service;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.exception.InvalidPlayerAccountException;
import esgi.cleancode.service.PlayerAccountCreatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerAccountCreatorServiceTest
{

    @InjectMocks
    private PlayerAccountCreatorService service;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_create_and_save_player_account_in_database()
    {
        var given = PlayerAccount.builder().build();
        when(database.savePlayerAccount(given)).thenReturn(given);
        var actual = service.create("Snake");

        Assertions.assertEquals(given, actual);
    }

    @Test()
    void should_not_create()
    {
        Assertions.assertThrows(InvalidPlayerAccountException.class, () -> service.create(""));
    }

}
