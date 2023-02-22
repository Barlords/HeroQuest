package esgi.cleancode.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.vavr.collection.Seq;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record AccountDto(
        UUID id,
        String pseudo,
        int nbToken,
        Seq<CardDto> deck
) {
}
