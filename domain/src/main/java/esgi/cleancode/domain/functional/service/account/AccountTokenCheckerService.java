package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.functional.model.Account;

public class AccountTokenCheckerService {

    public static boolean haveEnoughtToken(Account playerAccount, int nbTokenExpected) {
        return (
                nbTokenExpected > 0
                && playerAccount.getNbToken() >= nbTokenExpected
                );
    }

}
