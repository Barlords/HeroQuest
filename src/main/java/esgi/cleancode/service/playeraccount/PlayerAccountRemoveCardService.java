package esgi.cleancode.service.playeraccount;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.PlayerAccount;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PlayerAccountRemoveCardService {

    private final InMemoryDatabase database;

    private final PlayerAccountFinderService playerAccountFinderService;

    public PlayerAccount remove(UUID heroCardId, UUID playerAccountId) {
        var playerAccount = playerAccountFinderService.findById(playerAccountId);
        return null;
    }

}
