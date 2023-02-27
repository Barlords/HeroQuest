package esgi.cleancode.domain.functional.service.booster;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Booster;
import esgi.cleancode.domain.functional.service.account.AccountCardAdderService;
import esgi.cleancode.domain.functional.service.account.AccountTokenCheckerService;
import esgi.cleancode.domain.functional.service.account.AccountTokenRemoverService;
import esgi.cleancode.domain.ports.client.BoosterCardGeneratorApi;
import esgi.cleancode.domain.ports.client.BoosterOpenerApi;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.UUID;

import static io.vavr.API.Left;

@Slf4j
@RequiredArgsConstructor
public class BoosterOpenerService implements BoosterOpenerApi {

    private final AccountPersistenceSpi accountPersistenceSpi;

    private final BoosterCardGeneratorApi boosterCardGeneratorApi;

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
        if (!AccountTokenCheckerService.haveEnoughToken(account, booster)) {
            return Either.left(new ApplicationError("Nombre de jeton insufisant", "", account, null));
        }

        for (int i=0 ; i<booster.getNbCard() ; i++) {
            val card = boosterCardGeneratorApi.generateCard(booster);
            account = AccountCardAdderService.addCard(account, card);
        }
        
        account = AccountTokenRemoverService.removeToken(account, booster.getCost());

        return accountPersistenceSpi.save(account);
    }
}
