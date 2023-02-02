package esgi.cleancode.domain.functional.service.hero_card;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HeroCardFightSimulatorServiceTest {

    @InjectMocks
    private HeroCardFightSimulatorService service;

    @Mock
    private HeroCardArmorApplierService heroCardApplyArmorService;

    @Mock
    private HeroCardAdvantageApplierService heroCardApplyAdvantageService;

    @Mock
    private HeroCardLifeRemoverService heroCardRemoveLifeService;

    @Mock
    private HeroCardExperienceAdderService heroCardExperienceAdderService;

    @Mock
    private HeroCardLevelAdderService heroCardLevelAdderService;

    @Test
    void should_do_fight() {



    }

}
