package esgi.cleancode.domain.functional.model;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Hero {
    @Default
    UUID id = UUID.randomUUID();
    String name;
    Speciality speciality;
    Rarity rarity;
}
