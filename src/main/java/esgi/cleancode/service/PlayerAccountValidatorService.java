package esgi.cleancode.service;

import esgi.cleancode.domain.PlayerAccount;

public class PlayerAccountValidatorService {

    public static boolean isValidHeroCard(PlayerAccount given) {
        return (
                null != given.getPseudo()
                && 0 < given.getPseudo().length()
        );
    }

}
