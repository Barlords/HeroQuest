package esgi.cleancode.domain.ports.client;

import esgi.cleancode.domain.functional.model.Hero;
import io.vavr.collection.List;

public interface HeroFinderApi {

    List<Hero> findAll();

}
