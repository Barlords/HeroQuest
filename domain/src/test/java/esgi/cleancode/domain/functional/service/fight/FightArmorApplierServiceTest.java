package esgi.cleancode.domain.functional.service.fight;

import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.service.fight.FightArmorApplierService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FightArmorApplierServiceTest {

    @InjectMocks
    private FightArmorApplierService service;

    @ParameterizedTest
    @ValueSource(ints = 100)
    void should_reduce_damage(int amount) {
        var given = Card.builder().armor(20).build();

        var actual = service.apply(given, amount);

        Assertions.assertEquals(amount - given.getArmor(), actual);
    }
}
