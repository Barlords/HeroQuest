package service;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.domain.Rarity;
import esgi.cleancode.domain.Speciality;
import esgi.cleancode.service.PlayerAccountAddCardService;
import esgi.cleancode.service.PlayerAccountFinderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerAccountAddCardServiceTest
{

    @InjectMocks
    private PlayerAccountAddCardService playerAccountAddCardService;

    @Mock
    private PlayerAccountFinderService playerAccountFinderService;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_add_card_in_player_account()
    {
        var playerId = UUID.randomUUID();
        var playerGiven = PlayerAccount.builder().id(playerId).pseudo("Barlords").build();

        var heroGiven = HeroCard.builder().name("Kratos").life(100).power(10).armor(5).speciality(Speciality.TANK).rarity(Rarity.COMMON).build();

        var deckModified = playerGiven.getDeck();
        deckModified.add(heroGiven);

        var playerModified = playerGiven.withDeck(deckModified);

        when(playerAccountFinderService.findById(playerGiven.getId())).thenReturn(playerGiven);
        when(database.savePlayerAccount(playerModified)).thenReturn(playerModified);

        var playerActual = playerAccountAddCardService.addCardInPlayerAccount(heroGiven, playerGiven);

        Assertions.assertEquals(playerGiven.getId(), playerActual.getId());
        Assertions.assertEquals(playerGiven.getDeck().size()+1, playerActual.getDeck().size());
    }

    @Test
    void should_not_found_player_account() {

    }
}
