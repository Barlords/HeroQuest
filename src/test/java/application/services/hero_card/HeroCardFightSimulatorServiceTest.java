package application.services.hero_card;

import esgi.cleancode.application.services.hero_card.HeroCardAdvantageApplierService;
import esgi.cleancode.application.services.hero_card.HeroCardArmorApplierService;
import esgi.cleancode.application.services.hero_card.HeroCardFightSimulatorService;
import esgi.cleancode.application.services.hero_card.HeroCardLifeRemoverService;
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


}
