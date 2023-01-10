package esgi.cleancode.application.services.player_account;

import esgi.cleancode.adapter.out.InMemoryDatabase;
import esgi.cleancode.application.services.player_account.PlayerAccountFinderService;
import esgi.cleancode.application.services.player_account.PlayerAccountTokenAdderService;
import esgi.cleancode.application.services.player_account.PlayerAccountTokenCheckerService;
import esgi.cleancode.application.services.player_account.PlayerAccountTokenRemoverService;
import esgi.cleancode.domain.PlayerAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerAccountTokenAdderServiceTest {

    @InjectMocks
    private PlayerAccountTokenAdderService service;

    @Mock
    private InMemoryDatabase database;

    @Mock
    private PlayerAccountFinderService playerAccountFinderService;

    @Captor
    private ArgumentCaptor<PlayerAccount> playerAccountCaptor;

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void should_add_token_on_player_account(int nbTokenToAdd) {
        var playerId = UUID.randomUUID();
        var given = PlayerAccount.builder().id(playerId).pseudo("Barlords").build();
        when(playerAccountFinderService.findById(playerId)).thenReturn(given);
        when(database.savePlayerAccount(any(PlayerAccount.class))).thenReturn(given.withNbToken(given.getNbToken()+nbTokenToAdd));
        var actual = service.add(given.getId(), nbTokenToAdd);

        verify(database).savePlayerAccount(playerAccountCaptor.capture());
        verifyNoMoreInteractions(database);

        Assertions.assertEquals(playerAccountCaptor.getValue(), actual);
        Assertions.assertEquals(4+nbTokenToAdd, actual.getNbToken());
    }

}
