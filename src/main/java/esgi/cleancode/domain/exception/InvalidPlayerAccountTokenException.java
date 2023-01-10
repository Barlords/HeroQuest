package esgi.cleancode.domain.exception;

public class InvalidPlayerAccountTokenException extends RuntimeException {
    public InvalidPlayerAccountTokenException(String message) {
        super(message);
    }
}