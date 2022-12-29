package esgi.cleancode.service;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.domain.Rarity;
import esgi.cleancode.domain.Speciality;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HeroCardCreatorService
{

    private final InMemoryDatabase database;

    public HeroCard create(String name, int life, int power, int armor, Speciality speciality, Rarity rarity)
    {
        var hero = HeroCard.builder()
                .name(name)
                .life(life)
                .power(power)
                .armor(armor)
                .speciality(speciality)
                .rarity(rarity)
                .build();
        return database.saveHeroCard(hero);
    }

}
