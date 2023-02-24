package esgi.cleancode.domain.functional.service.booster;

import esgi.cleancode.domain.functional.model.Booster;
import esgi.cleancode.domain.functional.model.Rarity;
import lombok.val;

public class BoosterRarityGeneratorService {

    public static Rarity generateRarity(Booster booster) {
        val seed = Math.random();
        Rarity rarity = Rarity.COMMON;
        if (seed > booster.getProbabilityOfCommon() && seed <= booster.getProbabilityOfCommon() + booster.getProbabilityOfRare()) {
            rarity = Rarity.RARE;
        }
        else if (seed > booster.getProbabilityOfCommon() + booster.getProbabilityOfRare() && seed <= booster.getProbabilityOfCommon() + booster.getProbabilityOfRare() + booster.getProbabilityOfLegendary()) {
            rarity = Rarity.LEGENDARY;
        }
        return rarity;
    }
}
