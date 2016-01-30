package be.vdab.web;

import be.vdab.exceptions.NoSystemStatusFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created on 23/12/2015 at 00:57.
 */
@ControllerAdvice
public class ErrorController {
    private static final String ERROR_REDIRECT = "redirect:/error";

    @ExceptionHandler(NoSystemStatusFoundException.class)
    String redirectToErrorView() {
        return ERROR_REDIRECT;
    }
}
