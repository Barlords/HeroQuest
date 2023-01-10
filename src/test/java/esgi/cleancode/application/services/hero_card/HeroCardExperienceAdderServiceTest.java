package esgi.cleancode.application.services.hero_card;

import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.application.services.hero_card.HeroCardExperienceAdderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class HeroCardExperienceAdderServiceTest {

    @InjectMocks
    private HeroCardExperienceAdderService service;


    @ParameterizedTest
    @ValueSource(ints = 1)
    void should_win_experience(int amount) {
        var id = UUID.randomUUID();
        var given = HeroCard.builder().id(id).build();

        var actual = service.winExp(given, amount);

        Assertions.assertEquals(given.getExperience()+amount, actual.getExperience());
    }
}
