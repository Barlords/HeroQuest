package esgi.cleancode.domain.exception;

public class InvalidPlayerAccountException extends RuntimeException {
    public InvalidPlayerAccountException(String message) {
        super(message);
    }
}
