package esgi.cleancode.domain;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Hero {
    UUID id;
    String name;
    int life;
    int power;
    int armor;
    Speciality speciality;
    Rarity rarity;
}
