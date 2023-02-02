package esgi.cleancode.domain.functional.service.hero_card;

import esgi.cleancode.domain.functional.model.HeroCard;

public class HeroCardArmorApplierService {

    public int apply(HeroCard heroReceivedDamage, int amount) {
        return amount - heroReceivedDamage.getArmor();
    }
}
