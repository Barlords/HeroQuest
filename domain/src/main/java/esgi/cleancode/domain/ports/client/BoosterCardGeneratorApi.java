package esgi.cleancode.domain.ports.client;

import esgi.cleancode.domain.functional.model.Booster;
import esgi.cleancode.domain.functional.model.Card;

public interface BoosterCardGeneratorApi {
    Card generateCard(Booster booster);
}
