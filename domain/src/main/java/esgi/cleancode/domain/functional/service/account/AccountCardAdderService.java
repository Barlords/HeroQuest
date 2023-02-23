package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Card;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
//@RequiredArgsConstructor
public class AccountCardAdderService {

    public static Account addCard(Account account, Card card) {
        return account.withDeck(account.getDeck().append(card));
    }

    /*

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

     */

}

