package service.hero;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.service.hero.HeroCardLevelUpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class HeroCardLevelUpServiceTest {

    @InjectMocks
    private HeroCardLevelUpService service;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_level_up() {
        var id = UUID.randomUUID();
        var given = HeroCard.builder().id(id).experience(5).build();

        var actual = service.levelUp(given);

        Assertions.assertEquals(given.getExperience() - 5, actual.getExperience());
        Assertions.assertEquals(given.getLevel() + 1, actual.getLevel());
        Assertions.assertEquals(given.getLife() * 1.1, actual.getLife());
        Assertions.assertEquals(given.getPower() * 1.1, actual.getPower());
        Assertions.assertEquals(given.getArmor() * 1.1, actual.getArmor());
    }

}
