package esgi.cleancode.service.hero;

import esgi.cleancode.domain.HeroCard;
import esgi.cleancode.exception.ResourceNotFoundException;

import java.util.List;

public class HeroCardDeckCheckerService {

    static HeroCard find(HeroCard expectedHero, List<HeroCard> deck) {
        for (var currentHero : deck) {

        }
        throw new ResourceNotFoundException("HeroCard not contain in deck");
    }

}
