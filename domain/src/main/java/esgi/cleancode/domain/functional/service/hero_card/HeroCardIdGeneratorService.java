package esgi.cleancode.domain.functional.service.hero_card;

import java.util.UUID;

public class HeroCardIdGeneratorService {
    public UUID generateNewHeroCardId() {
        return UUID.randomUUID();
    }
}
