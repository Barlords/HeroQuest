package esgi.cleancode.exception;

public class InvalidHeroException extends RuntimeException {
    public InvalidHeroException(String message) {
        super(message);
    }
}