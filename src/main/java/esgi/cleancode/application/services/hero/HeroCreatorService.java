package esgi.cleancode.application.services.hero;

import esgi.cleancode.adapter.out.InMemoryDatabase;
import esgi.cleancode.domain.Hero;
import esgi.cleancode.domain.Rarity;
import esgi.cleancode.domain.Speciality;
import esgi.cleancode.domain.exception.InvalidHeroException;
import esgi.cleancode.application.validation.HeroValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HeroCreatorService
{
    private final InMemoryDatabase database;

    private final HeroIdGeneratorService heroIdGeneratorService;

    public Hero create(String name, Speciality speciality, Rarity rarity)
    {
        var hero = Hero.builder()
                .id(heroIdGeneratorService.generateNewHeroId())
                .name(name)
                .life((int) (speciality.getLife() * (1 + rarity.getCoefficient())))
                .power((int) (speciality.getPower() * (1 + rarity.getCoefficient())))
                .armor((int) (speciality.getArmor() * (1 + rarity.getCoefficient())))
                .speciality(speciality)
                .rarity(rarity)
                .build();

        verifyHeroValidity(hero);
        return database.saveHero(hero);
    }

    private void verifyHeroValidity(Hero hero) {
        if (!HeroValidator.isValidHero(hero)) {
            throw new InvalidHeroException("HeroCard is not valid");
        }
    }
}
