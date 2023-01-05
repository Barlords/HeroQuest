package esgi.cleancode.application.validation;

import esgi.cleancode.domain.PlayerAccount;

public class PlayerAccountValidator {

    public static boolean isValidAccount(PlayerAccount given) {
        return (
                null != given.getPseudo()
                && 0 < given.getPseudo().length()
        );
    }

}
