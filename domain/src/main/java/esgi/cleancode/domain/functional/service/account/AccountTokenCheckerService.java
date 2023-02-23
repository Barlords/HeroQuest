package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Booster;

public class AccountTokenCheckerService {

    public static boolean haveEnoughToken(Account playerAccount, Booster booster) {
        return (
                booster.getCost() > 0
                && playerAccount.getNbToken() >= booster.getCost()
                );
    }

}
