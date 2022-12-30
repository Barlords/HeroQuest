package service.playeraccount;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.domain.Rarity;
import esgi.cleancode.domain.Speciality;
import esgi.cleancode.service.hero.HeroCardFinderService;
import esgi.cleancode.service.playeraccount.PlayerAccountAddCardService;
import esgi.cleancode.service.playeraccount.PlayerAccountFinderService;
import esgi.cleancode.service.playeraccount.PlayerAccountRemoveCardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerAccountRemoveCardServiceTest {

    @InjectMocks
    private PlayerAccountRemoveCardService playerAccountRemoveCardService;

    @Mock
    private PlayerAccountFinderService playerAccountFinderService;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_add_card_in_player_account()
    {
        var heroId = UUID.randomUUID();
        var heroGiven = HeroCard.builder()
                .id(heroId)
                .name("Kratos")
                .life(100)
                .power(10)
                .armor(5)
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON)
                .build();

        var playerId = UUID.randomUUID();
        var playerGiven = PlayerAccount.builder()
                .id(playerId)
                .pseudo("Barlords")
                .deck(List.of(heroGiven))
                .build();

        var deckModified = new ArrayList<>(playerGiven.getDeck());
        deckModified.remove(heroGiven);

        var playerModified = playerGiven.withDeck(deckModified);

        when(playerAccountFinderService.findById(playerId)).thenReturn(playerGiven);
        when(database.savePlayerAccount(playerModified)).thenReturn(playerModified);

        var playerActual = playerAccountRemoveCardService.remove(heroGiven, playerGiven);

        Assertions.assertEquals(playerGiven.getId(), playerActual.getId());
        Assertions.assertEquals(playerGiven.getDeck().size()-1, playerActual.getDeck().size());
    }

}
