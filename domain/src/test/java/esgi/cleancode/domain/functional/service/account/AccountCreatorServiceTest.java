package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.service.AccountCreatorService;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static io.vavr.API.Right;
import static org.assertj.vavr.api.VavrAssertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountCreatorServiceTest
{

    @InjectMocks
    private AccountCreatorService service;

    @Mock
    private AccountPersistenceSpi spi;

    @Test
    void should_create_account() {
        val pseudo = "Barlords";
        val given = Account.builder()
                .pseudo(pseudo)
                .build();

        when(spi.save(given)).thenReturn(Right(given));

        val actual = service.create(pseudo);
        assertThat(actual).containsRightSame(given);
        verifyNoMoreInteractions(spi);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void should_not_create_account_if_name_is_invalid(String pseudo) {
        val given = Account.builder()
                .pseudo(pseudo)
                .build();
        val actual = service.create(pseudo);
        assertThat(actual).containsLeftInstanceOf(ApplicationError.class);
        verifyNoInteractions(spi);
    }

}
