package esgi.cleancode.domain.functional.service.validation;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Account;
import io.vavr.control.Validation;
import lombok.val;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface AccountValidator {

    static Validation<ApplicationError, Account> validate(Account account) {
        val pseudo = account.getPseudo();
        return (pseudo != null && pseudo.length() > 0)
            ? Valid(account)
            : Invalid(new ApplicationError("Invalid pseudo", null, pseudo, null));
    }

}
