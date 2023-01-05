package esgi.cleancode.application.services.hero;

import esgi.cleancode.adapter.out.InMemoryDatabase;
import esgi.cleancode.domain.Hero;
import esgi.cleancode.domain.exception.ResourceNotFoundException;
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
