package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.service.validation.AccountValidator;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import static io.vavr.API.Left;

@Slf4j
@RequiredArgsConstructor
public class AccountTokenRemoverService {

    private final AccountPersistenceSpi spi;

    public Either<ApplicationError, Account> removeToken(UUID accountId, int amount) {
        return spi.findById(accountId)
                .onEmpty(() -> log.error("Unable to find account with id {}", accountId))
                .fold(
                        () -> Left(new ApplicationError("No account", null, accountId, null)),
                        account -> verifyRemoveAndSave(account, amount)
                );
    }

    private Either<ApplicationError, Account> verifyRemoveAndSave(Account account, int amount) {
        return AccountValidator.validate(account)
                .toEither()
                .peekLeft(
                        applicationError -> log.error("Unable to validate account : {}, with error {}", account, applicationError)
                )
                .map(o -> account.withNbToken(account.getNbToken() - amount))
                .flatMap(spi::save);
    }

}
