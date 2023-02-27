package esgi.cleancode.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record HeroDto(
        UUID id,
        String name,
        String rarity,
        String speciality
) {
}
