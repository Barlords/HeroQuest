package esgi.cleancode.domain.functional.service.hero;

import java.util.UUID;

public class HeroIdGeneratorService {
    public UUID generateNewHeroId() {
        return UUID.randomUUID();
    }
}
