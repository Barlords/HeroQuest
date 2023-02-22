package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;

public class CardAdvantageApplierService {

    public int apply(Card givenAtt, Card givenDef, int damage) {
        int result = damage;
        if (givenAtt.getSpeciality().getIdAdvantage() == givenDef.getSpeciality().getId()) {
            result += givenAtt.getSpeciality().getPowerUpAdvantage();
        }
        return result;
    }
}
