package esgi.cleancode.application.services.hero_card;

import esgi.cleancode.domain.HeroCard;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HeroCardFightSimulatorService {

    private final HeroCardArmorApplierService heroCardArmorApplierService;

    private final HeroCardAdvantageApplierService heroCardAdvantageApplierService;

    private final HeroCardLifeRemoverService heroCardLifeRemoverService;

    private final HeroCardExperienceAdderService heroCardExperienceAdderService;

    private final HeroCardLevelAdderService heroCardLevelAdderService;

    public HeroCard fight(HeroCard hero1, HeroCard hero2) {
        var hero1LifeBackup = hero1.getLife();
        var hero2LifeBackup = hero2.getLife();
        HeroCard winner = null;
        while(winner == null) {

            int damage = heroCardAdvantageApplierService.apply(hero1, hero2, hero1.getPower());
            damage = heroCardArmorApplierService.apply(hero2, damage);
            hero2 = heroCardLifeRemoverService.remove(hero2, damage);

            if (HeroCardEndFightCheckerService.isEnd(hero1, hero2)) {
                winner = hero1;
                break;
            }

            damage = heroCardAdvantageApplierService.apply(hero2, hero1, hero2.getPower());
            damage = heroCardArmorApplierService.apply(hero1, damage);
            hero1 = heroCardLifeRemoverService.remove(hero1, damage);

            if (HeroCardEndFightCheckerService.isEnd(hero1, hero2)) {
                winner = hero2;
            }
        }
        hero1 = hero1.withLife(hero1LifeBackup);
        hero2 = hero2.withLife(hero2LifeBackup);
        var modifiedHeroCard = heroCardExperienceAdderService.winExp(winner, 1);
        modifiedHeroCard = (HeroCardExperienceCheckerService.canLevelUp(modifiedHeroCard)) ? heroCardLevelAdderService.levelUp(modifiedHeroCard) : modifiedHeroCard;

        return modifiedHeroCard;
    }

    private HeroCard turnOfFight(HeroCard heroAtt, HeroCard heroDef) {
        int damage = heroCardAdvantageApplierService.apply(heroAtt, heroDef, heroAtt.getPower());
        damage = heroCardArmorApplierService.apply(heroDef, damage);
        heroDef = heroCardLifeRemoverService.remove(heroDef, damage);

        if(HeroCardEndFightCheckerService.isEnd(heroAtt, heroDef)) {
            return heroAtt;
        }

        return null;
    }

}
