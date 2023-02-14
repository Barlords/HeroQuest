package esgi.cleancode.domain.functional.service.hero;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.functional.service.validation.HeroValidator;
import esgi.cleancode.domain.ports.client.HeroCreatorApi;
import esgi.cleancode.domain.ports.server.HeroPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class HeroCreatorService implements HeroCreatorApi
{
    private final HeroPersistenceSpi spi;

    @Override
    public Either<ApplicationError, Hero> create(Hero hero) {
        return HeroValidator.validate(hero)
                .toEither()
                .peekLeft(
                        error -> log.error("An error occurred while validating hero : {}", error)
                )
                .flatMap(spi::save);
    }

}
