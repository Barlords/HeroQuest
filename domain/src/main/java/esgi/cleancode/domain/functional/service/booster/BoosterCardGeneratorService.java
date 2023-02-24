package esgi.cleancode.domain.functional.service.booster;

import esgi.cleancode.domain.functional.model.Booster;
import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.service.card.CardCreatorService;
import esgi.cleancode.domain.ports.client.BoosterCardGeneratorApi;
import esgi.cleancode.domain.ports.server.HeroPersistenceSpi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
@RequiredArgsConstructor
public class BoosterCardGeneratorService implements BoosterCardGeneratorApi {

    private final HeroPersistenceSpi heroPersistenceSpi;

    @Override
    public Card generateCard(Booster booster) {
        val rarity = BoosterRarityGeneratorService.generateRarity(booster);
        val speciality = BoosterSpecialityGeneratorService.generateSpeciality(booster);
        val heros = heroPersistenceSpi.findByRarityAndSpeciality(rarity.name(), speciality.name());
        val hero = heros.shuffle().get(0);
        return CardCreatorService.create(hero);
    }

}
