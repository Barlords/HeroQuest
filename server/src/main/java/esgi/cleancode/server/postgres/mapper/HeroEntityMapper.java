package esgi.cleancode.server.postgres.mapper;

import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;
import esgi.cleancode.server.postgres.entity.HeroEntity;
import io.vavr.collection.List;

public interface HeroEntityMapper {

    static Hero toDomain(HeroEntity entity) {
        return Hero.builder()
                .id(entity.getId())
                .name(entity.getName())
                .rarity(Rarity.valueOf(entity.getRarity()))
                .speciality(Speciality.valueOf(entity.getSpeciality()))
                .build();
    }

    static HeroEntity fromDomain(Hero domain) {
        return HeroEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .rarity(domain.getRarity().name())
                .speciality(domain.getSpeciality().name())
                .build();
    }

}
