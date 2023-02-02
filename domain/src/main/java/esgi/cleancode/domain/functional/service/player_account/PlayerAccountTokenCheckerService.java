package esgi.cleancode.domain.functional.service.player_account;

import esgi.cleancode.domain.functional.model.PlayerAccount;

public class PlayerAccountTokenCheckerService {

    public static boolean haveEnoughtToken(PlayerAccount playerAccount, int nbTokenExpected) {
        return (
                nbTokenExpected > 0
                && playerAccount.getNbToken() >= nbTokenExpected
                );
    }

}
