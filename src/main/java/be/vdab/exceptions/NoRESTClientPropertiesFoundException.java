package be.vdab.exceptions;

/**
 * Created on 31/01/2016 at 14:49.
 */
public class NoRESTClientPropertiesFoundException extends RuntimeException {

    public NoRESTClientPropertiesFoundException() {
        super();
    }

    public NoRESTClientPropertiesFoundException(String message) {
        super(message);
    }

    public NoRESTClientPropertiesFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRESTClientPropertiesFoundException(Throwable cause) {
        super(cause);
    }
}
