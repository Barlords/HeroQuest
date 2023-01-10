package application.services.player_account;

import esgi.cleancode.adapter.out.InMemoryDatabase;
import esgi.cleancode.application.services.player_account.PlayerAccountTokenRemoverService;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.domain.exception.PlayerAccountTokenRemoverException;
import esgi.cleancode.domain.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PlayerAccountTokenRemoverServiceTest {

    @InjectMocks
    private PlayerAccountTokenRemoverService service;

    @Mock
    private InMemoryDatabase database;

    @Captor
    private ArgumentCaptor<PlayerAccount> playerAccountCaptor;

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void should_remove_token_on_player_account(int nbTokenToRemove) {
        var playerId = UUID.randomUUID();
        var given = PlayerAccount.builder().id(playerId).pseudo("Barlords").build();
        when(database.savePlayerAccount(any(PlayerAccount.class))).thenReturn(given);
        var actual = service.remove(given, nbTokenToRemove);

        verify(database).savePlayerAccount(playerAccountCaptor.capture());
        verifyNoMoreInteractions(database);

        Assertions.assertEquals(playerAccountCaptor.getValue(), actual);
        Assertions.assertEquals(4-nbTokenToRemove, actual.getNbToken());
    }

}
