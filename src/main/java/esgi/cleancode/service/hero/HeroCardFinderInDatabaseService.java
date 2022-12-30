package esgi.cleancode.service.hero;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class HeroCardFinderInDatabaseService {

    private final InMemoryDatabase database;

    public HeroCard findById(UUID id)
    {
        return database.findHeroCardById(id).orElseThrow(() -> new ResourceNotFoundException("HeroCard not found"));
    }
}
