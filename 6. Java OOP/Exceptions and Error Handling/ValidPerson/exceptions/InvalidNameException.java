package custom.exceptions;

public class InvalidNameException extends Exception {
    public InvalidNameException(String errorMessage) {
        super(errorMessage);
    }
}
