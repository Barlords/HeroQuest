package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.model.FightResume;

public class CardFightResumeAdderService {

    public static Card addFightResume(Card card, FightResume fightResume) {
        return card.withFightHistory(card.getFightHistory().append(fightResume));
    }
}
