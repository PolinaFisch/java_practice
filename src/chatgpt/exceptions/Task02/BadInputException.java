package chatgpt.exceptions.Task02;

public class BadInputException extends RuntimeException {

    public BadInputException(String message) {
        super(message);
    }

    public BadInputException(String message, Throwable cause) {
        super(message, cause);
    }
}