package esgi.cleancode.domain.functional.service;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.service.validation.CardValidator;
import esgi.cleancode.domain.ports.client.CardAppenderApi;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import static io.vavr.API.Left;

@Slf4j
@RequiredArgsConstructor
public class CardAppenderService implements CardAppenderApi {

    private final AccountPersistenceSpi spi;

    @Override
    public Either<ApplicationError, Account> appendCard(UUID accountId, Card card) {
        return spi.findById(accountId)
                .onEmpty(() -> log.error("Unable to find account with id {}", accountId))
                .fold(
                        () -> Left(new ApplicationError("No account", null, accountId, null)),
                        account -> verifyAppendAndSave(account, card)
                );
    }

    private Either<ApplicationError, Account> verifyAppendAndSave(Account account, Card card) {
        return CardValidator.validate(card)
                .toEither()
                .peekLeft(
                        applicationError -> log.error("Unable to validate card : {}, with error {}", card, applicationError)
                )
                .map(o -> account.withDeck(account.getDeck().append(card)))
                .flatMap(spi::save);
    }
}
