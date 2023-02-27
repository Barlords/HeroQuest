package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Card;
import io.vavr.collection.List;
import lombok.val;

import static io.vavr.API.Seq;

public class AccountCardUpdaterService {

    public static Account updateCardInDeck(Account account, Card card) {
        val oldCard = account.getDeck()
                .toJavaStream()
                .filter(c -> c.getId().equals(card.getId()))
                .findAny()
                .orElse(null);

        return account.withDeck(account.getDeck().replace(oldCard, card));
    }

}

