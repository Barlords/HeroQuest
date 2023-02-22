package esgi.cleancode.domain.functional.service.hero;

import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.ports.client.HeroFinderApi;
import esgi.cleancode.domain.ports.server.HeroPersistenceSpi;
import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class HeroFinderService implements HeroFinderApi
{
    private final HeroPersistenceSpi spi;

    @Override
    public List<Hero> findAll() {
        return spi.findAll();
    }

}
