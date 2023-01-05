package esgi.cleancode.application.services.hero_card;

import esgi.cleancode.domain.HeroCard;

public class HeroCardArmorApplierService {

    public int apply(HeroCard heroReceivedDamage, int amount) {
        return amount - heroReceivedDamage.getArmor();
    }
}
