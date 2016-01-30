package be.vdab.web;

import be.vdab.restclients.APIEngineClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created on 30/01/2016 at 14:51.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    private static final String INDEX_VIEW = "index";

    @Autowired
    private APIEngineClient engineClient;

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView getIndex() {
        return new ModelAndView(INDEX_VIEW).addObject("status", engineClient.getSystemStatus());
    }
}
