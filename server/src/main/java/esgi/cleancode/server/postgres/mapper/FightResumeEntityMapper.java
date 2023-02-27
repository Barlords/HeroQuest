package esgi.cleancode.server.postgres.mapper;

import esgi.cleancode.domain.functional.model.FightResult;
import esgi.cleancode.domain.functional.model.FightResume;
import esgi.cleancode.server.postgres.entity.FightResumeEntity;

public interface FightResumeEntityMapper {

    static FightResume toDomain(FightResumeEntity entity) {
        return FightResume.builder()
                .id(entity.getId())
                .fightResult(FightResult.valueOf(entity.getFightResult()))
                .idCardOpponent(entity.getIdCardOpponent())
                .build();
    }

    static FightResumeEntity fromDomain(FightResume domain) {
        System.out.println("Creation FightResumeEntity");
        return FightResumeEntity.builder()
                .id(domain.getId())
                .fightResult(domain.getFightResult().name())
                .idCardOpponent(domain.getIdCardOpponent())
                .build();
    }

}
