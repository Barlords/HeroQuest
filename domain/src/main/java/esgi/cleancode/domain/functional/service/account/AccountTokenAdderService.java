package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.functional.model.Account;

public class AccountTokenAdderService {

    public static Account addToken(Account account, int amount) {
        return account.withNbToken(account.getNbToken() + amount);
    }

}

