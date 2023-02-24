package esgi.cleancode.domain.functional.service.booster;

import esgi.cleancode.domain.functional.model.Booster;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;
import esgi.cleancode.domain.ports.server.HeroPersistenceSpi;
import io.vavr.collection.List;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BoosterCardGeneratorServiceTest {

    @InjectMocks private BoosterCardGeneratorService service;

    @Mock private HeroPersistenceSpi heroSpi;

    @Test
    void should_generate_card() {

        val hero = Hero.builder()
                .name("Kratos")
                .speciality(Speciality.TANK)
                .rarity(Rarity.COMMON)
                .build();

        when(heroSpi.findByRarityAndSpeciality(any(String.class), any(String.class))).thenReturn(List.of(hero));

        val actual = service.generateCard(Booster.SILVER);
        org.junit.jupiter.api.Assertions.assertEquals(hero.getName(), actual.getName());
        org.junit.jupiter.api.Assertions.assertEquals(hero.getRarity(), actual.getRarity());
        org.junit.jupiter.api.Assertions.assertEquals(hero.getSpeciality(), actual.getSpeciality());
        org.junit.jupiter.api.Assertions.assertEquals(0, actual.getExperience());
        org.junit.jupiter.api.Assertions.assertEquals(1, actual.getLevel());
        org.junit.jupiter.api.Assertions.assertEquals(hero.getSpeciality(), actual.getSpeciality());
        org.junit.jupiter.api.Assertions.assertEquals(
                hero.getSpeciality().getLife() * hero.getRarity().getCoefficient(),
                actual.getLife()
        );
        org.junit.jupiter.api.Assertions.assertEquals(
                hero.getSpeciality().getPower() * hero.getRarity().getCoefficient(),
                actual.getPower()
        );
        Assertions.assertEquals(
                hero.getSpeciality().getArmor() * hero.getRarity().getCoefficient(),
                actual.getArmor()
        );
    }

}
