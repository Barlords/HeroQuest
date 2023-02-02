package esgi.cleancode.domain.functional.service.player_account;

import esgi.cleancode.domain.db.InMemoryDatabase;
import esgi.cleancode.domain.functional.model.HeroCard;
import esgi.cleancode.domain.functional.model.PlayerAccount;
import esgi.cleancode.domain.functional.service.hero.HeroFinderService;
import esgi.cleancode.domain.functional.service.hero_card.HeroCardIdGeneratorService;
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
                .life((int) (hero.getSpeciality().getLife() * hero.getRarity().getCoefficient()))
                .power((int) (hero.getSpeciality().getPower() * hero.getRarity().getCoefficient()))
                .armor((int) (hero.getSpeciality().getArmor() * hero.getRarity().getCoefficient()))
                .speciality(hero.getSpeciality())
                .rarity(hero.getRarity())
                .build();
        var modifiedDeck = new ArrayList<>(playerAccount.getDeck());
        modifiedDeck.add(heroCard);
        var playerAccountModified = playerAccount.withDeck(modifiedDeck);
        return database.savePlayerAccount(playerAccountModified);
    }
}
