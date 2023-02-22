package esgi.cleancode.domain.functional.service.card;

import esgi.cleancode.domain.functional.model.Card;

public class CardArmorApplierService {

    public int apply(Card heroReceivedDamage, int amount) {
        return amount - heroReceivedDamage.getArmor();
    }
}
