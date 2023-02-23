package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.service.card.CardExperienceAdderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class AccountTokenAdderServiceTest {

    @InjectMocks
    private AccountTokenAdderService service;


    @ParameterizedTest
    @ValueSource(ints = 1)
    void should_add_token(int amount) {
        var id = UUID.randomUUID();
        var given = Account.builder().id(id).build();

        var actual = service.addToken(given, amount);

        Assertions.assertEquals(given.getNbToken()+amount, actual.getNbToken());
    }
}
