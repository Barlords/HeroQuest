package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.ports.client.AccountFinderApi;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AccountFinderService implements AccountFinderApi
{
    private final AccountPersistenceSpi spi;

    @Override
    public List<Account> findAll() {
        return spi.findAll();
    }

}
