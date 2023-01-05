package adapter.out;

import esgi.cleancode.adapter.out.InMemoryDatabase;
import esgi.cleancode.domain.Hero;
import esgi.cleancode.domain.PlayerAccount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryDatabaseTest {

    private final InMemoryDatabase database = InMemoryDatabase.getInstance();

    @Test
    void should_save_and_find_hero() {
        final var id = UUID.randomUUID();
        final var given = Hero.builder().id(id).build();

        Assertions.assertThatNoException().isThrownBy(() -> database.saveHero(given));
        final var actual = database.findHeroById(id);

        assertThat(actual).containsSame(given);
    }

    @Test
    void should_save_and_find_player_account() {
        final var id = UUID.randomUUID();
        final var given = PlayerAccount.builder().id(id).build();

        Assertions.assertThatNoException().isThrownBy(() -> database.savePlayerAccount(given));
        final var actual = database.findPlayerAccountById(id);

        assertThat(actual).containsSame(given);
    }
}
