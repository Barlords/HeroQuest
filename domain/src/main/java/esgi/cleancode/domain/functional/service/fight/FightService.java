package esgi.cleancode.domain.functional.service.fight;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.model.FightResult;
import esgi.cleancode.domain.functional.service.account.AccountCardUpdaterService;
import esgi.cleancode.domain.functional.service.card.CardFightResumeAdderService;
import esgi.cleancode.domain.functional.service.card.CardLifeRemoverService;
import esgi.cleancode.domain.ports.client.FightApi;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.UUID;

import static io.vavr.API.Left;

@Slf4j
@RequiredArgsConstructor
public class FightService implements FightApi {

    private final AccountPersistenceSpi accountPersistenceSpi;

    @Override
    public Either<ApplicationError, Account> fight(UUID accountId, UUID cardId, UUID opponentAccountId, UUID opponentCardId) {
        return accountPersistenceSpi.findById(accountId)
                .onEmpty(() -> log.error("Unable to find account with id {}", accountId))
                .fold(
                        () -> Left(new ApplicationError("No account", null, accountId, null)),
                        account -> findOpponentAccountAndCardsAndFight(account, cardId, opponentAccountId, opponentCardId)
                );
    }

    private Either<ApplicationError, Account> findOpponentAccountAndCardsAndFight(Account account, UUID cardId, UUID opponentAccountId, UUID opponentCardId) {
        return accountPersistenceSpi.findById(opponentAccountId)
                .onEmpty(() -> log.error("Unable to find opponent account with id {}", opponentAccountId))
                .fold(
                        () -> Left(new ApplicationError("No account", null, opponentAccountId, null)),
                        opponentAccount -> findCardsAndFight(account, cardId, opponentAccount, opponentCardId)
                );
    }

    private Either<ApplicationError, Account> findCardsAndFight(Account account, UUID cardId, Account opponentAccount, UUID opponentCardId) {
        val cardAtt = account.getDeck()
                .toJavaStream()
                .filter(c -> c.getId().equals(cardId))
                .findAny()
                .orElse(null);

        if (cardAtt != null) {
            return findOpponentCardAndFight(account, cardAtt, opponentAccount, opponentCardId);
        }
        else {
            return Either.left(new ApplicationError("No card", null, cardId, null));
        }
    }

    private Either<ApplicationError, Account> findOpponentCardAndFight(Account account, Card card, Account opponentAccount, UUID opponentCardId) {
        val opponentCard = opponentAccount.getDeck()
                .toJavaStream()
                .filter(c-> c.getId().equals(opponentCardId))
                .findAny()
                .orElse(null);

        if (opponentCard != null) {
            return fight(account, card, opponentCard);
        }
        else {
            return Either.left(new ApplicationError("No card", null, opponentCardId, null));
        }
    }

    private Either<ApplicationError, Account> fight(Account account, Card card, Card opponentCard) {
        final Card backupCard = card;
        final Card backupOpponentCard = opponentCard;

        Card winner = null;
        while(winner == null) {

            int damage = FightAdvantageApplierService.apply(card, opponentCard, card.getPower());
            damage = FightArmorApplierService.apply(opponentCard, damage);
            opponentCard = CardLifeRemoverService.remove(opponentCard, damage);

            if (FightEndCheckerService.isEnd(card, opponentCard)) {
                winner = card;
                break;
            }

            damage = FightAdvantageApplierService.apply(opponentCard, card, opponentCard.getPower());
            damage = FightArmorApplierService.apply(card, damage);
            card = CardLifeRemoverService.remove(card, damage);

            if (FightEndCheckerService.isEnd(card, opponentCard)) {
                winner = opponentCard;
            }
        }

        if (winner.getId() == card.getId()) {
            System.out.println("Vous avez gagné le combat");
            card = CardFightResumeAdderService.addFightResume(backupCard, FightResumeCreatorService.create(backupOpponentCard, FightResult.WIN));
            account = FightWinnerApplierService.apply(account, card, 1);
        }
        else {
            card = CardFightResumeAdderService.addFightResume(backupCard, FightResumeCreatorService.create(backupOpponentCard, FightResult.LOOSE));
            account = AccountCardUpdaterService.updateCardInDeck(account, card);
        }

        return accountPersistenceSpi.save(account);
    }

}
