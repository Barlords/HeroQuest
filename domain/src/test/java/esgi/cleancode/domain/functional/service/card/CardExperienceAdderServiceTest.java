package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class CardExperienceAdderServiceTest {

    @InjectMocks
    private CardExperienceAdderService service;


    @ParameterizedTest
    @ValueSource(ints = 1)
    void should_win_experience(int amount) {
        var id = UUID.randomUUID();
        var given = Card.builder().id(id).build();

        var actual = service.addExperience(given, amount);

        Assertions.assertEquals(given.getExperience()+amount, actual.getExperience());
    }
}
