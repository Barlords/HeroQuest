package esgi.cleancode.domain.functional.model;

import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class Hero {
    Long id;
    String name;
    Speciality speciality;
    Rarity rarity;
}
