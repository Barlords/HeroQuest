package esgi.cleancode.domain.ports.client;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import io.vavr.control.Either;

import java.util.UUID;

public interface FightApi {
    Either<ApplicationError, Account> fight(UUID accountId, UUID cardId, UUID opponentAccountId, UUID opponentCardId);
}
