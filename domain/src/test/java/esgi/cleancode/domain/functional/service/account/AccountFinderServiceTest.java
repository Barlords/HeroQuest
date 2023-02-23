package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import io.vavr.collection.List;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static io.vavr.API.Right;
import static org.assertj.vavr.api.VavrAssertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountFinderServiceTest
{

    @InjectMocks
    private AccountFinderService service;

    @Mock
    private AccountPersistenceSpi spi;

    @Test
    void should_have_account() {
        val id = UUID.randomUUID();
        val account = Account.builder()
                .id(id)
                .pseudo("Barlords")
                .build();
        val given = List.of(account);
        when(spi.findAll()).thenReturn(given);

        val actual = service.findAll();
        assertThat(actual).isEqualTo(given);
        verifyNoMoreInteractions(spi);
    }

}
