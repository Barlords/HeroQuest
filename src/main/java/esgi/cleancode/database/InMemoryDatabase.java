package esgi.cleancode.database;

import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.PlayerAccount;

import java.util.Optional;
import java.util.UUID;

public class InMemoryDatabase {
    public HeroCard saveCardToPLayer(HeroCard given, PlayerAccount player)
    {
        return null;
    }

    public PlayerAccount savePlayerAccount(PlayerAccount given) {
        return null;
    }

    public Optional<PlayerAccount> findPlayerAccountById(UUID id) {
        return Optional.empty();
    }

    public Optional<HeroCard> findHeroCardById(UUID id) {
        return Optional.empty();
    }
}
