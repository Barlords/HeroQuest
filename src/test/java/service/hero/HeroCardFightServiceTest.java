package service.hero;

import esgi.cleancode.service.hero.HeroCardApplyAdvantageService;
import esgi.cleancode.service.hero.HeroCardApplyArmorService;
import esgi.cleancode.service.hero.HeroCardFightService;
import esgi.cleancode.service.hero.HeroCardRemoveLifeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HeroCardFightServiceTest {

    @InjectMocks
    private HeroCardFightService service;

    @Mock
    private HeroCardApplyArmorService heroCardApplyArmorService;

    @Mock
    private HeroCardApplyAdvantageService heroCardApplyAdvantageService;

    @Mock
    private HeroCardRemoveLifeService heroCardRemoveLifeService;


}
