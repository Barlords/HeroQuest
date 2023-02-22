package esgi.cleancode.client.rest.mapper;

import esgi.cleancode.client.rest.dto.HeroCreationRequest;
import esgi.cleancode.client.rest.dto.HeroDto;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;

public interface HeroDtoMapper {

    static HeroDto toDto(Hero hero) {
        return new HeroDto(
                hero.getId(),
                hero.getName(),
                hero.getRarity().name(),
                hero.getSpeciality().name());
    }

    static Hero heroCreationToDomain(HeroCreationRequest request) {
        return Hero.builder()
                .name(request.name())
                .rarity(Rarity.valueOf(request.rarity()))
                .speciality(Speciality.valueOf(request.speciality()))
                .build();
    }

}
