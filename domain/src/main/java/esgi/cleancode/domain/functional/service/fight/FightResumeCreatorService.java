package esgi.cleancode.domain.functional.service.fight;

import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.model.FightResult;
import esgi.cleancode.domain.functional.model.FightResume;

public class FightResumeCreatorService {

    public static FightResume create(Card opponent, FightResult fightResult) {
        return FightResume.builder()
                .idOpponent(opponent.getId())
                .fightResult(fightResult)
                .build();
    }
}
