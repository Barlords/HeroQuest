package esgi.cleancode.domain;

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
    int life;
    @Builder.Default
    @With
    int experience = 0;
    int power;
    int armor;
    Speciality speciality;
    Rarity rarity;
    @Builder.Default
    int level = 1;
}
