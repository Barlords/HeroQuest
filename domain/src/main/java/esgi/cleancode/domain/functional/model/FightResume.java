package esgi.cleancode.domain.functional.model;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class FightResume
{
    @Default
    UUID id = UUID.randomUUID();

    UUID idCardOpponent;

    FightResult fightResult;
}
