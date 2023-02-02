package esgi.cleancode.domain.functional.service.player_account;

import esgi.cleancode.domain.db.InMemoryDatabase;
import esgi.cleancode.domain.functional.model.PlayerAccount;
import esgi.cleancode.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PlayerAccountFinderService {

    private final InMemoryDatabase database;

    public PlayerAccount findById(UUID id)
    {
        return database.findPlayerAccountById(id).orElseThrow(() -> new ResourceNotFoundException("PlayerAccount not found"));
    }
}
