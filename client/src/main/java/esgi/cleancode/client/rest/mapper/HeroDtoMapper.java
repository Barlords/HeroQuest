package esgi.cleancode.client.rest.mapper;

import esgi.cleancode.client.rest.dto.HeroCreationRequest;
import esgi.cleancode.client.rest.dto.HeroDto;
import esgi.cleancode.domain.functional.model.Hero;

public interface HeroDtoMapper {

    static HeroDto toDto(Hero hero) {
        return new HeroDto(
                hero.getId(),
                hero.getName(),
                hero.getRarity(),
                hero.getSpeciality());
    }

    static Hero heroCreationToDomain(HeroCreationRequest request) {
        return Hero.builder().name(request.name()).rarity(request.rarity()).speciality(request.speciality()).build();
    }

}
