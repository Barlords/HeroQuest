package esgi.cleancode.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.vavr.collection.Seq;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record CardDto(
        UUID id,
        int experience,
        int level,
        int life,
        int power,
        int armor,
        String name,
        String speciality,
        String rarity,
        Seq<FightResumeDto> fightHistory
) {
}
