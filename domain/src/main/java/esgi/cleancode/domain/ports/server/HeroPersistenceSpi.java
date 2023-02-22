package esgi.cleancode.domain.ports.server;

import esgi.cleancode.domain.functional.model.Hero;
import io.vavr.control.Option;

import java.util.UUID;

public interface HeroPersistenceSpi extends PersistenceSpi<Hero, UUID> {
    @Override
    Option<Hero> findById(UUID uuid);
}
