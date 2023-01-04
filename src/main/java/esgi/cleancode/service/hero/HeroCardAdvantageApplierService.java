package esgi.cleancode.service.hero;

import esgi.cleancode.domain.HeroCard;

public class HeroCardAdvantageApplierService {

    public int apply(HeroCard givenAtt, HeroCard givenDef, int damage) {
        int result = damage;
        if (givenAtt.getSpeciality().getIdAdvantage() == givenDef.getSpeciality().getId()) {
            result += givenAtt.getSpeciality().getPowerUpAdvantage();
        }
        return result;
    }
}
