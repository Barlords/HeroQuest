package esgi.cleancode.domain.functional.model;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;
import lombok.With;

import java.util.UUID;

@Value
@Builder
public class Card
{
    @Default
    UUID id = UUID.randomUUID();

    @With @Default
    int experience = 0;

    @With @Default
    int level = 1;

    @With
    int life;

    @With
    int power;

    @With
    int armor;

    String name;

    Speciality speciality;

    Rarity rarity;
}
