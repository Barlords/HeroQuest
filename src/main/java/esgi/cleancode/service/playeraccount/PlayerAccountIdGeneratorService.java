package esgi.cleancode.service.playeraccount;

import java.util.UUID;

public class PlayerAccountIdGeneratorService {
    public UUID generateNewPlayerAccountId() {
        return UUID.randomUUID();
    }
}
