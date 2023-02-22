package esgi.cleancode.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record CardAppendRequest(
        @JsonProperty("account_id") UUID account_id,
        @JsonProperty("hero_id") UUID hero_id
)  {}
