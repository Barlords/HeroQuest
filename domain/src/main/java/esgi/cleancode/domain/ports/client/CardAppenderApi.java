package esgi.cleancode.domain.ports.client;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Card;
import io.vavr.control.Either;

import java.util.UUID;

public interface CardAppenderApi {

    Either<ApplicationError, Account> appendCard(UUID accountId, Card card);

}
