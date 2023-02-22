package esgi.cleancode.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record BoosterOpeningRequest(
        @JsonProperty("account_id") UUID account_id,
        @JsonProperty("booster") String booster
) {
}
