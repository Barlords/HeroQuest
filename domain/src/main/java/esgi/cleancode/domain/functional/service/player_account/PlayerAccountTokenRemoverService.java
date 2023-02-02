package esgi.cleancode.domain.functional.service.player_account;

import esgi.cleancode.domain.db.InMemoryDatabase;
import esgi.cleancode.domain.functional.model.PlayerAccount;
import esgi.cleancode.domain.exception.InvalidPlayerAccountTokenException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PlayerAccountTokenRemoverService {

    private final InMemoryDatabase database;

    private final PlayerAccountFinderService playerAccountFinderService;

    public PlayerAccount remove(UUID playerAccountId, int amount) {
        var playerAccount = playerAccountFinderService.findById(playerAccountId);
        if(!PlayerAccountTokenCheckerService.haveEnoughtToken(playerAccount, amount)) {
            throw new InvalidPlayerAccountTokenException("Number of token to remove is invalid (negative or higher than account token");
        }
        var playerAccountModified = playerAccount.withNbToken(playerAccount.getNbToken()-amount);
        return database.savePlayerAccount(playerAccountModified);
    }

}
