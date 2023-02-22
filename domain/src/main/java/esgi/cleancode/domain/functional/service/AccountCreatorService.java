package esgi.cleancode.domain.functional.service;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.service.validation.AccountValidator;
import esgi.cleancode.domain.ports.client.AccountCreatorApi;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AccountCreatorService implements AccountCreatorApi {

    private final AccountPersistenceSpi spi;

    @Override
    public Either<ApplicationError, Account> create(String pseudo) {
        return AccountValidator.validate(Account.builder().pseudo(pseudo).build())
            .toEither()
            .peekLeft(
                    error -> log.error("An error occurred while validating account : {}", error)
            )
            .flatMap(spi::save);
    }
}
