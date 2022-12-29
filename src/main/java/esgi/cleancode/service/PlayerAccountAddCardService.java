package esgi.cleancode.service;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.PlayerAccount;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class PlayerAccountAddCardService {

    private final InMemoryDatabase database;

    private final PlayerAccountFinderService playerAccountFinderService;

    private final HeroCardFinderService heroCardFinderService;

    public PlayerAccount addCardInPlayerAccount(UUID heroCardId, UUID playerAccountId)
    {
        var playerAccount = playerAccountFinderService.findById(playerAccountId);
        var heroCard = heroCardFinderService.findById(heroCardId);
        var modifiedDeck = new ArrayList<>(playerAccount.getDeck());
        modifiedDeck.add(heroCard);
        var playerAccountModified = playerAccount.withDeck(modifiedDeck);
        return database.savePlayerAccount(playerAccountModified);
    }
}
