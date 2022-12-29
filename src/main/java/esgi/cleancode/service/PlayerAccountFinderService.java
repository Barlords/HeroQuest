package esgi.cleancode.service;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.exception.ResourceNotFoundException;
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
