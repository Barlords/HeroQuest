package esgi.cleancode.domain.functional.service.validation;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Hero;
import io.vavr.control.Validation;
import lombok.val;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface HeroValidator {

    static Validation<ApplicationError, Hero> validate(Hero hero) {
        val name = hero.getName();
        return (name != null && name.length() > 0 && name.matches("[0-9a-zA-Z\\-\\s]+"))
                ? Valid(hero)
                : Invalid(new ApplicationError("Invalide Hero", null, hero, null));
    }

}
