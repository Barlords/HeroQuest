package esgi.cleancode.domain.functional.service.booster;

import esgi.cleancode.domain.functional.model.Booster;
import esgi.cleancode.domain.functional.model.Speciality;
import lombok.val;

public class BoosterSpecialityGeneratorService {

    public static Speciality generateSpeciality(Booster booster) {
        val seed = Math.random();
        if (seed <= 0.333) {
            return Speciality.TANK;
        }
        else if (seed <= 0.666) {
            return Speciality.MAGE;
        }
        else {
            return Speciality.ASSASSIN;
        }
    }
}
