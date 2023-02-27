package esgi.cleancode.domain.ports.client;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Booster;
import io.vavr.control.Either;

import java.util.UUID;

public interface BoosterOpenerApi {

    Either<ApplicationError, Account> openBooster(UUID accountId, Booster booster);

}
