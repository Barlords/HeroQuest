package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;
import esgi.cleancode.domain.functional.model.Hero;

public class CardCreatorService {

    public static Card create(Hero hero) {
        return Card.builder()
                .name(hero.getName())
                .rarity(hero.getRarity())
                .speciality(hero.getSpeciality())
                .life((int) (hero.getSpeciality().getLife() * hero.getRarity().getCoefficient()))
                .power((int) (hero.getSpeciality().getPower() * hero.getRarity().getCoefficient()))
                .armor((int) (hero.getSpeciality().getArmor() * hero.getRarity().getCoefficient()))
                .build();
    }
}
