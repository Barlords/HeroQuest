package esgi.cleancode.server.postgres.adapter;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import esgi.cleancode.server.postgres.mapper.AccountEntityMapper;
import esgi.cleancode.server.postgres.repository.AccountRepository;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static io.vavr.API.Try;

@Service
@RequiredArgsConstructor
public class AccountDatabaseAdapter implements AccountPersistenceSpi {

    private final AccountRepository repository;

    @Transactional
    @Override
    public Either<ApplicationError, Account> save(Account o) {
        val entity = AccountEntityMapper.fromDomain(o);
        return Try(() -> repository.save(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save hero", null, o, throwable))
                .map(AccountEntityMapper::toDomain);
    }

    @Transactional
    @Override
    public List<Account> findAll() {
        return repository.findAll()
                .stream()
                .map(AccountEntityMapper::toDomain)
                .collect(List.collector());
    }

    @Override
    @Transactional
    public Option<Account> findById(UUID id) {
        return repository.findAccountEntityById(id).map(AccountEntityMapper::toDomain);
    }
}