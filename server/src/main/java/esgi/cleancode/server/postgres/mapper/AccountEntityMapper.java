package esgi.cleancode.server.postgres.mapper;

import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.server.postgres.entity.AccountEntity;
import io.vavr.collection.List;

public interface AccountEntityMapper {

    static Account toDomain(AccountEntity entity) {
        return Account.builder()
                .id(entity.getId())
                .pseudo(entity.getPseudo())
                .deck(List.ofAll(entity.getDeck()).map(CardEntityMapper::toDomain))
                .nbToken(entity.getNbToken())
                .build();
    }

    static AccountEntity fromDomain(Account domain) {
        System.out.println("Creation AccountEntity");
        return AccountEntity.builder()
                .id(domain.getId())
                .pseudo(domain.getPseudo())
                .deck(domain.getDeck().map(CardEntityMapper::fromDomain).asJavaMutable())
                .nbToken(domain.getNbToken())
                .build();
    }

}
