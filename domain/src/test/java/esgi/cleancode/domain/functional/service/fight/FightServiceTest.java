package esgi.cleancode.domain.functional.service.fight;

import esgi.cleancode.domain.functional.model.Account;
import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import io.vavr.control.Either;
import lombok.val;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static io.vavr.API.*;
import static org.assertj.vavr.api.VavrAssertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FightServiceTest {

    @InjectMocks
    private FightService service;

    @Mock
    private AccountPersistenceSpi accountSpi;

    @Captor
    private ArgumentCaptor<Account> accountCaptor;

    @Test
    void should_do_fight() {

        val card = Card.builder()
                .name("Kratos")
                .life((int) (Speciality.TANK.getLife() * (1 + Rarity.COMMON.getCoefficient())))
                .power((int) (Speciality.TANK.getPower() * (1 + Rarity.COMMON.getCoefficient())))
                .armor((int) (Speciality.TANK.getArmor() * (1 + Rarity.COMMON.getCoefficient())))
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON).build();

        val opponentCard = Card.builder()
                .name("Braum")
                .life((int) (Speciality.TANK.getLife() * (1 + Rarity.COMMON.getCoefficient())))
                .power((int) (Speciality.TANK.getPower() * (1 + Rarity.COMMON.getCoefficient())))
                .armor((int) (Speciality.TANK.getArmor() * (1 + Rarity.COMMON.getCoefficient())))
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON).build();

        val account = Account.builder()
                .pseudo("Barlords")
                .deck(Seq(card))
                .build();

        val opponentAccount = Account.builder()
                .pseudo("Barlords")
                .deck(Seq(opponentCard))
                .build();

        when(accountSpi.findById(account.getId())).thenReturn(Some(account));
        when(accountSpi.findById(opponentAccount.getId())).thenReturn(Some(opponentAccount));
        when(accountSpi.save(any(Account.class))).thenReturn(Right(account));

        val actual = service.fight(
                account.getId(),
                card.getId(),
                opponentAccount.getId(),
                opponentCard.getId());

        assertThat(actual).containsOnRight(account);

        verify(accountSpi).save(accountCaptor.capture());

        Assertions.assertThat(account.getDeck().get(0).getExperience() + 1).isEqualTo(accountCaptor.getValue().getDeck().get(0).getExperience());

    }

}
