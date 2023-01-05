package esgi.cleancode.application.services.player_account;

import esgi.cleancode.adapter.out.InMemoryDatabase;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.domain.exception.InvalidPlayerAccountException;
import esgi.cleancode.application.validation.PlayerAccountValidator;
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
