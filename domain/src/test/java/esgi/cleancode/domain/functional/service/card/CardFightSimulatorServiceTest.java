package esgi.cleancode.domain.functional.service.card;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CardFightSimulatorServiceTest {

    @InjectMocks
    private CardFightSimulatorService service;

    @Mock
    private CardArmorApplierService heroCardApplyArmorService;

    @Mock
    private CardAdvantageApplierService heroCardApplyAdvantageService;

    @Mock
    private CardLifeRemoverService heroCardRemoveLifeService;

    @Mock
    private CardExperienceAdderService heroCardExperienceAdderService;

    @Mock
    private CardLevelAdderService heroCardLevelAdderService;

    @Test
    void should_do_fight() {



    }

}
