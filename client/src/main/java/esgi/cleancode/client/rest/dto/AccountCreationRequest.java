package esgi.cleancode.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountCreationRequest(
        @JsonProperty("pseudo") String pseudo
)  {}
