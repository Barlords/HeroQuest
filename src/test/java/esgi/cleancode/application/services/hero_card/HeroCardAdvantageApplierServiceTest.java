package esgi.cleancode.application.services.hero_card;

import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.Rarity;
import esgi.cleancode.domain.Speciality;
import esgi.cleancode.application.services.hero_card.HeroCardAdvantageApplierService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HeroCardAdvantageApplierServiceTest {

    @InjectMocks
    private HeroCardAdvantageApplierService service;

    @ParameterizedTest
    @ValueSource(ints = 100)
    void should_have_advantage(int damage) {
        var givenAtt = HeroCard.builder()
                .name("Kratos")
                .life((int) (Speciality.TANK.getLife() * (1 + Rarity.COMMON.getCoefficient())))
                .power((int) (Speciality.TANK.getPower() * (1 + Rarity.COMMON.getCoefficient())))
                .armor((int) (Speciality.TANK.getArmor() * (1 + Rarity.COMMON.getCoefficient())))
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON).build();

        var givenDef = HeroCard.builder()
                .name("Absol")
                .life((int) (Speciality.MAGE.getLife() * (1 + Rarity.COMMON.getCoefficient())))
                .power((int) (Speciality.MAGE.getPower() * (1 + Rarity.COMMON.getCoefficient())))
                .armor((int) (Speciality.MAGE.getArmor() * (1 + Rarity.COMMON.getCoefficient())))
                .speciality(Speciality.MAGE)
                .rarity(Rarity.COMMON).build();

        int actual = service.apply(givenAtt, givenDef, damage);

        Assertions.assertEquals(damage + Speciality.TANK.getPowerUpAdvantage(), actual);
    }

    @ParameterizedTest
    @ValueSource(ints = 100)
    void should_not_have_advantage(int damage) {
        var givenAtt = HeroCard.builder()
                .name("Absol")
                .life((int) (Speciality.MAGE.getLife() * (1 + Rarity.COMMON.getCoefficient())))
                .power((int) (Speciality.MAGE.getPower() * (1 + Rarity.COMMON.getCoefficient())))
                .armor((int) (Speciality.MAGE.getArmor() * (1 + Rarity.COMMON.getCoefficient())))
                .speciality(Speciality.MAGE)
                .rarity(Rarity.COMMON).build();

        var givenDef = HeroCard.builder()
                .name("Kratos")
                .life((int) (Speciality.TANK.getLife() * (1 + Rarity.COMMON.getCoefficient())))
                .power((int) (Speciality.TANK.getPower() * (1 + Rarity.COMMON.getCoefficient())))
                .armor((int) (Speciality.TANK.getArmor() * (1 + Rarity.COMMON.getCoefficient())))
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON).build();

        int actual = service.apply(givenAtt, givenDef, damage);

        Assertions.assertEquals(damage, actual);
    }

}
