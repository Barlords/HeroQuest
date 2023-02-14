package esgi.cleancode.client.rest.dto;

import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;

public record HeroDto(
        Long id,
        String name,
        Rarity rarity,
        Speciality speciality
) {
}
