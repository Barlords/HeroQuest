package esgi.cleancode.domain.ports.client;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Hero;
import io.vavr.control.Either;

public interface HeroCreatorApi {

    Either<ApplicationError, Hero> create(Hero hero);

}
