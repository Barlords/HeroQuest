package esgi.cleancode.server.postgres.adapter;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.ports.server.HeroPersistenceSpi;
import esgi.cleancode.server.postgres.entity.HeroEntity;
import esgi.cleancode.server.postgres.mapper.HeroEntityMapper;
import esgi.cleancode.server.postgres.repository.HeroRepository;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

@Slf4j
@Service
@RequiredArgsConstructor
public class HeroDatabaseAdapter implements HeroPersistenceSpi {

    private final HeroRepository repository;

    @Transactional
    @Override
    public Either<ApplicationError, Hero> save(Hero o) {
        val entity = HeroEntityMapper.fromDomain(o);
        return Try(() -> repository.save(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save hero", null, o, throwable))
                .map(HeroEntityMapper::toDomain);
    }

    @Transactional
    @Override
    public Option<Hero> findById(UUID id) {
        return repository.findHeroEntityById(id).map(HeroEntityMapper::toDomain);
    }
/*
    @Transactional
    public Option<List<Hero>> findByRarityAndSpeciality(String rarity, String speciality) {
        return repository.findHeroEntitiesByRarityAndSpeciality(rarity, speciality)
                .onEmpty(() -> log.error("Unable to find account with rarity {} and speciality {}", rarity, speciality))
                .fold(
                        () -> null,
                        heroEntities -> convertToHeros(heroEntities)
                );
    }
*/

}