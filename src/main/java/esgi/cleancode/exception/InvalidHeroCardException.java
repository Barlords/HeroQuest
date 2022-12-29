package esgi.cleancode.exception;

public class InvalidHeroCardException extends RuntimeException {
    public InvalidHeroCardException(String message) {
        super(message);
    }
}