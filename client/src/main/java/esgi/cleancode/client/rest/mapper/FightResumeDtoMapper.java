package esgi.cleancode.client.rest.mapper;

import esgi.cleancode.client.rest.dto.FightResumeDto;
import esgi.cleancode.client.rest.dto.HeroCreationRequest;
import esgi.cleancode.client.rest.dto.HeroDto;
import esgi.cleancode.domain.functional.model.FightResume;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;

public interface FightResumeDtoMapper {

    static FightResumeDto toDto(FightResume fightResume) {
        return new FightResumeDto(
                fightResume.getId(),
                fightResume.getIdOpponent(),
                fightResume.getFightResult().name()
        );
    }
}
