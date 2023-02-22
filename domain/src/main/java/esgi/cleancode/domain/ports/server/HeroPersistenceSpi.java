package esgi.cleancode.domain.ports.server;

import esgi.cleancode.domain.functional.model.Hero;
import io.vavr.collection.List;

import java.util.UUID;

public interface HeroPersistenceSpi extends PersistenceSpi<Hero, UUID> {

    List<Hero> findByRarityAndSpeciality(String rarity, String speciality);

}
