package application.services.hero_card;

import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.application.services.hero_card.HeroCardArmorApplierService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HeroCardArmorApplierServiceTest {

    @InjectMocks
    private HeroCardArmorApplierService service;

    @ParameterizedTest
    @ValueSource(ints = 100)
    void should_reduce_damage(int amount) {
        var given = HeroCard.builder().armor(20).build();

        var actual = service.apply(given, amount);

        Assertions.assertEquals(amount - given.getArmor(), actual);
    }
}