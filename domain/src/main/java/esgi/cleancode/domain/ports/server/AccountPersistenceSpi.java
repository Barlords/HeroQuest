package esgi.cleancode.domain.ports.server;

import esgi.cleancode.domain.functional.model.Account;

import java.util.UUID;

public interface AccountPersistenceSpi extends PersistenceSpi<Account, UUID> {

}
