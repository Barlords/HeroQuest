package esgi.cleancode.domain.functional.service.fight;

import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FightAdvantageApplierServiceTest {

    @ParameterizedTest
    @ValueSource(ints = 100)
    void should_have_advantage(int damage) {
        var givenAtt = Card.builder()
                .name("Kratos")
                .life((int) (Speciality.TANK.getLife() * (1 + Rarity.COMMON.getCoefficient())))
                .power((int) (Speciality.TANK.getPower() * (1 + Rarity.COMMON.getCoefficient())))
                .armor((int) (Speciality.TANK.getArmor() * (1 + Rarity.COMMON.getCoefficient())))
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON).build();

        var givenDef = Card.builder()
                .name("Absol")
                .life((int) (Speciality.MAGE.getLife() * (1 + Rarity.COMMON.getCoefficient())))
                .power((int) (Speciality.MAGE.getPower() * (1 + Rarity.COMMON.getCoefficient())))
                .armor((int) (Speciality.MAGE.getArmor() * (1 + Rarity.COMMON.getCoefficient())))
                .speciality(Speciality.MAGE)
                .rarity(Rarity.COMMON).build();

        int actual = FightAdvantageApplier.apply(givenAtt, givenDef, damage);

        Assertions.assertEquals(damage + Speciality.TANK.getPowerUpAdvantage(), actual);
    }

    @ParameterizedTest
    @ValueSource(ints = 100)
    void should_not_have_advantage(int damage) {
        var givenAtt = Card.builder()
                .name("Absol")
                .life((int) (Speciality.MAGE.getLife() * (1 + Rarity.COMMON.getCoefficient())))
                .power((int) (Speciality.MAGE.getPower() * (1 + Rarity.COMMON.getCoefficient())))
                .armor((int) (Speciality.MAGE.getArmor() * (1 + Rarity.COMMON.getCoefficient())))
                .speciality(Speciality.MAGE)
                .rarity(Rarity.COMMON).build();

        var givenDef = Card.builder()
                .name("Kratos")
                .life((int) (Speciality.TANK.getLife() * (1 + Rarity.COMMON.getCoefficient())))
                .power((int) (Speciality.TANK.getPower() * (1 + Rarity.COMMON.getCoefficient())))
                .armor((int) (Speciality.TANK.getArmor() * (1 + Rarity.COMMON.getCoefficient())))
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON).build();

        int actual = FightAdvantageApplier.apply(givenAtt, givenDef, damage);

        Assertions.assertEquals(damage, actual);
    }

}
