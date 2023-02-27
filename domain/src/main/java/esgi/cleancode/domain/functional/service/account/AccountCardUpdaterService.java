package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Card;
import lombok.val;

public class AccountCardUpdaterService {

    public static Account updateCardInDeck(Account account, Card card) {
        val oldCard = account.getDeck()
                .filter(filteredCard -> filteredCard.getId() == card.getId())
                .get(0);

        val deck = account.getDeck();

        val index = deck.indexOf(oldCard);

        deck.drop(index);

        deck.append(card);

        return account.withDeck(deck);
    }

}

