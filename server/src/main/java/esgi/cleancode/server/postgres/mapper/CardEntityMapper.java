package esgi.cleancode.server.postgres.mapper;

import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;
import esgi.cleancode.server.postgres.entity.CardEntity;
import esgi.cleancode.server.postgres.entity.FightResumeEntity;
import io.vavr.collection.List;

public interface CardEntityMapper {

    static Card toDomain(CardEntity entity) {
        return Card.builder()
                .id(entity.getId())
                .name(entity.getName())
                .level(entity.getLevel())
                .experience(entity.getExperience())
                .life(entity.getLife())
                .armor(entity.getArmor())
                .power(entity.getPower())
                .rarity(Rarity.valueOf(entity.getRarity()))
                .speciality(Speciality.valueOf(entity.getSpeciality()))
                .fightHistory(List.ofAll(entity.getFightHistory()).map(FightResumeEntityMapper::toDomain))
                .build();
    }

    static CardEntity fromDomain(Card domain) {
        System.out.println("Creation CardEntity");
        return CardEntity.builder()
               .id(domain.getId())
                .name(domain.getName())
                .level(domain.getLevel())
                .experience(domain.getExperience())
                .life(domain.getLife())
                .armor(domain.getArmor())
                .power(domain.getPower())
                .rarity(domain.getRarity().name())
                .speciality(domain.getSpeciality().name())
                .fightHistory(domain.getFightHistory().map(FightResumeEntityMapper::fromDomain).asJavaMutable())
                .build();
    }

}
