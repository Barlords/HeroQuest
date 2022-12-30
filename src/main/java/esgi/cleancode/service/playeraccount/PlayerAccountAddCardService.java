package esgi.cleancode.service.playeraccount;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.service.hero.HeroCardFinderInDatabaseService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@RequiredArgsConstructor
public class PlayerAccountAddCardService {

    private final InMemoryDatabase database;

    private final PlayerAccountFinderService playerAccountFinderService;

    private final HeroCardFinderInDatabaseService heroCardFinderService;

    public PlayerAccount add(UUID heroCardId, UUID playerAccountId)
    {
        var playerAccount = playerAccountFinderService.findById(playerAccountId);
        var heroCard = heroCardFinderService.findById(heroCardId);
        var modifiedDeck = new ArrayList<>(playerAccount.getDeck());
        modifiedDeck.add(heroCard);
        var playerAccountModified = playerAccount.withDeck(modifiedDeck);
        return database.savePlayerAccount(playerAccountModified);
    }
}
