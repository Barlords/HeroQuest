package esgi.cleancode.domain.functional.service.fight;

import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.service.account.AccountCardUpdaterService;
import esgi.cleancode.domain.functional.service.account.AccountTokenAdderService;
import esgi.cleancode.domain.functional.service.card.CardExperienceAdderService;
import esgi.cleancode.domain.functional.service.card.CardExperienceCheckerService;
import esgi.cleancode.domain.functional.service.card.CardLevelAdderService;

public class FightWinnerApplierService {

    public static Account apply(Account account, Card card, int experience) {

        var upgradeCard = CardExperienceAdderService.addExperience(card, experience);

        if (CardExperienceCheckerService.canLevelUp(upgradeCard)) {
            upgradeCard = CardLevelAdderService.levelUp(upgradeCard);
            account = AccountTokenAdderService.addToken(account, 1);
        }

        account = AccountCardUpdaterService.updateCardInDeck(account, upgradeCard);

        return account;
    }
}
