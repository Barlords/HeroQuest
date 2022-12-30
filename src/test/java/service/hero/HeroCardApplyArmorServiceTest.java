package service.hero;

import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.service.hero.HeroCardApplyArmorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HeroCardApplyArmorServiceTest {

    @InjectMocks
    private HeroCardApplyArmorService service;

    @ParameterizedTest
    @ValueSource(ints = 100)
    void should_reduce_damage(int amount) {
        var given = HeroCard.builder().armor(20).build();

        var actual = service.apply(given, amount);

        Assertions.assertEquals(amount - given.getArmor(), actual);
    }
}
