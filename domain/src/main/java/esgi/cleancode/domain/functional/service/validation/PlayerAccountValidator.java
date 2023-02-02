package esgi.cleancode.domain.functional.service.validation;

import esgi.cleancode.domain.functional.model.PlayerAccount;

public class PlayerAccountValidator {

    public static boolean isValidAccount(PlayerAccount given) {
        return (
                null != given.getPseudo()
                && 0 < given.getPseudo().length()
        );
    }

}
