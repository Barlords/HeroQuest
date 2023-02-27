package esgi.cleancode.domain.functional.service.fight;

import esgi.cleancode.domain.functional.model.*;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FightResumeCreatorServiceTest
{
    @Test
    void should_create_fight_resume() {
        val card = Card.builder()
                .name("Kratos")
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON)
                .build();

        val actual = FightResumeCreatorService.create(card, FightResult.WIN);

        Assertions.assertEquals(card.getId(), actual.getIdCardOpponent());
        Assertions.assertEquals(FightResult.WIN, actual.getFightResult());
    }

}
