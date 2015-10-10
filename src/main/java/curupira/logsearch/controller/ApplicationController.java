package curupira.logsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Maps the contexts and displays the necessary jsp
 */
@Controller
public class ApplicationController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

}
