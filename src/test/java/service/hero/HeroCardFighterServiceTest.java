package service.hero;

import esgi.cleancode.service.hero.HeroCardAdvantageApplierService;
import esgi.cleancode.service.hero.HeroCardArmorApplierService;
import esgi.cleancode.service.hero.HeroCardFighterService;
import esgi.cleancode.service.hero.HeroCardLifeRemoverService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HeroCardFighterServiceTest {

    @InjectMocks
    private HeroCardFighterService service;

    @Mock
    private HeroCardArmorApplierService heroCardApplyArmorService;

    @Mock
    private HeroCardAdvantageApplierService heroCardApplyAdvantageService;

    @Mock
    private HeroCardLifeRemoverService heroCardRemoveLifeService;


}
