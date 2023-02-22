package esgi.cleancode.domain.functional.service;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.*;
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

    private final AccountPersistenceSpi accountPersistenceSpi;

    private final HeroPersistenceSpi heroPersistenceSpi;

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
        val rarity = selectRarity(booster);
        val speciality = selectSpeciality();
        val heros = heroPersistenceSpi.findByRarityAndSpeciality(rarity.name(), speciality.name());
        val hero = heros.shuffle().get(0);
        return Card.builder()
                .name(hero.getName())
                .rarity(hero.getRarity())
                .speciality(hero.getSpeciality())
                .life((int) (hero.getSpeciality().getLife() * hero.getRarity().getCoefficient()))
                .power((int) (hero.getSpeciality().getPower() * hero.getRarity().getCoefficient()))
                .armor((int) (hero.getSpeciality().getArmor() * hero.getRarity().getCoefficient()))
                .build();
    }

    private Rarity selectRarity(Booster booster) {
        val seed = Math.random();
        if (seed <= booster.getProbabilityOfCommon()) {
            return Rarity.COMMON;
        }
        else if (seed <= booster.getProbabilityOfCommon() + booster.getProbabilityOfRare()) {
            return Rarity.RARE;
        }
        else {
            return Rarity.LEGENDARY;
        }
    }

    private Speciality selectSpeciality() {
        val seed = Math.random();
        if (seed <= 0.33) {
            return Speciality.TANK;
        }
        else if (seed <= 0.66) {
            return Speciality.MAGE;
        }
        else {
            return Speciality.ASSASSIN;
        }
    }

}
