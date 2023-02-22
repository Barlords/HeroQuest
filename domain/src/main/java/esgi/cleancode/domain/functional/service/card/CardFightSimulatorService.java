package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CardFightSimulatorService {

    private final CardArmorApplierService heroCardArmorApplierService;

    private final CardAdvantageApplierService heroCardAdvantageApplierService;

    private final CardLifeRemoverService heroCardLifeRemoverService;

    private final CardExperienceAdderService heroCardExperienceAdderService;

    private final CardLevelAdderService heroCardLevelAdderService;

    public Card fight(Card hero1, Card hero2) {
        var hero1LifeBackup = hero1.getLife();
        var hero2LifeBackup = hero2.getLife();
        Card winner = null;
        while(winner == null) {

            int damage = heroCardAdvantageApplierService.apply(hero1, hero2, hero1.getPower());
            damage = heroCardArmorApplierService.apply(hero2, damage);
            hero2 = heroCardLifeRemoverService.remove(hero2, damage);

            if (CardEndFightCheckerService.isEnd(hero1, hero2)) {
                winner = hero1;
                break;
            }

            damage = heroCardAdvantageApplierService.apply(hero2, hero1, hero2.getPower());
            damage = heroCardArmorApplierService.apply(hero1, damage);
            hero1 = heroCardLifeRemoverService.remove(hero1, damage);

            if (CardEndFightCheckerService.isEnd(hero1, hero2)) {
                winner = hero2;
            }
        }
        hero1 = hero1.withLife(hero1LifeBackup);
        hero2 = hero2.withLife(hero2LifeBackup);
        var modifiedHeroCard = heroCardExperienceAdderService.winExp(winner, 1);
        modifiedHeroCard = (CardExperienceCheckerService.canLevelUp(modifiedHeroCard)) ? heroCardLevelAdderService.levelUp(modifiedHeroCard) : modifiedHeroCard;

        return modifiedHeroCard;
    }

    private Card turnOfFight(Card heroAtt, Card heroDef) {
        int damage = heroCardAdvantageApplierService.apply(heroAtt, heroDef, heroAtt.getPower());
        damage = heroCardArmorApplierService.apply(heroDef, damage);
        heroDef = heroCardLifeRemoverService.remove(heroDef, damage);

        if(CardEndFightCheckerService.isEnd(heroAtt, heroDef)) {
            return heroAtt;
        }

        return null;
    }

}
