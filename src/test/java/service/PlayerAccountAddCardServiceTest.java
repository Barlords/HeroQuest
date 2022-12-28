package service;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.PlayerAccount;
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
        var player = PlayerAccount.builder().id(UUID.randomUUID()).build();
        var given = HeroCard.builder().build();
        when(playerAccountFinderService.findById(player.getId())).thenReturn(player);
        when(database.saveCardToPLayer(given, player)).thenReturn(given);
        var actual = playerAccountAddCardService.addCardInPlayerAccount(given, player);

        Assertions.assertEquals(given, actual);
    }
}
