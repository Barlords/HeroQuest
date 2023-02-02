package esgi.cleancode.domain.functional.service.player_account;

import java.util.UUID;

public class PlayerAccountIdGeneratorService {
    public UUID generateNewPlayerAccountId() {
        return UUID.randomUUID();
    }
}
