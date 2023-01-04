package esgi.cleancode.service.hero_card;

import java.util.UUID;

public class HeroCardIdGeneratorService {
    public UUID generateNewHeroCardId() {
        return UUID.randomUUID();
    }
}
