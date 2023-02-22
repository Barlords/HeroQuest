package esgi.cleancode.domain.ports.client;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import io.vavr.control.Either;

public interface AccountCreatorApi {
    Either<ApplicationError, Account> create(String pseudo);
}
