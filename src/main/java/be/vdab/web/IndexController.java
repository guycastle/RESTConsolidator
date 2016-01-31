package be.vdab.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created on 30/01/2016 at 14:51.
 */
@Controller
@RequestMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
class IndexController {
    private static final String INDEX_VIEW = "index";

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView getIndex() {
        return new ModelAndView(INDEX_VIEW);
    }
}
