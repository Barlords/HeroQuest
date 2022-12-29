package esgi.cleancode.service.playeraccount;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.PlayerAccount;
import esgi.cleancode.exception.InvalidPlayerAccountException;
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
        if (!PlayerAccountValidatorService.isValidAccount(account)) {
            throw new InvalidPlayerAccountException("Account is not valid");
        }
    }
}
