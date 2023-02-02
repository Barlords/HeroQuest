package esgi.cleancode.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public final class ApplicationError {
    private final String context;
    private final String message;
    private final Object value;
    private final Throwable cause;

    public ApplicationError(String context, String message, Object value, Throwable cause) {
        this.context = context;
        this.message = message;
        this.value = value;
        this.cause = cause;
    }

    public String context() {
        return context;
    }

    public String message() {
        return message;
    }

    public Object value() {
        return value;
    }

    public Throwable cause() {
        return cause;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ApplicationError) obj;
        return Objects.equals(this.context, that.context) &&
                Objects.equals(this.message, that.message) &&
                Objects.equals(this.value, that.value) &&
                Objects.equals(this.cause, that.cause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(context, message, value, cause);
    }

    @Override
    public String toString() {
        return "ApplicationError[" +
                "context=" + context + ", " +
                "message=" + message + ", " +
                "value=" + value + ", " +
                "cause=" + cause + ']';
    }
}
