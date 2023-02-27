package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.functional.model.Account;

public class AccountTokenRemoverService {

    public static Account removeToken(Account account, int amount) {
        return account.withNbToken(account.getNbToken() - amount);
    }

}
