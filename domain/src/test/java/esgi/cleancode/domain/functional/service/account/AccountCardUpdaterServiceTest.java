package esgi.cleancode.domain.functional.service.account;

import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static io.vavr.API.Seq;

@ExtendWith(MockitoExtension.class)
public class AccountCardUpdaterServiceTest {

    @ParameterizedTest
    @ValueSource(ints = 1)
    void should_update_card(int exp) {
        var id = UUID.randomUUID();

        var card = Card.builder()
                .name("Kratos")
                .life((int) (Speciality.TANK.getLife() * (1 + Rarity.COMMON.getCoefficient())))
                .power((int) (Speciality.TANK.getPower() * (1 + Rarity.COMMON.getCoefficient())))
                .armor((int) (Speciality.TANK.getArmor() * (1 + Rarity.COMMON.getCoefficient())))
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON).build();

        var given = Account.builder().id(id).deck(Seq(card)).build();


        var updateCard = card.withExperience(exp);

        var actual = AccountCardUpdaterService.updateCardInDeck(given, updateCard);

        Assertions.assertEquals(given.getDeck().get(0).getId(), actual.getDeck().get(0).getId());
        Assertions.assertEquals(exp, actual.getDeck().get(0).getExperience());
    }
}
