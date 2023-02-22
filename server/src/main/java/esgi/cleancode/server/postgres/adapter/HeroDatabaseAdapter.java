package esgi.cleancode.server.postgres.adapter;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.ports.server.HeroPersistenceSpi;
import esgi.cleancode.server.postgres.mapper.HeroEntityMapper;
import esgi.cleancode.server.postgres.repository.HeroRepository;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

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

    @Transactional
    @Override
    public List<Hero> findAll() {
        return repository.findAll()
                .stream()
                .map(HeroEntityMapper::toDomain)
                .collect(List.collector());
    }

    @Transactional
    @Override
    public List<Hero> findByRarityAndSpeciality(String rarity, String speciality) {
        return repository.findHeroEntitiesByRarityAndSpeciality(rarity, speciality)
                .stream()
                .map(HeroEntityMapper::toDomain)
                .collect(List.collector());
    }


}