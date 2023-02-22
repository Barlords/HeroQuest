package esgi.cleancode.client.rest.mapper;

import esgi.cleancode.client.rest.dto.AccountCreationRequest;
import esgi.cleancode.client.rest.dto.AccountDto;
import esgi.cleancode.domain.functional.model.Account;

public interface AccountDtoMapper {

    static AccountDto toDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getPseudo(),
                account.getNbToken(),
                account.getDeck().map(CardDtoMapper::toDto));
    }

    static Account accountCreationToDomain(AccountCreationRequest request) {
        return Account.builder()
                .pseudo(request.pseudo())
                .build();
    }

}
