package esgi.cleancode.domain.functional.service.fight;

import esgi.cleancode.domain.functional.service.card.CardExperienceAdderService;
import esgi.cleancode.domain.functional.service.card.CardLevelAdderService;
import esgi.cleancode.domain.functional.service.card.CardLifeRemoverService;
import esgi.cleancode.domain.functional.service.fight.FightAdvantageApplierService;
import esgi.cleancode.domain.functional.service.fight.FightArmorApplierService;
import esgi.cleancode.domain.functional.service.fight.FightSimulatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FightSimulatorServiceTest {

    @InjectMocks
    private FightSimulatorService service;

    @Mock
    private FightArmorApplierService heroCardApplyArmorService;

    @Mock
    private FightAdvantageApplierService heroCardApplyAdvantageService;

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
