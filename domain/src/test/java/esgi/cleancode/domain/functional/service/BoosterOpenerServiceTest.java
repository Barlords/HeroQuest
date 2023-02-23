package esgi.cleancode.domain.functional.service;

import esgi.cleancode.domain.functional.model.*;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import esgi.cleancode.domain.ports.server.HeroPersistenceSpi;
import io.vavr.collection.List;
import lombok.val;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static io.vavr.API.*;
import static org.assertj.vavr.api.VavrAssertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BoosterOpenerServiceTest {

    @InjectMocks private BoosterOpenerService service;

    @Mock private AccountPersistenceSpi accountSpi;

    @Mock private HeroPersistenceSpi heroSpi;

    @Captor
    private ArgumentCaptor<Account> accountCaptor;

    @ParameterizedTest
    @CsvSource({"1,3,0", "4,3,3"})
    void should_open_silver_booster_append_card_and_save_account(
            int currentNbToken, int expectedSizeOfDeck, int expectedNbToken
    ) {
        val account = Account.builder()
                .pseudo("Barlords")
                .nbToken(currentNbToken)
                .build();

        val hero = Hero.builder()
                .name("Kratos")
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON)
                .build();

        when(accountSpi.findById(account.getId())).thenReturn(Some(account));
        when(heroSpi.findByRarityAndSpeciality(any(String.class), any(String.class))).thenReturn(List.of(hero));
        when(accountSpi.save(any(Account.class))).thenReturn(Right(account));

        val actual = service.openBooster(account.getId(), Booster.SILVER);

        assertThat(actual).containsOnRight(account);

        verify(accountSpi).save(accountCaptor.capture());
        Assertions.assertThat(accountCaptor.getValue().getDeck().size()).isEqualTo(expectedSizeOfDeck);
        Assertions.assertThat(accountCaptor.getValue().getNbToken()).isEqualTo(expectedNbToken);
    }

    @ParameterizedTest
    @CsvSource({"2,5,0", "5,5,3"})
    void should_open_diamond_booster_append_card_and_save_account(
            int currentNbToken, int expectedSizeOfDeck, int expectedNbToken
    ) {
        val account = Account.builder()
                .pseudo("Barlords")
                .nbToken(currentNbToken)
                .build();

        val hero = Hero.builder()
                .name("Kratos")
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON)
                .build();

        when(accountSpi.findById(account.getId())).thenReturn(Some(account));
        when(heroSpi.findByRarityAndSpeciality(any(String.class), any(String.class))).thenReturn(List.of(hero));
        when(accountSpi.save(any(Account.class))).thenReturn(Right(account));

        val actual = service.openBooster(account.getId(), Booster.DIAMOND);

        assertThat(actual).containsOnRight(account);

        verify(accountSpi).save(accountCaptor.capture());
        Assertions.assertThat(accountCaptor.getValue().getDeck().size()).isEqualTo(expectedSizeOfDeck);
        Assertions.assertThat(accountCaptor.getValue().getNbToken()).isEqualTo(expectedNbToken);
    }
/*

  @ParameterizedTest
  @CsvSource({"1,12,11", "6,1,0"})
  void should_append_offence_calculate_points_and_update(
      int pointsToWithdraw, int currentLicencePoints, int expectedPoints) {

    val offence =
        TrafficOffence.builder().label("label").pointsToWithdraw(pointsToWithdraw).build();

    val licence = DrivingLicence.builder().availablePoints(currentLicencePoints).build();
    val licenceId = licence.getId();

    when(spi.findById(licenceId)).thenReturn(Some(licence));
    when(spi.save(any(DrivingLicence.class))).thenReturn(Right(licence));

    val actual = service.appendOffence(licenceId, offence);

    assertThat(actual).containsOnRight(licence);

    verify(spi).save(licenceCaptor.capture());
    Assertions.assertThat(licenceCaptor.getValue())
        .usingRecursiveComparison()
        .isEqualTo(
            DrivingLicence.builder()
                .id(licenceId)
                .offences(Seq(offence))
                .availablePoints(expectedPoints)
                .build());
  }

  @Test
  void should_not_append_if_no_driving_licence_found() {
    val offence = TrafficOffence.builder().label("label").pointsToWithdraw(1).build();
    val licence = DrivingLicence.builder().build();
    val licenceId = licence.getId();

    when(spi.findById(licenceId)).thenReturn(None());

    val actual = service.appendOffence(licenceId, offence);
    assertThat(actual).containsLeftInstanceOf(ApplicationError.class);
    verifyNoMoreInteractions(spi);
  }

  @Test
  void should_not_append_if_offence_is_invalid() {
    val licence = DrivingLicence.builder().build();
    val licenceId = licence.getId();

    when(spi.findById(licenceId)).thenReturn(None());

    val actual = service.appendOffence(licenceId, null);
    assertThat(actual).containsLeftInstanceOf(ApplicationError.class);
    verifyNoMoreInteractions(spi);
  }

  @Test
  void should_not_append_if_technical_error_occurred_in_adapter() {
    val offence = TrafficOffence.builder().label("label").pointsToWithdraw(1).build();
    val licence = DrivingLicence.builder().availablePoints(12).build();
    val licenceId = licence.getId();
    val error = new ApplicationError(null, null, null, null);

    when(spi.findById(licenceId)).thenReturn(Some(licence));
    when(spi.save(any(DrivingLicence.class))).thenReturn(Left(error));

    val actual = service.appendOffence(licenceId, offence);

    verify(spi).save(licenceCaptor.capture());

    assertThat(actual).containsLeftSame(error);
    Assertions.assertThat(licenceCaptor.getValue())
        .usingRecursiveComparison()
        .isEqualTo(
            DrivingLicence.builder()
                .id(licenceId)
                .offences(Seq(offence))
                .availablePoints(11)
                .build());
  }


 */
}
