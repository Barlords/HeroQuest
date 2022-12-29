package service.hero;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.domain.Rarity;
import esgi.cleancode.domain.Speciality;
import esgi.cleancode.service.hero.HeroCardFinderService;
import esgi.cleancode.service.playeraccount.PlayerAccountFightService;
import esgi.cleancode.service.playeraccount.PlayerAccountFinderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class HeroCardFightServiceTest {

    @InjectMocks
    private PlayerAccountFightService service;

    @Mock
    private PlayerAccountFinderService playerAccountFinderService;

    @Mock
    private HeroCardFinderService heroCardFinderService;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_be_fight_and_win_experience() {
        var player1Id = UUID.randomUUID();
        var player1Given = PlayerAccount.builder().id(player1Id).pseudo("Barlords").build();

        var hero1Id = UUID.randomUUID();
        var hero1Given = HeroCard.builder().id(hero1Id).name("Kratos").life(100).power(10).armor(5).speciality(Speciality.TANK).rarity(Rarity.COMMON).build();

        var player2Id = UUID.randomUUID();
        var player2Given = PlayerAccount.builder().id(player2Id).pseudo("Matthieu").build();

        var hero2Id = UUID.randomUUID();
        var hero2Given = HeroCard.builder().id(hero2Id).name("Absol").life(50).power(10).armor(5).speciality(Speciality.TANK).rarity(Rarity.COMMON).build();



        service.fight(player1Id, hero1Id, player2Id, hero2Id);

        Assertions.assertEquals(hero1Given.getExperience()+1, hero1Given.getExperience());
    }

    @Test
    void should_be_not_fight() {

    }

}
