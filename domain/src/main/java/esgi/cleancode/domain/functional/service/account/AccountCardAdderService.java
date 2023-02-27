package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Card;

public class AccountCardAdderService {

    public static Account addCard(Account account, Card card) {
        return account.withDeck(account.getDeck().append(card));
    }

}

