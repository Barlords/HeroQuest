package esgi.cleancode.domain.functional.service;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Booster;
import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.ports.client.BoosterOpenerApi;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import esgi.cleancode.domain.ports.server.HeroPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.UUID;

import static io.vavr.API.Left;

@Slf4j
@RequiredArgsConstructor
public class BoosterOpenerService implements BoosterOpenerApi {

    private final HeroPersistenceSpi heroPersistenceSpi;

    private final AccountPersistenceSpi accountPersistenceSpi;

    @Override
    public Either<ApplicationError, Account> openBooster(UUID accountId, Booster booster) {
        return accountPersistenceSpi.findById(accountId)
                .onEmpty(() -> log.error("Unable to find account with id {}", accountId))
                .fold(
                        () -> Left(new ApplicationError("No account", null, accountId, null)),
                        account -> verifyAppendAndSave(account, booster)
                );
    }

    private Either<ApplicationError, Account> verifyAppendAndSave(Account account, Booster booster) {
        if (account.getNbToken() < booster.getCost()) {
            return Either.left(new ApplicationError("Nombre de jeton insufisant", "", account, null));
        }

        for (int i=0 ; i<booster.getNbCard() ; i++) {
            val card = generateCard(booster);
            account = account.withDeck(account.getDeck().append(card));
        }
        account = account.withNbToken(account.getNbToken() - booster.getCost());

        return accountPersistenceSpi.save(account);
    }

    private Card generateCard(Booster booster) {
        val seed = Math.random();
        if (seed < booster.getProbabilityOfCommon()) {
            //val hero = heroPersistenceSpi.findByRarityAndSpeciality
        }
        else if (seed < booster.getProbabilityOfCommon() + booster.getProbabilityOfRare()) {

        }
        else {

        }
        return Card.builder().experience(1).power(1).armor(1).level(1).build();
    }

}
