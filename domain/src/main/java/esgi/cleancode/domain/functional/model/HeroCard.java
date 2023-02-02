package esgi.cleancode.domain.functional.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.UUID;

@Value
@Builder
public class HeroCard
{
    UUID id;

    String name;

    @With
    int life;

    @Builder.Default
    @With
    int experience = 0;

    @With
    int power;

    @With
    int armor;

    Speciality speciality;

    Rarity rarity;

    @Builder.Default
    @With
    int level = 1;
}
