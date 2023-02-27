package esgi.cleancode.client.rest.mapper;

import esgi.cleancode.client.rest.dto.FightResumeDto;
import esgi.cleancode.domain.functional.model.FightResume;

public interface FightResumeDtoMapper {

    static FightResumeDto toDto(FightResume fightResume) {
        return new FightResumeDto(
                fightResume.getId(),
                fightResume.getIdOpponent(),
                fightResume.getFightResult().name()
        );
    }
}
