package esgi.cleancode.application.services.player_account;

import esgi.cleancode.adapter.out.InMemoryDatabase;
import esgi.cleancode.domain.PlayerAccount;
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

