package esgi.cleancode.client.rest.mapper;

import esgi.cleancode.client.rest.dto.CardAppendRequest;
import esgi.cleancode.client.rest.dto.CardDto;
import esgi.cleancode.client.rest.dto.HeroCreationRequest;
import esgi.cleancode.client.rest.dto.HeroDto;
import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;

public interface CardDtoMapper {

    static CardDto toDto(Card card) {
        return new CardDto(
                card.getId(),
                card.getExperience(),
                card.getLevel(),
                card.getLife(),
                card.getPower(),
                card.getArmor(),
                card.getName(),
                card.getSpeciality().name(),
                card.getRarity().name(),
                card.getFightHistory().map(FightResumeDtoMapper::toDto)
        );
    }
/*
    static Card heroCreationToDomain(CardAppendRequest request) {
        return Card.builder()
                .name(request.name())
                .rarity(Rarity.valueOf(request.rarity()))
                .speciality(Speciality.valueOf(request.speciality()))
                .build();
    }
*/
}
