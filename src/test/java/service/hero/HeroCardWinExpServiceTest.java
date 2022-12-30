package service.hero;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.service.hero.HeroCardWinExpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HeroCardWinExpServiceTest {

    @InjectMocks
    private HeroCardWinExpService service;

    @Mock
    private InMemoryDatabase database;

    @ParameterizedTest
    @ValueSource(ints = 1)
    void should_win_experience_and_save_in_database(int amount) {
        var id = UUID.randomUUID();
        var given = HeroCard.builder().id(id).build();



        var actual = service.winExp(amount);

        Assertions.assertEquals(given.getExperience()+amount, actual.getExperience());
    }
}
