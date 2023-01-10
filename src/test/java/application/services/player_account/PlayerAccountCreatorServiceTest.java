package application.services.player_account;

import esgi.cleancode.adapter.out.InMemoryDatabase;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.domain.exception.InvalidPlayerAccountException;
import esgi.cleancode.application.services.player_account.PlayerAccountCreatorService;
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
public class PlayerAccountCreatorServiceTest
{

    @InjectMocks
    private PlayerAccountCreatorService service;

    @Mock
    private InMemoryDatabase database;

    @Captor
    private ArgumentCaptor<PlayerAccount> playerAccountCaptor;

    @Test
    void should_create_and_save_player_account_in_database()
    {
        var given = PlayerAccount.builder().pseudo("Barlords").build();
        when(database.savePlayerAccount(any(PlayerAccount.class))).thenReturn(given);
        var actual = service.create(given.getPseudo());

        verify(database).savePlayerAccount(playerAccountCaptor.capture());
        verifyNoMoreInteractions(database);

        Assertions.assertEquals(given, actual);
        Assertions.assertEquals(playerAccountCaptor.getValue(), actual);
        Assertions.assertEquals(4, actual.getNbToken());
    }

    @Test()
    void should_not_create()
    {
        Assertions.assertThrows(InvalidPlayerAccountException.class, () -> service.create(""));
    }

}
