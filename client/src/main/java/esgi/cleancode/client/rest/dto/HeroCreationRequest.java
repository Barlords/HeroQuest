package esgi.cleancode.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;

public record HeroCreationRequest(
        @JsonProperty("name") String name,
        @JsonProperty("speciality") String speciality,
        @JsonProperty("rarity") String rarity
)  {}
