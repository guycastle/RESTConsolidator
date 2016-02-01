package be.vdab.web;

import be.vdab.exceptions.NoRESTClientPropertiesFoundException;
import be.vdab.exceptions.NoSystemStatusFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author guillaume.vandecasteele on 01/02/2016 at 10:20.
 */
@ControllerAdvice
public class ErrorController {
    private static final String VIEW = "error";
    private static final String ERROR_404 = "Page does not exist";
    private static final String ERROR_FILE_MISSING = "Could not find configuration file";
    private static final String ERROR_GETCLIENT_REQUEST_FAILED = "GET-requests failed";

    @ExceptionHandler(NoHandlerFoundException.class)
    ModelAndView error404() {
        return new ModelAndView(VIEW, "message", ERROR_404);
    }

    @ExceptionHandler(NoRESTClientPropertiesFoundException.class)
    ModelAndView errorFileMissing() {
        return new ModelAndView(VIEW, "message", ERROR_FILE_MISSING);
    }

    @ExceptionHandler(NoSystemStatusFoundException.class)
    ModelAndView errorGetClientFailed() {
        return new ModelAndView(VIEW, "message", ERROR_GETCLIENT_REQUEST_FAILED);
    }
}
