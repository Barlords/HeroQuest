package esgi.cleancode.database;

import esgi.cleancode.domain.Hero;
import esgi.cleancode.domain.PlayerAccount;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDatabase {

    private static InMemoryDatabase INSTANCE;
    private static final java.util.Map<UUID, Hero> HERO_DATABASE = new ConcurrentHashMap<>();
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

    public Hero saveHero(Hero heroToSave) {
        HERO_DATABASE.put(heroToSave.getId(), heroToSave);
        return heroToSave;
    }

    public Optional<PlayerAccount> findPlayerAccountById(UUID id) {
        return Optional.ofNullable(PLAYER_ACCOUNT_DATABASE.get(id));
    }

    public Optional<Hero> findHeroById(UUID id) {
        return Optional.ofNullable(HERO_DATABASE.get(id));
    }

}
