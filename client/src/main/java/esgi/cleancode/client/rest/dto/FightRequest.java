package esgi.cleancode.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record FightRequest(
        @JsonProperty("opponent_account_id") UUID opponent_account_id,
        @JsonProperty("opponent_card_id") UUID opponent_card_id
)  {}
