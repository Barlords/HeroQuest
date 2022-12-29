package esgi.cleancode.service.playeraccount;

import esgi.cleancode.domain.PlayerAccount;

public class PlayerAccountValidatorService {

    public static boolean isValidAccount(PlayerAccount given) {
        return (
                null != given.getPseudo()
                && 0 < given.getPseudo().length()
        );
    }

}
