package esgi.cleancode.client.rest.dto;

import java.util.UUID;

public record CardDto(
        UUID id,
        int experience,
        int level,
        int life,
        int power,
        int armor,
        String name,
        String speciality,
        String rarity
) {
}
