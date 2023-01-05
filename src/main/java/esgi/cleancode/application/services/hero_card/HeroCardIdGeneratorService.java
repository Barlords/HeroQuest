package esgi.cleancode.application.services.hero_card;

import java.util.UUID;

public class HeroCardIdGeneratorService {
    public UUID generateNewHeroCardId() {
        return UUID.randomUUID();
    }
}
