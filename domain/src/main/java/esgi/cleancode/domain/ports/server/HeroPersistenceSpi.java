package esgi.cleancode.domain.ports.server;

import esgi.cleancode.domain.functional.model.Hero;

import java.util.UUID;

public interface HeroPersistenceSpi extends PersistenceSpi<Hero, UUID> {}
