package esgi.cleancode.domain.functional.service.validation;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Card;
import io.vavr.control.Validation;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface CardValidator {

    static Validation<ApplicationError, Card> validate(Card card) {
        return card.getName() != null
                && card.getName().length() > 0
                && card.getExperience() >= 0
                && card.getExperience() < 10
                && card.getLevel() >= 1
                && card.getLevel() < 100
                && card.getLife() >= 1
                && card.getArmor() >= 1
                && card.getPower() >= 1
            ? Valid(card)
            : Invalid(new ApplicationError("Invalid card", null, card, null));
    }

}
