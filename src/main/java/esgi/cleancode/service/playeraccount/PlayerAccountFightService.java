package esgi.cleancode.service.playeraccount;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.service.hero.HeroCardFinderService;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PlayerAccountFightService {

    private PlayerAccountFinderService playerAccountFinderService;

    private HeroCardFinderService heroCardFinderService;

    private InMemoryDatabase database;

    public void fight(UUID player1, UUID heroOfPlayer1, UUID player2, UUID heroOfPlayer2) {

    }
}