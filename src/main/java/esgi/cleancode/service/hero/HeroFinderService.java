package esgi.cleancode.service.hero;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.Hero;
import esgi.cleancode.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class HeroFinderService {

    private final InMemoryDatabase database;

    public Hero findById(UUID id)
    {
        return database.findHeroById(id).orElseThrow(() -> new ResourceNotFoundException("HeroCard not found"));
    }
}
