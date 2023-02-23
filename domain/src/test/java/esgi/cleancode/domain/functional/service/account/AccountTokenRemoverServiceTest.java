package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.functional.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class AccountTokenRemoverServiceTest {

    @InjectMocks
    private AccountTokenRemoverService service;


    @ParameterizedTest
    @ValueSource(ints = 1)
    void should_remove_token(int amount) {
        var id = UUID.randomUUID();
        var given = Account.builder().id(id).nbToken(10).build();

        var actual = service.removeToken(given, amount);

        Assertions.assertEquals(given.getNbToken()-amount, actual.getNbToken());
    }
}
