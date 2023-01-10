package esgi.cleancode.application.services.player_account;

import esgi.cleancode.domain.PlayerAccount;

public class PlayerAccountTokenCheckerService {

    public static boolean haveEnoughtToken(PlayerAccount playerAccount, int nbTokenExpected) {
        return (
                nbTokenExpected > 0
                && playerAccount.getNbToken() >= nbTokenExpected
                );
    }

}
