package esgi.cleancode.server.postgres.adapter;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.ports.server.HeroPersistenceSpi;
import esgi.cleancode.server.postgres.mapper.HeroEntityMapper;
import esgi.cleancode.server.postgres.repository.HeroRepository;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static esgi.cleancode.server.postgres.mapper.HeroEntityMapper.fromDomain;
import static io.vavr.API.Try;

@Service
@RequiredArgsConstructor
@Transactional
public class HeroDatabaseAdapter implements HeroPersistenceSpi {

    @Autowired
    private final HeroRepository repository;

    @Override
    public Either<ApplicationError, Hero> save(Hero o) {
        val entity = fromDomain(o);
        return Try(() -> repository.save(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save hero", null, o, throwable))
                .map(HeroEntityMapper::toDomain);
    }

    @Override
    public Optional<Hero> findById(Long id) {
        return repository.findById(id).map(HeroEntityMapper::toDomain);
    }
}