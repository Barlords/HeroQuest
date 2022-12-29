package esgi.cleancode.database;

import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.exception.ResourceNotFoundException;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDatabase {

    private static InMemoryDatabase INSTANCE;
    private static final java.util.Map<UUID, HeroCard> HERO_DATABASE = new ConcurrentHashMap<>();
    private static final java.util.Map<UUID, PlayerAccount> PLAYER_ACCOUNT_DATABASE = new ConcurrentHashMap<>();

    private InMemoryDatabase() {
    }

    public static synchronized InMemoryDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryDatabase();
        }
        return INSTANCE;
    }

    public PlayerAccount savePlayerAccount(PlayerAccount playerAccountToSave) {
        PLAYER_ACCOUNT_DATABASE.put(playerAccountToSave.getId(), playerAccountToSave);
        return playerAccountToSave;
    }

    public HeroCard saveHeroCard(HeroCard heroToSave) {
        HERO_DATABASE.put(heroToSave.getId(), heroToSave);
        return heroToSave;
    }

    public Optional<PlayerAccount> findPlayerAccountById(UUID id) {
        return Optional.ofNullable(PLAYER_ACCOUNT_DATABASE.get(id));
    }

    public Optional<HeroCard> findHeroCardById(UUID id) {
        return Optional.ofNullable(HERO_DATABASE.get(id));
    }

}
