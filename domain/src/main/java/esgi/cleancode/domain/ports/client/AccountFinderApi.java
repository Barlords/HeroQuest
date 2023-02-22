package esgi.cleancode.domain.ports.client;

import esgi.cleancode.domain.functional.model.Account;
import io.vavr.collection.List;

public interface AccountFinderApi {

    List<Account> findAll();

}
