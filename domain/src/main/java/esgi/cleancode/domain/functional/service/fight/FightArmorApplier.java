package esgi.cleancode.domain.functional.service.fight;

import esgi.cleancode.domain.functional.model.Card;

public class FightArmorApplier {

    public static int apply(Card heroReceivedDamage, int amount) {
        return amount - heroReceivedDamage.getArmor();
    }
}
