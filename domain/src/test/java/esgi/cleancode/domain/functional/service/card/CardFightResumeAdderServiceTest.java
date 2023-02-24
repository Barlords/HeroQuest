package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.model.FightResult;
import esgi.cleancode.domain.functional.model.FightResume;
import esgi.cleancode.domain.functional.service.fight.FightResumeCreatorService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class CardFightResumeAdderServiceTest {

    @InjectMocks
    private CardFightResumeAdderService service;

    @Test
    void should_add_fight_resume() {
        var card = Card.builder()
                .id(UUID.randomUUID())
                .build();

        var opponent = Card.builder()
                .id(UUID.randomUUID())
                .build();

        var given = FightResumeCreatorService.create(opponent, FightResult.WIN);

        var actual = service.addFightResume(card, given);

        Assertions.assertThat(actual.getFightHistory()).contains(given);
    }
}
