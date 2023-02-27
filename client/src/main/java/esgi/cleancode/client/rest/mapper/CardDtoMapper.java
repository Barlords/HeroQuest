package esgi.cleancode.client.rest.mapper;

import esgi.cleancode.client.rest.dto.CardDto;
import esgi.cleancode.domain.functional.model.Card;

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

}
