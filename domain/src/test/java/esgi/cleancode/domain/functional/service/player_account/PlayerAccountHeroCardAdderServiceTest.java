package esgi.cleancode.domain.functional.service.player_account;

import esgi.cleancode.domain.functional.model.*;
import esgi.cleancode.domain.db.InMemoryDatabase;
import esgi.cleancode.domain.functional.service.hero.HeroFinderService;
import esgi.cleancode.domain.functional.service.hero_card.HeroCardIdGeneratorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerAccountHeroCardAdderServiceTest
{

    @InjectMocks
    private PlayerAccountHeroCardAdderService playerAccountHeroCardAdderService;

    @Mock
    private PlayerAccountFinderService playerAccountFinderService;

    @Mock
    private HeroFinderService heroFinderService;

    @Mock
    private HeroCardIdGeneratorService heroCardIdGeneratorService;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_add_card_in_player_account()
    {
        var playerId = UUID.randomUUID();
        var playerGiven = PlayerAccount.builder()
                .id(playerId)
                .pseudo("Barlords")
                .build();

        var heroId = UUID.randomUUID();
        var heroGiven = Hero.builder()
                .id(heroId)
                .name("Kratos")
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON)
                .build();

        var heroCardId = UUID.randomUUID();
        var heroCardGiven = HeroCard.builder()
                .id(heroCardId)
                .name(heroGiven.getName())
                .life((int) (heroGiven.getSpeciality().getLife() * heroGiven.getRarity().getCoefficient()))
                .power((int) (heroGiven.getSpeciality().getPower() * heroGiven.getRarity().getCoefficient()))
                .armor((int) (heroGiven.getSpeciality().getArmor() * heroGiven.getRarity().getCoefficient()))
                .speciality(heroGiven.getSpeciality())
                .rarity(heroGiven.getRarity())
                .build();

        var deckModified = new ArrayList<>(playerGiven.getDeck());
        deckModified.add(heroCardGiven);

        var playerModified = playerGiven.withDeck(deckModified);

        when(playerAccountFinderService.findById(playerId)).thenReturn(playerGiven);
        when(heroFinderService.findById(heroId)).thenReturn(heroGiven);
        when(heroCardIdGeneratorService.generateNewHeroCardId()).thenReturn(heroCardId);
        when(database.savePlayerAccount(playerModified)).thenReturn(playerModified);

        var playerActual = playerAccountHeroCardAdderService.add(heroGiven.getId(), playerGiven.getId());

        Assertions.assertEquals(playerGiven.getId(), playerActual.getId());
        Assertions.assertEquals(playerGiven.getDeck().size()+1, playerActual.getDeck().size());
        Assertions.assertEquals(heroCardGiven, playerActual.getDeck().get(0));
    }

}
