package esgi.cleancode.service.hero;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.Rarity;
import esgi.cleancode.domain.Speciality;
import esgi.cleancode.exception.InvalidHeroCardException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HeroCardCreatorService
{

    private final InMemoryDatabase database;

    public HeroCard create(String name, Speciality speciality, Rarity rarity)
    {
        var hero = HeroCard.builder()
                .name(name)
                .life((int) (speciality.getLife() * (1 + rarity.getCoefficient())))
                .power((int) (speciality.getPower() * (1 + rarity.getCoefficient())))
                .armor((int) (speciality.getArmor() * (1 + rarity.getCoefficient())))
                .speciality(speciality)
                .rarity(rarity)
                .build();

        verifyHeroValidity(hero);
        return database.saveHeroCard(hero);
    }

    private void verifyHeroValidity(HeroCard hero) {
        if (!HeroCardValidatorService.isValidHeroCard(hero)) {
            throw new InvalidHeroCardException("HeroCard is not valid");
        }
    }
}
