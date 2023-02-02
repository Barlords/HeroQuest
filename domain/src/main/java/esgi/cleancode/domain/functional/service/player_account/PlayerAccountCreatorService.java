package esgi.cleancode.domain.functional.service.player_account;

import esgi.cleancode.domain.db.InMemoryDatabase;
import esgi.cleancode.domain.functional.model.PlayerAccount;
import esgi.cleancode.domain.exception.InvalidPlayerAccountException;
import esgi.cleancode.domain.functional.service.validation.PlayerAccountValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlayerAccountCreatorService {

    private final InMemoryDatabase database;

    public PlayerAccount create(String pseudo) {
        var playerAccount = PlayerAccount.builder().pseudo(pseudo).build();
        verifyAccountValidity(playerAccount);
        return database.savePlayerAccount(playerAccount);
    }

    private void verifyAccountValidity(PlayerAccount account) {
        if (!PlayerAccountValidator.isValidAccount(account)) {
            throw new InvalidPlayerAccountException("Account is not valid");
        }
    }
}
