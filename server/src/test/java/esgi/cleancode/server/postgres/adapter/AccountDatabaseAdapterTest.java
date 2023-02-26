package esgi.cleancode.server.postgres.adapter;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.server.postgres.entity.AccountEntity;
import esgi.cleancode.server.postgres.mapper.AccountEntityMapper;
import esgi.cleancode.server.postgres.repository.AccountRepository;
import lombok.val;
import org.assertj.vavr.api.VavrAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static io.vavr.API.None;
import static io.vavr.API.Some;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountDatabaseAdapterTest {

    @InjectMocks
    private AccountDatabaseAdapter adapter;

    @Mock
    private AccountRepository repository;

    @Nested
    class Save {

        @Captor
        private ArgumentCaptor<AccountEntity> entityCaptor;

        @Test
        void should_save() {
            val account = Account.builder()
                    .pseudo("Barlords")
                    .build();

            val entity = AccountEntityMapper.fromDomain(account);

            when(repository.save(any(AccountEntity.class))).thenReturn(entity);

            val actual = adapter.save(account);

            verify(repository).save(entityCaptor.capture());
            verifyNoMoreInteractions(repository);

            VavrAssertions.assertThat(actual).isRight().containsRightInstanceOf(Account.class);
            assertThat(actual.get()).usingRecursiveComparison().isEqualTo(account);
            assertThat(entityCaptor.getValue()).usingRecursiveComparison().isEqualTo(entity);
        }

        @Test
        void should_not_save_if_repository_throw_exception() {
            val account = Account.builder().pseudo("Barlords").build();
            val entity = AccountEntityMapper.fromDomain(account);
            val throwable = new IllegalArgumentException();

            doThrow(throwable).when(repository).save(any(AccountEntity.class));

            val actual = adapter.save(account);

            verify(repository).save(entityCaptor.capture());
            verifyNoMoreInteractions(repository);

            VavrAssertions.assertThat(actual).isLeft().containsLeftInstanceOf(ApplicationError.class);
            assertThat(actual.getLeft())
                    .usingRecursiveComparison()
                    .isEqualTo(new ApplicationError("Unable to save account", null, account, throwable));
            assertThat(entityCaptor.getValue()).usingRecursiveComparison().isEqualTo(entity);
        }
    }

    @Nested
    class FindById {
        @Test
        void should_find() {
            val id = UUID.randomUUID();
            val entity = AccountEntity.builder().pseudo("Barlords").deck(List.of()).build();
            val domain = AccountEntityMapper.toDomain(entity);

            when(repository.findAccountEntityById(id)).thenReturn(Some(entity));

            val actual = adapter.findById(id);

            VavrAssertions.assertThat(actual).isDefined();
            assertThat(actual.get()).usingRecursiveComparison().isEqualTo(domain);

            verifyNoMoreInteractions(repository);
        }

        @Test
        void should_not_find() {
            val id = UUID.randomUUID();

            when(repository.findAccountEntityById(id)).thenReturn(None());

            val actual = adapter.findById(id);

            VavrAssertions.assertThat(actual).isEmpty();

            verifyNoMoreInteractions(repository);
        }
    }

    @Nested
    class FindAll {
        @Test
        void should_find() {
            val id = UUID.randomUUID();
            val entity = AccountEntity.builder().pseudo("Barlords").deck(List.of()).build();
            val domain = AccountEntityMapper.toDomain(entity);

            when(repository.findAll()).thenReturn(List.of(entity));

            val actual = adapter.findAll();

            VavrAssertions.assertThat(actual).isNotEmpty();
            assertThat(actual.asJava()).usingRecursiveComparison().isEqualTo(List.of(domain));

            verifyNoMoreInteractions(repository);
        }

        @Test
        void should_not_find() {
            val id = UUID.randomUUID();

            when(repository.findAll()).thenReturn(List.of());

            val actual = adapter.findAll();

            VavrAssertions.assertThat(actual).isEmpty();

            verifyNoMoreInteractions(repository);
        }
    }

}