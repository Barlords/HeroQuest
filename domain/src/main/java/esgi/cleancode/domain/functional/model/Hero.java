package esgi.cleancode.domain.functional.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Hero {
    UUID id;
    String name;
    Speciality speciality;
    Rarity rarity;
}
