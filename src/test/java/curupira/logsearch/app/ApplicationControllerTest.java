package curupira.logsearch.app;

import curupira.logsearch.controller.ApplicationController;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ApplicationControllerTest {

    @Test
    public void homeTest(){
        ApplicationController controller = new ApplicationController();

        ModelAndView modelAndView = controller.home();
        assertNotNull(modelAndView);
        assertEquals("home",modelAndView.getViewName());
    }
}
