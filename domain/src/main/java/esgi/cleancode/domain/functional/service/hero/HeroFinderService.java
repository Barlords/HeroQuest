package esgi.cleancode.domain.functional.service.hero;

import esgi.cleancode.domain.db.InMemoryDatabase;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class HeroFinderService {

    private final InMemoryDatabase database;

    public Hero findById(UUID id)
    {
        return database.findHeroById(id).orElseThrow(() -> new ResourceNotFoundException("Hero not found"));
    }
}
