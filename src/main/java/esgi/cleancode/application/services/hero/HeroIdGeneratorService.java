package esgi.cleancode.application.services.hero;

import java.util.UUID;

public class HeroIdGeneratorService {
    public UUID generateNewHeroId() {
        return UUID.randomUUID();
    }
}
