package application.services.hero_card;

import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.application.services.hero_card.HeroCardLifeRemoverService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HeroCardLifeRemoverServiceTest {

    @InjectMocks
    private HeroCardLifeRemoverService service;

    @ParameterizedTest
    @ValueSource(ints = 10)
    void should_remove_life(int amount) {
        var given = HeroCard.builder().life(1000).build();

        var actual = service.remove(given, amount);

        Assertions.assertEquals(given.getLife() - amount, actual.getLife());
    }

}
