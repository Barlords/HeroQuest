package esgi.cleancode.domain.functional.service.player_account;

import esgi.cleancode.domain.db.InMemoryDatabase;
import esgi.cleancode.domain.functional.model.PlayerAccount;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PlayerAccountTokenAdderService {

    private final InMemoryDatabase database;

    private final PlayerAccountFinderService playerAccountFinderService;

    public PlayerAccount add(UUID playerAccountId, int amount) {
        var playerAccount = playerAccountFinderService.findById(playerAccountId);
        var playerAccountModified = playerAccount.withNbToken(playerAccount.getNbToken()+amount);
        return database.savePlayerAccount(playerAccountModified);
    }

}

