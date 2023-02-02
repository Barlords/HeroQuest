package esgi.cleancode.client.rest.dto;

import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;

import java.util.UUID;

public record HeroDto(
        UUID id,
        String name,
        Rarity rarity,
        Speciality speciality
) {
}
