package esgi.cleancode.domain.functional.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BoosterOpenerServiceTest {
/*
  @InjectMocks private BoosterOpenerService service;

  @Mock private AccountPersistenceSpi spi;

  @Captor private ArgumentCaptor<Account> accountCaptor;

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
