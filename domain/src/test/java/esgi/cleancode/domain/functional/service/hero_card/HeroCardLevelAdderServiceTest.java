package esgi.cleancode.domain.functional.service.hero_card;

import esgi.cleancode.domain.functional.model.HeroCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class HeroCardLevelAdderServiceTest {

    @InjectMocks
    private HeroCardLevelAdderService service;

    @Test
    void should_level_up() {
        var id = UUID.randomUUID();
        var given = HeroCard.builder().id(id).level(1).experience(5).life(1000).power(100).armor(20).build();

        var actual = service.levelUp(given);

        Assertions.assertEquals(given.getExperience() - 5, actual.getExperience());
        Assertions.assertEquals(given.getLevel() + 1, actual.getLevel());
        Assertions.assertEquals((int) (given.getLife() * 1.1), actual.getLife());
        Assertions.assertEquals((int) (given.getPower() * 1.1), actual.getPower());
        Assertions.assertEquals((int) (given.getArmor() * 1.1), actual.getArmor());
    }

}
