package esgi.cleancode.service.playeraccount;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.service.hero.HeroFinderService;
import esgi.cleancode.service.hero_card.HeroCardIdGeneratorService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@RequiredArgsConstructor
public class PlayerAccountHeroCardAdderService {

    private final InMemoryDatabase database;

    private final HeroCardIdGeneratorService heroCardIdGeneratorService;

    private final PlayerAccountFinderService playerAccountFinderService;

    private final HeroFinderService heroFinderService;

    public PlayerAccount add(UUID heroId, UUID playerAccountId)
    {
        var playerAccount = playerAccountFinderService.findById(playerAccountId);
        var hero = heroFinderService.findById(heroId);
        var heroCard = HeroCard.builder()
                .id(heroCardIdGeneratorService.generateNewHeroCardId())
                .name(hero.getName())
                .life(hero.getLife())
                .power(hero.getPower())
                .armor(hero.getArmor())
                .speciality(hero.getSpeciality())
                .rarity(hero.getRarity())
                .build();
        var modifiedDeck = new ArrayList<>(playerAccount.getDeck());
        modifiedDeck.add(heroCard);
        var playerAccountModified = playerAccount.withDeck(modifiedDeck);
        return database.savePlayerAccount(playerAccountModified);
    }
}
