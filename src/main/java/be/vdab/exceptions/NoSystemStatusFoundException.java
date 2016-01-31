package be.vdab.exceptions;

/**
 * Created on 30/01/2016 at 14:04.
 */
public class NoSystemStatusFoundException extends RuntimeException {

    public NoSystemStatusFoundException() {
        super();
    }

    public NoSystemStatusFoundException(String message) {
        super(message);
    }

    public NoSystemStatusFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSystemStatusFoundException(Throwable cause) {
        super(cause);
    }
}
