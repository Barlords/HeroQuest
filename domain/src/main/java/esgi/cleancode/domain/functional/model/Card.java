package esgi.cleancode.domain.functional.model;

import io.vavr.collection.Seq;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;
import lombok.With;

import static io.vavr.API.Seq;


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

    @With @Default
    Seq<FightResume> fightHistory = Seq();

    String name;

    Speciality speciality;

    Rarity rarity;

}
