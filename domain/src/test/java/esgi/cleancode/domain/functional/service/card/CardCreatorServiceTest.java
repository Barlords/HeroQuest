package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardCreatorServiceTest
{
    @Test
    void should_create_card() {
        val hero = Hero.builder()
                .name("Kratos")
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON)
                .build();

        val actual = CardCreatorService.create(hero);
        Assertions.assertEquals(hero.getName(), actual.getName());
        Assertions.assertEquals(hero.getRarity(), actual.getRarity());
        Assertions.assertEquals(hero.getSpeciality(), actual.getSpeciality());
        Assertions.assertEquals(0, actual.getExperience());
        Assertions.assertEquals(1, actual.getLevel());
        Assertions.assertEquals(hero.getSpeciality(), actual.getSpeciality());
        Assertions.assertEquals(
                hero.getSpeciality().getLife() * hero.getRarity().getCoefficient(),
                actual.getLife()
        );
        Assertions.assertEquals(
                hero.getSpeciality().getPower() * hero.getRarity().getCoefficient(),
                actual.getPower()
        );
        Assertions.assertEquals(
                hero.getSpeciality().getArmor() * hero.getRarity().getCoefficient(),
                actual.getArmor()
        );
    }

}
