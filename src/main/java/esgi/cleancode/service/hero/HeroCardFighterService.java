package esgi.cleancode.service.hero;

import esgi.cleancode.domain.HeroCard;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HeroCardFighterService {

    private HeroCardArmorApplierService heroCardApplyArmorService;

    private HeroCardAdvantageApplierService heroCardApplyAdvantageService;

    private HeroCardLifeRemoverService heroCardRemoveLifeService;

    private HeroCardExperienceAdderService heroCardWinExpService;

    private HeroCardLevelAdderService heroCardLevelUpService;

    public HeroCard fight(HeroCard hero1, HeroCard hero2) {
        var hero1LifeBackup = hero1.getLife();
        var hero2LifeBackup = hero2.getLife();
        HeroCard winner = null;
        while(winner == null) {

            int damage = heroCardApplyAdvantageService.apply(hero1, hero2, hero1.getPower());
            damage = heroCardApplyArmorService.apply(hero2, damage);
            hero2 = heroCardRemoveLifeService.remove(hero2, damage);

            if (HeroCardEndFightCheckerService.isEnd(hero1, hero2)) {
                winner = hero1;
                break;
            }

            damage = heroCardApplyAdvantageService.apply(hero2, hero1, hero2.getPower());
            damage = heroCardApplyArmorService.apply(hero1, damage);
            hero1 = heroCardRemoveLifeService.remove(hero1, damage);

            if (HeroCardEndFightCheckerService.isEnd(hero1, hero2)) {
                winner = hero2;
            }
        }
        hero1 = hero1.withLife(hero1LifeBackup);
        hero2 = hero2.withLife(hero2LifeBackup);
        var modifiedHeroCard = heroCardWinExpService.winExp(winner, 1);
        modifiedHeroCard = (HeroCardExperienceCheckerService.canLevelUp(modifiedHeroCard)) ? heroCardLevelUpService.levelUp(modifiedHeroCard) : modifiedHeroCard;

        return modifiedHeroCard;
    }

    private HeroCard turnOfFight(HeroCard heroAtt, HeroCard heroDef) {
        int damage = heroCardApplyAdvantageService.apply(heroAtt, heroDef, heroAtt.getPower());
        damage = heroCardApplyArmorService.apply(heroDef, damage);
        heroDef = heroCardRemoveLifeService.remove(heroDef, damage);

        if(HeroCardEndFightCheckerService.isEnd(heroAtt, heroDef)) {
            return heroAtt;
        }

        return null;
    }

}
