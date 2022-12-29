package esgi.cleancode.domain;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class HeroCard
{
    UUID id;
    String name;
    int life;
    @Builder.Default
    int experience = 0;
    int power;
    int armor;
    Speciality speciality;
    Rarity rarity;
    @Builder.Default
    int level = 1;
}
